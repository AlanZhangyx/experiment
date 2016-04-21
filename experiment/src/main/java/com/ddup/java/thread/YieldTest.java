package com.ddup.java.thread;

/**
 * XXX。
 * 
 * <p>
 * XXX
 * </p>
 * <ul>
 * <li></li>
 * </ul>
 * 
 * <strong>Time</strong>&nbsp;&nbsp;&nbsp;&nbsp;2016年4月21日<br>
 * <strong>copyright</strong>&nbsp;&nbsp;&nbsp;&nbsp;2016, 北京都在哪网讯科技有限公司<br>
 *
 * @version 1.0.0
 * @author 30459
 */
public class YieldTest {

	/**
	 * 测试目标：当前线程yield后并不一定会暂停执行
	 * 
	 * 结果： yield()只是按时调度器想先暂停一下，但是听不听或者暂停多久yield()管不了
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(111111);
		Thread.yield();
		int i = 0;
		while (i < 100000000) {
			i++;
			System.out.println(i);
			//Thread.yield();
		}
	}

}
