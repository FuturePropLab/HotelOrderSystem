package businesslogic.login;

import businesslogicservice.LoginService;
import dataservice.AccountDataService;
import vo.LogVO;

/**
 * Login的控制器，实现LoginService接口，负责实现ui层的调用
 * @author zjy
 *
 */
public class LoginController implements LoginService{
	private Login login;
	/**
	 * 
	 * @param accountDataService AccountDataService接口
	 */
	public LoginController(AccountDataService accountDataService) {
		super();
		this.login = new Login(accountDataService);
	}

	/**
	 * 
	 * @param username 用户输入的用户名
	 * @param password 用户输入的密码
	 * @return 登陆的结果
	 */
	public LogVO login(String username,String password){
		return login.login(username, password);
	}

}
