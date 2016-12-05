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
	
	/**
	 * 
	 * @param state 登陆的状态
	 * @param username 用户名
	 * @param accountType 账户类型
	 */
	public LogVO(State state, String username, AccountType accountType) {
		super();
		this.state = state;
		this.username = username;
		this.accountType = accountType;
	}
}
