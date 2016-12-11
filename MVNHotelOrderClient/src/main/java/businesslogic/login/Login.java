package businesslogic.login;

import java.io.File;
import java.net.StandardSocketOptions;
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
	private String username;
	private AccountType accountType;
	private String accountID;
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
		ResultMessage_LoginCheck loginResult=loginCheckService.checkLogin(username, password, accountType);
		if(loginResult.equals(ResultMessage_LoginCheck.Success)){
			this.state=State.login;
			this.username=username;
			this.accountType=accountType;
			this.accountID=loginCheckService.getUserID(username, password);
			
			System.out.println("ResultMessage_LoginCheck:!!!   "+accountID);
			System.out.println(accountID);
		}
		return loginResult;
	}
	
	/**
	 * 
	 * @return 登陆的状态
	 */
	public State getState(){
		return state;
	}
	
	/**
	 * 
	 * @return 登陆的状态
	 */
	public String getUserName(){
		return username;
	}
	
	/**
	 * 
	 * @return 登陆的状态
	 */
	public AccountType getAccountType(){
		return accountType;
	}

	/**
	 * 
	 * @return 账号对应的ID，如果是客户，就是客户ID，如果是酒店工作人员，就是酒店ID，依次类推
	 */
	public String getAccountID() {
		return accountID;
	}
}
