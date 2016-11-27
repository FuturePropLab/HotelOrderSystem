package stub;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import businesslogicservice.DiscountHotelService;
import businesslogicservice.DiscountWebService;
import tools.ResultMessage;
import tools.ResultMessage2;
import tools.ResultMessage_strategy;
import vo.DiscountVO;
import vo.DiscountVO_hotel;
import vo.DiscountVO_web;

public class Discount_stub implements DiscountWebService,DiscountHotelService{

	
	public ResultMessage2 addHotelDiscount(String hotel_id) {
		// TODO Auto-generated method stub
		DiscountVO dvo=new DiscountVO();
		dvo.Discount_id=hotel_id;
		return ResultMessage2.success;
	}

	
	public DiscountVO_hotel getSingleHotelDiscount(String discount_id) {
		// TODO Auto-generated method stub
		Date t1=new Date(2016,9,1);
		Date t2=new Date(2016,9,2);
		DiscountVO_hotel dvo=new DiscountVO_hotel("0000",9.9,t1,t2);
		dvo.Discount_id=discount_id;
		return dvo;
	}

	
	public List<DiscountVO_hotel> getHotelDiscount(String hotel_id) {
		// TODO Auto-generated method stub
		
		Date t1=new Date(2016,9,1);
		Date t2=new Date(2016,9,2);
		DiscountVO_hotel dvo=new DiscountVO_hotel("0000",9.9,t1,t2);
		List<DiscountVO_hotel> list=new LinkedList();
		list.add(dvo);
		return list;
		
	}


	
	public ResultMessage_strategy editHotelDiscount(String discount_id,DiscountVO_hotel dis) {
		// TODO Auto-generated method stub
		Date t1=new Date(2016,9,1);
		Date t2=new Date(2016,9,2);
		DiscountVO_hotel dvo= new DiscountVO_hotel("0000",9.9,t1,t2);
		dvo.Discount_id=discount_id;
		return ResultMessage_strategy.Success;
	}

//	
//	public ResultMessage_strategy saveDiscount(DiscountVO_hotel disvo) {
//		// TODO Auto-generated method stub
//		if(disvo!=null)return ResultMessage_strategy.Success;
//		else
//		return ResultMessage_strategy.Conflict;
//	}


	/*public DiscountVO getAHotelDiscount(String Discount_id) {
		// TODO Auto-generated method stub
		DiscountVO dis=new DiscountVO();
		if(dis.Discount_id=="0000"){
			dis.Discount_id="0000";
			dis.discount=6;
			return dis;
		}
		else return dis;
		
	}*/


	public ResultMessage_strategy addWebDiscount(DiscountVO_web dis) {
		// TODO Auto-generated method stub
		if(dis!=null)return ResultMessage_strategy.Success;
		else
			return ResultMessage_strategy.Existed;
		
	}



	public DiscountVO_web editWebDiscount(String Discount_id) {
		// TODO Auto-generated method stub
		Date t1=new Date(2016,9,1);
		Date t2=new Date(2016,9,2);
		DiscountVO_web dis=new DiscountVO_web(10,"新街口",9.9,t1,t2,10);
		
		return dis;
	}


	public DiscountVO_web getWebDiscount(String Discount_id) {
		// TODO Auto-generated method stub
		Date t1=new Date(2016,9,1);
		Date t2=new Date(2016,9,2);
		DiscountVO_web dis=new DiscountVO_web(10,"新街口",9.9,t1,t2,10);
		return dis;
	}




	public ResultMessage_strategy addHotelDiscount(String hotel_id, DiscountVO_hotel discountVO_hotel) {
		// TODO Auto-generated method stub
		return null;
	}


	public ResultMessage_strategy deleteDiscount(DiscountVO discount) {
		// TODO Auto-generated method stub
		return null;
	}


	public ResultMessage_strategy deleteHotelDiscount(String hotel_id, String discount_id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
