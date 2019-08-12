package com.learn.thread.chapter4;

import com.sun.org.apache.regexp.internal.RE;

import java.util.concurrent.LinkedBlockingQueue;

public class PrintProcessor extends Thread implements RequestProccess{


    LinkedBlockingQueue<Request> linkedBlockingQueue = new LinkedBlockingQueue();

    private final RequestProccess nextRequest;

    public PrintProcessor(RequestProccess nextRequest) {
        this.nextRequest = nextRequest;
    }

    @Override
    public void run() {
        while (true){
            try {
                Request request = linkedBlockingQueue.take();
                System.out.println( "print data:" + request );
                nextRequest.processorRequest(request);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void processorRequest(Request request) {
        linkedBlockingQueue.add(request);
    }


}
