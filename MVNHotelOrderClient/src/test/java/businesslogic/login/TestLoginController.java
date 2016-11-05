package businesslogic.login;

import static org.junit.Assert.*;

import org.junit.Test;

import stub.AccountData_stub;
/**
 * 
 * @author zjy
 *
 */
public class TestLoginController {

	@Test
	public void testLogin() {
		LoginController loginController=new LoginController(new AccountData_stub());
		assertEquals(loginController.login("zjy", "password").state, State.login);
	}

}
