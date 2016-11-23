package businesslogic.account;

import java.util.List;

import dataservice.AccountDataService;
import stub.AccountData_stub;
import tools.AccountType;
import tools.ResultMessage_Account;
import vo.AccountVO;
import vo.CustomerSearchVO;
import vo.CustomerVO;

/**
 * Account 委托类
 * @author wshwbluebird
 *
 */
public class Account {
	
	HotelInfo hotelInfo ;
	CustomerInfo customerInfo;
	AccountDataService accountDataService ;
	
	/**
	 * 
	 * @param hotelInfo
	 */
	public Account(HotelInfo hotelInfo){
		this.accountDataService = new AccountData_stub();
		this.hotelInfo = hotelInfo;
		this.customerInfo = null;
	}
	/**
	 * 
	 * @param customerInfo
	 */
	public Account(CustomerInfo customerInfo){
		this.accountDataService = new AccountData_stub();
		this.hotelInfo = null;
		this.customerInfo = customerInfo;
	}
	
	/**
	 * 无参数初始化
	 */
	public Account(){
		this.accountDataService = new AccountData_stub();
		this.hotelInfo = null;
		this.customerInfo = null;
	}
	
	
	/**
	 * 通过用户名 返回该账户的ID
	 * @param username
	 * @param password
	 * @return 该账户的ID 
	 */
	public String getAccountID(String username){
		//TODO
		return username;		
	}
	
	/**
	 * 通过注册的用户名和密码 以及账户类型 新增一个新的账户  自动生成ID
	 * @param username
	 * @param password
	 * @param accountType
	 * @return 是否成功
	 */
	public ResultMessage_Account addAccount(String username ,String password,AccountType accountType){
		//TODO
		return null;
		
	}
	
	/**
	 * 通过输入账户名 重制账户的密码
	 * @param userid
	 * @param newPassword
	 * @return 重设是否成功
	 */
	public ResultMessage_Account resetPassword(String userid, String newPassword){
		//TODO
		return null;
	}
	
	
	/**
	 * 通过账户的id ，获取账户的名字
	 * @param userId
	 * @return 该账户的用户名
	 */
	public String getUsername(String userId){
		//TODO
		return null;
	}
	
	/**
	 * 通过客户的id 返回客户的个人基本信息
	 * @param customer_id
	 * @return 
	 */
	public CustomerVO getCustomerDetail(String customer_id){
		//TODO
		return null;
	}
	
	
	/**
	 * 通过客户的搜索信息值 返回符合条件的AccountVO 列表
	 * @param customerSearchVO
	 * @return 符合条件的客户账户VO 列表
	 */
	public List<AccountVO> searchCustomerAccount(CustomerSearchVO customerSearchVO){
		//TODO
		return null;
	}
}
