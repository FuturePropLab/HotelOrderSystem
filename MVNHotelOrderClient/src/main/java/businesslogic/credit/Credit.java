

package businesslogic.credit;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import businesslogic.customer.CustomerInfoforCreditImp;
import businesslogic.discount.DiscountWebController;
import businesslogic.order.Order;
import businesslogicservice.MessageDealService;
import bussinesslogic.message.MessageDealController;
import dataservice.CreditDataService;
import dataservice.MessgeDataService;
import po.CreditLogPO;
import po.OrderPO;
import rmi.RemoteHelper;
import stub.CreditData_Stub;
import tools.ActionType;
import tools.RecoverValue;
import tools.ResultMessage;
import vo.CreditlogVO;
import vo.CustomerVO;

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
	 * chenyuyan 测试用构造方法
	 * 
	 */
	public Credit(){
		this.creditDataService = RemoteHelper.getInstance().getCreditDataService();
		//this.creditDataService = new CreditData_Stub();//test!!!
		this.customerInfo = CustomerInfoforCreditImp.getInstance();
	}
	/*public Credit(CreditData_Stub stub){
		this.creditDataService = stub;
	}*/
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
		
		
		if(type == ActionType.RightOrder){
			creditchange = order.getOrderValue();
		}else if(type == ActionType.RevokeOrder){
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
		//creditDataService = new CreditData_Stub();//test
		ResultMessage resultMessage;
		try {
			resultMessage = creditDataService.changeCredit(order.getCustomer().customerID, result);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(order==null){return ResultMessage.NotExist;}
		else if(type.equals(ActionType.RevokeOrder)){
			
			CreditLogPO creditLogPO = new CreditLogPO(order.getCustomer().customerID, type, order.getOrderID(),order.getRevokeTime(),creditchange,0);
	
			try {
				return creditDataService.add(creditLogPO);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(type.equals(ActionType.RightOrder)){
			CreditLogPO creditLogPO = new CreditLogPO(order.getCustomer().customerID, type, order.getOrderID(),order.getCheckInAndOutInfo().checkInTime,creditchange,0);
			try {
				return creditDataService.add(creditLogPO);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		return ResultMessage.NotExist;
	}
	
	
	
	
	/**
	 * 根据客户的ID 返回该客户所有信用记录
	 * @param customer_id
	 * @return List<CreditlogVO> 
	 */
	public List<CreditlogVO> getLogList(String customer_id) {
//		creditDataService = new CreditData_Stub();
		System.out.println(" getLogList:   "+customer_id);
		
		List<CreditlogVO> logList = new ArrayList<CreditlogVO>();
		List<CreditLogPO> list = null;
		try {
			list = creditDataService.getLogList(customer_id);
			System.out.println(list);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0 ; i <  list.size() ; i++){
			CreditLogPO creditlogPO = list.get(i);
			CreditlogVO creditlogVO;
			if(creditlogPO.getActionType()==ActionType.Charge){
				//充值
				creditlogVO = new CreditlogVO
						(creditlogPO.getCustomerID(),creditlogPO.getActionType(),null,creditlogPO.getChangDate(),creditlogPO.getChangeValue(),creditlogPO.getMoney());
			}else{
				//订单变化
				creditlogVO = new CreditlogVO
						(creditlogPO.getCustomerID(),creditlogPO.getActionType(),creditlogPO.getOrderID(),creditlogPO.getChangDate(),creditlogPO.getChangeValue(),0);
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
		customerVO.credit= customerVO.credit+ value;
		int result = customerVO.credit;
		Credit c= new Credit();
		//ResultMessage ret=ResultMessage.NotExist;
//		System.out.println(customerVO.credit);
//		System.out.println(customerVO.telephone);
//		System.out.println(customerVO.customerID);
//		System.out.println(customerVO.customerName);
		
		
		ResultMessage rm = customerInfo.changeCustomerInfo(customerVO);
		
		//if(rm==ResultMessage.NotExist||ret==ResultMessage.NotExist) return rm;
		
		CreditLogPO creditLogPO = new CreditLogPO(customer_id, ActionType.Charge,null,chargeTime,value,ChargeMoney);
		
		try {
			MessgeDataService messgeDataService  = RemoteHelper.getInstance().getMessgeDataService();
			messgeDataService.writeMessage(customer_id, "您的信用充值已经成功，您的信用值增加了"+value, null);
			return creditDataService.add(creditLogPO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.NotExist;
		}
	}
	
	
	/**
	 * @author chenyuyan
	 * 每次信用值有所变化后，检验并根据网站营销人员的制定更改等级
	 * level
	 * @throws RemoteException 
	 */
	public int levelUpdate(String customer_id) throws RemoteException{
		CustomerInfoforCredit customerInfo = CustomerInfoforCreditImp.getInstance();
//		CustomerInfoforCredit customerInfo  = new MockCustomer();//test!!!
		int result = customerInfo.getCustomerInfo(customer_id).credit;
//		DiscountWebController discountWeb =  DiscountWebController.getInstance();
		MockDiscount discountWeb = new MockDiscount();//test!!
		
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
		if(RecoverValue.RecoverAll.equals(recoverValue)){
			creditchange = value;
		}else{
			creditchange = value/2;
		}
		String customer_id = order.getPlacingOrderInfo().customerID;
		
		int credit = order.getCustomer().credit;
		credit = credit +creditchange;
		
		ResultMessage resultMessage = null;
		
		try {
			resultMessage = creditDataService.changeCredit(customer_id, credit);
			System.out.println("RECOVER "+resultMessage);
		} catch (RemoteException e) {
			e.printStackTrace();
		}//修改客户信用值
		
		if(resultMessage.equals(ResultMessage.Exist)){
			//String customerID , ActionType actionType , String  orderID, Date changDate ,  int changeValue,int money
			CreditLogPO creditlogPO = new CreditLogPO(order.getCustomer().customerID,ActionType.Recover,order.getOrderID(),order.getRevokeTime(),creditchange,0);
			try {
				resultMessage =creditDataService.add(creditlogPO);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return resultMessage;
		
		
	}
	
}
