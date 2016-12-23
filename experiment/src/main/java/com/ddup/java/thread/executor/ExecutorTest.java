package com.ddup.java.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorTest {

    public static void main(String[] args) throws Exception {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 2; i++) {
            System.out.println("第" + (i+1) + "次提交");
            Thread.sleep(3000l);
            System.out.println("休息3000ms再提交");
            fixedThreadPool.execute(new Thread(){
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000l);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("我是线程：" + Thread.currentThread().getName() + "我执行了1秒");
                }
            });
        }
        System.out.println("提交完成");
    }

}
