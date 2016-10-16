package vo;

import java.sql.Time;
import tools.OrderState;

public class SearchOrderInfoVO {
	public String orderID;
	public String customerID;
	public String hotelID;
	public Time startTime;//未定time用什么类
	public OrderState orderState;
}
