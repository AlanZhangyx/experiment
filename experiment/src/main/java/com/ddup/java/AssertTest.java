package com.ddup.java;

public class AssertTest {

	public static void main(String[] args) {
		// 使用VM参数 -ea 使得assert有效，默认为-da enable disable assert
		int i = 1;
		assert (1 == i);

		assert (1 == 0) : "1怎么会等于0呢";
	}

}
