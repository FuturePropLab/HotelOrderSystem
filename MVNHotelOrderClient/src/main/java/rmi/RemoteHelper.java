package rmi;

import java.rmi.Remote;

import dataservice.AccountDataService;
import dataservice.CreditDataService;
import dataservice.CustomerDataService;
import dataservice.DiscountHotelDataService;
import dataservice.DiscountWebDataService;
import dataservice.HotelDataService;
import dataservice.LoginCheckService;
import dataservice.MemberDataService;
import dataservice.MessgeDataService;
import dataservice.OrderDataService;
import dataservice.RoomDataService;

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
	
	public RoomDataService getRoomDataService(){
		return (RoomDataService)remote;
	}
	
	
	public DiscountWebDataService getDiscountWebDAteService(){
		return (DiscountWebDataService)remote;
	}
	
	public DiscountHotelDataService getDiscountHotelDataService(){
		return (DiscountHotelDataService)remote;
	}
	
	public CreditDataService getCreditDataService(){
		return (CreditDataService)remote;
	}
	
	public MemberDataService getMemberDataService(){
		return (MemberDataService)remote;
	}
	
	public MessgeDataService getMessgeDataService(){
		return (MessgeDataService)remote;
	}
	
	
}
