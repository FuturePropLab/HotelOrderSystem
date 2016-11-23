package businesslogic.account;

import java.util.ArrayList;
import java.util.List;

import dataservice.AccountDataService;
import po.CustomerAccountPO;
import po.HotelAccountPO;
import po.WebAccountPO;
import stub.AccountData_stub;
import tools.ResultMessage;
import tools.ResultMessage2;
import vo.CustomerAccountVO;
import vo.CustomerInputVO;
import vo.CustomerSearchVO;
import vo.CustomerVO;
import vo.HotelAccountVO;
import vo.HotelInfoVO;
import vo.HotelInputVO;
import vo.HotelSearchVO;
import vo.WebAccountVO;

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
	 * 通过customer_id 获取CustomerAccountVO
	 * @param customer_id
	 * @return CustomerAccountVO
	 */
	public CustomerAccountVO getCustomerAccount(String customer_id) {
		CustomerAccountPO accountPO = accountDataService.getCustomer(customer_id);
		
		CustomerAccountVO accountVO = new CustomerAccountVO(accountPO.getCustomerId(), 
				accountPO.getCustomerName(), accountPO.getPassword());
	
		return accountVO;
	}
	/**
	 * 修改Customer的持久化账户信息
	 * @param customerAccount
	 * @return ResultMessage
	 */
	public ResultMessage accountModify(CustomerAccountVO customerAccount) {
		CustomerAccountPO accountPO = new CustomerAccountPO(customerAccount.customerId,
				customerAccount.customerName, customerAccount.password);
		return accountDataService.modifyCustomer(accountPO);
	}
	/**
	 * @author chenyuyan
	 * 增加customer的持久化账户信息
	 * @return ResultMessage2
	 */
	public ResultMessage2 AddCustomerAccount(CustomerInputVO customerInfo){
		
		return null;
		
	}
	/**
	 * @author chenyuyan
	 * 根据用户名和密码生成一个id；
	 * @param username
	 * @param passworld
	 * @return
	 */
	public String getID(String username,String password){
		String id="0";
		return id;
		
	}
	
	
	/**
	 * 通过客户的搜索信息 返回全部的符合条件的客户信息列表
	 * @param customerSearchVO
	 * @return  List<CustomerAccountVO>
	 */
	public List<CustomerAccountVO> searchCustomerAccount(CustomerSearchVO customerSearchVO) {
		List<CustomerAccountVO> accountList = new ArrayList<CustomerAccountVO>();
		ArrayList<CustomerVO> list = (ArrayList<CustomerVO>) customerInfo.searchCustomer(customerSearchVO);
		for(int i = 0 ;i<list.size();i++){
			CustomerAccountVO vo  = getCustomerAccount(list.get(i).customerID);
			accountList.add(vo);		
		}
		
		return accountList;
	}
	
	/**
	 * 根据输入的信息 新增酒店 及酒店账户
	 * @param hotelAccount
	 * @param hotelInputVO
	 * @return ResultMessage
	 */
	public ResultMessage addHotelAccount(HotelAccountVO hotelAccount,HotelInputVO hotelInputVO) {
		HotelAccountPO hotelAccountPO = new HotelAccountPO(hotelAccount.id, 
				hotelAccount.name, hotelAccount.password);
		if(accountDataService.addHotel(hotelAccountPO)==ResultMessage.NotExist){
			return ResultMessage.NotExist;
		}
		return hotelInfo.addHotel(hotelInputVO);
	}
	
	/**
	 * 更新酒店账户信息的持久化存储
	 * @param hotelAccount
	 * @return ResultMessage
	 */
	public ResultMessage modifyHotelAccount(HotelAccountVO hotelAccount) {
		HotelAccountPO hotelAccountPO = new HotelAccountPO(hotelAccount.id, 
				hotelAccount.name, hotelAccount.password);
		return accountDataService.modifyHotel(hotelAccountPO);
	}

	/**
	 * 根据酒店的ID获取酒店账户信息的值对象
	 * @param hotel_id
	 * @return HotelAccountVO
	 */
	public HotelAccountVO getHotelAccount(String hotel_id) {
		HotelAccountPO hotelAccountPO = accountDataService.getHotel(hotel_id);
		HotelAccountVO hotelAccountVO = new HotelAccountVO(hotelAccountPO.getId(), 
				hotelAccountPO.getName(),hotelAccountPO.getPassword());
		return hotelAccountVO;
	}
	
	/**
	 * 根据酒店的ID 删除该酒店的账户
	 * @param hotel_id
	 * @return ResultMessage
	 */
	public ResultMessage deleteHotelAccount(String hotel_id) {
		return accountDataService.deleteHotel(hotel_id);
	}
	
	/**
	 * 网站管理人员根据酒店搜索条件搜索出的酒店列表
	 * @param hotelSearchVO
	 * @return List<HotelAccountVO>
	 */
	public List<HotelAccountVO> searchHotelAccount(HotelSearchVO hotelSearchVO) {
		List<HotelInfoVO> hotelList = hotelInfo.searchHotel(hotelSearchVO);
		List<HotelAccountVO> list  = new ArrayList<HotelAccountVO>();
		for(int i = 0 ; i < hotelList.size();i++){
			HotelAccountVO hotelAccountVO = getHotelAccount(hotelList.get(i).hotelID);
			list.add(hotelAccountVO);
		}
		return list;
	}
	
	/**
	 * 增加网站设计人员
	 * @param webAccountVO
	 * @return ResultMessage
	 */
	public ResultMessage addWebAccount(WebAccountVO webAccountVO) {
		WebAccountPO webAccountPO = new WebAccountPO(webAccountVO.id, webAccountVO.name, webAccountVO.password);
		return accountDataService.addWeb(webAccountPO);
	}
	
	
	/**
	 * 修改网站设计人员的账户信息
	 * @param webAccountVO
	 * @return ResultMessage
	 */
	public ResultMessage modifyWebAccount(WebAccountVO webAccountVO) {
		WebAccountPO webAccountPO = new WebAccountPO(webAccountVO.id, webAccountVO.name, webAccountVO.password);
		return accountDataService.modifyWeb(webAccountPO);
	}

	/**
	 * 根基ID获取网站设计人员的账户信息
	 * @param web_id
	 * @return WebAccountVO
	 */
	public WebAccountVO getWebAccount(String web_id) {
		WebAccountPO webAccountPO = accountDataService.getWeb(web_id);
		WebAccountVO webAccountVO = new WebAccountVO(webAccountPO.getId(), webAccountPO.getName()
				, webAccountPO.getPassword());
		
		return webAccountVO;
	}
	
	/**
	 * 根据ID获取客户的基本信息
	 * @param customer_id
	 * @return CustomerVO 
	 */
	public CustomerVO getCustomerDetail(String customer_id) {
		return customerInfo.getCustomerDetail(customer_id);
	}
	
	/**
	 * 根据酒店的的ID 获取酒店的基本信息
	 * @param hotel_id
	 * @return CustomerVO 
	 */
	public HotelInfoVO getHotelDetail(String hotel_id) {		
		return hotelInfo.getHotelDetail(hotel_id);
	}

}
