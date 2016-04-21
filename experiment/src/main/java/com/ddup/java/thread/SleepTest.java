package com.ddup.java.thread;

/**
 * XXX。
 * 
 * <p>休眠时的状态取不到，因为取状态只能用obj.getState()，而休眠时这代码执行不了，执行的时候它已经醒了</p>
 * 
 * <strong>Time</strong>&nbsp;&nbsp;&nbsp;&nbsp;2016年4月20日<br>
 * <strong>copyright</strong>&nbsp;&nbsp;&nbsp;&nbsp;2016, 北京都在哪网讯科技有限公司<br>
 *
 * @version  1.0.0
 * @author   30459
 */
public class SleepTest {
	
	static int l1 = 1;

	public static void main(String[] args) throws Exception {
		Thread thread1 = new Thread(){
			@Override
			public void run() {
				while (l1 < Integer.MAX_VALUE) {
					l1 ++;
					try {
						Thread.sleep(2000);
						System.out.println("Sleep Thread1后的状态 ： " + this.getState().toString() + "----l1 = " + l1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		thread1.start();
		System.out.println("开始执行后Thread1的状态 ： " + thread1.getState().toString() + "----l1 = " + l1);
	}
}
