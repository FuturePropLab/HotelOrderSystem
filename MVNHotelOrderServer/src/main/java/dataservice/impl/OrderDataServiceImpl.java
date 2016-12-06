package dataservice.impl;

import java.rmi.RemoteException;
import java.util.List;

import dataservice.OrderDataService;
import po.OrderPO;
import po.SearchOrderInfo;
import tools.ResultMessage;

public class OrderDataServiceImpl implements OrderDataService {

	public ResultMessage add(OrderPO order) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public OrderPO findOrder(String order_id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage modify(OrderPO order) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<OrderPO> searchOrder(SearchOrderInfo searchOrderInfo) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
