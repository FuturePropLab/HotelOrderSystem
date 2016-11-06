package businesslogic.order;

import java.sql.Time;
import java.util.ArrayList;

import dataservice.OrderDataService;
import po.OrderPO;
import tools.Mark;
import tools.OrderState;
import tools.ResultMessage;
import tools.RoomType;
import vo.AssessVO;
import vo.CustomerVO;
import vo.ExecutionInfoVO;
import vo.HotelInfoVO;
import vo.OrderInputVO;
import vo.OrderVO;

/**
 * 订单的领域类
 * orderID应该由data层决定，初始化order对象的时候应该没有orderID
 * order对象调用saveOrder()时，返回值应该是orderID，这一点还有待讨论
 * @author zjy
 *
 */
public class Order {
	private String orderID;
	private Time revokeTime;//实际撤销时间
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
	 */
	public Order(OrderInputVO orderInput,CustomerInfo customerInfo,HotelInfo hotelInfo,OrderDataService orderDataService){
		super();
		this.customerInfo=customerInfo;
		this.hotelInfo=hotelInfo;
		this.orderDataService=orderDataService;
		init(orderInput);
		saveOrder();
	}
	/**
	 * @deprecated
	 * 持久化保存订单
	 * @return  成功则返回true，失败返回false
	 */
	public boolean saveOrder(){
		orderID="orderID";//目前尚未有生成订单ID的方法
		value=1;//目前尚未有生成订单价值的方法
		placingOrderInfo.roomNumber=new ArrayList<String>();//目前尚未有生成房间号码的方法
		placingOrderInfo.roomNumber.add("8888");
		return orderDataService.add(getOrderPO()).equals(ResultMessage.Exist);
	}
	/**
	 * 改变订单的状态
	 * @param orderState 希望改变后的状态
	 * @return 成功则返回true，失败返回false
	 */
	public boolean changeState(OrderState orderState){
		this.orderState=orderState;
		return true;
	}
	/**
	 * 修改订单的入住信息
	 * @param executionInfo 入住信息
	 * @return 修改成功返回true，失败返回false
	 */
	public boolean modifyCheckInInfo(ExecutionInfoVO executionInfo){
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
				placingOrderInfo.numberOfRooms, placingOrderInfo.planedPeopleNumber, placingOrderInfo.child);
	}
	/**
	 * 
	 * @return 订单相关的酒店信息
	 */
	public HotelInfoVO getHotelInfo(){
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
				placingOrderInfo.startTime, placingOrderInfo.latestTime, checkInInfo.planedLeaveTime, 
				checkInInfo.checkInTime, checkOutInfo.checkOutTime, revokeTime, placingOrderInfo.roomType, 
				placingOrderInfo.numberOfRooms, value, placingOrderInfo.planedPeopleNumber, placingOrderInfo.child, 
				orderState, assessInfo.mark, assessInfo.assessment);
	}
	
	/**
	 * 订单的初始化
	 */
	private void init(OrderInputVO orderInput) {
		this.orderState=OrderState.Unexecuted;
		this.placingOrderInfo=new PlacingOrderInfo(orderInput.customerID, orderInput.roomType, 
				orderInput.numberOfRooms, null, orderInput.hotelID, orderInput.startTime, 
				orderInput.latestTime, orderInput.planedLeaveTime, orderInput.planedPeopleNumber, orderInput.child);
		this.checkInInfo=new CheckInInfo(null, null);
		this.checkOutInfo=new CheckOutInfo(null);
		this.assessInfo=new AssessInfo(null, null);
	}
	/**
	 * 定时从data层更新订单的信息
	 */
	private void sync() {
		
	}
}
