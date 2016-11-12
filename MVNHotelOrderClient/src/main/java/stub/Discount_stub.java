package stub;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import businesslogicservice.DiscountHotelService;
import businesslogicservice.DiscountWebService;
import tools.ResultMessage;
import tools.ResultMessage2;
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


	
	public DiscountVO_hotel editHotelDiscount(String discount_id) {
		// TODO Auto-generated method stub
		Date t1=new Date(2016,9,1);
		Date t2=new Date(2016,9,2);
		DiscountVO_hotel dvo= new DiscountVO_hotel("0000",9.9,t1,t2);
		dvo.Discount_id=discount_id;
		return dvo;
	}

	
	public ResultMessage2 saveDiscount(DiscountVO discount) {
		// TODO Auto-generated method stub
		if(discount!=null)return ResultMessage2.success;
		else
		return ResultMessage2.fail;
	}


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


	public ResultMessage2 addWebDiscount(DiscountVO_web dis) {
		// TODO Auto-generated method stub
		if(dis!=null)return ResultMessage2.success;
		else
			return ResultMessage2.fail;
		
	}



	public DiscountVO_web editWebDiscount(String Discount_id) {
		// TODO Auto-generated method stub
		Date t1=new Date(2016,9,1);
		Date t2=new Date(2016,9,2);
		DiscountVO_web dis=new DiscountVO_web(10,"新街口",9.9,t1,t2,10);
		
		return dis;
	}

	
}
