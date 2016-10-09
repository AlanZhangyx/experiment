package com.ddup.java.thread.executor;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorTest {

    public static void main(String[] args) {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            fixedThreadPool.execute(new Thread(){
                @Override
                public void run() {
                    try {
                        Random r = new Random();
                        Thread.currentThread().sleep((long)r.nextInt(5000));
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println("我是线程：" + Thread.currentThread().getName());
                }
            });
        }
        
    }

}
