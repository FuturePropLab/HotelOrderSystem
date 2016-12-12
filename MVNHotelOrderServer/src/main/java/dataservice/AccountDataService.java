package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.AccountPO;
import po.CustomerAccount;
import po.HotelAccount;
import tools.AccountType;
import tools.ResultMessage_Account;

public interface AccountDataService extends Remote{
	
	/**
	 * 根据账户的ID 和 输入的密码 存储该账户新的密码
	 * @param userid
	 * @param newPassword
	 * @return 修改密码是否成功
	 */
	public ResultMessage_Account resetPassword(String userid , String newPassword)throws RemoteException;
	
	/**
	 * 通过账户用户名 获取账户持久化数据 
	 * @param username
	 * @return AccountPO
	 * @return password==null
	 */
	public AccountPO getAccountByUserName(String username)throws RemoteException;
		
	/**
	 * 通过账户ID 获取账户持久化数据 传过来的
	 * @param userid
	 * @return AccountPO
	 * @return password==null
	 */
	public AccountPO getAccountByID(String userid)throws RemoteException;
	
	/**
	 * 新增持久化账户细信息
	 * @param accountPO
	 * @return 新增持久化账户细信息是否成功
	 */
	public ResultMessage_Account addAccount(AccountPO accountPO)throws RemoteException;
	
	/**
	 * 删除持久化账户细信息
	 * @param userid
	 * @return 删除持久化账户细信息是否成功
	 */
	public ResultMessage_Account deleteAccount(String userid)throws RemoteException;

	/**
	 * 通过客户id列表 获取 AccountPO列表
	 * @param idList
	 * @return AccountPO
	 * @throws RemoteException
	 */
	public List<AccountPO> getAccountList(List<String> idList,AccountType accountType) throws RemoteException;
	
	
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 */
	public List<CustomerAccount>  getCustomerAccount() throws RemoteException;
	
	
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 */
	public List<HotelAccount>  getHotelAccount() throws RemoteException;
	
	/**
	 * 
	 * @param accountType
	 * @return
	 * @throws RemoteException
	 */
	public List<AccountPO> getAccountByTypr(AccountType accountType) throws RemoteException;
}
