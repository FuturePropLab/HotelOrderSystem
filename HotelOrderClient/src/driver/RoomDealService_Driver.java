package driver;

import businesslogicservice.RoomDealService;
import po.Order;
import tools.RoomState;

public class RoomDealService_Driver {
	public void drive(RoomDealService hotelDealService){
	  System.out.println(hotelDealService.ChangeState("234", "32432", RoomState.Available));
	  Order order = new Order("21312axass");
	  order.setCustomerID("3242344");
	  order.setHotelID("324234");
	  System.out.println(hotelDealService.arrangeRoom(order));
	}
}
