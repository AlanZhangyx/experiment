package com.ddup.java.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorTest {
    
    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, // 核心线程数
            20, // 最大线程数,dubbo最多处理200个线程
            15, // 空闲线程 存活最大时间
            TimeUnit.SECONDS, // 单位秒
            new LinkedBlockingQueue<Runnable>(), // 没有长度限制的队列
            new ThreadPoolExecutor.CallerRunsPolicy()// 重试添加当前任务,会重复调用execute();
    );
    
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
