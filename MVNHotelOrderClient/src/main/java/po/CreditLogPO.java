package po;

import java.util.Date;

import tools.ActionType;

public class CreditLogPO {
		private  String customerID  ;//客户的ID
		private ActionType actionType ; //动作类型 
		private Date ChangDate; // 信用记录发生变化的时间
		private String orderID; //订单的ID
		private  double changeValue;  //信用值变化
		private  double money; // 充值金额
		
		public CreditLogPO(String customerID , ActionType actionType , String  orderID, Date changDate ,  double changeValue,double money){
			this.customerID = customerID;
			this.actionType = actionType;
			this.changeValue = changeValue;
			this.orderID = orderID;
			this.money = money;
			this.ChangDate = changDate;
		}
		
		
		
		public String getCustomerID() {
			return customerID;
		}



		public void setCustomerID(String customerID) {
			this.customerID = customerID;
		}



		public ActionType getActionType() {
			return actionType;
		}

		public Date getChangDate() {
			return ChangDate;
		}

		public void setChangDate(Date changDate) {
			ChangDate = changDate;
		}

		public String getOrderID() {
			return orderID;
		}

		public void setOrderID(String orderID) {
			this.orderID = orderID;
		}

		public double getChangeValue() {
			return changeValue;
		}

		public void setChangeValue(double changeValue) {
			this.changeValue = changeValue;
		}

		public double getMoney() {
			return money;
		}

		public void setMoney(double money) {
			this.money = money;
		}

		public void setActionType(ActionType actionType) {
			this.actionType = actionType;
		}

		
		
}
