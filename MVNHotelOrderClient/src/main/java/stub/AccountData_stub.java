package stub;

import java.util.List;

import dataservice.AccountDataService;
import po.CustomerAccountPO;
import po.HotelAccountPO;
import po.SearchCondition;
import po.WebAccountPO;
import tools.ResultMessage;
/**
 * 
 * @author zjy
 * 这个类本来不应该是我建的，但是我要用，所以我不得已建了，所有问题我不背锅
 */
public class AccountData_stub implements AccountDataService{

	public ResultMessage modifyCustomer(CustomerAccountPO CusPO) {
		// TODO Auto-generated method stub
		return null;
	}

	public CustomerAccountPO getCustomer(String customer_id) {
		// TODO Auto-generated method stub
		return new CustomerAccountPO();
	}

	public List<CustomerAccountPO> searchCustomerList(SearchCondition searchCondition) {
		// TODO Auto-generated method stub
		return null;
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
		return new HotelAccountPO(hotel_id, "zjy", "password");
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
		return new WebAccountPO();
	}

	public List<WebAccountPO> searchWebList(SearchCondition searchCondition) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
