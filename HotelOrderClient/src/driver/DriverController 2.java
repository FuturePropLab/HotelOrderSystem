package driver;

import dataservice.CreditDataService;
import stub.CreditData_Stub;

public class DriverController {
	public static void main(String[] args) {
		
//		CustomerSignupService customerSignupService = new CustomerSignup_Stub();
//		CustomerDealService customerDealService = new CustomerDeal_Stub();
//		
//		CustomerSignupService_Driver customerSignupService_Driver  = 
//				new CustomerSignupService_Driver();
//		customerSignupService_Driver.drive(customerSignupService);
//		
//		CustomerDataService customerDataService = new CustomerData_Stub() ;
//		
//		CustomerDealService_Driver customerDealService_Driver = new CustomerDealService_Driver();
//		customerDealService_Driver.drive(customerDealService);
//		CustomerDataService_Driver customerDataService_Driver = new CustomerDataService_Driver();
//		customerDataService_Driver.driver(customerDataService);
//		RoomHotelInfoService hotelInfoService = new RoomHotelInfo_Stub();
//		RoomHotelInfoService_Driver driver = new RoomHotelInfoService_Driver();
//		driver.driver(hotelInfoService);
//		RoomSingleService hotelSingleService = new RoomSingle_Stub();
//		RoomSingleService_Driver driver = new RoomSingleService_Driver();
//		driver.drive(hotelSingleService);
//		RoomDealService hotelDealService = new RoomDeal_Stub();
//		RoomDealService_Driver driver = new RoomDealService_Driver();
//		driver.drive(hotelDealService);
//		RoomDataService hotelDataService = new RoomData_Stub();
//		RoomDataService_Driver driver = new RoomDataService_Driver();
//		driver.drive(hotelDataService);
		
		
//		CreditLogDealService_Driver driver = new CreditLogDealService_Driver();
//		CreditLogDealService creditLogDealService = new CreditLogDeal_Stub();
//		driver.drive(creditLogDealService);
		
		CreditDataService_Driver driver = new CreditDataService_Driver();
		CreditDataService creditDataService = new CreditData_Stub();
		driver.drive(creditDataService);
		
	}
}
