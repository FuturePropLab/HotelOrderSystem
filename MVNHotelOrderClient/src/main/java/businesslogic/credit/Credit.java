

package businesslogic.credit;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import businesslogic.customer.CustomerInfoforCreditImp;
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
		int creditchange = 0;
		int result;
		OrderPO orderPO  =new OrderPO();
		//CustomerVO customerVO = customerInfo.getCustomerInfo(order.getCustomerID());
		CustomerVO customerVO = order.getCustomer();
		int credit = customerVO.credit;
		//int credit =80;
		switch (type){
		
		case RightOrder:creditchange = order.getOrderValue();//完成一个订单增加订单价值的信用值
		case RevokeOrder://撤销的订单时间距离最晚订单执行时间不足6个小时，扣去订单价值的一半，需求上写的
				Date revokedTime = order.getOrderPO().getRevokeTime();
				Date latestTimeArriv = order.getOrderPO().getLatestTime();
				long between = ((latestTimeArriv.getTime()-revokedTime.getTime())/(1000*60*60));
				if(between<6){
					creditchange = -order.getOrderValue()/2;
				}
			
		}
		result = credit+creditchange;
		//异常订单交给数据层处理,只处理正常订单和撤销订单，正常订单包括手动延迟入住，交给数据层判断
			
	/*
				Date latestTime = order.getOrderPO().getLatestTime();
				Date checkIntime = order.getOrderPO().getCheckInTime();
				Date planedLeaveTime =order.getOrderPO().getPlanedLeaveTime();
				Date checkOutTime = order.getOrderPO().getCheckOutTime();
				if(checkIntime.before(latestTime)){
					creditchange = -order.getOrderValue();
					
				}*/
	
				
				/*long between=((checkOutTime.getTime()-planedLeaveTime.getTime())/(1000*60));
				if(between>=30){
					creditchange -=30;
									}*/
				//System.out.println(between);
				
				
				
		
		
		
		
		
		//System.out.print(result);
	/*	try {
			ResultMessage updatelevel = c.levelUpdate(result, order.getCustomer().customerID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}*/  //会员等级信息不在这里同步了
		
		ResultMessage resultMessage = creditDataService.changeCredit(order.getCustomer().customerID, result);
		
	
		if(order==null){return ResultMessage.NotExist;}
		else if(type.equals(ActionType.RevokeOrder)){
			
			CreditLogPO creditLogPO = new CreditLogPO(order.getCustomer().customerID, type, order.getOrderID(),order.getRevokeTime(),creditchange,0);
	
			return creditDataService.add(creditLogPO);
		}else if(type.equals(ActionType.RightOrder)){
			CreditLogPO creditLogPO = new CreditLogPO(order.getCustomer().customerID, type, order.getOrderID(),order.getCheckInAndOutInfo().checkInTime,creditchange,0);
			return creditDataService.add(creditLogPO);
	}
			return resultMessage.NotExist;
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
			if(creditlogPO.getOrderID()==null){
				//充值
				creditlogVO = new CreditlogVO(creditlogPO.getCustomerID(),creditlogPO.getActionType(),null,creditlogPO.getChangDate(),creditlogPO.getChangeValue(),creditlogPO.getMoney());
			}else{
				//订单变化
				creditlogVO = new CreditlogVO(creditlogPO.getCustomerID(),creditlogPO.getActionType(),creditlogPO.getOrderID(),creditlogPO.getChangDate(),creditlogPO.getChangeValue(),0);
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
	public ResultMessage charge(String customer_id, int ChargeMoney,Date chargeTime){
		int value = ChargeMoney * 100;
		CustomerVO customerVO = customerInfo.getCustomerInfo(customer_id);
		customerVO.credit+= value;
		int result = customerVO.credit;
		Credit c= new Credit();
		ResultMessage ret=ResultMessage.NotExist;
		
		
		
		ResultMessage rm = customerInfo.changeCustomerInfo(customerVO);
		
		if(rm==ResultMessage.NotExist||ret==ResultMessage.NotExist) return rm;
		
		CreditLogPO creditLogPO = new CreditLogPO(customer_id, ActionType.Charge,null,chargeTime,value,ChargeMoney);
		
		return creditDataService.add(creditLogPO);
	}
	
	
	/**
	 * @author chenyuyan
	 * 每次信用值有所变化后，检验并根据网站营销人员的制定更改等级
	 * level
	 * @throws RemoteException 
	 */
	public int levelUpdate(String customer_id) throws RemoteException{
		CustomerInfoforCredit customerInfo = CustomerInfoforCreditImp.getInstance();
		
		int result = customerInfo.getCustomerInfo(customer_id).credit;
		DiscountWebController discountWeb =  DiscountWebController.getInstance();
		int [] uplevel =new int[4];
		
		int level=0;
		uplevel =discountWeb.getLevelCredit();
		for(int i=0;i<3;i++){
			if(result>=uplevel[i]&&result<uplevel[i+1]){
				level = i+2;
			}
			
			
		}
		return level;
		
		//System.out.println(level);
		
		//return creditDataService.setLevel(level, customer_id);
		
	
	}
	/**
	 * 线下申诉合理，撤销异常订单
	 * @param order
	 * @param recoverValue
	 * @return
	 */
	public ResultMessage Recover(Order order,RecoverValue recoverValue){
		int value  = order.getOrderValue();		
		int creditchange = 0;
		if(recoverValue == RecoverValue.RecoverAll){
			creditchange = value;
		}else{
			creditchange = value/2;
		}
		String customer_id = order.getCustomer().customerID;
		
		int credit = order.getCustomer().credit;
		credit = credit +creditchange;
		
		ResultMessage resultMessage = null;
		
		
			resultMessage = creditDataService.changeCredit(customer_id, credit);//修改客户信用值
		
		if(resultMessage.equals(ResultMessage.Exist)){
			//String customerID , ActionType actionType , String  orderID, Date changDate ,  int changeValue,int money
			CreditLogPO creditlogPO = new CreditLogPO(order.getCustomer().customerID,ActionType.RevokeOrder,order.getOrderID(),order.getRevokeTime(),creditchange,0);
			resultMessage =creditDataService.add(creditlogPO);
			
		}
		return resultMessage;
		
		
	}
	
	
	public Credit(){
		this.creditDataService = new  CreditData_Stub();
	}
}
