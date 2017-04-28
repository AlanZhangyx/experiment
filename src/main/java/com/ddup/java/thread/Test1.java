package com.ddup.java.thread;

import org.junit.Test;

/**
 * 每个对象都有
 * 	1. 一个关联的monitor
 * 	2. 一个关联的线程wait set
 * 
 * 
 * <br>
 * <br>
 * <br>
 * <strong>Time</strong>:2016年4月15日<br>
 *
 * @version : 1.0.0
 */
public class Test1 {

	public static void main(String[] args) {
		//ThreadLocal
		//ReentrantLock
		//Thread
		
	}
	
	@Test
	public void testWait() throws InterruptedException{
		synchronized (this){
			this.wait();
		}
	}

}
