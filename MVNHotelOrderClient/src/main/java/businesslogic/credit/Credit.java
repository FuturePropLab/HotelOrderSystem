package businesslogic.credit;

import java.util.ArrayList;
import java.util.List;

import dataservice.CreditDataService;
import po.CreditLogPO;
import po.Order;
import po.OrderPO;
import stub.CreditData_Stub;
import tools.ActionType;
import tools.ResultMessage;
import vo.CreditlogVO;
import vo.CustomerVO;
import vo.OrderVO;

/**
 * credit 委托类
 * @author wshwbluebird
 *
 */
public class Credit {
	private CreditDataService creditDataService;
	private CustomerInfo customerInfo;
	
	/**
	 * 获取订单信息后 增加一条信用记录
	 * @param order
	 * @param type
	 * @param result
	 * @return ResultMessage
	 */
	public ResultMessage addlog(Order order, ActionType type, int result) {
		if(order==null && type!=ActionType.Charge)  return ResultMessage.NotExist;
		if(type == ActionType.Charge)  return ResultMessage.NotExist;
		OrderPO orderPO  =new OrderPO(order);
		CreditLogPO creditLogPO = new CreditLogPO(type, orderPO, result);
		return creditDataService.add(creditLogPO);
	}
	
	/**
	 * 根据客户的ID 返回该客户所有信用记录
	 * @param customer_id
	 * @return List<CreditlogVO> 
	 */
	public List<CreditlogVO> getLogList(String customer_id) {
		List<CreditlogVO> logList = new ArrayList<CreditlogVO>();
		List<CreditLogPO> list = creditDataService.getLogList(customer_id);
		for(int i = 0 ; i <  list.size() ; i++){
			CreditLogPO creditlogPO = list.get(i);
			CreditlogVO creditlogVO;
			if(creditlogPO.getOrderPO()==null){
				creditlogVO = new CreditlogVO(creditlogPO.getActionType(),
						null , creditlogPO.getChangeValue());
			}else{
				OrderVO orderVO = new OrderVO(creditlogPO.getOrderPO());
				creditlogVO = new CreditlogVO(creditlogPO.getActionType(),
						orderVO , creditlogPO.getChangeValue());
			}
			
			logList.add(creditlogVO);
		}
		return logList;
	}

	/**
	 * 充值信用  并增加一条信用记录
	 * @param customer_id
	 * @param ChargeMoney
	 * @return ResultMessage
	 */
	public ResultMessage charge(String customer_id, int ChargeMoney) {
		int value = ChargeMoney * 100;
		CustomerVO customerVO = customerInfo.getCustomerInfo(customer_id);
		customerVO.credit+= value;
		ResultMessage rm = customerInfo.changeCustomerInfo(customerVO);
		
		if(rm==ResultMessage.NotExist) return rm;
		
		return addlog(null, ActionType.Charge, value);
	}
	
	/**
	 * 初始化
	 */
	public Credit(CustomerInfo customerInfo){
		this.customerInfo = customerInfo;
		this.creditDataService = new  CreditData_Stub();
	}
}
