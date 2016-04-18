package com.ddup.java.thread;



public class Immutable {
	public static void main(String[] args) throws InterruptedException {
		/*Thread t1 = new Thread(new Thread1());
		t1.start();
		Thread t2 = new Thread(new Thread2());
		t2.start();*/
		
		new Thread(new Thread3()).start();
		new Thread(new Thread4()).start();
		/*Thread.sleep(1000);*/
		/*System.out.println(ImmutableResourseTest.s1);*/
	}
	
}

class Thread1 implements Runnable {

	@Override
	public void run() {
		while (ImmutableResourseTest.haveTickets() > 0) {
			/*ImmutableResourseTest.i1 --;
			System.out.println("Thread一 : " + ImmutableResourseTest.i1);*/
		}
		ImmutableResourseTest.s1 = "abcd1";
	}
}

class Thread2 implements Runnable {

	@Override
	public void run() {
		while (ImmutableResourseTest.haveTickets() > 0) {
			/*ImmutableResourseTest.i1 --;
			System.out.println("Thread二 : " + ImmutableResourseTest.i1);*/
		}
		ImmutableResourseTest.s1 = "abcd2";
	}
}

class Thread3 implements Runnable {

	@Override
	public void run() {
		while (ImmutableResourseTest.haveTickets() > 0) {
			ImmutableResourseTest.sellTicket(Thread.currentThread());
		}
	}
}

class Thread4 implements Runnable {

	@Override
	public void run() {
		while (ImmutableResourseTest.haveTickets() > 0) {
			ImmutableResourseTest.sellTicket(Thread.currentThread());
		}
	}
}

class ImmutableResourseTest{
	
	private static int i1 = 1000;//模拟1000张票，两个窗口去卖
	public static String s1 = "abcd";
	
	public static int haveTickets(){
		return i1;
	}
	
	public static void sellTicket(Thread t){
		synchronized(ImmutableResourseTest.class){
			System.out.println("Thread" + t.getName() + " : " + i1);
			i1--;
		}
	}
}