package vo;

import po.Order;
import tools.ActionType;

public class CreditlogVO {
		public ActionType actionType ;
		public OrderVO order ;
		public int changeValue;// 
		
		public CreditlogVO(ActionType actionType , OrderVO order,int changeValue){
			this.actionType = actionType;
			this.changeValue = changeValue;
			this.order = order;
		}
		
}
