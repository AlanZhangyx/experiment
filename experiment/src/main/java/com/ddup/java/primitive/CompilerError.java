package com.ddup.java.primitive;

public class CompilerError {

	public static void main(String[] args) {
		byte s1 = 127;

		// int i1 = 2147483648;
		
		s1 = 1 + 111;

		int i1 = 2147483647 + 1;
		System.out.println(i1 / 2);
		
		Short ss1 = 1;

		System.out.println(i1 >>> 1);
	}

}
