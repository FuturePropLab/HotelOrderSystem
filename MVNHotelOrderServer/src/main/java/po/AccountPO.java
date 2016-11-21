package po;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import tools.AccountType;

@Entity
public class AccountPO {
		private String id;
		private String password;
		@Enumerated(EnumType.STRING)
		private AccountType accountType;
		
		public AccountPO(String id , String password  , AccountType accountType){
			this.id = id;
			this.password = password;
			this.accountType = accountType;
		}
		@Id
		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}
		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		@Enumerated(EnumType.STRING)
		public AccountType getAccountType() {
			return accountType;
		}

		public void setAccountType(AccountType accountType) {
			this.accountType = accountType;
		}
		
}
