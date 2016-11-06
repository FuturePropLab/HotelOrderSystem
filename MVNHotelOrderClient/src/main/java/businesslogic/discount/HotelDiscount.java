package businesslogic.discount;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import stub.Discount_stub;
import tools.ResultMessage;
import tools.ResultMessage2;
import vo.DiscountVO;
import vo.DiscountVO_hotel;

public class HotelDiscount extends Discount{

	/**
	 * ���ӾƵ��Żݲ���
	 * @param hotel_id
	 * @return
	 */

	public ResultMessage2 addHotelDiscount(String hotel_id) {
		// TODO Auto-generated method stub
		Discount_stub test=new Discount_stub();
		
		return test.addHotelDiscount(hotel_id);
	}
	/**
	 * �޸ľƵ��Żݲ���
	 * @param Discount_id
	 * @return
	 */
	public DiscountVO_hotel editHotelDiscount(String Discount_id){
		Discount_stub test=new Discount_stub();
		return test.editHotelDiscount(Discount_id);
		
		
		
		
	}
	/**
	 * ��ȡ�Ƶ��Żݲ���
	 * @param Discount_id
	 * @return
	 */
	public DiscountVO_hotel getSingleHotelDiscount(String Discount_id){
		Discount_stub test=new Discount_stub();
		return test.getSingleHotelDiscount(Discount_id);
				
		
	}
	/**
	 * ��ȡ�Ƶ�ȫ���Żݲ���
	 * @param hotel_id
	 * @return
	 */
	public List<DiscountVO_hotel> getHotelDiscount(String hotel_id){
		Discount_stub test=new Discount_stub();
		return test.getHotelDiscount(hotel_id);
	
		
	}
	
	
	
}
