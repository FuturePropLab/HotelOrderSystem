package businesslogicservice.impl;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class TestLoginServiceImpl1 {

	@Ignore//zjy注
	public void test1() {
//		LoginService lg = new LoginServiceImpl();
		LoginServiceImpl lg = new LoginServiceImpl();
		assertEquals(lg.checkValid("wsw", "wsw"), true);
	}

	@Ignore//zjy注
	public void test2() {
//		LoginService lg = new LoginServiceImpl();
		LoginServiceImpl lg = new LoginServiceImpl();
		assertEquals(lg.checkValid("wswq", "wsw"), false);
	}

}
