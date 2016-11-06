package businesslogic.account;

import java.util.List;

import businesslogicservice.AccountHotelService;
import tools.ResultMessage;
import vo.HotelAccountVO;
import vo.HotelInfoVO;
import vo.HotelInputVO;
import vo.HotelSearchVO;

/**
 * 
 * @author wshwbluebird
 *
 */
public class HotelAccountController implements AccountHotelService {
	
	private Account account;
	

	/**
	 * 初始化
	 */
	public HotelAccountController(){
		this.account = new Account();
	}


	public ResultMessage addHotelAccount(HotelAccountVO hotelAccount, HotelInputVO hotelInputVO) {
	
		return account.addHotelAccount(hotelAccount, hotelInputVO);
	}


	public ResultMessage modifyHotelAccount(HotelAccountVO hotelAccount) {
		return account.modifyHotelAccount(hotelAccount);
	}


	public HotelAccountVO getHotelAccount(String hotel_id) {
		return account.getHotelAccount(hotel_id);
	}


	public ResultMessage deleteHotelAccount(String hotel_id) {
		return account.deleteHotelAccount(hotel_id);
	}


	public List<HotelAccountVO> searchHotelAccount(HotelSearchVO vo) {
		return account.searchHotelAccount(vo);
	}


	public HotelInfoVO getHotelDetail(String hotel_id) {
		return account.getHotelDetail(hotel_id);
	}

}
