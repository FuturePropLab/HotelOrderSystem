package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dataservice.AccountDataService;
import dataservice.CustomerDataService;
import dataservice.LoginCheckService;
import dataservice.impl.AccountDataServiceImpl;
import dataservice.impl.CustomerDataServiceImpl;
import dataservice.impl.LoginCheckServiceImpl;
import po.AccountPO;
import po.CustomerPO;
import tools.AccountType;
import tools.ResultMessage_Account;
import tools.ResultMessage_LoginCheck;
import tools.ResultMessage_Modify;
import tools.ResultMessage_signUp;

public class DataRemoteObject extends UnicastRemoteObject implements  LoginCheckService ,AccountDataService,CustomerDataService{
	/**
	 *  RMI 接口
	 */
	private static final long serialVersionUID = 4029039744279087114L;
	private LoginCheckService loginCheckService;
	private AccountDataService accountDataService;
	private CustomerDataService customerDataService;
	protected DataRemoteObject() throws RemoteException {
		//用loginCheckServiceIMPL 实现
		loginCheckService = new LoginCheckServiceImpl();
		accountDataService = new AccountDataServiceImpl();
		customerDataService = new CustomerDataServiceImpl();

	}
	/**
	 * LoginCheckService的接口方法
	 */
	public ResultMessage_LoginCheck checkLogin(String username, String password,AccountType accountType)  throws RemoteException{		
		//System.out.println("远程调用方法 : loginCheckService.checkLogin ");
		return loginCheckService.checkLogin(username, password,accountType);
	}
	
	public String getUserID(String username, String password) throws RemoteException  {
		return loginCheckService.getUserID(username, password);
	}
	
	/**
	 * AccountDataService 的接口方法
	 * @throws RemoteException 
	 */
	public ResultMessage_Account resetPassword(String userid, String newPassword) throws RemoteException {
		return accountDataService.resetPassword(userid, newPassword);
	}
	public AccountPO getAccountByUserName(String username) throws RemoteException {
		return accountDataService.getAccountByUserName(username);
	}
	public AccountPO getAccountByID(String userid) throws RemoteException {
		return accountDataService.getAccountByID(userid);
	}
	public ResultMessage_Account addAccount(AccountPO accountPO) throws RemoteException {
		return accountDataService.addAccount(accountPO);
	}
	public ResultMessage_Account deleteAccount(String userid) throws RemoteException {
		return accountDataService.deleteAccount(userid);
	}
	public List<AccountPO> getAccountList(List<String> idList,AccountType accountType) throws RemoteException {
		return accountDataService.getAccountList(idList,accountType);
	}
	
	/**
	 * customer 类的数据相关内容
	 */
	public ResultMessage_signUp add(CustomerPO customerInfo) throws RemoteException {
		return customerDataService.add(customerInfo);
	}
	public CustomerPO find(String customer_id) throws RemoteException {
		return customerDataService.find(customer_id);
	}
	public ResultMessage_Modify modify(CustomerPO customerInfo) throws RemoteException {
		return customerDataService.modify(customerInfo);
	}
	public List<CustomerPO> searchCustomer() throws RemoteException {
		return customerDataService.searchCustomer();
	}

}
