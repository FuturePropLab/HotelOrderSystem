package testHibernate;

import dataservice.datahelper.LoginCheckDatahelper;
import dataservice.datahelper.impl.LoginCheckDatahelperImpl;

public class testLogin {
			public static void main(String[] args) {
				LoginCheckDatahelper loginCheckDatahelper  = LoginCheckDatahelperImpl.getInstance();
				String id = loginCheckDatahelper.getID("zhujunyi", "zhujunyi");
				System.out.println(id);
			}
}
