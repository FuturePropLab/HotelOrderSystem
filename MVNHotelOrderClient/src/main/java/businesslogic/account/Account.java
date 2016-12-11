package businesslogic.account;

import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import businesslogic.customer.CustomerInfoImp;
import dataservice.AccountDataService;
import po.AccountPO;
import rmi.RemoteHelper;
import stub.AccountData_stub;
import tools.AccountType;
import tools.ResultMessage_Account;
import vo.AccountVO;
import vo.CustomerSearchVO;
import vo.CustomerVO;
import vo.HotelSearchVO;
import vo.HotelbriefVO;
import vo.WebDesignerSearchVO;

/**
 * Account 委托类
 * @author wshwbluebird
 *
 */
public class Account {
	
	
	static final String invalid_input = "INVALID_INPUT";
	static final String usrname_notexits = "USERNAME_NOT_EXITS";
	static final String usrID_notexits = "USERID_NOT_EXITS";
	static final String rmi_fail = "RMI_FAIL";
	
	
	HotelInfo hotelInfo ;
	CustomerInfo customerInfo;
	AccountDataService accountDataService ;
	
	/**
	 * 
	 * @param hotelInfo
	 */
	public Account(HotelInfo hotelInfo){
//		this.accountDataService = new AccountData_stub();
		this.hotelInfo = hotelInfo;
		this.customerInfo = null;
	}
	/**
	 * 
	 * @param customerInfo
	 */
	public Account(CustomerInfo customerInfo){
//		this.accountDataService = new AccountData_stub();
		this.hotelInfo = null;
		this.customerInfo = customerInfo;
	}
	
	/**
	 * 无参数初始化
	 */
	public Account(){
		this.accountDataService = RemoteHelper.getInstance().getAccountDataService();
//		this.accountDataService = new AccountData_stub();
		this.hotelInfo = null;
		this.customerInfo = null;
	}
	
	
	/**
	 * 通过用户名 返回该账户的ID
	 * @param username
	 * @param password
	 * @return 该账户的ID ,  "INVALID_INPUT": 输入不合法 ， "USERNAME_NOT_EXITS":用户名不合法
	 * 						"RMI_FAIL" : rmi连接错误
	 */
	public String getAccountID(String username){
		if(!Certificate.isValidUsername(username)){
			return invalid_input;
		}
		AccountPO accountPO;
		try {
//			accountPO = accountDataService.getAccountByUserName(username);
			accountDataService = new AccountData_stub();
			accountPO = accountDataService.getAccountByUserName(username);
			if(accountPO==null)
				return usrname_notexits;
			return accountPO.getUserid();
		} catch (RemoteException e) {
			 return rmi_fail;
		}			
	}
	
	/**
	 * 通过注册的用户名和密码 以及账户类型 新增一个新的账户  自动生成ID
	 * @param username
	 * @param password
	 * @param accountType
	 * @return 是否成功
	 */
	public ResultMessage_Account addAccount(String username ,String password,AccountType accountType){
		if(!Certificate.isValidUsername(username) || !Certificate.isValidPassword(password)){
			return ResultMessage_Account.InvalidInput;
		}
		
		String generatedID= "";
		
		//generate id by accounttype
		if(accountType == AccountType.Customer)  generatedID = "CS";
		else if (accountType == AccountType.Hotel)  generatedID = "HT";
		else if	(accountType == accountType.Web) generatedID = "WB";
		else return ResultMessage_Account.InvalidInput;
		
		AccountPO accountPO;
		ResultMessage_Account result  = ResultMessage_Account.InvalidGennerateID;
		int generatetime = 0;
		//generate id by current time 
		do{
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSS");
			LocalDateTime now = LocalDateTime.now();
			generatedID = generatedID + dtf.format(now);
			accountPO = new AccountPO(generatedID, username, password, accountType); 
			try {
				result = accountDataService.addAccount(accountPO);
			} catch (RemoteException e) {
				return ResultMessage_Account.SystemError;
			}
			generatetime++;
			if(result!=ResultMessage_Account.InvalidGennerateID)  return result;
		}while(result == ResultMessage_Account.InvalidGennerateID && generatetime < 3);
		
		return ResultMessage_Account.SystemError;
		
	}
	
