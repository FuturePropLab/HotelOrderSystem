package stub;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import po.Order;
import tools.ActionType;
import tools.RecoverValue;
import tools.ResultMessage;
import vo.CreditlogVO;

public class CreditLogDeal_Stub implements businesslogicservice.CreditLogDealService {

	
	public ResultMessage addlog(Order order, ActionType type, int result) {
		if(order!=null && result !=0)  return ResultMessage.Exist;
		else return ResultMessage.NotExist;
	}

	
	/*public List<CreditlogVO> getLogList(String customer_id) {
		List<CreditlogVO> creditLogList = new ArrayList<CreditlogVO>();
		
		CreditlogVO creditlogVO1 = new CreditlogVO(ActionType.Charge, null, 100);
		
		creditLogList.add(creditlogVO1);
		
		
		return creditLogList;
		
	}*/


	public ResultMessage charge(String customer_id, int ChargeMoney) {
		// TODO Auto-generated method stub
		return null;
	}


	public ResultMessage CreditChangeAboutOrder(Order order, ActionType type) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ResultMessage CreditChangeAboutOrder(businesslogic.order.Order order, ActionType type) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ResultMessage Recover(businesslogic.order.Order order, RecoverValue recoverValue) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ResultMessage charge(String customer_id, int ChargeMoney, Date chargeTime) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int levelUpdate(String customer_id) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public List<CreditlogVO> getLogList(String customer_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
