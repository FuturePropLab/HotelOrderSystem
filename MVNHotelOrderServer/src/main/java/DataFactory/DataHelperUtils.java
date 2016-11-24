package DataFactory;

import dataservice.datahelper.AccountDataHelper;
import dataservice.datahelper.LoginCheckDatahelper;
import dataservice.datahelper.impl.AccountDataHelperImpl;
import dataservice.datahelper.impl.LoginCheckDatahelperImpl;

/**
 * 数据助手类抽象工厂
 * @author wshwbluebird
 *
 */
public class DataHelperUtils {
	private static LoginCheckDatahelper loginCheckDatahelper = new LoginCheckDatahelperImpl();
	private static AccountDataHelper accountDataHelper = new AccountDataHelperImpl();
	
	/**
	 * 
	 * @return LoginCheckDatahelper
	 */
	public static LoginCheckDatahelper getLoginCheckDatahelper(){
		return loginCheckDatahelper;
	}
	
	/**
	 * AccountDataHelper
	 * @return
	 */
	public static AccountDataHelper getAccountDataHelper(){
		return accountDataHelper;
	}
	
}
