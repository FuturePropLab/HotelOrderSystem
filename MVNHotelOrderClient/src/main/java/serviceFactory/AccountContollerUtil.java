package serviceFactory;

import businesslogic.account.CustomerAccountController;
import businesslogicservice.AccountCustomerService;

public class AccountContollerUtil {
		public static AccountCustomerService  getAccountCustomerServiceUtil(){
			return CustomerAccountController.getInstance();
		}
}
