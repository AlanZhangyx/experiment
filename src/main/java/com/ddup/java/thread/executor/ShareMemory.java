package com.ddup.java.thread.executor;

public class ShareMemory {

    //  即变量真正独立于其他变量和自己以前的值：再使用volatile
    static volatile int i1 = 10;
    // 线程私有变量
    static ThreadLocal<Integer> userId = new ThreadLocal<>();
    
    static {
        userId.set(111);
    }
    
    public static void main(String[] args) {

        int i2 = 0;
        while (i2 < 10) {
            new Thread(){
                @Override
                public void run() {
                    try {
                        Thread.sleep(500l);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                    synchronized(ShareMemory.class){
//                        System.out.println(Thread.currentThread().getName() + "：" + --i1);
//                    }
                    System.out.println(Thread.currentThread().getName() + "：" + userId.get());
                };
            }.start();
            
            i2 ++;
        }
    }

}
