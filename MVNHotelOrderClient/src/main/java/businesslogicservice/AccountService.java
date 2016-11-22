package businesslogicservice;

import tools.AccountType;
import tools.ResultMessage;
import tools.ResultMessage_Account;

public interface AccountService {
	/**
	 * 通过用户名 返回该账户的ID
	 * @param username
	 * @param password
	 * @return 该账户的ID 
	 */
	public String getAccountID(String username);
	
	/**
	 * 通过注册的用户名和密码 以及账户类型 新增一个新的账户  自动生成ID
	 * @param username
	 * @param password
	 * @param accountType
	 * @return 是否成功
	 */
	public ResultMessage_Account addAccount(String username ,String password , AccountType accountType);
	
	/**
	 * 通过输入账户名 重制账户的密码
	 * @param userid
	 * @param newPassword
	 * @return 重设是否成功
	 */
	public ResultMessage_Account resetPassword(String userid, String newPassword);
	
	
	/**
	 * 通过账户的id ，获取账户的名字
	 * @param userId
	 * @return 该账户的用户名
	 */
	public String getUsername(String userId);
	
	
}
