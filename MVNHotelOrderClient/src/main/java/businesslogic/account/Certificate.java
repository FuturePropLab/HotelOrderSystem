package businesslogic.account;


/**
 * 验证数据的合法性
 * @author wshwbluebird
 *
 */
public class Certificate {
		/**
		 * 检测用户名是合法
		 * @param username
		 * @return boolean
		 */
		public static boolean isValidUsername(String username){
			//TODO add more restriction 
			if(username == null)
				return false;
			if(username.length()<5 || username.length() >=20 ){
				return false;
			}
			
			return true;
		}
		
		/**
		 * 检测要修改的密码是否合法
		 * @param password
		 * @return boolean
		 */
		public static boolean isValidPassword(String password){
			
			//TODO add more restriction to password
			if(password==null)
				return false;
			if(password.length()<5 || password.length()>=20 )
				return false;
			return true;
		}
		
		
}
