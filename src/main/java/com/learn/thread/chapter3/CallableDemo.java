package com.learn.thread.chapter3;

import java.util.concurrent.*;

public class CallableDemo implements Callable<String> {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        CallableDemo callableDemo = new CallableDemo();


        Future<String> future = executorService.submit(callableDemo);

        // 会产生阻塞
        String s = future.get();

        System.out.println(s);
        executorService.shutdown();


    }


    @Override
    public String call() throws Exception {
        return "string" +1;
    }
}
