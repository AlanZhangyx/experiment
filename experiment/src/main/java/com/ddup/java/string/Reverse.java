package com.ddup.java.string;

public class Reverse {

	public static void main(String[] args) {
		String s1 = "汉";
		String s2 = "1";
		byte[] bytes1 = s1.getBytes();
		byte[] bytes2 = s2.getBytes();
		System.out.println(bytes1.length);
		System.out.println(bytes2.length);
		
		/**
		 * reverse题
		 * 
		 * 如果java文件编码格式是UTF-8，那么它可以使用所有Unicode字符，包括大于2字节的字符
		 * 如果使用了大于UCS - 2的字符，那么此时使用String.length()是查询的实际所用char的长度，就会是3或者4个了
		 * 
		 * 所以，我们反转的操作不能涉及这些非UCS - 2 字符
		 */
		String s3 = "𐀀张1a";
		byte[] bytes3 = s3.getBytes();
		System.out.println(bytes3.length);
		System.out.println(s3.length());
		
		
		String s4 = "天天向上";
		
		StringBuilder sb = new StringBuilder();
		for (int i = s4.length() - 1; i > -1; i--) {
			sb.append(s4.charAt(i));
		}
		System.out.println(sb.toString());
		
	}

}
