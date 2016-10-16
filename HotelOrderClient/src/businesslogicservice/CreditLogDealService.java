package bussinesslogicservice;

import java.util.List;

import po.Order;
import tools.ActionType;
import tools.ResultMessage;
import vo.CreditlogVO;

public interface CreditLogDealService {
	public ResultMessage addlog(Order order,ActionType type,int result);
	
	public List<CreditlogVO> getLogList(String customer_id);
}
