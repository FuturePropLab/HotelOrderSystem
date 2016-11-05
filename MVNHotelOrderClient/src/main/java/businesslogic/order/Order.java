package businesslogic.order;

import java.sql.Time;

import dataservice.OrderDataService;
import po.OrderPO;
import tools.Mark;
import tools.OrderState;
import tools.ResultMessage;
import tools.RoomType;
import vo.OrderInputVO;
import vo.OrderVO;

/**
 * 订单的领域类
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
	private OrderPO orderPO;
	
	/**
	 * 订单的构造方法，通过客户下单生成订单，构造之后会调用saveOrder
	 * @param orderInput 下单信息
	 */
	public Order(OrderInputVO orderInput){
		super();
		//saveOrder();
	}
	/**
	 * 持久化保存订单
	 * @param orderVO 订单的信息
	 * @return  成功则返回true，失败返回false
	 */
	public boolean saveOrder(OrderVO orderVO){
		return orderDataService.add(orderPO).equals(ResultMessage.Exist);
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
}
