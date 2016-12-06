package vo;

import po.Order;
import tools.ActionType;

public class CreditlogVO {
		public ActionType actionType ;
		public OrderVO order ;
		public double changeValue;// 
		
		public CreditlogVO(ActionType actionType , OrderVO order,double d){
			this.actionType = actionType;
			this.changeValue = d;
			this.order = order;
		}
		
}
