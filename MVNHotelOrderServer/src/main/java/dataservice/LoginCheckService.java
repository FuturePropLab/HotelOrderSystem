package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import tools.AccountType;

/**
 * 检验登录的RMI调用
 * @author wshwbluebird
 *
 */
public interface LoginCheckService extends Remote{
	/**
	 * 向数据端传递rmi调用 检测用户名密码四否匹配
	 * @param username
	 * @param password
	 * @return boolean
	 * @throws RemoteException 
	 */
	public boolean checkLogin(String username ,String password, AccountType accountType) throws RemoteException;
}
