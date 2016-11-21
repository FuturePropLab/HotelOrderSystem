package po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import tools.AccountType;

@Entity
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
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
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
