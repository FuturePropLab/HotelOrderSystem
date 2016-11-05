package dataservice.datahelper;

import java.util.Map;

public interface LoginCheckDatahelper {
		/**
		 * 获取所有持久化存储的用户名和密码
		 * @return Map<username , password>
		 */
		public Map<String , String> getAlluserInfo();
		
		public boolean updataAlluserInfo(Map<String,String> map);
		
}
