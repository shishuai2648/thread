package com.learn.thread.chapter4;

import java.util.concurrent.TimeUnit;

public class ThreadInterruptDemo {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            while (true) {
                boolean in = Thread.currentThread().isInterrupted();
                if (in) {
                    System.out.println("before:" + in);
                    Thread.interrupted();
                    System.out.println("after:" + Thread.currentThread().isInterrupted());
                }
            }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();

    }
}
