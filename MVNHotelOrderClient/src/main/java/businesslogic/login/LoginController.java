package businesslogic.login;

import java.rmi.RemoteException;

import businesslogic.customer.CustomerDealController;
import businesslogicservice.CustomerDealService;
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
	private static LoginController loginController = null;
	private Login loginw; //变量名设重复了
	/**
	 * 
	 * @param accountDataService AccountDataService接口
	 */
	public LoginController(AccountDataService accountDataService) {
		super();
		this.loginw = new Login();
	}
	
	/**
	 * 单件模式初始化
	 */
	private LoginController(){
		super();
		this.loginw = new Login();
	}
	
	/**
	 * 单件模式，通过静态方法得到实例化的对象
	 * @return 实例化的LoginController
	 */
	public static LoginController getInstance(){
		if(loginController==null)
			loginController = new LoginController();
		return loginController;
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

	/**
	 * 获取登陆的状态和信息
	 * @return
	 */
	@Override
	public LogVO getLogState() {
		
		return new LogVO(loginw.getState(), loginw.getUserName(), loginw.getAccountType(), loginw.getAccountID());
	}

}
