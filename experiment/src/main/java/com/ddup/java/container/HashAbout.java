package com.ddup.java.container;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class HashAbout {

	public static void main(String[] args) {
		Map map1 = new HashMap();
		
		Set set1 = new HashSet();//HashSet就是用的HashMap实现的（仅用key，而value用一个static dummy对象），
		Set set2 = new TreeSet();//TreeSet用的是TreeMap
	}

}
