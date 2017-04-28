package com.ddup.java.thread;

import java.lang.Thread.State;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 *  帮小龙想的一个关于上传图片的事。
 * 
 * <strong>Time</strong> 2016年7月28日<br>
 *
 * @version 1.0.0
 * @author alanzhang
 */
public class DragonUploadPicture {
    

    public static void main(String[] args) throws InterruptedException {
        // 这里循环一次，相当于选择一组图片并点击了上传
        while (true) {
            onClick();
            Thread.sleep(1000);
        }
    }
    
    static Queue<String> queue = new LinkedList<>();//上传队列
    static Thread uploadThread = null;// 上传子线程
    
    static int picId = 0;//照片ID
    
    public static void onClick(){
        // 选择了一组图片，好比10个
        String[] array = new String[10];
        array[0] = String.valueOf(picId ++);
        array[1] = String.valueOf(picId ++);
        array[2] = String.valueOf(picId ++);
        array[3] = String.valueOf(picId ++);
        array[4] = String.valueOf(picId ++);
        array[5] = String.valueOf(picId ++);
        array[6] = String.valueOf(picId ++);
        array[7] = String.valueOf(picId ++);
        array[8] = String.valueOf(picId ++);
        array[9] = String.valueOf(picId ++);
        // 上传
        doUpload(array);
    }
    
    private static void doUpload(String[] array){
        
        Collections.addAll(queue, array);//将新图片加入队列
        
        if (uploadThread ==null || uploadThread.getState() == State.TERMINATED) {
            uploadThread = new Thread(){
                @Override
                public void run() {
                    while (!queue.isEmpty()) {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        String pic = queue.poll();//取出队列头元素
                        if (pic != null) {
                            System.out.println("上传【" + pic + "】成功！！当前【上传队列】大小：" + queue.size());
                        }
                    }
                }
            };
            uploadThread.start();
        }
        
    }
}
