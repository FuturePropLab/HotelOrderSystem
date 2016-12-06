package dataservice.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import DataFactory.DataHelperUtils;
import dataservice.OrderDataService;
import dataservice.datahelper.OrderDataHelper;
import po.OrderPO;
import po.SearchOrderInfo;
import tools.ResultMessage;

public class OrderDataServiceImpl implements OrderDataService {
	private OrderDataHelper orderDataHelper ;
	
	public OrderDataServiceImpl(){
		this.orderDataHelper =  DataHelperUtils.getOrderDataHelper();
	}
	
	public ResultMessage add(OrderPO orderPO) throws RemoteException {
		List<String> roomList = orderDataHelper.getArrangeRoom
				(orderPO.getHotelID(), orderPO.getRoomType(), orderPO.getNumberOfRooms(),
						orderPO.getLatestTime(), orderPO.getPlanedLeaveTime());
		if(roomList == null)  return ResultMessage.NotExist;
		
		orderPO.setRoomNumber((ArrayList<String>) roomList);
		
		return orderDataHelper.addCompleteOrderPO(orderPO);
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
