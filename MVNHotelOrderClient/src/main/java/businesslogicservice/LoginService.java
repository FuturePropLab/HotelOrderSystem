package businesslogicservice;

public interface LoginService {
	    /**
	     * 检查是用户名密码是否正确
	     * @param userID
	     * @param password
	     * @return boolean
	     */
		public boolean checkValid(String userID , String password);
}
