package businesslogic.account;

import java.util.ArrayList;
import java.util.List;

import dataservice.AccountDataService;
import po.CustomerAccountPO;
import po.HotelAccountPO;
import stub.AccountData_stub;
import tools.ResultMessage;
import vo.CustomerAccountVO;
import vo.CustomerSearchVO;
import vo.CustomerVO;
import vo.HotelAccountVO;
import vo.HotelInputVO;
import vo.HotelSearchVO;

/**
 * Account 委托类
 * @author wshwbluebird
 *
 */
public class Account {
	/**
	 * 通过customer_id 获取CustomerAccountVO
	 * @param customer_id
	 * @return CustomerAccountVO
	 */
	public CustomerAccountVO getCustomerAccount(String customer_id) {
		AccountDataService accountDataService = new AccountData_stub();
		CustomerAccountPO accountPO = accountDataService.getCustomer(customer_id);
		CustomerAccountVO accountVO = new CustomerAccountVO(accountPO.customerId, 
				accountPO.customerName, accountPO.password);
		return accountVO;
	}
	/**
	 * 修改Customer的持久化账户信息
	 * @param customerAccount
	 * @return ResultMessage
	 */
	public ResultMessage accountModify(CustomerAccountVO customerAccount) {
		AccountDataService accountDataService = new AccountData_stub();
		CustomerAccountPO accountPO = new CustomerAccountPO(customerAccount.customerId,
				customerAccount.customerName, customerAccount.password);
		return accountDataService.modifyCustomer(accountPO);
	}
	/**
	 * 通过客户的搜索信息 返回全部的符合条件的客户信息列表
	 * @param customerSearchVO
	 * @return  List<CustomerAccountVO>
	 */
	public List<CustomerAccountVO> searchCustomerAccount(CustomerSearchVO customerSearchVO) {
		List<CustomerAccountVO> accountList = new ArrayList<CustomerAccountVO>();
		CustomerInfo customerInfo =new MockCustomer();
		ArrayList<CustomerVO> list = (ArrayList<CustomerVO>) customerInfo.searchCustomer(customerSearchVO);
		for(int i = 0 ;i<list.size();i++){
			CustomerAccountVO vo  = getCustomerAccount(list.get(i).customeID);
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
		HotelInfo hotelInfo = new MockHotel();
		HotelAccountPO hotelAccountPO = new HotelAccountPO(hotelAccount.id, 
				hotelAccount.name, hotelAccount.password);
		AccountDataService accountDataService = new AccountData_stub();
		if(accountDataService.addHotel(hotelAccountPO)==ResultMessage.NotExist){
			return ResultMessage.NotExist;
		}
		return hotelInfo.addHotel(hotelInputVO);
	}

	public ResultMessage modifyHotelAccount(HotelAccountVO hotelAccount) {
		// TODO Auto-generated method stub
		return null;
	}

	public HotelAccountVO getHotelAccount(String hotel_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage deleteHotelAccount(String hotel_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HotelAccountVO> searchHotelAccount(HotelSearchVO hotelSearchVO) {
		// TODO Auto-generated method stub
		return null;
	}
}
