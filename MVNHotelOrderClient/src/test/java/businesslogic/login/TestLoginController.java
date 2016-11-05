package businesslogic.login;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * 
 * @author zjy
 *
 */
public class TestLoginController {

	@Test
	public void testLogin() {
		LoginController loginController=new LoginController();
		assertEquals(loginController.login("zjy", "password").state, State.login);
	}

}
