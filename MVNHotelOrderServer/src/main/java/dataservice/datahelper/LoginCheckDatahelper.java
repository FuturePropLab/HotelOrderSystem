package dataservice.datahelper;

import java.util.Map;

import tools.AccountType;

public interface LoginCheckDatahelper {
		/**
		 * 
		 * @param userid
		 * @param accountType
		 * @return 加密后的密码
		 */
		public String passwordInSha(String userid , AccountType accountType);
		
		public boolean updataAlluserInfo(Map<String,String> map);
		
}
