package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataservice.LoginCheckService;
import dataservice.impl.LoginCheckServiceImpl;

public class DataRemoteObject extends UnicastRemoteObject implements  LoginCheckService{
	/**
	 *  RMI 接口
	 */
	private static final long serialVersionUID = 4029039744279087114L;
	private LoginCheckService loginCheckService;
	protected DataRemoteObject() throws RemoteException {
		//用loginCheckServiceIMPL 实现
		loginCheckService = new LoginCheckServiceImpl();

	}
	public boolean checkLogin(String username, String password)  throws RemoteException{ {
		// TODO Auto-generated method stub
		return loginCheckService.checkLogin(username, password);
	}

	
	}
}
