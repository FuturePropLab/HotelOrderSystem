package serviceFactory;

import businesslogic.account.CustomerAccountController;
import businesslogic.account.HotelAccountController;
import businesslogic.account.WebDesignerAccountController;
import businesslogicservice.AccountCustomerService;
import businesslogicservice.AccountHotelService;
import businesslogicservice.AccountWebService;

public class AccountContollerUtil {
		public static AccountCustomerService  getAccountCustomerServiceUtil(){
			return CustomerAccountController.getInstance();
		}
		
		public static AccountHotelService getAccoutHotelServiceUtil(){
			return HotelAccountController.getInstance();
		}
		
		public static AccountWebService getAccountWebDesignerServiceUtil(){
			return WebDesignerAccountController.getInstance();
		}
}
