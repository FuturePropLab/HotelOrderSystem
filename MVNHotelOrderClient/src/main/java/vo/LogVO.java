package vo;

import businesslogic.login.AccountType;
import businesslogic.login.State;

/**
 * 登陆的信息
 * @author zjy
 *
 */
public class LogVO {
	public State state;
	public String username;
	public String password;
	public AccountType accountType;
	
	/**
	 * 
	 * @param state 登陆的状态
	 * @param username 用户名
	 * @param password 密码
	 * @param accountType 账户类型
	 */
	public LogVO(State state, String username, String password, AccountType accountType) {
		super();
		this.state = state;
		this.username = username;
		this.password = password;
		this.accountType = accountType;
	}
}
