package businesslogicservice.impl;

import businesslogicservice.LoginService;

public class LoginServiceImpl implements LoginService {
	/**
	 * 只是用于示范maven junit并不是真的实现方法
	 * (non-Javadoc)
	 * @see businesslogicservice.LoginService#checkValid(java.lang.String, java.lang.String)
	 */
	public boolean checkValid(String userID, String password) {

		return userID == password;
	}

}
