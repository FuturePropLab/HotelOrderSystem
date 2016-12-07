package po;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import tools.ActionType;


@Entity
public class CreditLogPO  implements Serializable{
	
	
		/**
	 * 
	 */
		private static final long serialVersionUID = -2606867803581702730L;
		
		private  String customerID  ;//客户的ID
		private ActionType actionType ; //动作类型 
		private Date ChangDate; // 信用记录发生变化的时间
		@Id
		private String orderID; //订单的ID
		private  int changeValue;  //信用值变化
		private  int money; // 充值金额
		
		public CreditLogPO(String customerID , ActionType actionType , String  orderID, Date changDate ,  int changeValue,int money){
			this.customerID = customerID;
			this.actionType = actionType;
			this.changeValue = changeValue;
			this.orderID = orderID;
			this.money = money;
			this.ChangDate = changDate;
		}
		
		public CreditLogPO(){
			
		}
		
		public String getCustomerID() {
			return customerID;
		}



		public void setCustomerID(String customerID) {
			this.customerID = customerID;
		}


		@Enumerated(EnumType.STRING)
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

		public int getChangeValue() {
			return changeValue;
		}

		public void setChangeValue(int changeValue) {
			this.changeValue = changeValue;
		}

		public int getMoney() {
			return money;
		}

		public void setMoney(int money) {
			this.money = money;
		}

		public void setActionType(ActionType actionType) {
			this.actionType = actionType;
		}

		
		
}
