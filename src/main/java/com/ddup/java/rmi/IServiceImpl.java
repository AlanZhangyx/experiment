package com.ddup.java.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class IServiceImpl extends UnicastRemoteObject implements IService {

	protected IServiceImpl() throws RemoteException {
		super();
	}

	/**  */
	private static final long serialVersionUID = 1L;

	@Override
	public String sayHelloByName(String name) throws RemoteException {
		return "收到" + name + "!";
	}

	@Override
	public TestDTO sayObject(TestDTO dto) throws RemoteException {
		dto.setUserName("服务端重新set");
		return dto;
	}

}
