package dataservice.impl;

import java.rmi.RemoteException;

import DataFactory.DataHelperUtils;
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
//	private LoginCheckDatahelper loginCheckDatahelper;
//	
//	public LoginCheckServiceImpl(){
//		loginCheckDatahelper = new LoginCheckDatahelperImpl();
//	}
	public ResultMessage_LoginCheck checkLogin(String username, String password, AccountType accountType) throws RemoteException {
		String inputPassSha ;
		try {
			inputPassSha = ShaUtil.shaEncode(password);
		} catch (Exception e) {
			return ResultMessage_LoginCheck.InvalidUsername;
		}
		//System.out.println("here!!");
	//	LoginCheckDatahelper loginCheckDatahelper = DataHelperUtils.getLoginCheckDatahelper();
		LoginCheckDatahelper loginCheckDatahelper = new LoginCheckDatahelperImpl();
		//System.out.println("there!!");
		String realPassSha = loginCheckDatahelper.passwordInSha(username, accountType);
		if("Bad_ID".equals(realPassSha))  return ResultMessage_LoginCheck.InvalidUsername;
		if(!inputPassSha.equals(realPassSha)) return ResultMessage_LoginCheck.InvalidPassword;
		String id = getUserID(username, password);
		return loginCheckDatahelper.addState(id);
	}

	public String getUserID(String username, String password) throws RemoteException {	
		LoginCheckDatahelper loginCheckDatahelper = DataHelperUtils.getLoginCheckDatahelper();
		return loginCheckDatahelper.getID(username, password);
	}

	public ResultMessage_LoginCheck logOut(String accountID) throws RemoteException {
		LoginCheckDatahelper loginCheckDatahelper = DataHelperUtils.getLoginCheckDatahelper();
		return loginCheckDatahelper.deleteState(accountID);
	}
}
