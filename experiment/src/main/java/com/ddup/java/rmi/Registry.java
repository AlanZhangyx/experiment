package com.ddup.java.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Registry {

	public static void main(String[] args) throws RemoteException {
		//1. 创建注册表Registry。用于提供名称：远程对象的映射
		LocateRegistry.createRegistry(1099);
	}

}
