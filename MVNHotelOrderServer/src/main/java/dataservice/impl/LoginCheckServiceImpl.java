package dataservice.impl;

import java.rmi.RemoteException;
import java.util.Map;

import dataservice.LoginCheckService;
import dataservice.datahelper.LoginCheckDatahelper;
import dataservice.datahelper.impl.LoginCheckDatahelperImpl;
import passwordtool.ShaUtil;
import tools.AccountType;
/**
 * 
 * @author wshwbluebird
 *
 */
public class LoginCheckServiceImpl implements LoginCheckService {
		
	/**
	 * 检查登录是否成功
	 */
	public boolean checkLogin(String username, String password, AccountType accountType) throws RemoteException {
		
		ShaUtil sha = new ShaUtil();
		String inputPassSha ;
		try {
			inputPassSha = sha.shaEncode(password);
		} catch (Exception e) {
			return false;
		}
		LoginCheckDatahelper loginCheckDatahelper = new LoginCheckDatahelperImpl();
		String realPassSha = loginCheckDatahelper.passwordInSha(username, accountType);
		return inputPassSha.equals(realPassSha);
	}
}
