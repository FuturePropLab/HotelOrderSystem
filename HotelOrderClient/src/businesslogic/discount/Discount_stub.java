package businesslogic.discount;

import java.util.LinkedList;
import java.util.List;

import businesslogicservice.DiscountHotel_blService;
import businesslogicservice.DiscountWeb_blService;
import tools.ResultMessage;
import vo.DiscountVO;

public class Discount_stub implements DiscountWeb_blService,DiscountHotel_blService{

	@Override
	public DiscountVO addHotelDiscount(String hotel_id) {
		// TODO Auto-generated method stub
		DiscountVO dvo=new DiscountVO();
		dvo.Discount_id=hotel_id;
		return dvo;
	}

	@Override
	public DiscountVO getSingleHotelDiscount(String discount_id) {
		// TODO Auto-generated method stub
		DiscountVO dvo=new DiscountVO();
		dvo.Discount_id=discount_id;
		return dvo;
	}

	@Override
	public List<DiscountVO> getHotelDiscount(String hotel_id) {
		// TODO Auto-generated method stub
		DiscountVO dvo=new DiscountVO();
		dvo.Discount_id=hotel_id;
		List<DiscountVO> list=new LinkedList();
		list.add(dvo);
		return list;
		
	}

	@Override
	public ResultMessage addHotelDiscount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DiscountVO editHotelDiscount(String Discount_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage saveDiscount(DiscountVO discount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DiscountVO getAHotelDiscount(String Discount_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
