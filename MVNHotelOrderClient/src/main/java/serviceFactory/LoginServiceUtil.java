package serviceFactory;

import businesslogic.login.LoginController;
import businesslogicservice.LoginService;

public class LoginServiceUtil {
	private static LoginService loginService = new LoginController();
	
	public static LoginService getLoginService(){
		return loginService;
	}
}
