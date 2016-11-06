package businesslogic.credit;

import java.util.List;

import businesslogicservice.CreditLogDealService;
import po.Order;
import tools.ActionType;
import tools.ResultMessage;
import vo.CreditlogVO;


/**
 * 实现CreditLogDealService的接口
 * @author wshwbluebird
 *
 */
public class CreditController implements CreditLogDealService{

	public ResultMessage addlog(Order order, ActionType type, int result) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CreditlogVO> getLogList(String customer_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage charge(String customer_id, int ChargeMoney) {
		// TODO Auto-generated method stub
		return null;
	}

}
