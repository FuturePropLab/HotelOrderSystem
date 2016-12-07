package vo;

import businesslogic.login.State;
import tools.AccountType;

/**
 * 登陆的信息
 * @author zjy
 *
 */
public class LogVO {
	public State state;
	public String username;
	public AccountType accountType;
	public String accountID;
	
	/**
	 * 
	 * @param accountID 如果是客户就是客户ID，如果是酒店工作人员就是酒店工作人员ID，以此类推
	 * @param state 登陆的状态
	 * @param username 用户名
	 * @param accountType 账户类型
	 */
	public LogVO(State state, String username, AccountType accountType,String accountID) {
		super();
		this.state = state;
		this.username = username;
		this.accountType = accountType;
		this.accountID=accountID;
	}
}
