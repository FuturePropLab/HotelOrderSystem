package dataservice.datahelper.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import dataservice.datahelper.LoginCheckDatahelper;

public class LoginCheckDatahelperImpl implements LoginCheckDatahelper {
	
	/**
	 * 查找所有的信息数据
	 * 包含所有的用户名和密码
	 * 明文存储w
	 */
	public Map<String, String> getAlluserInfo() {
		File file = new File("src/main/resources/TXTdata/LoginUserInfo.txt");
		Map<String,String> map = new HashMap<String, String>();
		try {
			InputStreamReader reader = new InputStreamReader(new FileInputStream(
					file), "UTF-8");
			BufferedReader br = new BufferedReader(reader);
			String str = br.readLine();
			
			while (str != null) {
				
				String[] data = str.split(";");
				String username = data[0];
				String  password = data[1];
				map.put(username, password);
				
				str = br.readLine();
				
			}

			br.close();
			
			return map;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	public boolean updataAlluserInfo(Map<String, String> map) {
		// TODO Auto-generated method stub
		return false;
	}

}
