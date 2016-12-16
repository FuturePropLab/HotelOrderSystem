package dataservice.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.plaf.synth.SynthSpinnerUI;

import DataFactory.DataHelperUtils;
import dataservice.AccountDataService;
import dataservice.HotelDataService;
import dataservice.datahelper.AccountDataHelper;
import dataservice.datahelper.CustomerDataHelper;
import dataservice.datahelper.HotelDataHelper;
import po.AccountPO;
import po.CustomerAccount;
import po.CustomerPO;
import po.HotelAccount;
import po.HotelAddressPO;
import po.HotelBasePO;
import tools.AccountType;
import tools.ResultMessage_Account;

/**
 * 
 * @author wshwbluebird
 *
 */
public class AccountDataServiceImpl implements AccountDataService {
	
	/*
	 * (non-Javadoc)
	 * @see dataservice.AccountDataService#resetPassword(java.lang.String, java.lang.String)
	 */
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
	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.AccountDataService#getAccountByUserName(java.lang.String)
	 */
	public AccountPO getAccountByUserName(String username) {
		AccountDataHelper accountDataHelper = DataHelperUtils.getAccountDataHelper();
		return accountDataHelper.getAccountByUserName(username);
	}
	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.AccountDataService#getAccountByID(java.lang.String)
	 */
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
	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.AccountDataService#addAccount(po.AccountPO)
	 */
	public ResultMessage_Account addAccount(AccountPO accountPO) {
		System.out.println(accountPO.getUserid());
		System.out.println(accountPO.getUsername());
		System.out.println(accountPO.getPassword());
		System.out.println(accountPO.getAccountType());
		AccountDataHelper accountDataHelper = DataHelperUtils.getAccountDataHelper();
		return accountDataHelper.addAccount(accountPO);
	}
	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.AccountDataService#deleteAccount(java.lang.String)
	 */
	public ResultMessage_Account deleteAccount(String userid) {
		//TODO 检测用户名 是否符合要求
		if(userid.length()<5 || userid.length()>=20) 
			return ResultMessage_Account.InvalidInput;
		AccountDataHelper accountDataHelper = DataHelperUtils.getAccountDataHelper();
		return accountDataHelper.deleteAccount(userid);
	}
	
	/**
	 * 测试用
	 * @param args
	 */
	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.AccountDataService#getAccountList(java.util.List)
	 */
	public List<AccountPO> getAccountList(List<String> idList,AccountType accountType) throws RemoteException {
		AccountDataHelper accountDataHelper = DataHelperUtils.getAccountDataHelper();
		List<AccountPO> accountList = accountDataHelper.getAccountList(accountType);
		List<AccountPO> accountListReturn = new ArrayList<AccountPO>();
		Iterator<AccountPO> accountIt = accountList.iterator();
		while(accountIt.hasNext()){
			AccountPO accountPO = accountIt.next();
			String userid = accountPO.getUserid();
			System.out.println(userid);
			Iterator<String> it =  idList.iterator();
			while(it.hasNext()){
				if(it.next().equals(userid)){
					accountListReturn.add(accountPO);
					break;
				}
			}			
		}
		return accountListReturn;
	}

	public List<CustomerAccount> getCustomerAccount() throws RemoteException {
		AccountDataHelper accountDataHelper = DataHelperUtils.getAccountDataHelper();
		List<AccountPO>  accountList = accountDataHelper.getAccountList(AccountType.Customer);
		List<CustomerAccount> customerAccounts  =new  ArrayList<CustomerAccount>();
		Iterator<AccountPO> it = accountList.iterator();
		CustomerDataHelper customerDataHelper = DataHelperUtils.getCustomerDataHelper();
		while(it.hasNext()){
			AccountPO accountPO = it.next();
			CustomerPO customerPO  =customerDataHelper.find(accountPO.getUserid()) ;
			if(customerPO!=null && accountPO!=null){
				CustomerAccount account = new CustomerAccount(accountPO, customerPO);
				customerAccounts.add(account);
			}
		}
		return customerAccounts;
	}

	public List<HotelAccount> getHotelAccount() throws RemoteException {
		AccountDataHelper accountDataHelper = DataHelperUtils.getAccountDataHelper();
		List<AccountPO>  accountList = accountDataHelper.getAccountList(AccountType.Hotel);
		List<HotelAccount> hotelAccounts  =new  ArrayList<HotelAccount>();
		Iterator<AccountPO> it = accountList.iterator();
		HotelDataHelper hotelDataHelper= DataHelperUtils.getHotelDataHelper();
		HotelDataService hotelDataService = new HotelDataServiceImpl();
		
		while(it.hasNext()){
			AccountPO accountPO = it.next();
			HotelAddressPO hotelAddressPO  =hotelDataHelper.getHotelAddressPO(accountPO.getUserid()) ;
			HotelBasePO hotelBasePO = hotelDataHelper.getHotelBasePO(accountPO.getUserid());
			if(accountPO!=null && hotelAddressPO!=null && hotelBasePO!=null){
				HotelAccount account = new HotelAccount(accountPO, hotelAddressPO, hotelBasePO);
				List<String>  liststr = hotelDataService.getHotelInfoString(accountPO.getUserid());
				if(liststr!=null && !liststr.isEmpty()){
					account.setContactWay(liststr.get(0));
				}
				hotelAccounts.add(account);
			}
		}
		return hotelAccounts;
	}

	public List<AccountPO> getAccountByTypr(AccountType accountType) throws RemoteException {
		AccountDataHelper accountDataHelper = DataHelperUtils.getAccountDataHelper();
		List<AccountPO> list= accountDataHelper.getAccountList(accountType);
		if(list == null){
			list =  new ArrayList<AccountPO>();
		}
		
		return list;
	}

}
