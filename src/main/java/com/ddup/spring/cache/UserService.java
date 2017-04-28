package com.ddup.spring.cache;

import java.util.Map;

import org.springframework.cache.annotation.Cacheable;

public class UserService {
	
	/**
	 * 测试时调用者连续调用两次本方法，
	 * 第一次：给map一个key=1
	 * 第二次：给map一个key=2
	 * 如果两次都返回1，说明直接使用map做缓存的key不行
	 * @Title
	 * @Description
	 * @param map
	 * @return
	 * @TestUrl
	 */
	@Cacheable(value = "users")
	public String getXXX(Map<String, Object> map){
		String key = (String)map.get("key");
		if ("1".equals(key)) {
			key = "1";
			System.out.println("1不走缓存");
		}
		if ("2".equals(key)) {
			key = "2";
			System.out.println("2不走缓存");
		}
		return key;
	}
	
	@Cacheable(value = "long")
	public long getLong(Map<String, Long> map){
		long key = map.get("key");
		if (key == 1) {
			key = 11;
			System.out.println("1不走缓存");
		}
		if (key == 2) {
			key = 22;
			System.out.println("2不走缓存");
		}
		return key;
	}
	
}
