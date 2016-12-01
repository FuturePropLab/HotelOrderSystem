package businesslogic.credit;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
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
	private String customer_id;
	
	/**
	 * @author chenyuyan 12/1
	 * 
	 * 获取订单信息，计算信用变化 ，并调用addlog增加记录
	 */
	public ResultMessage CreditChangeAboutOrder (Order order,ActionType type){
		int creditchange = 0;
		int result;
		OrderPO orderPO  =new OrderPO(order);
		CustomerVO customerVO = customerInfo.getCustomerInfo(customer_id);
		int credit = customerVO.credit;
		switch (type){
		
		case RightOrder:creditchange = 50;//完成一个订单增加50信用值
		case RevokeOrder:creditchange = -30;//撤销订单信用值－30，
		case BadOrder:
			
			
			
			
			//延迟入住信用值减25,延迟退房超过30分钟减25,
				Date latestTime = order.getLatestTime();
				Date checkIntime = order.getCheckInTime();
				Date planedLeaveTime =order.getPlanedLeaveTime();
				Date checkOutTime = order.getCheckOutTime();
				if(checkIntime.before(latestTime)){
					creditchange = creditchange-25;
					
				
			}
				long between=(checkOutTime.getTime()-planedLeaveTime.getTime())/1000/60;
				if(between>=30){
					creditchange -=30;
				}
				//System.out.println(between);
				
				
				
		
		
		}
		result = credit+creditchange;
		ResultMessage resultMessage = creditDataService.changeCredit(order.getCustomerID(), result);
		if(resultMessage == ResultMessage.Exist){
		return addlog(order, type, creditchange);}else{return ResultMessage.NotExist;}
		
	}
	
	
	
	
	/**
	 *  增加一条信用记录
	 * @param order
	 * @param type
	 * @param result
	 * @return ResultMessage
	 */
	public ResultMessage addlog(Order order, ActionType type, int changeValue) {
		int creditchange =0;
		
		if(order==null && type!=ActionType.Charge)  return ResultMessage.NotExist;
		if(type == ActionType.Charge)  {
			CreditLogPO creditpo = new CreditLogPO(type,null,changeValue);
			
			return creditDataService.add(creditpo);}
		
		else{
		OrderPO orderPO  =new OrderPO(order);
		//CustomerVO customerVO = customerInfo.getCustomerInfo(customer_id);
		/*CustomerVO  customerVO  = new CustomerVO
				("ppd", "wsw", "male", "15251124223", null, 20);
		int credit = customerVO.credit;
		
		
		//撤销订单信用值－30，延迟入住信用值减25,延迟退房超过30分钟减25,没有异常的话，完成一个订单增加50信用值
		Date revoketime = order.getRevokeTime();
		if(revoketime !=null){
			creditchange =creditchange -30;
		}
			Date latestTime = order.getLatestTime();
			Date checkIntime = order.getCheckInTime();
			Date planedLeaveTime =order.getPlanedLeaveTime();
			Date checkOutTime = order.getCheckOutTime();
			if(checkIntime.before(latestTime)){
				creditchange = creditchange-25;
				
			
		}
			long between=(checkOutTime.getTime()-planedLeaveTime.getTime())/1000/60;
			if(between>=30){
				creditchange -=30;
			}
			//System.out.println(between);
			if(creditchange==0) creditchange =50;
			result = credit+creditchange;
			
			System.out.println(creditchange);
			ResultMessage resultMessage = creditDataService.changeCredit(customer_id, result);
			
			CreditLogPO creditLogPO = new CreditLogPO(type, orderPO, result);*/
		CreditLogPO creditLogPO = new CreditLogPO(type, orderPO, changeValue);
			
		return creditDataService.add(creditLogPO);
	}
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
	/**
	 * 添加构造方法
	 * @author chenyuyan
	 */
	public Credit(String customer_id){
		this.creditDataService = new  CreditData_Stub();
	}
}
