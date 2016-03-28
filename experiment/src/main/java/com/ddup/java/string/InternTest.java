package com.ddup.java.string;

public class InternTest {
	public static void main(String[] args) {
		String s1 = "abc";
        String s2 = new String("abc");
        String s3 = "a" + "bc";
        
        System.out.println(s1 == s2);//flase
        System.out.println(s1 == s3);//true
        System.out.println(s1 == s1.intern());//true
        
        
        String s4 = new String(new char['d']);
        String s5 = new String(new char['d']);
        String s6 = "d";
        
        System.out.println(s4 == s5);//false
        System.out.println(s4 == s6);//false
        
        
        String s7 = new String("efg");
        String s8 = "efg";
        System.out.println(s7.intern() == s8);//true
	}
}
