package com.lqm.demo.service;

import java.util.concurrent.LinkedBlockingQueue;

public class Consumer {


    public static void consumer(LinkedBlockingQueue queue){
        while (true) {
            try {
                String str = (String)queue.take();
                System.out.println(str);
                if (str.equals( "over")) {
                    break;
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
