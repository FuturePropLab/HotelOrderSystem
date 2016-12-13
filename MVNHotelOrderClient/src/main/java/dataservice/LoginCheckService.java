package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import tools.AccountType;
import tools.ResultMessage;
import tools.ResultMessage_LoginCheck;

/**
 * 已经正式开始写了
 * @author wshwbluebird
 *
 */
public interface LoginCheckService extends Remote{
	/**
	 * 检测用户名密码 输入是否匹配
	 * @param username
	 * @param password
	 * @return boolean
	 * @throws RemoteException 
	 */
	public ResultMessage_LoginCheck checkLogin(String username ,String password, AccountType accountType) throws RemoteException;
	
	/**
	 * 通过用户名密码获取  该客户的ID信息
	 * 如果id不存在返回FAIL
	 * @param username
	 * @param password
	 * @param accountType
	 * @return 该账户的ID 信息
	 * @throws RemoteException
	 */
	public String  getUserID(String username, String password) throws RemoteException;
	
	/**
	 * 结束时的登出
	 * @param accountID
	 * @return null
	 * @throws RemoteException
	 */
	public ResultMessage_LoginCheck logOut(String accountID)throws RemoteException;
}
