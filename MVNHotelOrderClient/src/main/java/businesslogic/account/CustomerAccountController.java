package businesslogic.account;

import java.rmi.RemoteException;
import java.util.List;

import businesslogicservice.AccountCustomerService;
import po.CustomerAccount;
import tools.AccountType;
import tools.ResultMessage_Account;
import vo.AccountVO;
import vo.CustomerSearchVO;
import vo.CustomerVO;

/**
 * 
 * @author wshwbluebird
 *
 */
public class CustomerAccountController implements AccountCustomerService{
	private static CustomerAccountController customerAccountController = null;
	private CustomerAccountController(){
		account = new Account();
	}
	private Account account;
	
	public static CustomerAccountController getInstance(){
		if(customerAccountController==null)
			customerAccountController  =new CustomerAccountController();
		return customerAccountController;
	}
	
	/**
	 * 无参数 初始化方法
	 */
//	public CustomerAccountController(){
//		account = new Account();
//	}
	

	public String getAccountID(String username) {
		return account.getAccountID(username);
	}

	public ResultMessage_Account addAccount(String username, String password) {
		return account.addAccount(username, password, AccountType.Customer);
	}

	public ResultMessage_Account resetPassword(String userid, String newPassword) {
		return account.resetPassword(userid, newPassword);
	}

	public String getUsername(String userId) {
		return account.getUsername(userId);
	}

	public CustomerVO getCustomerDetail(String customer_id) throws RemoteException {
		return account.getCustomerDetail(customer_id);
	}

	public List<AccountVO> searchCustomerAccount(CustomerSearchVO customerSearchVO) throws RemoteException {
		return account.searchCustomerAccount(customerSearchVO);
	}


	public ResultMessage_Account deleteAccount(String userId) {
		return account.deleteAccount(userId);
	}

	@Override
	public List<CustomerAccount> getCustomerAccount() throws RemoteException {
		return account.getCustomerAccount();
	}

	@Override
	public ResultMessage_Account modifyUserName(String accountID, String username) {
		return account.modifyUserName(accountID, username);
	}
	
		
}
