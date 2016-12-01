package businesslogic.hotel;

import java.util.ArrayList;
import java.util.List;

import Exception.CustomerCreditNotEnoughException;
import businesslogic.order.CustomerInfo;
import businesslogic.order.HotelInfo;
import businesslogic.order.Order;
import dataservice.OrderDataService;
import vo.CommentVO;
import vo.OrderInputVO;

public class MockOrder extends Order implements getComment{

	public MockOrder(OrderInputVO orderInput, CustomerInfo customerInfo, HotelInfo hotelInfo,
			OrderDataService orderDataService) throws CustomerCreditNotEnoughException {
		super(orderInput, customerInfo, hotelInfo, orderDataService);
		// TODO Auto-generated constructor stub
	}

	public List<CommentVO> getComment() {
		// TODO Auto-generated method stub
		List<CommentVO> list=new ArrayList();
		CommentVO c=new CommentVO("GOOD");
		list.add(c);
		
		
		return list;
	}

}
