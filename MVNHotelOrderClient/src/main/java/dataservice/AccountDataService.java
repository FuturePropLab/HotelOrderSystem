package dataservice;

import java.util.List;

import po.CustomerAccountPO;
import po.HotelAccountPO;
import po.SearchCondition;
import po.WebAccountPO;
import tools.ResultMessage;
import tools.ResultMessage2;
import vo.CustomerInputVO;

public interface AccountDataService {

	public ResultMessage modifyCustomer(CustomerAccountPO CusPO);
	/**
	 * 数据层 获取CustomerAccountPO
	 * @param customer_id
	 * @return CustomerAccountPO
	 */
	public CustomerAccountPO getCustomer(String customer_id);

	/**
	 * @author chenyuyan 11/22
	 * 数据层 增加customer
	 * @param customerInfo
	 * @return
	 */
	public ResultMessage2 accountAdd(CustomerInputVO customerInfo);
	
	public List<CustomerAccountPO> searchCustomerList(SearchCondition searchCondition);
	
	public ResultMessage addHotel(HotelAccountPO hotelAccPO);

	public ResultMessage modifyHotel(HotelAccountPO hotelAccPO);
	
	/**
	 * 数据层 获取HotelAccountPO
	 * @param hotel_id
	 * @return HotelAccountPO
	 */
	public HotelAccountPO getHotel(String hotel_id);

	public ResultMessage deleteHotel(String hotel_id);
	
	public ResultMessage addWeb(WebAccountPO po);

	public ResultMessage modifyWeb(WebAccountPO po);
	/**
	 * 数据层 获取WebAccountPO 网站设计人员
	 * @param WebAccount_id
	 * @return WebAccountPO
	 */
	public WebAccountPO getWeb(String WebAccount_id);

	

}
