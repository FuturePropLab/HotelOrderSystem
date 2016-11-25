package serviceFactory;

import businesslogic.login.LoginController;
import businesslogicservice.LoginService;

public class LoginServiceUtil {
	public static LoginService getLoginService(){
		return LoginController.getInstance();
	}
}
