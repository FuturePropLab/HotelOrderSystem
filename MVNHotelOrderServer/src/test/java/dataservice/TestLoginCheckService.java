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
import tools.ResultMessage_LoginCheck;

public class TestLoginCheckService {
	LoginCheckService loginCheckService;
	@Before
	public void testBeforeClass(){
		loginCheckService = new LoginCheckServiceImpl();
	}
	
	@Test
	public void test1() {
		try {
			assertEquals(ResultMessage_LoginCheck.Success,loginCheckService.checkLogin("zhujunyi", "zhujunyi", AccountType.Customer));
		} catch (RemoteException e) {
			fail();
		}
	}
	
	@Test
	public void test2() {
		try {
			assertEquals(ResultMessage_LoginCheck.InvalidUsername,loginCheckService.checkLogin("zhujun", "zhujunyi", AccountType.Customer));
		} catch (RemoteException e) {
			fail();
		}
	}
	
	@Test
	public void test3() {
		try {
			assertEquals(ResultMessage_LoginCheck.InvalidPassword,loginCheckService.checkLogin("zhujunyi", "zhujuny2", AccountType.Customer));
		} catch (RemoteException e) {
			fail();
		}
	}
	@Test
	public void test4() {
		try {
			assertEquals("FAIL",loginCheckService.getUserID("zhujunyi", "junyizhu"));
		} catch (RemoteException e) {
			fail();
		}
	}
	@Test
	public void test5() {
		try {
			assertEquals("CS001",loginCheckService.getUserID("zhujunyi", "zhujunyi"));
		} catch (RemoteException e) {
			fail();
		}
	}
	
	

}
