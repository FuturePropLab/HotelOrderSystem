package DataFactory;

import dataservice.datahelper.AccountDataHelper;
import dataservice.datahelper.AddressDataHelper;
import dataservice.datahelper.CreditLogdataHelper;
import dataservice.datahelper.CustomerDataHelper;
import dataservice.datahelper.DiscountHotelDataHelper;
import dataservice.datahelper.DiscountWebDataHelper;
import dataservice.datahelper.HotelDataHelper;
import dataservice.datahelper.LoginCheckDatahelper;
import dataservice.datahelper.MemberDataHelper;
import dataservice.datahelper.OrderDataHelper;
import dataservice.datahelper.RoomDateHelper;
import dataservice.datahelper.impl.AccountDataHelperImpl;
import dataservice.datahelper.impl.AddressDataHelperImpl;
import dataservice.datahelper.impl.CreditLogdataHelperImpl;
import dataservice.datahelper.impl.CustomerDataHelperImpl;
import dataservice.datahelper.impl.DiscountHotelDataHelperImpl;
import dataservice.datahelper.impl.DiscountWebDataHelperImpl;
import dataservice.datahelper.impl.HotelDataHelperImpl;
import dataservice.datahelper.impl.LoginCheckDatahelperImpl;
import dataservice.datahelper.impl.MemberDataHelperImpl;
import dataservice.datahelper.impl.OrderDateHelperImpl;
import dataservice.datahelper.impl.RoomDateHelperImpl;

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
	
	/**
	 * 
	 * @return
	 */
	public static RoomDateHelper getRoomDateHelper(){
		return  RoomDateHelperImpl.getInstantce();
	}
	
	/**
	 * 
	 * @return
	 */
	public static DiscountWebDataHelper getDiscountWebDataHelper(){
		return DiscountWebDataHelperImpl.getInstance();
	}
	
	/**
	 * 
	 * @return
	 */
	public static DiscountHotelDataHelper getDiscountHotelDataHelper(){
		return DiscountHotelDataHelperImpl.getInstance();
	}
	
	/**
	 * 
	 * @return
	 */
	public static OrderDataHelper getOrderDataHelper(){
		return OrderDateHelperImpl.getInstance();
	}
	
	
	public static CreditLogdataHelper getCreditLogdataHelper(){
		return CreditLogdataHelperImpl.getIntance();
	}
	
	
	public static MemberDataHelper  getMemberDataHelper(){
		return  MemberDataHelperImpl.getInstance();
	}
	
}
