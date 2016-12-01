package businesslogic.order;

import java.util.ArrayList;
import java.util.List;

import Exception.CustomerCreditNotEnoughException;
import businesslogicservice.OrderService;
import dataservice.OrderDataService;
import po.OrderPO;
import po.SearchOrderInfo;
import rmi.RemoteHelper;
import tools.OrderState;
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
	
	/**
	 * 单件模式，通过静态方法得到实例化的对象
	 * @return 实例化的OrderController
	 */
	public OrderController getInstance(){
		if(orderController==null)
			orderController = new OrderController();
		return orderController;
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
		orderVO.checkOutTime=orderPO.getCheckOutTime();
		orderVO.revokeTime=orderPO.getRevokeTime();
		orderVO.roomType=orderPO.getRoomType();
		orderVO.numberOfRooms=orderPO.getNumberOfRooms();
		orderVO.value=orderPO.getValue();
		orderVO.planedPeopleNumber=orderPO.getPlanedPeopleNumber();
		orderVO.child=orderPO.isChild();
		orderVO.orderState=orderPO.getOrderState();
		orderVO.mark=orderPO.getMark();
		orderVO.assessment=orderPO.getAssessment();
		return orderVO;
	}
	
	/**
	 * 创建订单
	 * @param orderInput 下单信息
	 * @return 订单信息
	 * @throws CustomerCreditNotEnoughException 客户信用值为负
	 */
	public OrderVO createOrders(OrderInputVO orderInput) throws CustomerCreditNotEnoughException {
		if(orderInput==null){
			return null;
		}
		Order order=new Order(orderInput, new MockCustomerInfo(), new MockHotelInfo(), orderDataService);//TODO: 暂时先用Mock代替
		return getOrderVO(order);
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
		Order order=new Order(orderDataService.findOrder(preorder.orderID), new MockCustomerInfo(), //TODO: 暂时先用Mock代替
				new MockHotelInfo(), orderDataService);
		if(order.saveOrder()){
			return ResultMessage.Exist;
		}
		return ResultMessage.NotExist;
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
		List<OrderPO> poList=orderDataService.searchOrder(new SearchOrderInfo(searchOrderInfo.orderID, 
				searchOrderInfo.customerID, searchOrderInfo.hotelID, searchOrderInfo.startTime, 
				searchOrderInfo.orderState));
		List<OrderVO> voList=new ArrayList<OrderVO>();
		for(OrderPO orderPO:poList){
			voList.add(getOrderVO(orderPO));
		}
		return voList;
	}
	/**
	 * 获取单个订单的信息
	 * @param order_id 订单的ID
	 * @return 订单的信息
	 */
	public OrderVO checkSingleOrder(String order_id) {
		if(order_id==null){
			return null;
		}
		return getOrderVO(orderDataService.findOrder(order_id));
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
		OrderPO orderPO=orderDataService.findOrder(order.orderID);
		if(orderPO==null){
			return ResultMessage.NotExist;
		}
		Order order2=new Order(orderPO,  new MockCustomerInfo(),new MockHotelInfo(), orderDataService); //TODO: 暂时先用Mock代替
		if(order2.getState().equals(OrderState.Unexecuted)){
			return order2.changeState(OrderState.Revoked)? ResultMessage.Exist:ResultMessage.NotExist;
		}
		return ResultMessage.NotExist;
	}
	/**
	 * 计算撤销订单将要损失的信用值
	 * @param order 订单的信息
	 * @return 预计损失的信用值，如果order为null，则返回-1
	 */
	public int calculateCreditLose(OrderVO order) {
		if(order==null){
			return -1;
		}
		OrderPO orderPO=orderDataService.findOrder(order.orderID);
		if(orderPO==null){
			return -1;
		}
		Order order2=new Order(orderPO,  new MockCustomerInfo(),new MockHotelInfo(), orderDataService); //TODO: 暂时先用Mock代替
		return order2.getOrderValue();
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
		OrderPO orderPO=orderDataService.findOrder(executionInfo.orderID);
		if(orderPO==null){
			return ResultMessage.NotExist;
		}
		Order order=new Order(orderPO,  new MockCustomerInfo(),new MockHotelInfo(), orderDataService); //TODO: 暂时先用Mock代替
		boolean checkIn=order.modifyCheckInInfo(executionInfo);
		boolean checkOut=order.modifyCheckOutInfo(executionInfo);
		if(checkIn&&checkOut){
			return ResultMessage.Exist;
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
		OrderPO orderPO=orderDataService.findOrder(Order.orderID);
		if(orderPO==null){
			return ResultMessage.NotExist;
		}
		Order order2=new Order(orderPO,  new MockCustomerInfo(),new MockHotelInfo(), orderDataService); //TODO: 暂时先用Mock代替
		return ResultMessage.Exist;
	}
	/**
	 * 撤销异常订单
	 * @param badOrder 订单信息
	 * @return 调用成功则返回Exist，失败返回NotExist
	 */
	public ResultMessage revokeBadOrderr(OrderVO badOrder) {
		if(badOrder==null){
			return ResultMessage.NotExist;
		}
		OrderPO orderPO=orderDataService.findOrder(badOrder.orderID);
		if(orderPO==null){
			return ResultMessage.NotExist;
		}
		Order order=new Order(orderPO,  new MockCustomerInfo(),new MockHotelInfo(), orderDataService); //TODO: 暂时先用Mock代替
		if(order.getState().equals(OrderState.Exception)){
			return order.changeState(OrderState.Unexecuted)? ResultMessage.Exist:ResultMessage.NotExist;
		}
		return ResultMessage.NotExist;
	}

}
