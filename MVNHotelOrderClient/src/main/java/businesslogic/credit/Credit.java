

package businesslogic.credit;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import businesslogic.discount.DiscountWebController;
import businesslogic.order.Order;
import dataservice.CreditDataService;
import po.CreditLogPO;
import po.OrderPO;
import stub.CreditData_Stub;
import tools.ActionType;
import tools.RecoverValue;
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
	private CustomerInfoforCredit customerInfo;
	//private String customer_id;
	
	/**
	 * @author chenyuyan 12/1
	 * 
	 * 获取订单信息，计算信用变化 ，并调用addlog增加记录
	 * @throws RemoteException 
	 */
	public ResultMessage CreditChangeAboutOrder (Order order,ActionType type){
		double creditchange = 0;
		double result;
		OrderPO orderPO  =new OrderPO();
		//CustomerVO customerVO = customerInfo.getCustomerInfo(order.getCustomerID());
		CustomerVO customerVO = order.getCustomer();
		int credit = customerVO.credit;
		//int credit =80;
		switch (type){
		
		case RightOrder:creditchange = order.getOrderPO().getPrice();//完成一个订单增加订单价值的信用值
		//case DelayOrder:creditchange = order.getOrderPO().getPrice();//手工延迟入住，并恢复信用值
		
		case RevokeOrder://撤销的订单时间距离最晚订单执行时间不足6个小时，扣去订单价值的一半，需求上写的
				Date revokedTime = order.getOrderPO().getRevokeTime();
				Date latestTimeArriv = order.getOrderPO().getLatestTime();
				long between = ((latestTimeArriv.getTime()-revokedTime.getTime())/(1000*60*60));
				if(between<6){
					creditchange = -order.getOrderPO().getPrice()/2;
				}
			
			
		case BadOrder:
			
			
			
			
			
				Date latestTime = order.getOrderPO().getLatestTime();
				Date checkIntime = order.getOrderPO().getCheckInTime();
				Date planedLeaveTime =order.getOrderPO().getPlanedLeaveTime();
				Date checkOutTime = order.getOrderPO().getCheckOutTime();
				if(checkIntime.before(latestTime)){
					creditchange = -order.getOrderPO().getPrice();
					
				}
	
				
				/*long between=((checkOutTime.getTime()-planedLeaveTime.getTime())/(1000*60));
				if(between>=30){
					creditchange -=30;
									}*/
				//System.out.println(between);
				
				
				
		
		
		}
		Credit c= new Credit();
		result = credit+creditchange;
		
		//System.out.print(result);
		try {
			ResultMessage updatelevel = c.levelUpdate(result, order.getCustomer().customerID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		ResultMessage resultMessage = creditDataService.changeCredit(order.getCustomer().customerID, result);
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
	public ResultMessage addlog(Order order, ActionType type, double creditchange2) {
		int creditchange =0;
		
		if(order==null && type!=ActionType.Charge)  return ResultMessage.NotExist;
		if(type == ActionType.Charge)  {
			CreditLogPO creditpo = new CreditLogPO(type,null,creditchange2);
			
			return creditDataService.add(creditpo);}
		
		else{
		OrderPO orderPO  =order.getOrderPO();
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
		CreditLogPO creditLogPO = new CreditLogPO(type, orderPO, creditchange2);
			
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
	 * @throws RemoteException 
	 */
	public ResultMessage charge(String customer_id, int ChargeMoney){
		int value = ChargeMoney * 100;
		CustomerVO customerVO = customerInfo.getCustomerInfo(customer_id);
		customerVO.credit+= value;
		int result = customerVO.credit;
		Credit c= new Credit();
		ResultMessage ret=ResultMessage.NotExist;
		try {
			ret = c.levelUpdate(result, customer_id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		
		ResultMessage rm = customerInfo.changeCustomerInfo(customerVO);
		
		if(rm==ResultMessage.NotExist||ret==ResultMessage.NotExist) return rm;
		
		return addlog(null, ActionType.Charge, value);
	}
	
	/**
	 * 初始化
	 */
	/*public Credit(CustomerInfoforCredit customerInfo){
		this.customerInfo = customerInfo;
		this.creditDataService = new  CreditData_Stub();
	}
	/**
	 * 添加构造方法
	 * @author chenyuyan
	 */
	/*public Credit(String customer_id){
		this.creditDataService = new  CreditData_Stub();
	}*/
	/**
	 * @author chenyuyan
	 * 每次信用值有所变化后，检验并根据网站营销人员的制定更改等级
	 * level
	 * @throws RemoteException 
	 */
	public ResultMessage levelUpdate(double result,String customer_id) throws RemoteException{
		DiscountWebController discountWeb =  DiscountWebController.getInstance();
		int [] uplevel =new int[4];
		
		int level=0;
		uplevel =discountWeb.getLevelCredit();
		for(int i=0;i<3;i++){
			if(result>=uplevel[i]&&result<uplevel[i+1]){
				level = i+2;
			}
			
			
		}
		
		//System.out.println(level);
		
		return creditDataService.setLevel(level, customer_id);
		
	
	}
	public ResultMessage Recover(Order order,RecoverValue recoverValue){
		int value  = order.getOrderValue();		
		int creditchange = 0;
		if(recoverValue == RecoverValue.RecoverAll){
			creditchange = value;
		}else{
			creditchange = value/2;
		}
		
		
		return null;
		
		
	}
	
	
	public Credit(){
		this.creditDataService = new  CreditData_Stub();
	}
}
