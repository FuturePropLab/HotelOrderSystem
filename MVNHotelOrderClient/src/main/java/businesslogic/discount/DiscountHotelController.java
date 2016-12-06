package businesslogic.discount;

import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import businesslogicservice.DiscountHotelService;
import tools.DiscountState;
import tools.ResultMessage_Discount;
import tools.ResultMessage_DiscountDetail;
import tools.Strategy_hotelType;
import vo.DiscountVO_hotel;

/**
 * 
 * @author LWY
 *
 */
public class DiscountHotelController implements DiscountHotelService {
	
	private static DiscountHotelController discountHotelController;

	private HotelDiscount hotelDiscount;
	
	private String hotelID;
	
	private List<DiscountVO_hotel> list;//缓存list，不需重复调用Data层
	
	private DiscountHotelController() {
		hotelDiscount = new HotelDiscount();
	}
	
	/**
	 * 单件
	 * @return
	 */
	public static DiscountHotelController getInstance() {
		if (discountHotelController == null) {
			discountHotelController = new DiscountHotelController();
		}
		return discountHotelController;
	}

/**
 * 得到所有该酒店的促销策略，必须先被调用
 */
	public List<DiscountVO_hotel> getHotelDiscount(String hotelID) {
		
		try {
			return hotelDiscount.getHotelDiscount(hotelID);
		} catch (RemoteException e) {
			e.printStackTrace();
			//System.out.println(e.getMessage());
			return null;
		}
	}
	
	public ResultMessage_DiscountDetail addHotelDiscount(String hotelID, DiscountVO_hotel dis) {
		
		try {
			return hotelDiscount.addHotelDiscount(hotelID, dis);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public ResultMessage_Discount editHotelDiscount(String discountID, DiscountVO_hotel discountVO_hotel) {
		
		try {
			return hotelDiscount.editHotelDiscount(discountID, discountVO_hotel);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}


	public ResultMessage_Discount deleteHotelDiscount(String hotelID, String discountID) {
		
		try {
			return hotelDiscount.deleteHotelDiscount(hotelID, discountID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public List<DiscountVO_hotel> getHotelDiscountByType(String hotelID,Strategy_hotelType type) {
		
		List<DiscountVO_hotel> res = new LinkedList<DiscountVO_hotel>();
		
		//add null value check
		if(list==null){
			this.list = getHotelDiscount(hotelID);
		}
		
		Iterator<DiscountVO_hotel> iterator = list.iterator();
		
		while (iterator.hasNext()) {
			DiscountVO_hotel discountVO_hotel =  iterator.next();
			if(discountVO_hotel.type==type) res.add(discountVO_hotel);
		}
		
		return res;
	}
	/**
	 * 
	 * @param hotelID
	 * @param type
	 * @param discountState
	 * @return 根据策略状态和策略类型来得到符合条件的
	 */
	public List<DiscountVO_hotel> getHotelDiscountByState(String hotelID,Strategy_hotelType type,DiscountState discountState){
		List<DiscountVO_hotel> res = new LinkedList<DiscountVO_hotel>();
		Iterator<DiscountVO_hotel> iterator = list.iterator();
		while (iterator.hasNext()) {
			DiscountVO_hotel discountVO_hotel =  iterator.next();
			if(discountVO_hotel.type==type&&discountVO_hotel.discountState==discountState) res.add(discountVO_hotel);
		}
		return res;
	}
	
	public ResultMessage_Discount invalidDiscount(String hotelID,String discountID) {
		Iterator<DiscountVO_hotel> iterator = list.iterator();
		while (iterator.hasNext()) {
			DiscountVO_hotel discountVO_hotel = (DiscountVO_hotel) iterator.next();
			if(discountVO_hotel.discountID.equals(discountID)){
				discountVO_hotel.discountState=DiscountState.invalid;
			}
		}
		try {
			return hotelDiscount.invalidDiscount(hotelID, discountID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
}
