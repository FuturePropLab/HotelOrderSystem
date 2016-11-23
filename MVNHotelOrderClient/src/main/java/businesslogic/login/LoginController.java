package businesslogic.login;

import java.rmi.RemoteException;

import businesslogicservice.LoginService;
import dataservice.AccountDataService;
import rmi.RemoteHelper;
import tools.AccountType;
import tools.ResultMessage_LoginCheck;
import vo.LogVO;

/**
 * Login的控制器，实现LoginService接口，负责实现ui层的调用
 * @author zjy
 *
 */
/**
 * 新的Login的控制器，实现LoginService接口，负责实现ui层的调用
 * @author wshwbluebird
 *
 */
public class LoginController implements LoginService{
	private Login loginw;
	/**
	 * 
	 * @param accountDataService AccountDataService接口
	 */
	public LoginController(AccountDataService accountDataService) {
		super();
		this.loginw = new Login();
	}
	
	public LoginController(){
		super();
		this.loginw = new Login();
	}

	/**
	 * 
	 * @param username 用户输入的用户名
	 * @param password 用户输入的密码
	 * @return 登陆的结果
	 * @throws RemoteException 
	 */
	public ResultMessage_LoginCheck login(String username, String password, AccountType accountType) throws RemoteException {
		return loginw.login(username, password, accountType);
	}

}
