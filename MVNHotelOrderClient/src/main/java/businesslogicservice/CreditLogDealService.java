package businesslogicservice;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import businesslogic.order.Order;
import tools.ActionType;
import tools.RecoverValue;
import tools.ResultMessage;
import vo.CreditlogVO;

public interface CreditLogDealService {
	
	/*/**
	 * 增加一条信用记录
	 * @param order
	 * @param type
	 * @param result(信用值变化度)
	 * @return ResultMessage
	 */
	//public ResultMessage addlog(Order order,ActionType type,int result);／／cyy，删掉，但下面两个变更过程会调用，
	
	/**
	 * @author chenyuyan 12/1
	 * 根据订单变更信用值
	 * @param order
	 * @param type
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMessage CreditChangeAboutOrder(Order order,ActionType type);
	
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
	 * @throws RemoteException 
	 */
	public ResultMessage charge(String customer_id,int ChargeMoney,Date chargeTime);
	/**
	 * 申诉成功，恢复信用值，且有网站营销人员决定恢复一般还是全部
	 * @author chenyuyan
	 * @param order 
	 * @param RecoverValue 一半，全部
	 */
	public ResultMessage Recover(Order order,RecoverValue recoverValue);
	public int levelUpdate(String customer_id);
}
