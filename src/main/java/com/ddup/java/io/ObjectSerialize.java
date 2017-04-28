package com.ddup.java.io;

import java.io.Serializable;

public class ObjectSerialize implements Serializable {

	private static final long serialVersionUID = 1L;

	public int i1 = 10;

	public void say() {
		System.out.println(i1 + "我是序列化对象");
	}
}
