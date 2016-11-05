package businesslogic.account;

import java.util.List;

import businesslogicservice.AccountCustomerService;
import tools.ResultMessage;
import vo.CustomerAccountVO;
import vo.CustomerSearchVO;

public class CustomerAccountController implements AccountCustomerService{
	private Account account;
	public CustomerAccountVO getCustomerAccount(String customer_id) {
		return account.getCustomerAccount(customer_id);
	}

	public ResultMessage accountModify(CustomerAccountVO customerAccount) {
		return account.accountModify(customerAccount);
	}

	public List<CustomerAccountVO> searchCustomerAccount(CustomerSearchVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
		
}
