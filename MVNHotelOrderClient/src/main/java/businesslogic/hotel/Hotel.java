package businesslogic.hotel;

import java.util.List;

import stub.HotelData_Stub;
import stub.HotelDeal_Stub;
import stub.ManageHotelInfo_Stub;
import tools.ResultMessage2;
import tools.SortType;
import vo.CommentVO;
import vo.DiscountVO;
import vo.DiscountVO_hotel;
import vo.HotelInfoVO;
import vo.HotelInputVO;
import vo.SearchHotelVO;

public class Hotel {
	/**
	 * 添加酒店信息
	 * @param vo
	 * @return 添加成功与否
	 */
	public ResultMessage2 addHotel(HotelInputVO vo) {
		// TODO Auto-generated method stub
		ManageHotelInfo_Stub test=new ManageHotelInfo_Stub();
		return test.addHotel(vo);
	}
	
	/**
	 * 修改酒店信息
	 * @param hotel_id
	 * @return 修改后酒店信息
	 */
	public HotelInfoVO editHotelInfo(String hotel_id) {
		// TODO Auto-generated method stub
		ManageHotelInfo_Stub test=new ManageHotelInfo_Stub();
		return test.editHotelInfo(hotel_id);
	}
	/**
	 * 保存酒店信息
	 * @param hotelInfo
	 * @return成功失败
	 */
	public ResultMessage2 saveHotelInfo(HotelInfoVO hotelInfo) {
		// TODO Auto-generated method stub
		ManageHotelInfo_Stub test=new ManageHotelInfo_Stub();
		return test.saveHotelInfo(hotelInfo);
	}

	/**
	 * 搜索酒店
	 * @param searchhotel
	 * @return 符合条件的酒店
	 */
	public List<HotelInfoVO> SearchHotel(SearchHotelVO searchhotel) {
		// TODO Auto-generated method stub
		HotelDeal_Stub test=new HotelDeal_Stub();
		return test.SearchHotel(searchhotel);
	}

	/**
	 * 排序
	 * @param hotelInfo
	 * @param sortType
	 * @return 按一定顺序排列的酒店信息
	 */
	public List<HotelInfoVO> SortHotel(List<HotelInfoVO> hotelInfo, SortType sortType) {
		// TODO Auto-generated method stub
		HotelDeal_Stub test=new HotelDeal_Stub();
		return test.SortHotel(hotelInfo, sortType);
	}
	/**
	 * 
	 * @param hotel_id
	 * @return 酒店详细信息
	 */
	public HotelInfoVO getHotelInfo(String hotel_id) {
		// TODO Auto-generated method stub
		HotelDeal_Stub test=new HotelDeal_Stub();
		
		return test.getHotelInfo(hotel_id);
	}
	/**
	 * 
	 * @param hotel_id
	 * @return 酒店优惠策略
	 */
	public List<DiscountVO_hotel> getHotelDiscount(String hotel_id) {
		// TODO Auto-generated method stub
		MockHotelDiscount test=new MockHotelDiscount();
		return test.getHotelDiscount(hotel_id);
	}
	/**
	 * 
	 * @param hotel_id
	 * @return 酒店评价信息
	 */
	public List<CommentVO> getComment(String hotel_id) {
		// TODO Auto-generated method stub
		MockOrder test=new MockOrder(null, null, null, null);
		return test.getComment();
	}

}
