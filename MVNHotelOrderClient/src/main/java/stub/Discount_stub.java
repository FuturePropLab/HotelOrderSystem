package stub;

import java.util.LinkedList;
import java.util.List;

import businesslogicservice.DiscountHotelService;
import businesslogicservice.DiscountWebService;
import tools.ResultMessage;
import vo.DiscountVO;

public class Discount_stub implements DiscountWebService,DiscountHotelService{

	
	public DiscountVO addHotelDiscount(String hotel_id) {
		// TODO Auto-generated method stub
		DiscountVO dvo=new DiscountVO();
		dvo.Discount_id=hotel_id;
		return dvo;
	}

	
	public DiscountVO getSingleHotelDiscount(String discount_id) {
		// TODO Auto-generated method stub
		DiscountVO dvo=new DiscountVO();
		dvo.Discount_id=discount_id;
		return dvo;
	}

	
	public List<DiscountVO> getHotelDiscount(String hotel_id) {
		// TODO Auto-generated method stub
		DiscountVO dvo=new DiscountVO();
		dvo.Discount_id=hotel_id;
		List<DiscountVO> list=new LinkedList();
		list.add(dvo);
		return list;
		
	}


	
	public DiscountVO editHotelDiscount(String discount_id) {
		// TODO Auto-generated method stub
		DiscountVO dvo= new DiscountVO();
		dvo.Discount_id=discount_id;
		return dvo;
	}

	
	public ResultMessage saveDiscount(DiscountVO discount) {
		// TODO Auto-generated method stub
		if(discount!=null)return ResultMessage.Exist;
		else
		return ResultMessage.NotExist;
	}


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


	public ResultMessage addWebDiscount(DiscountVO dis) {
		// TODO Auto-generated method stub
		if(dis!=null)return ResultMessage.Exist;
		else
			return ResultMessage.NotExist;
		
	}

	
}