	/**
	 * 通过输入账户名 重制账户的密码
	 * @param userid
	 * @param newPassword
	 * @return 重设是否成功
	 * 
	 *TODO  补充返回注释说明
	 */
	public ResultMessage_Account resetPassword(String userid, String newPassword){
		if(!Certificate.isValidPassword(newPassword) || !Certificate.isValidUserID(userid)){
			return ResultMessage_Account.InvalidInput;
		}
		try {
			return accountDataService.resetPassword(userid, newPassword);
		} catch (RemoteException e) {
			return ResultMessage_Account.SystemError;
		}
	}
	
	
	/**
	 * 通过账户的id ，获取账户的名字
	 * @param userId
	 * @return 该账户的用户名
	 */
	public String getUsername(String userId){
		if(!Certificate.isValidUserID(userId)){
			return invalid_input;
		}
		AccountPO accountPO;
		try {
			accountDataService = new AccountData_stub();
			accountPO = accountDataService.getAccountByID(userId);
			if(accountPO==null)
				return usrID_notexits;
			return accountPO.getUsername();
		} catch (RemoteException e) {
			 return rmi_fail;
		}		
	}
	
	/**
	 * 通过客户的id 返回客户的个人基本信息
	 * @param customer_id
	 * @return 
	 * @throws RemoteException 
	 */
	public CustomerVO getCustomerDetail(String customer_id) throws RemoteException{
		CustomerInfo customerInfo = CustomerInfoImp.getInstance();
//		MockCustomer customerInfo = new MockCustomer();
		return customerInfo.getCustomerDetail(customer_id);
	}
	
	
	/**
	 * 通过客户的搜索信息值 返回符合条件的AccountVO 列表
	 * @param customerSearchVO
	 * @return 符合条件的客户账户VO 列表
	 * @throws RemoteException 
	 */
	public List<AccountVO> searchCustomerAccount(CustomerSearchVO customerSearchVO) throws RemoteException{
		CustomerInfo customerInfo = CustomerInfoImp.getInstance();
		List<String>idList = customerInfo.searchCustomer(customerSearchVO);
		List<AccountPO> accountPOs = accountDataService.getAccountList(idList, AccountType.Customer);
		Iterator<AccountPO> it = accountPOs.iterator();
		List<AccountVO> accountVOs = new ArrayList<AccountVO>();
		while(it.hasNext()){
			AccountPO accountPO = it.next();
			AccountVO accountVO = new AccountVO(accountPO.getUserid(), accountPO.getUsername(),
					accountPO.getAccountType());;
			accountVOs.add(accountVO);
		}
		
		return accountVOs;
	}
	
	/**
	 * 根据输入的网站设计人员的搜索信息 返回符合条件的网站设计人员账户信息列表
	 * @param webDesignerSearchVO
	 * @return  List<AccountVO>
	 */
	public List<AccountVO> searchWebDesignerAccount(WebDesignerSearchVO webDesignerSearchVO){
		//TODO
		return null;
	}
	

	/**
	 * 通过客户的搜索信息值 返回符合条件的AccountVO 列表
	 * @param hotelSearchVO
	 * @return 符合条件的客户账户VO 列表
	 */
	public List<AccountVO> searchHotelAccount(HotelSearchVO hotelSearchVO) {
		//TODO
		return null;
	}
	
	/**
	 * 根据酒店的ID 查看酒店的详细信息
	 * @param hotel_id
	 * @return HotelInfoPO 
	 */
	public HotelbriefVO getHotelDetail(String hotel_id) {
		//TODO
		return null;
	}
	
	/**
	 * 根据id 删除账户信息
	 * @param userId
	 * @return 删除操作是否成功
	 */
	public ResultMessage_Account deleteAccount(String userId) {
		if(!Certificate.isValidUserID(userId)){
			return ResultMessage_Account.InvalidInput;
		}
		try {
//			accountDataService = new AccountData_stub();
			return accountDataService.deleteAccount(userId);
		} catch (RemoteException e) {
			return ResultMessage_Account.SystemError;
		}
	}
	
}
