package po;

import tools.ActionType;

public class CreditLogPO {
		private ActionType actionType ;
		private  OrderPO orderPO ;
		private  int changeValue;
		
		public CreditLogPO(ActionType actionType , OrderPO orderPO,int changeValue){
			this.actionType = actionType;
			this.changeValue = changeValue;
			this.orderPO = orderPO;
		}
		
		public ActionType getActionType() {
			return actionType;
		}

		public void setActionType(ActionType actionType) {
			this.actionType = actionType;
		}

		public OrderPO getOrderPO() {
			return orderPO;
		}

		public void setOrderPO(OrderPO orderPO) {
			this.orderPO = orderPO;
		}

		public int getChangeValue() {
			return changeValue;
		}

		public void setChangeValue(int changeValue) {
			this.changeValue = changeValue;
		}
		
		
}
