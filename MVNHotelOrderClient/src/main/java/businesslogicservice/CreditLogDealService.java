package businesslogicservice;

import java.util.List;

import po.Order;
import tools.ActionType;
import tools.ResultMessage;
import vo.CreditlogVO;

public interface CreditLogDealService {
	
	/**
	 * 增加一条信用记录
	 * @param order
	 * @param type
	 * @param result(信用值变化度)
	 * @return ResultMessage
	 */
	public ResultMessage addlog(Order order,ActionType type,int result);
	
	
	/**
	 * 根据客户的ID 返回该客户的所有信用记录
	 * @param customer_id
	 * @return  List<CreditlogVO>
	 */
	public List<CreditlogVO> getLogList(String customer_id);
	
	/**
	 * 客户的信用充值
	 * @param customer_id
	 * @param ChargeMoney
	 * @return ResultMessage
	 */
	public ResultMessage charge(String customer_id,int ChargeMoney);
}
