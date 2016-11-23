package businesslogic.account;

import java.util.List;

import businesslogicservice.AccountWebService;
import tools.ResultMessage;
import tools.ResultMessage_Account;
import vo.AccountVO;
import vo.WebAccountVO;
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

	public List<AccountVO> searchWebDesignerAccount(WebDesignerSearchVO webDesignerSearchVO) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
