package stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dataservice.OrderDataService;
import po.OrderAssessPO;
import po.OrderPO;
import po.SearchOrderInfo;
import tools.ResultMessage;

public class OrderDate_Stub implements OrderDataService{

	
	public ResultMessage add(OrderPO order) {
		if(order.getOrderID()!=null){
			return ResultMessage.Exist;
		}
		return ResultMessage.NotExist;
	}

	
	public OrderPO findOrder(String order_id) {
		if(order_id!=null){
			return new OrderPO(order_id);
		}
		return null;
	}

	
	public ResultMessage modify(OrderPO order) {
		if(order.getOrderID()!=null){
			return ResultMessage.Exist;
		}
		return ResultMessage.NotExist;
	}

	
	public List<OrderPO> searchOrder(SearchOrderInfo searchOrderInfo) {
		List<OrderPO> list=new ArrayList<OrderPO>();
		return list;
	}


	@Override
	public List<String> getAllComment(String hotelID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<OrderPO> searchFuzzyOrder(String hotelID, String cusrtomerID, String input, Date begin)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ResultMessage assessOrder(OrderAssessPO orderAssessPO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
