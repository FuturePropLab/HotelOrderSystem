package dataservice.Account;

import java.util.List;

public interface Web {
	public ResultMessage addWeb(WebAccountPO po);

	public ResultMessage modifyWeb(WebAccountPO po);

	public WebAccountPO getWeb(String WebAccount_id);

	public List<WebAccountPO> searchWebList(SearchCondition searchCondition);

}
