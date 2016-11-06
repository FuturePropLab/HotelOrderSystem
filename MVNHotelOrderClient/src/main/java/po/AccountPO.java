package po;

import tools.AccountType;

public class AccountPO {
		private String id;
		private String password;
		private String name;
		private AccountType accountType;
		
		public AccountPO(String id , String password , String name , AccountType accountType){
			this.id = id;
			this.name = name;
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

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public AccountType getAccountType() {
			return accountType;
		}

		public void setAccountType(AccountType accountType) {
			this.accountType = accountType;
		}
		
}
