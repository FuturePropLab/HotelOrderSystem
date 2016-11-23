package businesslogic.account;

import java.util.List;

import businesslogicservice.AccountHotelService;
import tools.AccountType;
import tools.ResultMessage_Account;
import vo.AccountVO;
import vo.HotelInfoVO;
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
		return account.getAccountID(username);
	}


	public ResultMessage_Account addAccount(String username, String password) {
		return account.addAccount(username, password, AccountType.Hotel);
	}


	public ResultMessage_Account resetPassword(String userid, String newPassword) {
		return account.resetPassword(userid, newPassword);
	}


	public String getUsername(String userId) {
		return account.getUsername(userId);
	}


	public List<AccountVO> searchHotelAccount(HotelSearchVO hotelSearchVO) {
		return account.searchHotelAccount(hotelSearchVO);
	}


	public HotelInfoVO getHotelDetail(String hotel_id) {
		return account.getHotelDetail(hotel_id);
	}


	public ResultMessage_Account deleteAccount(String userId) {
		return account.deleteAccount(userId);
	}


}
