package com.ddup.java;

public class Autoboxing {

	public static void main(String[] args) {
		Integer a = 1;
		Integer b = 2;
		Integer c = 3;
		Integer d = 3;
		Integer e = 321;
		Integer f = 321;
		Long g = 3L;
		System.out.println(c == d);          //true
		System.out.println(e == f);          //false
		System.out.println(c == (a + b));    //true
		System.out.println(c.equals(a + b)); //true     Integer会先存储一个equals会
		System.out.println(g == (a + b));    //true
		System.out.println(g.equals(a + b)); //false
		
		//结论
		//1.1 java将Byte、Short、Integer、Long都缓存了-127 - 128共256个对象在方法区常量池中
		//Double、Float肯定不会这样做
		//1.2 接上继续说，包装类的 == 运算（在非基本类型比较情况时）在不遇到算数运算的时候"不会"自动拆箱(遇到就会拆箱)，而是比较的对象内存地址
		//所以：true false true * true
		
		//2 equals比较的都会先判断是不是当前包装类型
			//2.1 不是直接false
			//2.2 是的话转为primitive比较
		//所以：第6个 false
		
		System.out.println(new Long(3).equals(new Integer(3)));
		//20160125
		//包装类最好：
		//		1. 与primitive进行==比较
		//		2. 与自身类型进行equals比较
		//包装类不要：
		//		1. 与其他包装类型==比较和equals比较
		//		2. 与自身类型进行==比较
	}

}
