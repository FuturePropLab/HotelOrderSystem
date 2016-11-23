package businesslogicservice.impl;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class TestLoginEXP {

	@Ignore//zjy注
	public void test() {
		LoginServiceImpl ls = new LoginServiceImpl();
		assertEquals(ls.checkValid("wqeqwe", "zdxz"), false);
	}

}
