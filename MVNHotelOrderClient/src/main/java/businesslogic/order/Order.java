package businesslogic.order;

import java.util.ArrayList;
import java.util.Date;

import Exception.CustomerCreditNotEnoughException;
import dataservice.OrderDataService;
import po.OrderPO;
import tools.MemberBelongType;
import tools.OrderState;
import tools.ResultMessage;
import vo.AssessVO;
import vo.CustomerVO;
import vo.ExecutionInfoVO;
import vo.HotelbriefVO;
import vo.OrderInputVO;

/**
 * 订单的领域类
 * orderID应该由data层决定，初始化order对象的时候应该没有orderID
 * @author zjy
 *
 */
public class Order {
	private String orderID;
	private Date revokeTime;//实际撤销时间
	private int value;//订单的价值
	private OrderState orderState;
	private PlacingOrderInfo placingOrderInfo;
	private CheckInInfo checkInInfo;
	private CheckOutInfo checkOutInfo;
	private AssessInfo assessInfo;
	private CustomerInfo customerInfo;
	private HotelInfo hotelInfo;
	private OrderDataService orderDataService;
//	private OrderPO orderPO;
	
	/**
	 * 订单的构造方法，通过客户下单生成订单，构造之后会调用saveOrder
	 * @param orderInput 下单信息
	 * @param customerInfo 实现客户信息接口的对象
	 * @param hotelInfo 实现酒店信息接口的对象
	 * @param OrderDataService 实现OrderDataService接口的对象
	 * @throws CustomerCreditNotEnoughException 客户信用值为负
	 */
	public Order(OrderInputVO orderInput,CustomerInfo customerInfo,HotelInfo hotelInfo,OrderDataService orderDataService) 
			throws CustomerCreditNotEnoughException{
		super();
		if(orderInput==null){
			return;
		}
		if(customerInfo.getCustomer(placingOrderInfo.customerID).credit<0){
			throw new CustomerCreditNotEnoughException();
		}
		else {
			this.customerInfo=customerInfo;
			this.hotelInfo=hotelInfo;
			this.orderDataService=orderDataService;
			init(orderInput);
			saveOrder();
//			sync();
		}
	}
	/**
	 * 订单的构造方法，通过从data层得到的OrderPO创建出的Order
	 * @param orderPO
	 * @param customerInfo
	 * @param hotelInfo
	 * @param orderDataService
	 */
	public Order(OrderPO orderPO,CustomerInfo customerInfo,HotelInfo hotelInfo,OrderDataService orderDataService){
		super();
		if(orderPO==null){
			return;
		}
		this.customerInfo=customerInfo;
		this.hotelInfo=hotelInfo;
		this.orderDataService=orderDataService;
		init(orderPO);
//		sync();
	}
	/**
	 * @deprecated
	 * 持久化保存订单
	 * @return  成功则返回true，失败返回false
	 */
	public boolean saveOrder(){
		return orderDataService.add(getOrderPO()).equals(ResultMessage.Exist);
	}
	/**
	 * 改变订单的状态
	 * @param orderState 希望改变后的状态
	 * @return 成功则返回true，失败返回false
	 */
	public boolean changeState(OrderState orderState){
		this.orderState=orderState;
		orderDataService.modify(getOrderPO());
		return true;
	}
	/**
	 * 修改订单的入住信息
	 * @param executionInfo 入住信息
	 * @return 修改成功返回true，失败返回false
	 */
	public boolean modifyCheckInInfo(ExecutionInfoVO executionInfo){
		if(executionInfo==null){
			return false;
		}
		if(!executionInfo.orderID.equals(this.orderID)){
			return false;
		}
		if(executionInfo.checkInTime!=null){
			checkInInfo.checkInTime=executionInfo.checkInTime;
		}
		if(executionInfo.planedLeaveTime!=null){
			checkInInfo.planedLeaveTime=executionInfo.planedLeaveTime;
		}
		if(executionInfo.roomNumber!=null){
			placingOrderInfo.roomNumber=executionInfo.roomNumber;
		}
		if(checkInInfo.filled()&&orderState.equals(OrderState.Unexecuted)){
			changeState(OrderState.Executed);
		}
		ResultMessage resultMessage=orderDataService.modify(getOrderPO());
		return resultMessage.equals(ResultMessage.Exist);
	}
	/**
	 * 修改订单的退房信息
	 * @param executionInfo 退房信息
	 * @return 修改成功返回true，失败返回false
	 */
	public boolean modifyCheckOutInfo(ExecutionInfoVO executionInfo){
		if(executionInfo==null){
			return false;
		}
		if(!executionInfo.orderID.equals(this.orderID)){
			return false;
		}
		if(executionInfo.checkOutTime!=null){
			checkOutInfo.checkOutTime=executionInfo.checkOutTime;
		}
		ResultMessage resultMessage=orderDataService.modify(getOrderPO());
		return resultMessage.equals(ResultMessage.Exist);
	}
	/**
	 * 
	 * @return 订单的状态
	 */
	public OrderState getState(){
		return orderState;
	}
	/**
	 * 
	 * @return 订单的价值
	 */
	public int getOrderValue(){
		return value;
	}
	/**
	 * 
	 * @return 订单的ID
	 */
	public String getOrderID(){
		return orderID;
	}
	/**
	 * 
	 * @return 下单的客户的信息
	 */
	public CustomerVO getCustomer(){
		return customerInfo.getCustomer(placingOrderInfo.customerID);
	}
	/**
	 * 
	 * 得到客户的下单信息
	 * @return 下单信息
	 */
	public OrderInputVO getPlacingOrderInfo(){
		return new OrderInputVO(placingOrderInfo.customerID, placingOrderInfo.hotelID, placingOrderInfo.startTime, 
				placingOrderInfo.latestTime, placingOrderInfo.planedLeaveTime, placingOrderInfo.roomType, 
				placingOrderInfo.numberOfRooms, placingOrderInfo.planedPeopleNumber, placingOrderInfo.child,
				placingOrderInfo.price);
	}
	/**
	 * 
	 * @return 订单相关的酒店信息
	 */
	public HotelbriefVO getHotelInfo(){
		return hotelInfo.getHotelInfo(placingOrderInfo.hotelID);
	}
	/**
	 * 
	 * 得到订单的入住和退房信息
	 * @return 入住和退房信息
	 */
	public ExecutionInfoVO getCheckInAndOutInfo(){
		return new ExecutionInfoVO(orderID, placingOrderInfo.roomNumber, checkInInfo.planedLeaveTime, 
				checkInInfo.checkInTime, checkOutInfo.checkOutTime);
	}
	/**
	 * 得到订单的评价信息
	 * @return 评价信息
	 */
	public AssessVO getAssessInfo(){
		return new AssessVO(assessInfo.mark, assessInfo.assessment);
	}
	/**
	 * 
	 * @return OrderPO
	 */
	public OrderPO getOrderPO() {
		return new OrderPO(orderID, placingOrderInfo.customerID, placingOrderInfo.hotelID, placingOrderInfo.roomNumber,
				placingOrderInfo.startTime, placingOrderInfo.latestTime, placingOrderInfo.planedLeaveTime, 
				checkInInfo.checkInTime, checkInInfo.planedLeaveTime,checkOutInfo.checkOutTime, revokeTime, placingOrderInfo.roomType, 
				placingOrderInfo.numberOfRooms, value, placingOrderInfo.planedPeopleNumber, placingOrderInfo.child, 
				orderState, assessInfo.mark, assessInfo.assessment,placingOrderInfo.price);
	}
	/**
	 * 
	 * @return 房间号码
	 */
	public ArrayList<String> getRoomNumber(){
		return placingOrderInfo.roomNumber;
	}
	/**
	 * 
	 * @return 撤销时间
	 */
	public Date getRevokeTime(){
		return revokeTime;
	}
	
