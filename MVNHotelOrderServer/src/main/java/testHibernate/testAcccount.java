package testHibernate;

import java.rmi.RemoteException;

import DataFactory.DataHelperUtils;
import dataservice.LoginCheckService;
import dataservice.datahelper.AccountDataHelper;
import dataservice.impl.LoginCheckServiceImpl;
import tools.AccountType;

public class testAcccount {
		
		public static void main(String[] args) throws RemoteException {
//			AccountDataServiceImpl accountDataServiceImpl = new AccountDataServiceImpl();
//			AccountPO accountPO  =new AccountPO("CS001", "zhujunyi", "zhujunyi", AccountType.Customer)
//			accountDataServiceImpl.addAccount(new AccountPO()
			AccountDataHelper accountDataHelper = DataHelperUtils.getAccountDataHelper();
			LoginCheckService loginCheckService = new LoginCheckServiceImpl();
			//System.out.println(loginCheckService.checkLogin("zhujunyi", "zjyzjy11", AccountType.Customer));
			System.out.println(accountDataHelper.resetPassword("CS001", "zhujunyi"));
			 loginCheckService = new LoginCheckServiceImpl();
			//System.out.println(loginCheckService.checkLogin("zhujunyi", "zjyzjy", AccountType.Customer));
			 //System.out.println(accountDataHelper.resetPassword("CS001", "zjyzjy33315"));
			//loginCheckService = new LoginCheckServiceImpl();
			System.out.println(loginCheckService.checkLogin("zhujunyi", "zhujunyi", AccountType.Customer));
			System.out.println(accountDataHelper.resetPassword("CS001", "zhujunyi11"));
			 loginCheckService = new LoginCheckServiceImpl();
			//System.out.println(loginCheckService.checkLogin("zhujunyi", "zjyzjy", AccountType.Customer));
			 //System.out.println(accountDataHelper.resetPassword("CS001", "zjyzjy33315"));
			//loginCheckService = new LoginCheckServiceImpl();
			System.out.println(loginCheckService.checkLogin("zhujunyi", "zhujunyi11", AccountType.Customer));
		}
}
