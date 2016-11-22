package dataservice.datahelper;

import java.util.Map;

import tools.AccountType;

public interface LoginCheckDatahelper {
		/**
		 * 
		 * @param username
		 * @param accountType
		 * @return 加密后的密码
		 */
		public String passwordInSha(String username , AccountType accountType);
		
		/**
		 * 通过用户名密码  获取id
		 * @param username
		 * @param password
		 * @return ID
		 */
		public String getID(String username , String password);
		
		
		public boolean updataAlluserInfo(Map<String,String> map);
		
}
