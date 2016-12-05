package businesslogicservice.impl;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import businesslogic.discount.HotelDiscount;
import stub.Discount_stub;
import tools.ResultMessage_Discount;
import vo.DiscountVO_hotel;

public class TestHotelDiscount {

	@Test
	public void test() throws RemoteException {
		Date t1=new Date(2016,9,1);
		Date t2=new Date(2016,9,2);
		ResultMessage_Discount expect=ResultMessage_Discount.Fail;
		String hotelid="0000";
		String discountid="0001";
		HotelDiscount test=new HotelDiscount();
//		DiscountVO_hotel expect2=new DiscountVO_hotel("0000",9.9,t1,t2);
		List<DiscountVO_hotel> list=new LinkedList();
//		list.add(expect2);
		assertEquals(t1,test.getHotelDiscount(hotelid).get(0).startDate);
//		assertEquals(t1,test.getSingleHotelDiscount(discountid).startDate);
//		assertEquals(t2,test.editHotelDiscount(hotelid).EndDate);
//		assertEquals(ResultMessage2.success,test.addHotelDiscount(hotelid));
	}
	}
		/*public ResultMessage2 addHotelDiscount(String hotel_id) {
			// TODO Auto-generated method stub
			Discount_stub test=new Discount_stub();
			
			return test.addHotelDiscount(hotel_id);
		}
		public DiscountVO_hotel editHotelDiscount(String Discount_id){
			Discount_stub test=new Discount_stub();
			return test.editHotelDiscount(Discount_id);
			
			
			
			
		}
		public DiscountVO_hotel getSingleHotelDiscount(String Discount_id){
			Discount_stub test=new Discount_stub();
			return test.getSingleHotelDiscount(Discount_id);
					
			
		}
		public List<DiscountVO_hotel> getHotelDiscount(String hotel_id){
			Discount_stub test=new Discount_stub();
			return test.getHotelDiscount(hotel_id);
		
			
		}
	}

}*/
/*
package mock_blserviceImpl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import vo.DiscountVO;
import vo.OrderInputVO;

public class MockDiscount {
	 private String type;
	 private OrderInputVO orderInput;
	 public MockDiscount(OrderInputVO orderInput,String str){
		 this.orderInput=orderInput;
		 type=str;
	 }
	 public List<DiscountVO> getsuitableDiscount(){
		 //Ӧ�ø���type �� orderInput��get
		 List<DiscountVO> res=new LinkedList<DiscountVO>();
		 DiscountVO dv=new DiscountVO();
		 dv.discount=0.9;
		 dv.Discount_id="0001";
		 res.add(dv);
		 return res;
	 }
}
package strategyblserviceimpl;

import static org.junit.Assert.*;

import java.sql.Time;

import org.junit.Test;

import businesslogic.strategy.Strategy;
import mock_blserviceImpl.MockDiscount;
import tools.RoomType;
import vo.OrderInputVO;
import vo.StrategyVO;

public class TestStrategy {

	@Test
	public void test() {
		
		OrderInputVO orderInput = new OrderInputVO("0001", "00", Time.valueOf("2016/11/3"), Time.valueOf("2016/11/4"), Time.valueOf("2016/11/5"), RoomType.Double, 1, 1, false);
		Strategy str=new Strategy();
		StrategyVO expect=new StrategyVO(null, null);//���޸�
		
		MockDiscount disW = new MockDiscount(orderInput,"web");
		MockDiscount disH = new MockDiscount(orderInput,"hotel");
		disW.getsuitableDiscount()//������
		assertEquals(expect,str.CalculateBestStrategy(orderInput));
	}
	

}
*/