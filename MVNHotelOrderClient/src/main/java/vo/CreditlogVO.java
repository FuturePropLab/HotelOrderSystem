package vo;

import java.util.Date;

import po.Order;
import tools.ActionType;

public class CreditlogVO {
	public  String customerID  ;//客户id
	public ActionType actionType ; //动作
	public Date ChangDate; // 信用变化时间
	public String orderID; //订单id
	public  int changeValue;  //修改值
	public  int money; // 充值金额
		
		public CreditlogVO(String customerID , ActionType actionType , String  orderID, Date changDate ,  int changeValue,int money){
			this.customerID = customerID;
			this.actionType = actionType;
			this.changeValue = changeValue;
			this.orderID = orderID;
			this.money = money;
			this.ChangDate = changDate;
		}
		
}
