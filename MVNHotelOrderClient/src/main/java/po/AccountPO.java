package po;

import tools.AccountType;

public class AccountPO {
		private String id;
		private String password;
		private String username;
		private AccountType accountType;
		
		public AccountPO(String id , String password , String username , AccountType accountType){
			this.id = id;
			this.username = username;
			this.password = password;
			this.accountType = accountType;
		}

		public String getId() {
			return id;
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
