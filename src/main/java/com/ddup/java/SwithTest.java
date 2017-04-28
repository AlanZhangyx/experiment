package com.ddup.java;

public class SwithTest {

	public static void main(String[] args) {
		int i = 0;
		long l = 0;
		float f = 1.1f;
		TEST test = TEST.MALE;
		
		
		switch (2) {
			case 1:
				System.out.println(1);
				break;
			default:
				System.out.println(2);
				break;
		}
	}
	
	
	public enum TEST{
		MALE, FEMAIL;
	}

}
