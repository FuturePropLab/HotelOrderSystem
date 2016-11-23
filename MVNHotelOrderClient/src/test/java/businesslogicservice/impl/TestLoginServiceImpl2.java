package businesslogicservice.impl;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import businesslogicservice.LoginService;

public class TestLoginServiceImpl2 {

	@Ignore//zjy注
	public void test() {
//		LoginService lg =  new LoginServiceImpl();
		LoginServiceImpl lg =  new LoginServiceImpl();
		assertEquals(lg.checkValid("wsw", "wsq"), false);
	}

}
