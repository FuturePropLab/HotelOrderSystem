package businesslogic.account;

import java.util.List;

import businesslogicservice.AccountHotelService;
import tools.ResultMessage;
import tools.ResultMessage_Account;
import vo.AccountVO;
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


	public String getAccountID(String username) {
		// TODO Auto-generated method stub
		return null;
	}


	public ResultMessage_Account addAccount(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}


	public ResultMessage_Account resetPassword(String userid, String newPassword) {
		// TODO Auto-generated method stub
		return null;
	}


	public String getUsername(String userId) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<AccountVO> searchHotelAccount(HotelSearchVO hotelSearchVO) {
		// TODO Auto-generated method stub
		return null;
	}


	public HotelInfoVO getHotelDetail(String hotel_id) {
		// TODO Auto-generated method stub
		return null;
	}


}
