package businesslogicservice;

import java.util.List;

import tools.ResultMessage;
import vo.CustomerAccountVO;
import vo.SearchConditionVO;

public interface AccountCustomerService {
	public CustomerAccountVO getCustomerAccount(String customer_id);

	public ResultMessage accountModify(CustomerAccountVO customerAccount);

	public List<CustomerAccountVO> searchCustomerAccount(SearchConditionVO vo);
}
