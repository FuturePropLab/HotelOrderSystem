package stub;

import java.util.LinkedList;
import java.util.List;

import businesslogicservice.DiscountHotelService;
import businesslogicservice.DiscountWebService;
import tools.ResultMessage;
import vo.DiscountVO;

public class Discount_stub implements DiscountWebService,DiscountHotelService{

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
	public DiscountVO editHotelDiscount(String discount_id) {
		// TODO Auto-generated method stub
		DiscountVO dvo= new DiscountVO();
		dvo.Discount_id=discount_id;
		return dvo;
	}

	@Override
	public ResultMessage saveDiscount(DiscountVO discount) {
		// TODO Auto-generated method stub
		if(discount!=null)return ResultMessage.Exist;
		else
		return ResultMessage.NotExist;
	}

	@Override
	public DiscountVO getAHotelDiscount(String Discount_id) {
		// TODO Auto-generated method stub
		DiscountVO dis=new DiscountVO();
		if(dis.Discount_id=="0000"){
			dis.Discount_id="0000";
			dis.discount=6;
			return dis;
		}
		else return dis;
		
	}

	@Override
	public ResultMessage addWebDiscount(DiscountVO dis) {
		// TODO Auto-generated method stub
		if(dis!=null)return ResultMessage.Exist;
		else
			return ResultMessage.NotExist;
		
	}

	
}
