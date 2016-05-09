package com.ddup.java.thread;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerConsumer2 {
	
	/**
	 * 定义一个队列缓冲区，数据为Integer
	 */
	LinkedList<Integer> list = new LinkedList<Integer>();
	
	//记录当前容量和最大容量
	AtomicInteger CURRENT_SIZE = new AtomicInteger(0);
	static final int MAX_SIZE = 100;
	
	/**
	 * 生产者。
	 * 
	 * <p>生产者进行V操作</p>
	 * <ul><li>获取缓冲区，如果没有缓冲区没有达到MAX_SIZE，则生产一个产品放入缓冲区，并唤醒所有线程</li></ul>
	 * 
	 * <strong>Time</strong>&nbsp;&nbsp;&nbsp;&nbsp;2016年5月9日<br>
	 * <strong>copyright</strong>&nbsp;&nbsp;&nbsp;&nbsp;2016, <br>
	 *
	 * @version  1.0.0
	 * @author   30459
	 */
	class Producer implements Runnable{
		@Override
		public void run() {
			
			synchronized (list){
				while (CURRENT_SIZE.get() < MAX_SIZE) {
					
					int num = new Random().nextInt(100);
					list.add(num);
					CURRENT_SIZE.incrementAndGet();
					list.notifyAll();
					System.out.println("生产者" + Thread.currentThread().getName() + "生产了产品：" + num + "，----此时缓冲区容量为" + CURRENT_SIZE.get());
					
					//下面纯粹是为了慢一点执行，和逻辑无关
					try {
						Thread.sleep(500l);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		}
	}
	
	/**
	 * 消费者。
	 * 
	 * <p>消费者进行P操作</p>
	 * <ul><li>获取缓冲区，如果没有缓冲区不为空，则从缓冲区取出一个产品（n个也行），并等待</li></ul>
	 * 
	 * <strong>Time</strong>&nbsp;&nbsp;&nbsp;&nbsp;2016年5月9日<br>
	 * <strong>copyright</strong>&nbsp;&nbsp;&nbsp;&nbsp;2016, <br>
	 *
	 * @version  1.0.0
	 * @author   30459
	 */
	class Consumer implements Runnable{
		@Override
		public void run() {
			synchronized (list){
				while (list.size() > 0) {
					int num = list.poll();
					CURRENT_SIZE.decrementAndGet();
					System.out.println("消费者" + Thread.currentThread().getName() + "消费了产品：" + num + "，----此时缓冲区容量为" + CURRENT_SIZE.get());
					
					try {
						list.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	

	public static void main(String[] args) {
		ProducerConsumer2 pc = new ProducerConsumer2();
		
		Consumer c = pc.new Consumer();
		Producer p = pc.new Producer();
		
		new Thread(c).start();
		new Thread(c).start();
		new Thread(c).start();
		
		new Thread(p).start();
		new Thread(p).start();
		
	}

}
