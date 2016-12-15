package testHibernate;

import java.rmi.RemoteException;
import java.util.List;

import dataservice.impl.AccountDataServiceImpl;
import po.AccountPO;
import po.CustomerAccount;
import tools.AccountType;

public class testAcccount {
		
		public static void main(String[] args) throws RemoteException {
			AccountDataServiceImpl ccccc = new AccountDataServiceImpl();
//			AccountPO accountPO  =new AccountPO("WB001", "mengyidan", "mengyidan", AccountType.Web);
//			accountDataServiceImpl.addAccount(accountPO);
			List<CustomerAccount> customerAccounts =ccccc.getCustomerAccount();
			System.out.println(customerAccounts.size());
			
			//AccountDataHelper accountDataHelper = DataHelperUtils.getAccountDataHelper();
			//LoginCheckService loginCheckService = new LoginCheckServiceImpl();
			//System.out.println(loginCheckService.checkLogin("zhujunyi", "zjyzjy11", AccountType.Customer));
			//System.out.println(accountDataHelper.resetPassword("CS001", "zhujunyi"));
			 //loginCheckService = new LoginCheckServiceImpl();
			//System.out.println(loginCheckService.checkLogin("zhujunyi", "zjyzjy", AccountType.Customer));
			 //System.out.println(accountDataHelper.resetPassword("CS001", "zjyzjy33315"));
			//loginCheckService = new LoginCheckServiceImpl();
			//System.out.println(loginCheckService.checkLogin("zhujunyi", "zhujunyi", AccountType.Customer));
			//System.out.println(accountDataHelper.resetPassword("CS001", "zhujunyi11"));
			 //loginCheckService = new LoginCheckServiceImpl();
			//System.out.println(loginCheckService.checkLogin("zhujunyi", "zjyzjy", AccountType.Customer));
			 //System.out.println(accountDataHelper.resetPassword("CS001", "zjyzjy33315"));
			//loginCheckService = new LoginCheckServiceImpl();
			//System.out.println(loginCheckService.checkLogin("zhujunyi", "zhujunyi11", AccountType.Customer));
		}
}
