package dataservice.datahelper;

import po.AccountPO;
import tools.ResultMessage_Account;

/**
 * 
 * @author wshwbluebird
 *
 */
public interface AccountDataHelper{
	
	/**
	 * 修改数据库中 该id的密码
	 *  
	 * @param userid
	 * @param newPassword
	 * @return ResultMessage_Account 
	 * 
	 */
	public ResultMessage_Account resetPassword(String userid, String newPassword);
	
	/**
	 * 根据用户名 返回持久化数据
	 * @param username
	 * @return AccountPO
	 */
	public AccountPO getAccountByUserName(String username) ;
	
	/**
	 * 根据唯一识别id 返回持久化数据
	 * @param userid
	 * @return
	 */
	public AccountPO getAccountByID(String userid);
	
	/**
	 * 插入新的持久化数据
	 * @param accountPO
	 * @return 插入是否成功
	 */
	public ResultMessage_Account addAccount(AccountPO accountPO) ;
	
	/**
	 * 根据id 删除出久化存储数据
	 * @param userid
	 * @return 删除是否成功
	 */
	public ResultMessage_Account deleteAccount(String userid);
}
