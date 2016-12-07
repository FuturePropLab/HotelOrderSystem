package businesslogic.credit;

import java.rmi.RemoteException;
import java.util.List;

import businesslogic.customer.Customer;
import businesslogic.customer.CustomerDealController;
import businesslogic.customer.CustomerInfoImp;
import businesslogic.order.Order;
import businesslogicservice.CreditLogDealService;
import tools.ActionType;
import tools.RecoverValue;
import tools.ResultMessage;
import vo.CreditlogVO;


/**
 * 瀹炵幇CreditLogDealService鐨勬帴鍙�
 * @author wshwbluebird
 *
 */
public class CreditController implements CreditLogDealService{
	
	private Credit credit;
	private static CreditController creditController;
	private CreditController() {
		// TODO Auto-generated constructor stub
		Credit credit = new Credit();
	} 
	
	
	
	public static CreditController getInstance(){
		if(creditController==null) creditController=new CreditController();
		return creditController;
	}
	
	/*public ResultMessage addlog(Order order, ActionType type, int result) {
		// TODO Auto-generated method stub
		
		Credit credit = new Credit(order.getCustomerID());
		
		return credit.addlog(order, type, result);
	}*/
	public ResultMessage CreditChangeAboutOrder(Order order,ActionType type){
		//Credit credit = new Credit(order.getCustomerID());
		
		return credit.CreditChangeAboutOrder(order, type);
	}
	public List<CreditlogVO> getLogList(String customer_id) {
		// TODO Auto-generated method stub
		
		//Credit credit = new Credit(customer_id);
		return credit.getLogList(customer_id);
	}

	public ResultMessage charge(String customer_id, int ChargeMoney){
		// TODO Auto-generated method stub
		//Credit credit = new Credit(customer_id);
		return credit.charge(customer_id, ChargeMoney);
	}
	public ResultMessage Recover(Order order,RecoverValue recoverValue){
		return credit.Recover(order, recoverValue);
		
	}
}
