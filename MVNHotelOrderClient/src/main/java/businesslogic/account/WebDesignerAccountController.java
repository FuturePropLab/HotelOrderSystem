package businesslogic.account;

import businesslogicservice.AccountWebService;
import tools.ResultMessage;
import vo.WebAccountVO;
/**
 * 实现WebDesignerAccountService的接口
 * @author wshwbluebird
 *
 */
public class WebDesignerAccountController implements AccountWebService {
	
	private Account account;
	
	public ResultMessage addWebAccount(WebAccountVO webAccountVO) {
		return account.addWebAccount(webAccountVO);
	}

	public ResultMessage modifyWebAccount(WebAccountVO webAccountVO) {
		return account.modifyWebAccount(webAccountVO);
	}

	public WebAccountVO getWebAccount(String web_id) {
		return account.getWebAccount(web_id);
	}

	
	/**
	 * 初始化
	 */
	public WebDesignerAccountController(){
		this.account = new Account();
	}
}
