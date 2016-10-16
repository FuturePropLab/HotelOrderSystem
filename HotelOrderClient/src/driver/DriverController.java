package driver;

import stub.MemberBL_Stub;
import stub.MemberData_Stub;
import stub.OrderBL_Stub;
import stub.OrderDate_Stub;

public class DriverController {
	public static void main(String[] args) {
		blservice.OrderService orderBLService=new OrderBL_Stub();
		dataservice.OrderService orderDataService=new OrderDate_Stub();
		blservice.MemberService memberBLService=new MemberBL_Stub();
		dataservice.MemberService memberDataService=new MemberData_Stub();
		
		System.out.println(new OrderBLService_Driver().drive(orderBLService));
		System.out.println(new OrderDataService_Driver().drive(orderDataService));
		System.out.println(new MemberBLService_Driver().drive(memberBLService));
		System.out.println(new MemberDataService_Driver().drive(memberDataService));
	}
}
