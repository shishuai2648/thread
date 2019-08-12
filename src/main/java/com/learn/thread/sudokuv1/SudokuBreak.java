//package com.learn.thread.sudokuv1;
//
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class SudokuBreak {
//}
//
//class BreakUtil{
//
//    public static void getBeginData(List<TableInfo> list){
//        for( TableInfo info : list ){
//            if( info.getValue().size() == 1 ){
//                continue;
//            }
//        }
//    }
//
//    // 初始数据
//    private static List<String> beginData = Arrays.asList(new String[]{"1","2","3","4","5","6","7","8","9"});
//
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
//    public List<String> findUseValueX(int x, List<TableInfo> tableInfos){
//
//        List<String> list = new ArrayList<>();
//        for(TableInfo tableInfo : tableInfos){
//            int xSeat = tableInfo.getX();
//            if( x == xSeat && ){
//                list.add(tableInfo.getValue());
//            }
//        }
//
//
//        return this.excludeNumber(list);
//    }
//    // 根据列，判断当前位置可填数字
//    public List<String> findUseValueY(int y,List<TableInfo> tableInfos){
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
//    public List<String> findUseValueArea(String area, List<TableInfo> tableInfos){
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
//
//
//class TableInfoData{
//
//    private static final int WIDTH = 9;
//    private static final int HEIGHT = 9;
//
//    // 初始数据
//    private static List<String> BEGIN_DATA = Arrays.asList(new String[]{"1","2","3","4","5","6","7","8","9"});
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
//}
//
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
//    private List<String> value;
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
