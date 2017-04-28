package com.ddup.java.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @Description: 一个remote服务接口 必须继承Remote接口，其中需要远程调用的方法必须抛出RemoteException异常 
 * @Author alanzhang
 * @Date 2016年5月21日 下午2:49:54 
 */
public interface IService extends Remote {
	String sayHelloByName(String name) throws RemoteException;
	
	TestDTO sayObject(TestDTO dto) throws RemoteException;
}
