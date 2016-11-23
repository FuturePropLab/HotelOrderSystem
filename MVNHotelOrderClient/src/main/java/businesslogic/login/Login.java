package businesslogic.login;

import dataservice.AccountDataService;
import tools.AccountType;
import vo.LogVO;

/**
 * Login的领域类
 * @author zjy
 * 
 */
public class Login {
	private AccountDataService accountDataService;
	private State state;
	/**
	 * 
	 * @param accountDataService AccountDataService接口
	 */
	public Login(AccountDataService accountDataService) {
		super();
		this.accountDataService = accountDataService;
		this.state=State.logout;
	}
	/**
	 * 
	 * @param username 用户输入的用户名
	 * @param password 用户输入的密码
	 * @return 登陆的结果
	 */
	public LogVO login(String username,String password){
		if(accountDataService.getHotel(username)!=null){
			return new LogVO(State.login, username, password, AccountType.Hotel);
		}
		else if (accountDataService.getWeb(username)!=null) {
			return new LogVO(State.login, username, password, AccountType.Web);
		}
		else if (accountDataService.getCustomer(username)!=null){
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
