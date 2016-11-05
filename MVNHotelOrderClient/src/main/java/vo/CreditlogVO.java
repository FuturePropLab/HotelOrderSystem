package vo;

import po.Order;
import tools.ActionType;

public class CreditlogVO {
		public ActionType actionType ;
		public Order order ;
		public int changeValue;// 
		
		public CreditlogVO(ActionType actionType , Order order,int changeValue){
			this.actionType = actionType;
			this.changeValue = changeValue;
			this.order = order;
		}
		
}
