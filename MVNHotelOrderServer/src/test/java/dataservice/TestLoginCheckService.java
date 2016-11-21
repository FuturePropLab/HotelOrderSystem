package dataservice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.rmi.RemoteException;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dataservice.impl.LoginCheckServiceImpl;
import testHibernate.Hibernateutils;
import tools.AccountType;

public class TestLoginCheckService {
	LoginCheckService loginCheckService;
	@Before
	public void testBeforeClass(){
		loginCheckService = new LoginCheckServiceImpl();
	}
	
	@Test
	public void test1() {
		try {
			assertEquals(true,loginCheckService.checkLogin("CS001", "zhujunyi", AccountType.Customer));
		} catch (RemoteException e) {
			fail();
		}
	}
	
	@Test
	public void test2() {
		try {
			assertEquals(false,loginCheckService.checkLogin("CS002", "zhujunyi", AccountType.Customer));
		} catch (RemoteException e) {
			fail();
		}
	}
	
	@Test
	public void test3() {
		try {
			assertEquals(false,loginCheckService.checkLogin("CS001", "zhujuny2", AccountType.Customer));
		} catch (RemoteException e) {
			fail();
		}
	}
	

}
