package businesslogic.account;

import java.util.LinkedList;
import java.util.List;

import businesslogicservice.AccountCustomer_blService;
import tools.ResultMessage;
import vo.CustomerAccountVO;

public class Account_driver {

	public static void main(String[] args) {
		AccountCustomer_blService accustomerbl = new Account_stub();
		drive(accustomerbl);
	}

	public static void drive(AccountCustomer_blService accountCustomer_blService) {
		ResultMessage result = accountCustomer_blService.accountModify(new CustomerAccountVO("003", "happy", "2016"));
		if (result == ResultMessage.Exist)
			System.out.println("Modify successfully");
		CustomerAccountVO cusvo = new CustomerAccountVO("01", "enen", "201616");
		cusvo = accountCustomer_blService.getCustomerAccount("01");
		System.out.println(cusvo.customerId);
		List<CustomerAccountVO> searchCustomerAccount = new LinkedList<CustomerAccountVO>();
		searchCustomerAccount.add(cusvo);

	}

}
