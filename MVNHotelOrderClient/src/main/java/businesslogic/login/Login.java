package businesslogic.login;

import java.rmi.RemoteException;

import dataservice.LoginCheckService;
import rmi.RemoteHelper;
import tools.AccountType;
import tools.ResultMessage_LoginCheck;
import vo.LogVO;

/**
 * Login的领域类
 * @author zjy
 * 
 */
public class Login {
	private LoginCheckService loginCheckService;
	private State state;
	/**
	 * 
	 * @param accountDataService AccountDataService接口
	 */
	public Login(LoginCheckService loginCheckService) {
		super();
		this.loginCheckService = loginCheckService;
		this.state=State.logout;
	}
	
	
	public Login(){
		this.loginCheckService = RemoteHelper.getInstance().getLoginCheckService();
		this.state=State.logout;
	}
	/**
	 * 
	 * @param username 用户输入的用户名
	 * @param password 用户输入的密码
	 * @return 登陆的结果
	 * @throws RemoteException 
	 */
	public ResultMessage_LoginCheck login(String username,String password,AccountType accountType) throws RemoteException{
		return loginCheckService.checkLogin(username, password, accountType);
	}
	/**
	 * 
	 * @return 登陆的状态
	 */
	public State getState(){
		return state;
	}
}
