package businesslogic.order;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Exception.CustomerCreditNotEnoughException;
import businesslogic.credit.CreditController;
import businesslogic.customer.CustomerDealController;
import businesslogic.customer.OrderCustomerInfoImpl;
import businesslogic.hotel.OrderHotelInfoImpl;
import businesslogic.login.LoginController;
import businesslogicservice.CreditLogDealService;
import businesslogicservice.CustomerDealService;
import businesslogicservice.LoginService;
import businesslogicservice.OrderService;
import dataservice.OrderDataService;
import po.OrderPO;
import po.SearchOrderInfo;
import rmi.RemoteHelper;
import tools.AccountType;
import tools.ActionType;
import tools.OrderState;
import tools.RecoverValue;
import tools.ResultMessage;
import vo.ExecutionInfoVO;
import vo.OrderInputVO;
import vo.OrderVO;
import vo.SearchOrderInfoVO;

/**
 * 订单的控制器，实现OrderService
 * @author zjy
 *
 */
public class OrderController implements OrderService{
	private static OrderController orderController;
	private OrderDataService orderDataService;
	
	
	/**
	 * 单件模式，通过静态方法得到实例化的对象
	 * @return 实例化的OrderController
	 */
	public static OrderController getInstance(){
		if(orderController==null){
			orderController = new OrderController();
		}
		return orderController;
	}

	/**
	 * 
	 * @param orderDataService 实现了orderDataService接口的对象
	 */
	public OrderController(OrderDataService orderDataService) {
		super();
		this.orderDataService = orderDataService;
	}
	
	/**
	 * 通过RMI得到OrderDataService的构造方法
	 * @author wsw
	 */
	public OrderController() {
		super();
		this.orderDataService = RemoteHelper.getInstance().getOrderDataService();
	}
	
	private OrderVO getOrderVO(Order order) {
		if(order==null){
			return null;
		}
		OrderVO orderVO=new OrderVO();
		orderVO.orderID=order.getOrderID();
		orderVO.customerID=order.getCustomer().customerID;
		orderVO.hotelID=order.getHotelInfo().hotelID;
		orderVO.roomNumber=order.getRoomNumber();
		orderVO.startTime=order.getPlacingOrderInfo().startTime;
		orderVO.latestTime=order.getPlacingOrderInfo().latestTime;
		orderVO.planedLeaveTime=order.getPlacingOrderInfo().planedLeaveTime;
		orderVO.checkInTime=order.getCheckInAndOutInfo().checkInTime;
		orderVO.planedCheckOutTime=order.getCheckInAndOutInfo().planedLeaveTime;
		orderVO.checkOutTime=order.getCheckInAndOutInfo().checkOutTime;
		orderVO.revokeTime=order.getRevokeTime();
		orderVO.roomType=order.getPlacingOrderInfo().roomType;
		orderVO.numberOfRooms=order.getPlacingOrderInfo().numberOfRooms;
		orderVO.value=order.getOrderValue();
		orderVO.planedPeopleNumber=order.getPlacingOrderInfo().planedPeopleNumber;
		orderVO.child=order.getPlacingOrderInfo().child;
		orderVO.orderState=order.getState();
		orderVO.mark=order.getAssessInfo().mark;
		orderVO.assessment=order.getAssessInfo().assessment;
		return orderVO;
	}
	private OrderVO getOrderVO(OrderPO orderPO) {
		if(orderPO==null){
			return null;
		}
		OrderVO orderVO=new OrderVO();
		orderVO.orderID=orderPO.getOrderID();
		orderVO.customerID=orderPO.getCustomerID();
		orderVO.hotelID=orderPO.getHotelID();
		orderVO.roomNumber=orderPO.getRoomNumber();
		orderVO.startTime=orderPO.getStartTime();
		orderVO.latestTime=orderPO.getLatestTime();
		orderVO.planedLeaveTime=orderPO.getPlanedLeaveTime();
		orderVO.checkInTime=orderPO.getCheckInTime();
		orderVO.planedCheckOutTime=orderPO.getPlanedCheckOutTime();
		orderVO.checkOutTime=orderPO.getCheckOutTime();
		orderVO.revokeTime=orderPO.getRevokeTime();
		orderVO.roomType=orderPO.getRoomType();
		orderVO.numberOfRooms=orderPO.getNumberOfRooms();
		orderVO.value=orderPO.getValue();
		orderVO.planedPeopleNumber=orderPO.getPlanedPeopleNumber();
		orderVO.child=orderPO.isChild();
		orderVO.orderState=orderPO.getOrderState();
		orderVO.mark=orderPO.getMark();
		System.out.println("change:         "+orderPO.getAssessment());
		orderVO.assessment=orderPO.getAssessment();
		return orderVO;
	
	}
	
