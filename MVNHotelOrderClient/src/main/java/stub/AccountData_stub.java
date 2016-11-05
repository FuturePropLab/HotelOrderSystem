package stub;

import java.util.ArrayList;
import java.util.List;

import dataservice.AccountDataService;
import po.CustomerAccountPO;
import po.HotelAccountPO;
import po.SearchCondition;
import po.WebAccountPO;
import tools.ResultMessage;

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
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage modifyHotel(HotelAccountPO hotelAccPO) {
		// TODO Auto-generated method stub
		return null;
	}

	public HotelAccountPO getHotel(String hotel_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage deleteHotel(String hotel_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HotelAccountPO> searchHotelList(SearchCondition searchCondition) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage addWeb(WebAccountPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage modifyWeb(WebAccountPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	public WebAccountPO getWeb(String WebAccount_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<WebAccountPO> searchWebList(SearchCondition searchCondition) {
		// TODO Auto-generated method stub
		return null;
	}

}
