package po;

import java.io.Serializable;

import tools.AccountType;

/**
 * 
 * @author wshwbluebird
 *
 */
public class AccountPO implements Serializable{
	
	private static final long serialVersionUID = -3068966912083464632L;
		private String userid;
		private String password;
		private String username;
		private AccountType accountType;
		
		public AccountPO(String id , String username , String password , AccountType accountType){
			this.userid = id;
			this.username = username;
			this.password = password;
			this.accountType = accountType;
		}

		
		public String getUserid() {
			return userid;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public AccountType getAccountType() {
			return accountType;
		}

		public void setAccountType(AccountType accountType) {
			this.accountType = accountType;
		}
		
}
