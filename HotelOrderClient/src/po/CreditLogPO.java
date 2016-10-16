package po;

import tools.ActionType;

public class CreditLogPO {
		public ActionType actionType ;
		public OrderPO orderPO ;
		public int changeValue;
		
		public CreditLogPO(ActionType actionType , OrderPO orderPO,int changeValue){
			this.actionType = actionType;
			this.changeValue = changeValue;
			this.orderPO = orderPO;
		}
		
}
