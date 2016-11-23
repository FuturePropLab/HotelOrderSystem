package businesslogic.account;

import java.util.List;

import businesslogicservice.AccountWebService;
import tools.AccountType;
import tools.ResultMessage_Account;
import vo.AccountVO;
import vo.WebDesignerSearchVO;
/**
 * 实现WebDesignerAccountService的接口
 * @author wshwbluebird
 *
 */
public class WebDesignerAccountController implements AccountWebService {
	
	private Account account;
	
	/**
	 * 初始化
	 */
	public WebDesignerAccountController(){
		this.account = new Account();
	}

	public String getAccountID(String username) {
		return account.getAccountID(username);
	}

	public ResultMessage_Account addAccount(String username, String password) {
		return account.addAccount(username, password, AccountType.Web);
	}

	public ResultMessage_Account resetPassword(String userid, String newPassword) {
		return account.resetPassword(userid, newPassword);
	}

	public String getUsername(String userId) {
		return account.getUsername(userId);
	}

	public List<AccountVO> searchWebDesignerAccount(WebDesignerSearchVO webDesignerSearchVO) {
		return account.searchWebDesignerAccount(webDesignerSearchVO);
	}

	public ResultMessage_Account deleteAccount(String userId) {
		return account.deleteAccount(userId);
	}
	
}
