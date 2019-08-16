package com.learn.thread.chapter4;

import java.util.concurrent.TimeUnit;

public class InterruptDemo {

    private static int i;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while(!Thread.currentThread().isInterrupted()){
                i++;
            }
            System.out.println(i);
        },"interruptDemo");

        System.out.println(thread.isInterrupted());

        thread.start();

        TimeUnit.SECONDS.sleep(1);
        System.out.println(thread.isInterrupted());
        // interrupt并没有去终止标识，只是设置一个中断标志
        thread.interrupt();// 设置interrupt为true
        System.out.println(thread.isInterrupted());
    }


}
