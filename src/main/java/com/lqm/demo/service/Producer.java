package com.lqm.demo.service;

import java.util.concurrent.LinkedBlockingQueue;

public class Producer {

    public static void producer(LinkedBlockingQueue queue){



        try {
            for (int i = 0;i < 1000000;i++) {
                queue.put("curr No :" + Executor.getNo());

            }
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }


    }

}
