package dataservice.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import DataFactory.DataHelperUtils;
import dataservice.OrderDataService;
import dataservice.datahelper.OrderDataHelper;
import dataservice.datahelper.RoomDateHelper;
import po.OrderAssessPO;
import po.OrderNotChangePO;
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
		
		if(order.getRevokeTime()!=null||order.getCheckOutTime()!=null){
			//OrderNotChangePO orderNotChangePO = orderDataHelper.getOrderNotChangePO(order.getOrderID());
			Date date = order.getLatestTime();
			RoomDateHelper roomDateHelper = DataHelperUtils.getRoomDateHelper();
			List<String> roomList = order.getRoomNumber();
			for (int i = 0; i < roomList.size(); i++) {
				roomDateHelper.deleteRecord(order.getHotelID(), roomList.get(i), date);
			}		
		}
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

	public List<OrderPO> searchFuzzyOrder(String hotelID, String customerID, String input, Date begin) throws RemoteException {
		List<String>  allIDList;
		// getAll list by State  if null get all
		List<OrderSearchStorePO>   polist = orderDataHelper.getOrderListBycondition
				(null, hotelID, customerID);
		
		String inputPattern = null ;
		if(input!=null){
			inputPattern = ".*";
			for (int i = 0; i < input.length(); i++) {
				inputPattern = inputPattern + input.charAt(i)+".*";
			}
		}
		
		Iterator<OrderSearchStorePO>  it = polist.iterator();
		List<String>   strList = new ArrayList<String>();
		while(it.hasNext()){
			OrderSearchStorePO orderSearchStorePO = it.next();
			String orderID = orderSearchStorePO.getOrderID();
			String hoteID = orderSearchStorePO.getHotelID();
			String cutomerID = orderSearchStorePO.getCustomerID();
			if(orderDataHelper.isValidCustomerName(inputPattern, cutomerID)  || 
					orderDataHelper.isValidHotelName(inputPattern, hoteID))
				strList.add(orderID);
		}
		
		Iterator<String>  listit = strList.iterator();
		List<String>  newlist = new ArrayList<String>();
		while(listit.hasNext()){
			String orderID = listit.next();
			if(orderDataHelper.isValidTime(orderID,begin))
				newlist.add(orderID);
		}
		
		List<OrderPO>  listpo = new ArrayList<OrderPO>();
		Iterator<String>  iter = newlist.iterator();
		while(iter.hasNext()){
			listpo.add(orderDataHelper.getCompleteOrderPO(iter.next()));
		}	
		return listpo;
	}
	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.OrderDataService#assessOrder(po.OrderAssessPO)
	 */
	public ResultMessage assessOrder(OrderAssessPO orderAssessPO) throws RemoteException {
		return orderDataHelper.updateAssess(orderAssessPO);
	}

}
