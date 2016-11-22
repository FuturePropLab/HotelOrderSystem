package dataservice.impl;

import java.rmi.RemoteException;
import java.util.Map;

import dataservice.LoginCheckService;
import dataservice.datahelper.LoginCheckDatahelper;
import dataservice.datahelper.impl.LoginCheckDatahelperImpl;
import passwordtool.ShaUtil;
import tools.AccountType;
import tools.ResultMessage_LoginCheck;
/**
 * 
 * @author wshwbluebird
 *
 */
public class LoginCheckServiceImpl implements LoginCheckService {
		
	/**
	 * 检查登录是否成功
	 */
	private LoginCheckDatahelper loginCheckDatahelper;
	
	public LoginCheckServiceImpl(){
		loginCheckDatahelper = new LoginCheckDatahelperImpl();
	}
	public ResultMessage_LoginCheck checkLogin(String username, String password, AccountType accountType) throws RemoteException {
		
		ShaUtil sha = new ShaUtil();
		String inputPassSha ;
		try {
			inputPassSha = sha.shaEncode(password);
		} catch (Exception e) {
			return ResultMessage_LoginCheck.InvalidUsername;
		}
		String realPassSha = loginCheckDatahelper.passwordInSha(username, accountType);
		if("Bad_ID".equals(realPassSha))  return ResultMessage_LoginCheck.InvalidUsername;
		if(!inputPassSha.equals(realPassSha)) return ResultMessage_LoginCheck.InvalidPassword;
		return ResultMessage_LoginCheck.Success;
	}

	public String getUserID(String username, String password) throws RemoteException {	
		return loginCheckDatahelper.getID(username, password);
	}
}
