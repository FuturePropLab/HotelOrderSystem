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
		List<DiscountPO_hotel>res = new LinkedList<DiscountPO_hotel>();
		DiscountPO_hotel discountPO_hotel = new DiscountPO_hotel(DiscountState.valid, Strategy_hotelType.Birthday, "", 0.5, null, null, null, true, null);
		res.add(discountPO_hotel);
		res.add(new DiscountPO_hotel(DiscountState.valid, Strategy_hotelType.Period, "1", 0.9, LocalDate.of(2016, 12, 3), LocalDate.of(2016, 12, 9), null, true, null));
		res.add(new DiscountPO_hotel(DiscountState.valid, Strategy_hotelType.OrderMore, "", 0.2, null, null, null, false, null));
		if(hotelID.equals("330")) return res;
		else return new LinkedList<DiscountPO_hotel>();
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
