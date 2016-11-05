package businesslogic.login;

import dataservice.AccountDataService;
import vo.LogVO;

/**
 * Login的领域类
 * @author zjy
 *
 */
public class Login {
	private AccountDataService accountService;
	private State state=State.logout;
	
	/**
	 * 
	 * @param username 用户输入的用户名
	 * @param password 用户输入的密码
	 * @return 登陆的结果
	 */
	public LogVO login(String username,String password){
		if(accountService.getHotel(username)!=null){
			return new LogVO(State.login, username, password, AccountType.Hotel);
		}
		else if (accountService.getWeb(username)!=null) {
			return new LogVO(State.login, username, password, AccountType.Web);
		}
		else if (accountService.getCustomer(username)!=null){
			return new LogVO(State.login, username, password, AccountType.Customer);
		}
		return new LogVO(State.logout, null, null, null);
	}
	/**
	 * 
	 * @return 登陆的状态
	 */
	public State getState(){
		return state;
	}
}
