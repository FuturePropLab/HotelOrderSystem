package dataservice.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import DataFactory.DataHelperUtils;
import dataservice.OrderDataService;
import dataservice.datahelper.OrderDataHelper;
import po.OrderAssessPO;
import po.OrderPO;
import po.OrderSearchStorePO;
import po.SearchOrderInfo;
import tools.ResultMessage;

public class OrderDataServiceImpl implements OrderDataService {
	private OrderDataHelper orderDataHelper ;
	
	public OrderDataServiceImpl(){
		this.orderDataHelper =  DataHelperUtils.getOrderDataHelper();
	}
	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.OrderDataService#add(po.OrderPO)
	 */
	public ResultMessage add(OrderPO orderPO) throws RemoteException {
		List<String> roomList = orderDataHelper.getArrangeRoom
				(orderPO.getHotelID(), orderPO.getRoomType(), orderPO.getNumberOfRooms(),
						orderPO.getLatestTime(), orderPO.getPlanedLeaveTime());
		if(roomList == null)  return ResultMessage.NotExist;
		
		orderPO.setRoomNumber((ArrayList<String>) roomList);		
		return orderDataHelper.addCompleteOrderPO(orderPO);
	}

	public OrderPO findOrder(String order_id) throws RemoteException {
		return orderDataHelper.getCompleteOrderPO(order_id);
	}
	
	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.OrderDataService#modify(po.OrderPO)
	 */
	
	public ResultMessage modify(OrderPO order) throws RemoteException {
		double markV = 5.0;
		if(order.getMark()!=null){
			markV = order.getMark().getValue();
		}
		OrderAssessPO orderAssessPO = new OrderAssessPO(order.getOrderID(),order.getHotelID(),markV,order.getAssessment());
		ResultMessage rs = orderDataHelper.modifyOrderAssessPO(orderAssessPO);
		if(rs == ResultMessage.NotExist)  return ResultMessage.NotExist;
		
		return  orderDataHelper.modifyOrderSearchPO(new OrderSearchStorePO(order));
	}

	
	
	
	
	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.OrderDataService#searchOrder(po.SearchOrderInfo)
	 */
	public List<OrderPO> searchOrder(SearchOrderInfo searchOrderInfo) throws RemoteException {
		
		List<OrderPO>  list = new ArrayList<OrderPO>();
		//get it if orderid not null
		if(!"".equals(searchOrderInfo.orderID) && searchOrderInfo.orderID !=null){
			OrderPO orderPO = findOrder(searchOrderInfo.orderID);
			if(orderPO != null) 
			list.add(orderPO);
			return list;
		}		
		
		List<String>  allIDList;
		// getAll list by State  if null get all
		List<OrderSearchStorePO>   polist = orderDataHelper.getOrderListBycondition
				(searchOrderInfo.orderState, searchOrderInfo.hotelID, searchOrderInfo.customerID);
		
		Iterator<OrderSearchStorePO>  it = polist.iterator();
		// check  if hotelname  or  customername;
		String hotelName = searchOrderInfo.hotelName;
		String customerName =  searchOrderInfo.customerName;
		
		String customerPattern = null ;
		String hotelPattern = null;
		
		if(hotelName!=null){
			hotelPattern = ".*";
			for (int i = 0; i < hotelName.length(); i++) {
				hotelPattern = hotelPattern + hotelName.charAt(i)+".*";
			}
		}
		
		System.out.println("customerPattern :  "+customerPattern);
		
		if(customerName !=null){
			customerPattern = ".*";
			for (int i = 0; i < customerName.length(); i++) {
				customerPattern = customerPattern + customerName.charAt(i)+".*";
			}
		}
		
		System.out.println("hotelPattern:  "+hotelPattern);
		
		List<String>   strList = new ArrayList<String>();
		while(it.hasNext()){
			OrderSearchStorePO orderSearchStorePO = it.next();
			String orderID = orderSearchStorePO.getOrderID();
			String hotelID = orderSearchStorePO.getHotelID();
			String cutomerID = orderSearchStorePO.getCustomerID();
			if(orderDataHelper.isValidCustomerName(customerPattern, cutomerID)  && 
					orderDataHelper.isValidHotelName(hotelPattern, hotelID))
				strList.add(orderID);
		}
		
		//check if date is not null;
		Iterator<String>  listit = strList.iterator();
		List<String>  newlist = new ArrayList<String>();
		while(listit.hasNext()){
			String orderID = listit.next();
			if(orderDataHelper.isValidTime(orderID,searchOrderInfo.startTime ))
				newlist.add(orderID);
		}
		//get all by id
		
		List<OrderPO>  listpo = new ArrayList<OrderPO>();
		Iterator<String>  iter = newlist.iterator();
		while(iter.hasNext()){
			listpo.add(orderDataHelper.getCompleteOrderPO(iter.next()));
		}	
		return listpo;
	}

	public List<String> getAllComment(String hotelID) throws RemoteException {
		return orderDataHelper.getAllComment(hotelID);
	}

}
