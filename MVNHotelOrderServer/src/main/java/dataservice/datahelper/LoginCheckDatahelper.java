package dataservice.datahelper;

import java.util.Map;

import tools.AccountType;

public interface LoginCheckDatahelper {
		/**
		 * 通过账户类型 和 用户名 获取加密后的密码
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

		
}
