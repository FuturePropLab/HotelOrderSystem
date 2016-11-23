package businesslogicservice;

import vo.LogVO;

/**
 * 
 * @author zjy
 *
 */
public interface LoginService {
	/**
	 * 
	 * @param username 用户输入的用户名
	 * @param password 用户输入的密码
	 * @return 登陆的结果
	 */
	public LogVO login(String username,String password);
}