	/**
	 * 创建订单
	 * @param orderInput 下单信息
	 * @return 订单信息
	 * @throws CustomerCreditNotEnoughException 客户信用值为负
	 */
	public ResultMessage createOrders(OrderInputVO orderInput) throws CustomerCreditNotEnoughException {
		if(orderInput==null){
			return null;
		}
		Order order=new Order(orderInput, new OrderCustomerInfoImpl(), new OrderHotelInfoImpl() , orderDataService);
		//TODO: 暂时先用Mock代替
		return order.saveOrder();
	}
	/**
	 * 持久化保存订单
	 * @deprecated
	 * 因每次创建新订单时Order对象会自动持久化保存订单，所以应该用不到
	 * @param preorder 订单信息
	 * @return 调用成功则返回Exist，失败返回NotExist
	 */
	public ResultMessage saveOrder(OrderVO preorder) {
		if(preorder==null){
			return ResultMessage.NotExist;
		}
		try {
			Order order = new Order(orderDataService.findOrder(preorder.orderID), new MockCustomerInfo(), 
					new MockHotelInfo(), orderDataService);//TODO: 暂时先用Mock代替
			return order.saveOrder();
		} catch (RemoteException e) {
			System.err.println(e.getCause().getMessage());
			return ResultMessage.NotExist;
		}
	}
	/**
	 * 搜索订单
	 * @param searchOrderInfo 搜索订单的搜索条件
	 * @return 符合条件的订单列表
	 */
	public List<OrderVO> CheckOrderList(SearchOrderInfoVO searchOrderInfo) {
		if(searchOrderInfo==null){
			return null;
		}
		try {
			LoginService loginService=LoginController.getInstance();
			String hotelID = loginService.getLogState().accountType.equals(AccountType.Hotel)?
					loginService.getLogState().accountID:null;
			String customerID = loginService.getLogState().accountType.equals(AccountType.Customer)?
					loginService.getLogState().accountID:null;
			
			//把关键字分别当做订单ID、客户姓名、酒店名称来搜索
			List<OrderPO> poList=orderDataService.searchOrder(new SearchOrderInfo(hotelID,customerID,
					searchOrderInfo.keywords, null, null, searchOrderInfo.date, searchOrderInfo.orderState));
			System.out.println("polist size1:   "+poList.size());
			poList.addAll(orderDataService.searchOrder(new SearchOrderInfo(hotelID,customerID,null, 
					searchOrderInfo.keywords, null, searchOrderInfo.date, searchOrderInfo.orderState)));
			System.out.println("polist size2:   "+poList.size());
			poList.addAll(orderDataService.searchOrder(new SearchOrderInfo(hotelID,customerID,null, null, 
					searchOrderInfo.keywords, searchOrderInfo.date, searchOrderInfo.orderState)));
			List<OrderVO> voList=new ArrayList<OrderVO>();
			System.out.println("polist size3:   "+poList.size());
			for(OrderPO orderPO:poList){
				voList.add(getOrderVO(orderPO));
			}
			return voList;
		} catch (RemoteException e) {
			System.err.println(e.getCause().getMessage());
			return new ArrayList<OrderVO>();
		}
	}
	/**
	 * 获取单个订单的信息
	 * @param order_id 订单的ID
	 * @return 订单的信息，如果获取失败，则返回null
	 */
	public OrderVO checkSingleOrder(String order_id) {
		if(order_id==null){
			return null;
		}
		try {
			OrderPO orderPO  = orderDataService.findOrder(order_id);
			System.out.println(orderPO.getAssessment());
			return getOrderVO(orderDataService.findOrder(order_id));
		} catch (RemoteException e) {
			System.err.println(e.getCause().getMessage());
			return null;
		}
	}
	/**
	 * 撤销订单
	 * @param order 订单的信息
	 * @return 调用成功则返回Exist，失败返回NotExist
	 */
	public ResultMessage revokeCurrentOrder(OrderVO order) {
		if(order==null){
			return ResultMessage.NotExist;
		}
		try {
			OrderPO orderPO=orderDataService.findOrder(order.orderID);
			if(orderPO==null){
				return ResultMessage.NotExist;
			}
			Order order2=new Order(orderPO,  new MockCustomerInfo(),new MockHotelInfo(), orderDataService); 
			//TODO: 暂时先用Mock代替
			if(order2.getState().equals(OrderState.Unexecuted)){
				CreditLogDealService creditLogDealService=CreditController.getInstance();
				creditLogDealService.CreditChangeAboutOrder(order2, ActionType.RevokeOrder);
				order2.setRevokeTime(new Date());
				return order2.changeState(OrderState.Revoked);
			}
		} catch (RemoteException e) {
			System.err.println(e.getCause().getMessage());
		}
		return ResultMessage.NotExist;
	}
	/**
	 * 计算撤销订单将要损失的信用值
	 * @param order 订单的信息
	 * @return 预计损失的信用值，如果找不到订单，则返回-1
	 */
	public int calculateCreditLose(OrderVO order) {
		if(order==null){
			throw new NullPointerException();
		}
		try {
			OrderPO orderPO=orderDataService.findOrder(order.orderID);
			if(orderPO==null){
				return -1;
			}
			Order order2=new Order(orderPO,  new MockCustomerInfo(),new MockHotelInfo(), orderDataService); 
			//TODO: 暂时先用Mock代替
			//如果撤销的订单距离最晚订单执行时间不足6个小时，撤销的同时扣除信用值，信用值为订单的（总价值*1/2）
			return new Date().getTime()-order2.getPlacingOrderInfo().latestTime.getTime()>6*24*60*1000?
					0:order2.getOrderValue()/2;
		} catch (RemoteException e) {
			System.err.println(e.getCause().getMessage());
			return -1;
		}
	}
	/**
	 * 客户到店办理入住时，酒店工作人员执行订单，即修改订单的入住信息
	 * @param executionInfo 修改的信息
	 * @return 调用成功则返回Exist，失败返回NotExist
	 */
	public ResultMessage executionModify(ExecutionInfoVO executionInfo) {
		if(executionInfo==null){
			return ResultMessage.NotExist;
		}
		try {
			OrderPO orderPO=orderDataService.findOrder(executionInfo.orderID);
			if(orderPO==null){
				return ResultMessage.NotExist;
			}
			Order order=new Order(orderPO,  new MockCustomerInfo(),new MockHotelInfo(), orderDataService); 
			//TODO: 暂时先用Mock代替
			boolean checkIn=order.modifyCheckInInfo(executionInfo);
			boolean checkOut=order.modifyCheckOutInfo(executionInfo);
			if(checkIn&&checkOut){
				return ResultMessage.Exist;
			}
		} catch (RemoteException e) {
			System.err.println(e.getCause().getMessage());
		}
		return ResultMessage.NotExist;
	}
	/**
	 * 时间超过最晚到店时间时，自动将订单置为异常订单
	 * @deprecated 因为订单对象会定时自动刷新，所以这个方法应该用不着
	 * @param Order 订单信息
	 * @return 调用成功则返回Exist，失败返回NotExist
	 */
	public ResultMessage AutoToBad(OrderVO Order) {
		if(Order==null){
			return ResultMessage.NotExist;
		}
		try {
			OrderPO orderPO=orderDataService.findOrder(Order.orderID);
			if(orderPO==null){
				return ResultMessage.NotExist;
			}
			Order order2=new Order(orderPO,  new MockCustomerInfo(),new MockHotelInfo(), orderDataService); 
			//TODO: 暂时先用Mock代替
			return ResultMessage.Exist;
		} catch (RemoteException e) {
			System.err.println(e.getCause().getMessage());
			return ResultMessage.NotExist;
		}
	}
	/**
	 * 撤销异常订单
	 * @param badOrder 订单信息
	 * @param recoverValue 选择恢复全部的信用值还是一半
	 * @return 调用成功则返回Exist，失败返回NotExist
	 */
	public ResultMessage revokeBadOrderr(OrderVO badOrder,RecoverValue recoverValue) {
		if(badOrder==null){
			return ResultMessage.NotExist;
		}
		try {
			OrderPO orderPO=orderDataService.findOrder(badOrder.orderID);
			if(orderPO==null){
				return ResultMessage.NotExist;
			}
			Order order=new Order(orderPO,  new MockCustomerInfo(),new MockHotelInfo(), orderDataService); 
			//TODO: 暂时先用Mock代替
			if(order.getState().equals(OrderState.Exception)){
				CreditLogDealService creditLogDealService=CreditController.getInstance();
				creditLogDealService.Recover(order, recoverValue);
				order.setRevokeTime(new Date());
				return order.changeState(OrderState.Revoked);
			}
		} catch (RemoteException e) {
			System.err.println(e.getCause().getMessage());
		}
		return ResultMessage.NotExist;
	}

}
