package vo;

import po.Order;
import tools.ActionType;

public class CreditlogVO {
		public ActionType actionType ;
		public OrderVO order ;
		public int changeValue;// 
		
		public CreditlogVO(ActionType actionType , OrderVO order,int  i){
			this.actionType = actionType;
			this.changeValue = i;
			this.order = order;
		}
		
}
