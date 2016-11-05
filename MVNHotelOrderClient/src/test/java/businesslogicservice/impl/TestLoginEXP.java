package businesslogicservice.impl;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestLoginEXP {

	@Test
	public void test() {
		LoginServiceImpl ls = new LoginServiceImpl();
		assertEquals(ls.checkValid("wqeqwe", "zdxz"), false);
	}

}
