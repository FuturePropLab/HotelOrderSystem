package businesslogicservice;

import java.rmi.RemoteException;

import tools.AccountType;
import tools.ResultMessage_LoginCheck;
import vo.LogVO;

/**
 * 
 * @author zjy
 *
 */
/**
 * 修改
 * @author wshwbluebird
 *
 */
public interface LoginService {
	/**
	 * 
	 * @param username 用户输入的用户名
	 * @param password 用户输入的密码
	 * @return 登陆的结果
	 * @throws RemoteException 
	 */
	public ResultMessage_LoginCheck login(String username,String password,AccountType accountType) throws RemoteException;
	
	/**
	 * 获取登陆的状态和信息
	 * @return
	 */
	public LogVO getLogState() ;

	/**
	 * 	登出
	 * @param accountID
	 * @return
	 */
	public ResultMessage_LoginCheck logOut(String accountID);
}
