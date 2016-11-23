package dataservice.impl;

import dataservice.AccountDataService;
import po.AccountPO;
import tools.AccountType;
import tools.ResultMessage_Account;

public class AccountDataServiceImpl implements AccountDataService {
	
	private AccountDataService accountDataService; 
	
	public ResultMessage_Account resetPassword(String userid, String newPassword) {
		//TODO 检测用户名 是否符合要求
		if(userid.length()<6 || userid.length()>=20) 
			return ResultMessage_Account.InvalidInput;
		else if(newPassword.length() < 6)
			return ResultMessage_Account.InvalidInput;
		else
			return accountDataService.resetPassword(userid, newPassword);
	}

	public AccountPO getAccountByUserName(String username) {
		return accountDataService.getAccountByUserName(username);
	}

	public AccountPO getAccountByID(String userid) {
		//TODO 检测用户名 是否符合要求
		if(userid.length()<6 || userid.length()>=20) 
			return null;
		AccountPO accountPO = accountDataService.getAccountByID(userid);
		
		// 密码是不能传递的
		if(accountPO!=null){
			accountPO.setPassword(null);
		}
		return accountPO;
		
	}

	public ResultMessage_Account addAccount(AccountPO accountPO) {
		return accountDataService.addAccount(accountPO);
	}

	public ResultMessage_Account deleteAccount(String userid) {
		//TODO 检测用户名 是否符合要求
		if(userid.length()<6 || userid.length()>=20) 
			return null;
		return accountDataService.deleteAccount(userid);
	}

}
