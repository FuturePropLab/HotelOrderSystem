package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LoginCheckService extends Remote{
	/**
	 * 向数据端传递rmi调用 检测用户名密码四否匹配
	 * @param username
	 * @param password
	 * @return boolean
	 */
	public boolean checkLogin(String username ,String password)  throws RemoteException;
}
