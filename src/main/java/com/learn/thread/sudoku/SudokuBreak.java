//package com.learn.thread.sudoku;
//
//import com.sun.org.apache.bcel.internal.generic.NEW;
//import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.*;
//
//public class SudokuBreak {
//
//
//
//
//    public static void main(String[] args) {
//
//        TableInfoData tableInfoData = new TableInfoData();
//        List<TableInfo> tableInfos = tableInfoData.tableInfos;
//
//        String line1 = "5,0,0,9,0,0,0,6,8";
//        String line2 = "9,0,2,3,0,0,0,0,7";
//        String line3 = "6,0,3,8,0,0,0,9,5";
//        String line4 = "8,0,0,0,3,0,0,0,2";
//        String line5 = "7,0,0,0,2,0,0,0,4";
//        String line6 = "1,0,0,6,8,0,0,0,9";
//        String line7 = "2,9,0,0,0,1,5,0,3";
//        String line8 = "3,0,0,0,0,8,9,0,6";
//        String line9 = "4,6,0,0,0,3,0,0,1";
//
//        List<String> list = new ArrayList<>();
//        list.add(line1);
//        list.add(line2);
//        list.add(line3);
//        list.add(line4);
//        list.add(line5);
//        list.add(line6);
//        list.add(line7);
//        list.add(line8);
//        list.add(line9);
//
//        int count = 0;
//        for(String str : list){
//            String[] split = str.split(",");
//            for( String value : split ){
//                tableInfos.get(count).setValue(value);
//                count++;
//            }
//        }
//
//        while (!tableInfoData.isEnd()){
//            for(TableInfo tableInfo : tableInfos){
//
//                if( !tableInfo.getValue().equals("0") ){
//                    continue;
//                }
//
//                List<String> adjustData = tableInfoData.adjustData(tableInfo);
//
//                if(adjustData.size() == 1){
//                    tableInfo.setValue(adjustData.get(0));
//                }
//
//            }
//        }
//        int countNum = 0;
//        for( TableInfo tableInfo: tableInfos ){
//
//            System.out.print(tableInfo.getValue()+"\t");
//            countNum ++ ;
//            if( countNum == 9 ){
//                System.out.println();
//                countNum = 0;
//            }
//
//        }
//
//
//    }
//
//}
//
//class TableInfoData{
//
//    private static final int WIDTH = 9;
//    private static final int HEIGHT = 9;
//
//    // 初始数据
//    private static List<String> beginData = Arrays.asList(new String[]{"1","2","3","4","5","6","7","8","9"});
//
//    // 用来存储对应节点信息
//    List<TableInfo> tableInfos = new ArrayList<>();
//
//    // 使用构造方法进行初始化      ---     初始化内容为节点坐标与所在区域
//    public TableInfoData() {
//        for( int i = 0 ; i < WIDTH ; i ++ ){
//            for( int j = 0 ; j < HEIGHT ; j ++ ){
//                TableInfo tableInfo = new TableInfo(i, j);
//
//                int xflag = i / 3;
//                int yflag = j / 3;
//
//                String area = xflag + "" +  yflag;
//                tableInfo.setArea(area);
//                tableInfos.add(tableInfo);
//            }
//        }
//    }
//
//    // 判断是否结束
//    public boolean isEnd(){
//        for(TableInfo tableInfo : tableInfos){
//            String value = tableInfo.getValue();
//            if( "0".equals(value)) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    // 查找当前可用数据
//    public List<String> adjustData(TableInfo tableInfo){
//
//        List<String> valueX = this.findUseValueX(tableInfo.getX());
//        List<String> valueY = this.findUseValueY(tableInfo.getY());
//        List<String> valueArea = this.findUseValueArea(tableInfo.getArea());
//
//        return this.excludeNumber(valueX, valueY, valueArea);
//
//    }
//
//    // 查找当前位置可存放数据
//    public List<String> excludeNumber(List<String> xList,List<String> yList,List<String> areaList){
//
//        List<String> list = new ArrayList<>();
//        for(String value : beginData){
//            if( xList.contains(value) && yList.contains(value) && areaList.contains(value) ){
//                list.add(value);
//            }
//        }
//
//        return list;
//    }
//
//    // 根据行，判断当前位置可填数字
//    public List<String> findUseValueX(int x){
//
//        List<String> list = new ArrayList<>();
//        for(TableInfo tableInfo : tableInfos){
//            int xSeat = tableInfo.getX();
//            if( x == xSeat ){
//                list.add(tableInfo.getValue());
//            }
//        }
//
//
//        return this.excludeNumber(list);
//    }
//    // 根据列，判断当前位置可填数字
//    public List<String> findUseValueY(int y){
//        List<String> list = new ArrayList<>();
//        for(TableInfo tableInfo : tableInfos){
//            int ySeat = tableInfo.getY();
//            if( y == ySeat ){
//                list.add(tableInfo.getValue());
//            }
//        }
//
//        return this.excludeNumber(list);
//    }
//
//    // 根据九宫格判断当前可填数字
//    public List<String> findUseValueArea(String area){
//
//        List<String> list = new ArrayList<>();
//        for(TableInfo tableInfo : tableInfos){
//            String areaSeat = tableInfo.getArea();
//            if( areaSeat.equals(area) ){
//                list.add(tableInfo.getValue());
//            }
//        }
//
//        return this.excludeNumber(list);
//    }
//
//
//    // 排除当前已存在数据
//    public List<String> excludeNumber(List<String> targetList){
//        List<String> list = new ArrayList<>();
//        for( String num : beginData ){
//            boolean flag = targetList.contains(num);
//            if( !flag ){
//                list.add(num);
//            }
//        }
//        return list;
//    }
//
//}
//
//@Data
//@NoArgsConstructor
//class TableInfo{
//
//    private int x;
//
//    private int y;
//
//    private String area;
//
//    private String value;
//
//    public TableInfo(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//
//    @Override
//    public String toString() {
//        return "TableInfo{" +
//                "x=" + x +
//                ", y=" + y +
//                ", area='" + area + '\'' +
//                ", value='" + value + '\'' +
//                '}';
//    }
//}
