package rmi;

import java.rmi.Remote;

import dataservice.AccountDataService;
import dataservice.CustomerDataService;
import dataservice.HotelDataService;
import dataservice.LoginCheckService;
import dataservice.OrderDataService;

/**
 * 
 * @author wshwbluebird
 *
 */
public class RemoteHelper {
	private Remote remote;
	private static RemoteHelper remoteHelper = new RemoteHelper();
	public static RemoteHelper getInstance(){
		return remoteHelper;
	}
	
	private RemoteHelper() {
	}
	
	public void setRemote(Remote remote){
		this.remote = remote;
	}
	
	/**
	 * 返回LoginCheckService RMI调用
	 * @return LoginCheckService
	 */
	public LoginCheckService getLoginCheckService(){
		return (LoginCheckService )remote;
	}
	
	/**
	 * 返回AccountDataService RMI调用
	 * @return AccountDataService
	 */
	public AccountDataService getAccountDataService(){
		return (AccountDataService)remote;
	}
	
	public OrderDataService getOrderDataService(){
		return (OrderDataService)remote;
	}
	
	/**
	 * 返回CustomerDataService RMI调用
	 * @return CustomerDataService
	 */
	public CustomerDataService getCustomerDataService(){
		return (CustomerDataService)remote;
	}

	/**
	 * 
	 * @return
	 */
	public HotelDataService getHotelDataService(){
		return (HotelDataService)remote;
	}
}
