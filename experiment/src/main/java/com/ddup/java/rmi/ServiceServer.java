package com.ddup.java.rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * 其实核心是将本机作为注册表 - Registry，想要提供服务的程序可以将方法注册上去。
 * 
 * @author 30459
 *
 */
public class ServiceServer {

	public static void main(String[] args) {
		
		try {
			//1. 创建注册表Registry。用于提供名称：远程对象的映射
			LocateRegistry.createRegistry(1099);
			
			//这一句，也可以不写在这里而是写在具体的
			//Naming提供在远程主机上的Registry中设置和获取远程对象的方法
			//LocateRegistry.getRegistry(1099);
			
			Naming.bind("rmi://localhost:1099/RemoteIService", new IServiceImpl());
			
			System.out.println(">>>>>INFO：远程对象注册成功！");
			
		} catch (RemoteException | MalformedURLException | AlreadyBoundException e) {
			e.printStackTrace();
		}
	}

}
