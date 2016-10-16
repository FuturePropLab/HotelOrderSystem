package stub;

import java.util.LinkedList;
import java.util.List;

import businesslogicservice.AccountCustomerService;
import businesslogicservice.AccountHotelService;
import businesslogicservice.AccountWebService;
import tools.ResultMessage;
import vo.CustomerAccountVO;
import vo.HotelAccountVO;
import vo.SearchConditionVO;
import vo.WebAccountVO;

public class Account_stub implements AccountCustomerService, AccountWebService, AccountHotelService {

	@Override
	public ResultMessage addHotelAccount(HotelAccountVO hotelAccount) {
		// TODO Auto-generated method stub
		if (hotelAccount != null)
			return ResultMessage.Exist;
		else
			return ResultMessage.NotExist;
	}

	@Override
	public ResultMessage modifyHotelAccount(HotelAccountVO hotelAccount) {
		// TODO Auto-generated method stub
		if (hotelAccount != null)
			return ResultMessage.Exist;
		else
			return ResultMessage.NotExist;
	}

	@Override
	public HotelAccountVO getHotelAccount(String hotel_id) {
		// TODO Auto-generated method stub
		HotelAccountVO hotelvo = new HotelAccountVO("01", "handsome girl", "123123");
		return hotelvo;
	}

	@Override
	public ResultMessage deleteHotelAccount(String hotel_id) {
		// TODO Auto-generated method stub
		if (hotel_id != null)
			return ResultMessage.Exist;
		else
			return ResultMessage.NotExist;
	}

	@Override
	public List<HotelAccountVO> searchHotelAccount(SearchConditionVO vo) {
		// TODO Auto-generated method stub
		List<HotelAccountVO> list = new LinkedList<HotelAccountVO>();
		HotelAccountVO hotelvo = new HotelAccountVO("01", "handsome girl", "123123");
		list.add(hotelvo);
		return list;
	}

	@Override
	public ResultMessage addWebAccount(WebAccountVO vo) {
		// TODO Auto-generated method stub
		if (vo != null)
			return ResultMessage.Exist;
		else
			return ResultMessage.NotExist;
	}

	@Override
	public ResultMessage modifyWebAccount(WebAccountVO vo) {
		// TODO Auto-generated method stub
		if (vo != null)
			return ResultMessage.Exist;
		else
			return ResultMessage.NotExist;
	}

	@Override
	public WebAccountVO getWebAccount(String web_id) {
		// TODO Auto-generated method stub

		WebAccountVO webvo = new WebAccountVO("01", "good girl", "123123");
		return webvo;
	}

	@Override
	public List<WebAccountVO> searchWebAccount(SearchConditionVO vo) {
		// TODO Auto-generated method stub
		List<WebAccountVO> list = new LinkedList<WebAccountVO>();
		WebAccountVO webvo = new WebAccountVO("02", "good girl", "123123");
		list.add(webvo);
		return list;
	}

	@Override
	public CustomerAccountVO getCustomerAccount(String customer_id) {
		// TODO Auto-generated method stub
		CustomerAccountVO customerA = new CustomerAccountVO("03", "beautiful girl", "123123");

		return customerA;
	}

	@Override
	public ResultMessage accountModify(CustomerAccountVO customerAccount) {
		// TODO Auto-generated method stub
		if (customerAccount != null)
			return ResultMessage.Exist;
		else
			return ResultMessage.NotExist;
	}

	@Override
	public List<CustomerAccountVO> searchCustomerAccount(SearchConditionVO vo) {
		// TODO Auto-generated method stub
		List<CustomerAccountVO> list = new LinkedList<CustomerAccountVO>();
		CustomerAccountVO customerA = new CustomerAccountVO("03", "beautiful girl", "123123");
		list.add(customerA);
		System.out.println(list.get(0).customerName);
		return list;
	}

}
