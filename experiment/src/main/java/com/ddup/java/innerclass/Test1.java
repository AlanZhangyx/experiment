package com.ddup.java.innerclass;

public class Test1 {
	
	public static void main(String[] args) {
		Haha haha = new Haha();
		haha.setA(5);
		changeReference(haha);
		System.out.println(haha.getA());
		
		Object o = new Object();
	}
	
	private static void changeReference(Haha haha){
		haha = new Haha();
		haha.setA(2);
	}
	
	public void test(){
		new Inner();
		new Object();
	}
	
	
	public class Inner{
		public static final String ab = "";
	}
	
	
}

class Haha{
	int a;
	
	public void setA(int a){this.a = a;}
	
	public int getA(){return a;}
}
