package DataFactory;

import dataservice.datahelper.AccountDataHelper;
import dataservice.datahelper.AddressDataHelper;
import dataservice.datahelper.CustomerDataHelper;
import dataservice.datahelper.HotelDataHelper;
import dataservice.datahelper.LoginCheckDatahelper;
import dataservice.datahelper.impl.AccountDataHelperImpl;
import dataservice.datahelper.impl.AddressDataHelperImpl;
import dataservice.datahelper.impl.CustomerDataHelperImpl;
import dataservice.datahelper.impl.HotelDataHelperImpl;
import dataservice.datahelper.impl.LoginCheckDatahelperImpl;

/**
 * 数据助手类抽象工厂
 * @author wshwbluebird
 *
 */
public  class DataHelperUtils {
	
	/**
	 * 
	 * @return LoginCheckDatahelper
	 */
	public static LoginCheckDatahelper getLoginCheckDatahelper(){
		return LoginCheckDatahelperImpl.getInstance();
	}
	
	/**
	 * AccountDataHelper
	 * @return
	 */
	public static AccountDataHelper getAccountDataHelper(){
		return AccountDataHelperImpl.getInstance();
	}
	
	/**
	 * 
	 * @return
	 */
	public static CustomerDataHelper getCustomerDataHelper(){
		return CustomerDataHelperImpl.getInstance();
	}
	
	/**
	 * 
	 */
	 
	public static HotelDataHelper getHotelDataHelper(){
		return HotelDataHelperImpl.getInstance();
	}
	
	/**
	 * 
	 * @return
	 */
	public static AddressDataHelper geAddressDataHelper(){
		return AddressDataHelperImpl.getInstance();
	}
	
}
