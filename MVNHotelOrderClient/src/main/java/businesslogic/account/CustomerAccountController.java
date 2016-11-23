package businesslogic.account;

import java.util.List;

import businesslogicservice.AccountCustomerService;
import tools.AccountType;
import tools.ResultMessage;
import tools.ResultMessage2;
import tools.ResultMessage_Account;
import vo.AccountVO;
import vo.CustomerAccountVO;
import vo.CustomerInputVO;
import vo.CustomerSearchVO;
import vo.CustomerVO;
import vo.HotelSearchVO;

/**
 * 
 * @author wshwbluebird
 *
 */
public class CustomerAccountController implements AccountCustomerService{
	private Account account;
	
	public CustomerAccountController(){
		account = new Account();
	}

	public String getAccountID(String username) {
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

	public CustomerVO getCustomerDetail(String customer_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<AccountVO> searchCustomerAccount(CustomerSearchVO customerSearchVO) {
		// TODO Auto-generated method stub
		return null;
	}
	
		
}
