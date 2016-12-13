package testHibernate;

import java.rmi.RemoteException;

import dataservice.LoginCheckService;
import dataservice.datahelper.LoginCheckDatahelper;
import dataservice.datahelper.impl.LoginCheckDatahelperImpl;
import dataservice.impl.LoginCheckServiceImpl;

public class testLogin {
			public static void main(String[] args) throws RemoteException {
				LoginCheckDatahelper loginCheckDatahelper  = LoginCheckDatahelperImpl.getInstance();
				LoginCheckService loginCheckService = new LoginCheckServiceImpl();
				loginCheckService.logOut("CS001");
//				String id = loginCheckDatahelper.getID("zhujunyi", "zhujunyi");
//				System.out.println(loginCheckDatahelper.addState("HT001"));
//				System.out.println(loginCheckDatahelper.addState("HT002"));
//				System.out.println(loginCheckDatahelper.addState("HT003"));
				//System.out.println(loginCheckDatahelper.deleteAll());
			}
}
