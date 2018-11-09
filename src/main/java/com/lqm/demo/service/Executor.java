package com.lqm.demo.service;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

public class Executor {


    private static ExecutorService executorService = Executors.newFixedThreadPool(12);

    private static AtomicLong atomicLong = new AtomicLong(1);

    public static void ex() throws InterruptedException {

        LinkedBlockingQueue queue = new LinkedBlockingQueue(1000000);

        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            executorService.execute(()-> {
                try {
                    Producer.producer(queue);
                }finally {
                    countDownLatch.countDown();
                }

            });
        }

        executorService.execute(()->{
            Consumer.consumer(queue);
        });
        countDownLatch.await();
        queue.put("over");
        executorService.shutdown();
    }


    public static synchronized long getNo(){
        return atomicLong.incrementAndGet();

    }


    public static void main(String[] args) throws InterruptedException {

        ex();

    }



}
