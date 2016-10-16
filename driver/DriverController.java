package driver;

import stub.OrderBL_Stub;
import stub.OrderDate_Stub;

public class DriverController {
	public static void main(String[] args) {
		businesslogicservice.Order.OrderService orderBLService=new OrderBL_Stub();
		dataservice.order.OrderService orderDataService=new OrderDate_Stub();
		
		System.out.println(new OrderBLService_Driver().drive(orderBLService));
		System.out.println(new OrderDataService_Driver().drive(orderDataService));
	}
}
