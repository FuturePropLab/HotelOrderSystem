package stub;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import dataservice.DiscountHotelDataService;
import po.DiscountPO_hotel;
import tools.DiscountState;
import tools.ResultMessage_Discount;
import tools.ResultMessage_DiscountDetail;
import tools.Strategy_hotelType;

public class DiscountHotelData_stub implements DiscountHotelDataService{

	@Override
	public ResultMessage_DiscountDetail addHotelDiscount(String hotelID, DiscountPO_hotel dis) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage_DiscountDetail.Success;
	}

	@Override
	public ResultMessage_Discount editHotelDiscount(String hotelID, DiscountPO_hotel dis) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage_Discount.Success;
	}

	@Override
	public List<DiscountPO_hotel> getHotelDiscount(String hotelID) throws RemoteException {
		// TODO Auto-generated method stub
		//DiscountState discountState,Strategy_hotelType type,String discountID,double discount,LocalDate startDate,LocalDate enDate,String remarks,boolean superimpose,String enterpriseName
		List<DiscountPO_hotel>res = new LinkedList<DiscountPO_hotel>();
		LocalDate date1 = LocalDate.of(2016, 1, 1);
		LocalDate date2 = LocalDate.of(2016, 1, 2);
		LocalDate date3 = LocalDate.of(2016, 1, 3);
		LocalDate date4 = LocalDate.of(2016, 1, 4);
		LocalDate date5 = LocalDate.of(2016, 1, 5);
		LocalDate date6 = LocalDate.of(2016, 1, 6);
		DiscountPO_hotel discountPO_hotel1 = new DiscountPO_hotel(DiscountState.valid, Strategy_hotelType.Birthday, "001", 0.5, date1, date2, "a", true, null);
		DiscountPO_hotel discountPO_hotel2= new DiscountPO_hotel(DiscountState.valid, Strategy_hotelType.Birthday, "002", 0.5, date3, date4, "a", true, null);
		DiscountPO_hotel discountPO_hotel3= new DiscountPO_hotel(DiscountState.valid, Strategy_hotelType.CooperateEnterprise, "003", 0.5, date5, date6, "a", true,"nanda");
		
		res.add(discountPO_hotel1);
		res.add(discountPO_hotel2);
//		res.add(discountPO_hotel3);
//		res.add(new DiscountPO_hotel(DiscountState.valid, Strategy_hotelType.Period, "1", 0.9, LocalDate.of(2016, 12, 3), LocalDate.of(2016, 12, 9), null, true, null));
//		res.add(new DiscountPO_hotel(DiscountState.valid, Strategy_hotelType.OrderMore, "", 0.2, null, null, null, false, null));
		if(hotelID.equals("001")) return res;
		
		else {
			res.add(discountPO_hotel3);
			return res;
		}
	}

	@Override
	public ResultMessage_Discount deleteHotelDiscount(String hotelID, String discountID) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage_Discount.Success;
	}

	@Override
	public ResultMessage_Discount invalidDiscount(String discountID) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage_Discount.Success;
	}

}
