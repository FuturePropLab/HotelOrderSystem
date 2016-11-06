package po;

import tools.AccountType;

/**
 * 
 * @author wshwbluebird
 *
 */
public class AccoutPO {
		private String ID;
		private String name;
		private String password;
		private AccountType  accountType;
		
		public AccoutPO(String ID,String name,String password, AccountType  accountType) {
			this.ID = ID;
			this.password = password;
			this.accountType = accountType;
			this.name = name;
		}

		public String getID() {
			return ID;
		}


		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public AccountType getAccountType() {
			return accountType;
		}

		public void setAccountType(AccountType accountType) {
			this.accountType = accountType;
		}
		
}
