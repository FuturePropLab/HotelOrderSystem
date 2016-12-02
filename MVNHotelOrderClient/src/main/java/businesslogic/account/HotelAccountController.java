package businesslogic.account;

import java.util.List;

import businesslogicservice.AccountHotelService;
import tools.AccountType;
import tools.ResultMessage_Account;
import vo.AccountVO;
import vo.HotelSearchVO;
import vo.HotelbriefVO;

/**
 * 
 * @author wshwbluebird
 *
 */
public class HotelAccountController implements AccountHotelService {
	
	private Account account;
	
	private static HotelAccountController hotelAccountController = null;
	
	/**
	 * 单件模式初始化
	 */
	private HotelAccountController(){
		this.account = new Account();
	}
	
	public static HotelAccountController getInstance(){
		if(hotelAccountController == null)
			hotelAccountController = new HotelAccountController();
		return hotelAccountController;
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


	public HotelbriefVO getHotelDetail(String hotel_id) {
		return account.getHotelDetail(hotel_id);
	}


	public ResultMessage_Account deleteAccount(String userId) {
		return account.deleteAccount(userId);
	}


}
