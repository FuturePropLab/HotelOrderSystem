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
	 * ��ӾƵ���Ϣ
	 * @param vo
	 * @return ��ӳɹ����
	 */
	public ResultMessage2 addHotel(HotelInputVO vo) {
		// TODO Auto-generated method stub
		ManageHotelInfo_Stub test=new ManageHotelInfo_Stub();
		return test.addHotel(vo);
	}
	
	/**
	 * �޸ľƵ���Ϣ
	 * @param hotel_id
	 * @return �޸ĺ�Ƶ���Ϣ
	 */
	public HotelInfoVO editHotelInfo(String hotel_id) {
		// TODO Auto-generated method stub
		ManageHotelInfo_Stub test=new ManageHotelInfo_Stub();
		return test.editHotelInfo(hotel_id);
	}
	/**
	 * ����Ƶ���Ϣ
	 * @param hotelInfo
	 * @return�ɹ�ʧ��
	 */
	public ResultMessage2 saveHotelInfo(HotelInfoVO hotelInfo) {
		// TODO Auto-generated method stub
		ManageHotelInfo_Stub test=new ManageHotelInfo_Stub();
		return test.saveHotelInfo(hotelInfo);
	}

	/**
	 * �����Ƶ�
	 * @param searchhotel
	 * @return ���������ľƵ�
	 */
	public List<HotelInfoVO> SearchHotel(SearchHotelVO searchhotel) {
		// TODO Auto-generated method stub
		HotelDeal_Stub test=new HotelDeal_Stub();
		return test.SearchHotel(searchhotel);
	}

	/**
	 * ����
	 * @param hotelInfo
	 * @param sortType
	 * @return ��һ��˳�����еľƵ���Ϣ
	 */
	public List<HotelInfoVO> SortHotel(List<HotelInfoVO> hotelInfo, SortType sortType) {
		// TODO Auto-generated method stub
		HotelDeal_Stub test=new HotelDeal_Stub();
		return test.SortHotel(hotelInfo, sortType);
	}
	/**
	 * 
	 * @param hotel_id
	 * @return �Ƶ���ϸ��Ϣ
	 */
	public HotelInfoVO getHotelInfo(String hotel_id) {
		// TODO Auto-generated method stub
		HotelDeal_Stub test=new HotelDeal_Stub();
		
		return test.getHotelInfo(hotel_id);
	}
	/**
	 * 
	 * @param hotel_id
	 * @return �Ƶ��Żݲ���
	 */
	public List<DiscountVO_hotel> getHotelDiscount(String hotel_id) {
		// TODO Auto-generated method stub
		MockHotelDiscount test=new MockHotelDiscount();
		return test.getHotelDiscount(hotel_id);
	}
	/**
	 * 
	 * @param hotel_id
	 * @return �Ƶ�������Ϣ
	 */
	public List<CommentVO> getComment(String hotel_id) {
		// TODO Auto-generated method stub
		MockOrder test=new MockOrder(null, null, null, null);
		return test.getComment();
	}

}
