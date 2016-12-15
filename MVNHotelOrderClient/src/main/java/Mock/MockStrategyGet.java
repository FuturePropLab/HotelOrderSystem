package Mock;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import businesslogic.strategy.StrategyGetService;
import po.DiscountPO_hotel;
import tools.DiscountState;
import tools.Strategy_hotelType;
import tools.Strategy_webType;
import vo.DiscountVO_web;
import vo.OrderInputCalVO;
import vo.StrategyVO_hotel;

public class MockStrategyGet implements StrategyGetService{

	@Override
	public List<StrategyVO_hotel> getSuitableDiscount_hotel(OrderInputCalVO orderInput) throws RemoteException {
		// TODO Auto-generated method stub
		List<StrategyVO_hotel> hotelDiscountList = new ArrayList<StrategyVO_hotel>() ;
		LocalDate date1 = LocalDate.of(2016,1,1);
		LocalDate date2 = LocalDate.of(2016,1,2);
		DiscountPO_hotel discountPO_hotel = new DiscountPO_hotel(DiscountState.valid,Strategy_hotelType.CooperateEnterprise,"001",8.8,date1,date2,"aa",true,null);
		StrategyVO_hotel strategy= new StrategyVO_hotel(discountPO_hotel);
		hotelDiscountList.add(strategy);
		
		return hotelDiscountList;
	}

	@Override
	public List<DiscountVO_web> getSuitableDiscount_web(OrderInputCalVO orderInput) throws RemoteException {
		// TODO Auto-generated method stub
		List<DiscountVO_web> webDiscountList = new ArrayList<DiscountVO_web>() ;
		LocalDate date1 = LocalDate.of(2016,1,1);
		LocalDate date2 = LocalDate.of(2016,1,2);
		DiscountVO_web webDiscount = new DiscountVO_web();
		webDiscount.type=Strategy_webType.VIP_district;
		webDiscount.discount=7;
		webDiscount.discountID="002";
		webDiscountList.add(webDiscount);
		return webDiscountList;
	}
	
}
