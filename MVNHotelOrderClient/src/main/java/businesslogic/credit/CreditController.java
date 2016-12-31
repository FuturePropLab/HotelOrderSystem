package businesslogic.credit;

import java.rmi.RemoteException;
import java.util.Date;
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
 * @author wshwbluebird
 *
 */
public class CreditController implements CreditLogDealService{
	
	private Credit credit;
	private static CreditController creditController;
	private CreditController() {
		// TODO Auto-generated constructor stub
		this.credit = new Credit();
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
		return credit.getLogList(customer_id);
	}

	public ResultMessage charge(String customer_id, int ChargeMoney,Date chargeTime){
		// TODO Auto-generated method stub
		//Credit credit = new Credit(customer_id);
		return credit.charge(customer_id, ChargeMoney,chargeTime);
	}
	public ResultMessage Recover(Order order,RecoverValue recoverValue){
		return credit.Recover(order, recoverValue);
		
	}
	public int levelUpdate(String customer_id){
		try {
			return credit.levelUpdate(customer_id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -99999;
		}
	}
}
