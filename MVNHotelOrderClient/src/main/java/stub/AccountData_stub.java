package stub;

import java.util.ArrayList;
import java.util.List;

import dataservice.AccountDataService;
import po.AccountPO;
import po.CustomerAccountPO;
import po.HotelAccountPO;
import po.SearchCondition;
import po.WebAccountPO;
import tools.ResultMessage;
import tools.ResultMessage2;
import tools.ResultMessage_Account;
import vo.CustomerInputVO;

/**
 * 
 * @author wshwbluebird
 *
 */
public class AccountData_stub implements AccountDataService{

	public ResultMessage modifyCustomer(CustomerAccountPO CusPO) {
		if(CusPO!=null)  
			return ResultMessage.Exist;
		return ResultMessage.NotExist;
	}

	public CustomerAccountPO getCustomer(String customer_id) {
		CustomerAccountPO accountPO = new CustomerAccountPO(customer_id,"wsw","qisini");
		//ystem.out.println(accountPO.getCustomerName());
		return accountPO;
	}

	public List<CustomerAccountPO> searchCustomerList(SearchCondition searchCondition) {
		CustomerAccountPO accountPO1 = new CustomerAccountPO("wsw","wsw","qisini");
		CustomerAccountPO accountPO2 = new CustomerAccountPO("waw","waw","qissni");
		List<CustomerAccountPO> list = new ArrayList<CustomerAccountPO>();
		list.add(accountPO1);
		list.add(accountPO2);
		
		return list;
	}

	public ResultMessage addHotel(HotelAccountPO hotelAccPO) {
		if(hotelAccPO!=null)  
			return ResultMessage.Exist;
		return ResultMessage.NotExist;

	}

	public ResultMessage modifyHotel(HotelAccountPO hotelAccPO) {
		if(hotelAccPO!=null) 
			return ResultMessage.Exist;
		return ResultMessage.NotExist;
		
	}

	public HotelAccountPO getHotel(String hotel_id) {
		HotelAccountPO hotelAccountPO = new HotelAccountPO(hotel_id, "荣华大酒店", "ingedg");
		return hotelAccountPO;
	}

	public ResultMessage deleteHotel(String hotel_id) {
		if(hotel_id!=null)  
			return ResultMessage.Exist;
		return ResultMessage.NotExist;
	}



	public ResultMessage addWeb(WebAccountPO po) {
		if(po!=null) 
			return ResultMessage.Exist;
		return ResultMessage.NotExist;
		
	}

	public ResultMessage modifyWeb(WebAccountPO po) {
		if(po!=null) 
			return ResultMessage.Exist;
		return ResultMessage.NotExist;
	}

	public WebAccountPO getWeb(String WebAccount_id) {
		WebAccountPO accountPO = new WebAccountPO(WebAccount_id, "zzjy", "qwer");
		return accountPO;
	}

	public ResultMessage2 accountAdd(CustomerInputVO customerInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage_Account resetPassword(String userid, String newPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	public AccountPO getAccountByUserName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public AccountPO getAccountByID(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage_Account addAccount(AccountPO accountPO) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage_Account deleteAccount(String userid) {
		// TODO Auto-generated method stub
		return null;
	}



}
