package dataservice.impl;

import DataFactory.DataHelperUtils;
import dataservice.AccountDataService;
import dataservice.datahelper.AccountDataHelper;
import po.AccountPO;
import tools.AccountType;
import tools.ResultMessage_Account;

/**
 * 
 * @author wshwbluebird
 *
 */
public class AccountDataServiceImpl implements AccountDataService {
	
	
	public ResultMessage_Account resetPassword(String userid, String newPassword) {
		//TODO 检测用户名 是否符合要求
		if(userid.length()<5 || userid.length()>=20) 
			return ResultMessage_Account.InvalidInput;
		if(newPassword.length() < 6)
			return ResultMessage_Account.InvalidInput;
		else{
			AccountDataHelper accountDataHelper = DataHelperUtils.getAccountDataHelper();
			return accountDataHelper.resetPassword(userid, newPassword);
		}
	}

	public AccountPO getAccountByUserName(String username) {
		AccountDataHelper accountDataHelper = DataHelperUtils.getAccountDataHelper();
		return accountDataHelper.getAccountByUserName(username);
	}

	public AccountPO getAccountByID(String userid) {
		//TODO 检测用户名 是否符合要求
		if(userid.length()<5 || userid.length()>=20) 
			return null;
		AccountDataHelper accountDataHelper = DataHelperUtils.getAccountDataHelper();
		AccountPO accountPO = accountDataHelper.getAccountByID(userid);
		
		// 密码是不能传递的
		if(accountPO!=null){
			accountPO.setPassword(null);
		}
		return accountPO;
		
	}

	public ResultMessage_Account addAccount(AccountPO accountPO) {
		AccountDataHelper accountDataHelper = DataHelperUtils.getAccountDataHelper();
		return accountDataHelper.addAccount(accountPO);
	}

	public ResultMessage_Account deleteAccount(String userid) {
		//TODO 检测用户名 是否符合要求
		if(userid.length()<5 || userid.length()>=20) 
			return null;
		AccountDataHelper accountDataHelper = DataHelperUtils.getAccountDataHelper();
		return accountDataHelper.deleteAccount(userid);
	}
	
	
	public static void main(String[] args) {
//		AccountDataServiceImpl impl = new AccountDataServiceImpl();
//		System.out.println(impl.addAccount(new AccountPO("CR003","lwylwy","zhujunyi",AccountType.Customer)));
//		AccountPO accountPO = impl.getAccountByUserName("lwylwy");
//		System.out.println(accountPO.getUserid());
	}

}
