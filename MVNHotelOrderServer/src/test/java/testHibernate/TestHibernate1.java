package testHibernate;

import static org.junit.Assert.*;

import org.junit.Test;

import testHibernate.OOhibernate;

public class TestHibernate1 {

	@Test
	public void test() {
		OOhibernate oh  =new OOhibernate();
		assertEquals(2, oh.getAgeByScore().size());
	
	}

}