	/**
	 * 订单的初始化
	 */
	private void init(OrderInputVO orderInput) {
		this.orderState=OrderState.Unexecuted;
		this.placingOrderInfo=new PlacingOrderInfo(orderInput.customerID, orderInput.roomType, orderInput.numberOfRooms, 
				null, orderInput.hotelID, orderInput.startTime, orderInput.latestTime, orderInput.planedLeaveTime, 
				orderInput.planedPeopleNumber, orderInput.child,orderInput.price);
		this.checkInInfo=new CheckInInfo(null, null);
		this.checkOutInfo=new CheckOutInfo(null);
		this.assessInfo=new AssessInfo(null, null);
		
		orderID="orderID";//生成订单ID应该由data层决定
		value=createValue();
	}
	/**
	 * 订单的初始化
	 */
	private void init(OrderPO orderPO) {
		this.orderID=orderPO.getOrderID();
		this.value=orderPO.getValue();
		this.orderState=orderPO.getOrderState();
		this.revokeTime=orderPO.getRevokeTime();
		this.placingOrderInfo=new PlacingOrderInfo(orderPO.getCustomerID(), orderPO.getRoomType(), 
				orderPO.getNumberOfRooms(), orderPO.getRoomNumber(), orderPO.getHotelID(), orderPO.getStartTime(), 
				orderPO.getLatestTime(), orderPO.getPlanedLeaveTime(), orderPO.getPlanedPeopleNumber(), 
				orderPO.isChild(),orderPO.getPrice());
		this.checkInInfo=new CheckInInfo(orderPO.getPlanedCheckOutTime(), orderPO.getCheckInTime());
		this.checkOutInfo=new CheckOutInfo(orderPO.getCheckOutTime());
		this.assessInfo=new AssessInfo(orderPO.getMark(), orderPO.getAssessment());
	}
	/**
	 * 定时从data层更新订单的信息
	 */
	private void sync() {
		Thread syncThread=new Thread(new SyncHandeler());
		syncThread.start();
	}
	/**
	 * 生成订单价值
	 * 算法：订单价值=订单总价+酒店评分*100，如果客户是会员再加1000
	 * @return
	 */
	private int createValue() {
		int newValue=0;
		newValue+=placingOrderInfo.price;
		newValue+=hotelInfo.getHotelInfo(placingOrderInfo.hotelID).mark.getValue()*100;
		newValue+=customerInfo.getCustomer(placingOrderInfo.customerID).membervo.memberType.getType()
				.equals(MemberBelongType.None)?0:1000;
		return newValue;
	}
	
	/**
	 * 刷新器线程，定时从data层更新Order的信息
	 * @author zjy
	 *
	 */
	private class SyncHandeler implements Runnable {
		public void run() {
			try {
				while (true) {
					OrderPO orderPO=orderDataService.findOrder(orderID);
					if(orderPO==null){
						return;
					}
					init(orderPO);
					Thread.sleep(1000);//1s刷新一次
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
