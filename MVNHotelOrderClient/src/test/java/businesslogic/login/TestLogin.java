package businesslogic.login;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * 
 * @author zjy
 *
 */
public class TestLogin {

	@Test
	public void testLogin() {
		Login login=new Login();
		assertEquals(login.login("zjy", "password").state, State.login);
	}
	@Test
	public void testGetState() {
		Login login=new Login();
		assertEquals(login.getState(), State.logout);
	}

}
