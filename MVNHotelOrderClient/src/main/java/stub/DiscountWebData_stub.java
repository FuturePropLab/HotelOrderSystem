package stub;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import dataservice.DiscountWebDataService;
import po.DiscountPO_hotel;
import po.DiscountPO_web;
import po.DiscountPO_web_period;
import tools.DiscountState;
import tools.ResultMessage_Discount;
import tools.ResultMessage_DiscountDetail;
import tools.Strategy_hotelType;
import tools.Strategy_webType;

public class DiscountWebData_stub implements DiscountWebDataService{

	@Override
	public ResultMessage_DiscountDetail addWebDiscount(DiscountPO_web dis) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage_DiscountDetail.Success;
	}

	@Override
	public ResultMessage_Discount editWebDiscount(DiscountPO_web discountPO_web) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage_Discount.Success;
	}

	@Override
	public List<DiscountPO_web> getWebDiscount() throws RemoteException {
		// TODO Auto-generated method stub
		
		List<DiscountPO_web>res = new LinkedList<DiscountPO_web>();
		LocalDate date1 = LocalDate.of(2016, 1, 1);
		LocalDate date2 = LocalDate.of(2016, 1, 2);
		/*LocalDate date3 = LocalDate.of(2016, 1, 3);
		LocalDate date4 = LocalDate.of(2016, 1, 4);
		LocalDate date5 = LocalDate.of(2016, 1, 5);
		LocalDate date6 = LocalDate.of(2016, 1, 6);*/
		
		
		
		DiscountPO_web_period webDis = new DiscountPO_web_period(8.8, date1, date2,Strategy_webType.Period, DiscountState.invalid, "good");
	
		res.add(webDis);
		return res;
		
	}
	@Override
	public ResultMessage_Discount deleteWebDiscount(String discountID) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage_Discount.Success;
	}

	@Override
	public ResultMessage_Discount invalidDiscount(String discountID) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage_Discount.Success;
	}

}
