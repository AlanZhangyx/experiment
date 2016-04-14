package com.ddup.java.innerclass;

import org.junit.Test;

public class InnerClassTest {

	public void main(String[] args) {
		InnerClassTest parent = new InnerClassTest();
	}
	
	public void test(){
		System.out.println(111);
	}
	
	class Inner extends InnerClassTest{
		
		@Test
		public void test(){
			super.test();
		}
	}

}
