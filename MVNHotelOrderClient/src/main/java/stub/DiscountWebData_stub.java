package stub;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import dataservice.DiscountWebDataService;
import po.DiscountPO_web;
import po.DiscountPO_web_period;
import tools.DiscountState;
import tools.ResultMessage_Discount;
import tools.ResultMessage_DiscountDetail;
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
		List<DiscountPO_web>discountPO_webs = new LinkedList<DiscountPO_web>();
		DiscountPO_web discountPO_web = new DiscountPO_web_period(0.9, LocalDate.of(2016, 12, 1), LocalDate.of(2016, 12, 10),Strategy_webType.Period, DiscountState.valid, null);
		discountPO_webs.add(discountPO_web);
		return discountPO_webs;
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
