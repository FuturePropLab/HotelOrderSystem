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
 * 增删改查 采用缓存链表的形式，数据发生改变后先调用数据库，
 * 若更新成功则在本地的缓存进行更新。
 *  酒店ID更改则重新加载缓存
 */
public class DiscountHotelController implements DiscountHotelService {

	private static DiscountHotelController discountHotelController;

	private HotelDiscount hotelDiscount;

	private String hotelID;

	private List<DiscountVO_hotel> list;// 缓存list，不需重复调用Data层

	private DiscountHotelController() {
		hotelDiscount = new HotelDiscount();
	}

	/**
	 * 单件
	 * 
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
		List<DiscountVO_hotel> discountVO_hotels = new LinkedList<DiscountVO_hotel>();
		if (this.hotelID != null && hotelID.equals(this.hotelID)) {
			return list;
		} else {
			discountVO_hotels = initHotelDiscount(hotelID);
		}
		return discountVO_hotels;
	}

	public ResultMessage_DiscountDetail addHotelDiscount(String hotelID, DiscountVO_hotel dis) {
		ResultMessage_DiscountDetail resultMessage_DiscountDetail = ResultMessage_DiscountDetail.fail;
		try {

			resultMessage_DiscountDetail = hotelDiscount.addHotelDiscount(hotelID, dis);
			if (resultMessage_DiscountDetail == ResultMessage_DiscountDetail.Success) {
				initHotelDiscount(hotelID);
			}
			return resultMessage_DiscountDetail;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public ResultMessage_Discount editHotelDiscount(String discountID, DiscountVO_hotel discountVO_hotel) {

		ResultMessage_Discount resultMessage_Discount = ResultMessage_Discount.Fail;
		try {
			resultMessage_Discount = hotelDiscount.editHotelDiscount(discountID, discountVO_hotel);
			if (resultMessage_Discount == ResultMessage_Discount.Success) {
				getHotelDiscount(hotelID);
			}
			return resultMessage_Discount;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public ResultMessage_Discount deleteHotelDiscount(String hotelID, String discountID) {

		ResultMessage_Discount resultMessage_Discount = ResultMessage_Discount.Fail;
		try {
			resultMessage_Discount = hotelDiscount.deleteHotelDiscount(hotelID, discountID);
			if (resultMessage_Discount == ResultMessage_Discount.Success && hotelID == this.hotelID) {
				Iterator<DiscountVO_hotel> iterator = list.iterator();
				while (iterator.hasNext()) {
					DiscountVO_hotel discountVO_hotel = iterator.next();
					if (discountVO_hotel.discountID.equals(discountID)) {
						iterator.remove();
					}
				}
			}
			return resultMessage_Discount;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public List<DiscountVO_hotel> getHotelDiscountByType(String hotelID, Strategy_hotelType type) {

		List<DiscountVO_hotel> res = new LinkedList<DiscountVO_hotel>();

		// add null value check
		if (list == null) {
			getHotelDiscount(hotelID);
		}

		Iterator<DiscountVO_hotel> iterator = list.iterator();

		while (iterator.hasNext()) {
			DiscountVO_hotel discountVO_hotel = iterator.next();
			if (discountVO_hotel.type == type)
				res.add(discountVO_hotel);
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
	public List<DiscountVO_hotel> getHotelDiscountByState(String hotelID, Strategy_hotelType type,
			DiscountState discountState) {
		if (list == null) {
			getHotelDiscount(hotelID);
		}
		List<DiscountVO_hotel> res = new LinkedList<DiscountVO_hotel>();
		Iterator<DiscountVO_hotel> iterator = list.iterator();
		while (iterator.hasNext()) {
			DiscountVO_hotel discountVO_hotel = iterator.next();
			if (discountVO_hotel.type == type && discountVO_hotel.discountState == discountState)
				res.add(discountVO_hotel);
		}
		return res;
	}

	public ResultMessage_Discount invalidDiscount(String hotelID, String discountID) {
		ResultMessage_Discount resultMessage_Discount = ResultMessage_Discount.Fail;
		try {
			resultMessage_Discount = hotelDiscount.invalidDiscount(hotelID, discountID);
			if (resultMessage_Discount == ResultMessage_Discount.Success) {
				Iterator<DiscountVO_hotel> iterator = list.iterator();
				while (iterator.hasNext()) {
					DiscountVO_hotel discountVO_hotel = (DiscountVO_hotel) iterator.next();
					if (discountVO_hotel.discountID.equals(discountID)) {
						discountVO_hotel.discountState = DiscountState.invalid;
					}
				}
			}
			return resultMessage_Discount;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	private List<DiscountVO_hotel> initHotelDiscount(String hotelID) {
		List<DiscountVO_hotel> discountVO_hotels = new LinkedList<DiscountVO_hotel>();
		try {
			discountVO_hotels = hotelDiscount.getHotelDiscount(hotelID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.list = discountVO_hotels;
		this.hotelID = hotelID;
		return discountVO_hotels;
	}

}
