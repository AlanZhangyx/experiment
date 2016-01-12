package com.ddup.spring.cache;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * 结论
 * map：
 * 	对于一个map对象，怎么样都行
 * 	但是对于不同的map对象（一般都是，一个请求的参数都会用新new一个map）
 * 		cacheable不能正确处理，必须重新实现key生成类了
 *
 * <br>
 * <strong>copyright</strong>： 2015, 北京都在哪网讯科技有限公司<br>
 * <strong>Time </strong>: 2016年1月12日<br>
 * <strong>History</strong>：<br>
 * Editor　　　version　　　Time　　　　　Operation　　　　　　　Description<br>
 *
 * @author dznzyx
 * @version : 1.0.0
 */
public class CacheTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-cache.xml");
		UserService userService = context.getBean(UserService.class);
		
		//1 对于一个map，是正确的期望缓存结果
/*		Map<String, Object> map = new HashMap<String, Object>();
		map.put("key", "1");
		System.out.println(userService.getXXX(map));
		map.put("key", "1");
		System.out.println(userService.getXXX(map));
		map.put("key", "2");
		System.out.println(userService.getXXX(map));
		map.put("key", "1");
		System.out.println(userService.getXXX(map));*/
		
		//2 不同的map呢
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("key", "1");
		System.out.println("第1步");
		System.out.println(userService.getXXX(map));
		
		Map<String, Object> map1 = new HashMap<String, Object>();
		map.put("key", "1");
		System.out.println("第2步");
		System.out.println(userService.getXXX(map1));
		
		Map<String, Object> map2 = new HashMap<String, Object>();
		map.put("key", "2");
		System.out.println("第3步");
		System.out.println(userService.getXXX(map2));
		
		Map<String, Object> map3 = new HashMap<String, Object>();
		map.put("key", "1");
		System.out.println("第4步");
		System.out.println(userService.getXXX(map3));
	}
}
