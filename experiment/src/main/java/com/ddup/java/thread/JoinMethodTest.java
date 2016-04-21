package com.ddup.java.thread;

/**
 * join方法可以这样理解：将线程加入到当前线程中来（相当于同步执行了）。
 * 
 * <p>
 * threadObj.join() 是让当前线程（比如：main调用就是main线程）进入threadObj的wait set<br>
 * 
 * </p>
 * 
 * <strong>Time</strong>&nbsp;&nbsp;&nbsp;&nbsp;2016年4月20日<br>
 * <strong>copyright</strong>&nbsp;&nbsp;&nbsp;&nbsp;2016, 北京都在哪网讯科技有限公司<br>
 *
 * @version  1.0.0
 * @author   30459
 */
public class JoinMethodTest {
	
	static long i = 0;
	
	/**
	 * 下面这段代码让我困惑的一点是：
	 * 看完join()的源代码发现thread1.join()可以让main线程进入waiting状态，<br>
	 * 那么为什么在thread1线程执行完后，System.out.println(i);还会被执行呢？main线程不是已经waiting了吗？
	 * 想不明白之后，在网上搜索的很久，看得出来没人说的明白
	 * 这个留待之后探索，可能的原因：
	 * 	thread1线程执行完后，默认调用了notify()方法？
	 * 
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		
		Thread thread1 = new Thread(){
			@Override
			public void run() {
				while (i < 5554775807l) {
					i ++;
				}
			}
		};
		thread1.start();
		thread1.join();
		System.out.println(i);
	}

}
