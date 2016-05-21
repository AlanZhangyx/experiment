package com.ddup.java.rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class ServiceServer {

	public static void main(String[] args) {
		
		try {
			IService service = new IServiceImpl();
			
			//注册表Registry，提供名称：远程对象的映射
			LocateRegistry.createRegistry(1099);
			//Registry registry = LocateRegistry.getRegistry();//获得默认本地1099注册表
			
			//Naming提供在远程主机上的Registry中设置和获取远程对象的方法
			Naming.bind("rmi://localhost:1099/RemoteIService", service);
			
			System.out.println(">>>>>INFO：远程对象注册成功！");
			
		} catch (RemoteException | MalformedURLException | AlreadyBoundException e) {
			e.printStackTrace();
		}
	}

}
