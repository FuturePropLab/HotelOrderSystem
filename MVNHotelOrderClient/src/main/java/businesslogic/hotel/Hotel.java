package businesslogic.hotel;

import java.rmi.RemoteException;
import java.util.List;

import Exception.CustomerCreditNotEnoughException;
import businesslogic.account.HotelAccountController;
import dataservice.HotelDataService;
import po.HotelPO;
import rmi.RemoteHelper;
import stub.HotelDeal_Stub;
import tools.ResultMessage_Account;
import tools.ResultMessage_Hotel;
import tools.SortType;
import vo.CommentVO;
import vo.DiscountVO_hotel;
import vo.HotelInputVO;
import vo.HotelbriefVO;
import vo.SearchHotelVO;

public class Hotel {
	private HotelDataService hotelDataService;
	public Hotel(){
		hotelDataService = RemoteHelper.getInstance().getHotelDataService();
	}
	
	/**
	 * 添加酒店
	 * @param hotelInputVO
	 * @return ResultMessage_Hotel成功
	 */
	public ResultMessage_Hotel addHotel(HotelInputVO hotelInputVO) {
		String username = hotelInputVO.username;
		String password = hotelInputVO.password;
		HotelAccountController hotelAccountController =  HotelAccountController.getInstance();
		ResultMessage_Account rs = hotelAccountController.addAccount(username, password);
		
		if(!rs.equals(ResultMessage_Account.Success)){
			//TODO  add more return detail
			return ResultMessage_Hotel.fail;
		}
		String hotelID = hotelAccountController.getAccountID(username);
		if("".equals(hotelID) || hotelID == null) return ResultMessage_Hotel.fail;
		
		HotelPO hotelPO = new HotelPO(hotelInputVO);
		hotelPO.setHotelID(hotelID);	
		ResultMessage_Hotel result;
		try {
			result = hotelDataService.addHotel(hotelPO);
		} catch (RemoteException e) {
			System.out.println(e.getMessage());
			return ResultMessage_Hotel.fail;
		}
		return result;
	} 
	

	/**
	 *保存酒店信息
	 * @param hotelInfo
	 * @return 成功
	 */
	public ResultMessage_Hotel saveHotelInfo(HotelInputVO hotelInputVO) {
		if(hotelInputVO.hotelID==null || "".equals(hotelInputVO.hotelID));
		HotelPO hotelPO = new HotelPO(hotelInputVO);
		ResultMessage_Hotel rs;
		try {
			rs = hotelDataService.modifyHotel(hotelPO);
		} catch (RemoteException e) {
			System.out.println(e.getMessage());
			return ResultMessage_Hotel.fail;
		}
		return rs;
	}

	/**
	 * 搜索酒店
	 * @param searchhotel
	 * @return 酒店信息列表
	 */
	public List<HotelbriefVO> SearchHotel(SearchHotelVO searchhotel) {
		// TODO Auto-generated method stub
		HotelDeal_Stub test=new HotelDeal_Stub();
		return test.SearchHotel(searchhotel);
	}

	/**
	 * 排序
	 * @param hotelInfo
	 * @param sortType
	 * @return 排序列表
	 */
	public List<HotelbriefVO> SortHotel(List<HotelbriefVO> hotelInfo, SortType sortType) {
		// TODO Auto-generated method stub
		HotelDeal_Stub test=new HotelDeal_Stub();
		return test.SortHotel(hotelInfo, sortType);
	}
	/**
	 * 获取酒店信息
	 * @param hotel_id
	 * @return 
	 */
	public HotelbriefVO getHotelInfo(String hotel_id) {
		// TODO Auto-generated method stub
		HotelDeal_Stub test=new HotelDeal_Stub();
		
		return test.getHotelInfo(hotel_id);
	}
	/**
	 * 
	 * @param hotel_id
	 * @return 酒店优惠列表
	 */
	public List<DiscountVO_hotel> getHotelDiscount(String hotel_id) {
		// TODO Auto-generated method stub
		MockHotelDiscount test=new MockHotelDiscount();
		return test.getHotelDiscount(hotel_id);
	}
	/**
	 * 
	 * @param hotel_id
	 * @return 酒店评价
	 */
	public List<CommentVO> getComment(String hotel_id) {
		// TODO Auto-generated method stub
		MockOrder test = null;
		try {
			test = new MockOrder(null, null, null, null);
		} catch (CustomerCreditNotEnoughException e) {
			System.out.println("客户信用值不足");
		}
		return test.getComment();
	}
	
}
