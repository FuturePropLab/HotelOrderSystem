package dataservice.impl;

import java.util.Map;

import dataservice.LoginCheckService;
import dataservice.datahelper.LoginCheckDatahelper;
import dataservice.datahelper.impl.LoginCheckDatahelperImpl;
/**
 * 
 * @author wshwbluebird
 *
 */
public class LoginCheckServiceImpl implements LoginCheckService {
	/**
	 * 
	 */
	public boolean checkLogin(String username, String password) {
		LoginCheckDatahelper dh = new LoginCheckDatahelperImpl();
		Map<String,String> map = dh.getAlluserInfo();
		if(password.equals(map.get(username))) return true;
		else  return false;
	}

}
