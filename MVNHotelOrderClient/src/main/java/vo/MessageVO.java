package vo;

import po.MessagePO;

/**
 * 
 * @author wshwbluebird
 *
 */
public class MessageVO {
		public String customerID;
		public String message;
		public String OrderID;
		
		public MessageVO(MessagePO messagePO){
			super();
			if(messagePO==null)  return;
			this.customerID = messagePO.getCustomerID();
			this.message = messagePO.getMessage();
			this.OrderID = messagePO.getOrderID();
			
		}
}
