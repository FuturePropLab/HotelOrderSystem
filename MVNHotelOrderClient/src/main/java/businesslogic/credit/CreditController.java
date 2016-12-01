package businesslogic.credit;

import java.util.List;

import businesslogic.customer.CustomerInfoImp;
import businesslogicservice.CreditLogDealService;
import po.Order;
import tools.ActionType;
import tools.ResultMessage;
import vo.CreditlogVO;


/**
 * 瀹炵幇CreditLogDealService鐨勬帴鍙�
 * @author wshwbluebird
 *
 */
public class CreditController implements CreditLogDealService{

	/*public ResultMessage addlog(Order order, ActionType type, int result) {
		// TODO Auto-generated method stub
		
		Credit credit = new Credit(order.getCustomerID());
		
		return credit.addlog(order, type, result);
	}*/
	public ResultMessage CreditChangeAboutOrder(Order order,ActionType type){
		Credit credit = new Credit(order.getCustomerID());
		
		return credit.CreditChangeAboutOrder(order, type);
	}
	public List<CreditlogVO> getLogList(String customer_id) {
		// TODO Auto-generated method stub
		
		Credit credit = new Credit(customer_id);
		return credit.getLogList(customer_id);
	}

	public ResultMessage charge(String customer_id, int ChargeMoney) {
		// TODO Auto-generated method stub
		Credit credit = new Credit(customer_id);
		return credit.charge(customer_id, ChargeMoney);
	}

}
