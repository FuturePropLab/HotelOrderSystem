package businesslogic.account;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import businesslogicservice.AccountWebService;
import po.AccountPO;
import tools.AccountType;
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
	
	private static WebDesignerAccountController webDesignerAccountController = null;
	
	/**
	 * 初始化
	 */
	private WebDesignerAccountController(){
		this.account = new Account();
	}
	
	public static WebDesignerAccountController getInstance(){
		if(webDesignerAccountController == null)
			webDesignerAccountController = new WebDesignerAccountController();
		return webDesignerAccountController;
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

	@Override
	public List<WebAccountVO> getWebAccount() {
		List<AccountPO>  WebAccounts  = null;
		try {
			WebAccounts  = account.getWebAccount();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			WebAccounts = new ArrayList<>();
		}
		List<WebAccountVO> voList = new ArrayList<WebAccountVO>();
		Iterator<AccountPO> it = WebAccounts.iterator();
		while(it.hasNext()){
			AccountPO accountPO = it.next();
			voList.add(new WebAccountVO(accountPO));
		}
		return voList;
	}
	
	
	@Override
	public ResultMessage_Account modifyUserName(String accountID, String username) {
		return account.modifyUserName(accountID, username);
	}
	
}
