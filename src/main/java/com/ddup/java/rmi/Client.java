package com.ddup.java.rmi;

import java.rmi.Naming;

public class Client {

	public static void main(String[] args) {
		try {
			//
			//在RMI服务注册表中查找名称为IService的对象，并调用其上的方法 
            IService service =(IService) Naming.lookup("rmi://localhost:1099/RemoteIService"); 
            System.out.println(service.sayHelloByName("张三"));
            
            TestDTO dto = new TestDTO();
            dto.setUserName("客户端set");
            System.out.println(dto.getUserName());
            System.out.println(service.sayObject(dto).getUserName()); 
			} catch (Exception e) {
				
			}
	}

}
