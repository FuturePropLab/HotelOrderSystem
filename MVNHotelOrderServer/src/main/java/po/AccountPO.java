package po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import tools.AccountType;

@Entity
public class AccountPO implements Serializable{
	private static final long serialVersionUID = -3068966912083464632L;
		private String userid;
		private String password;
		private String username;
		@Enumerated(EnumType.STRING)
		private AccountType accountType;
		
		public AccountPO(){
			
		}
		public AccountPO(String id ,String username, String password  , AccountType accountType){
			this.userid = id;
			this.username =username;
			this.password = password;
			this.accountType = accountType;
		}
		@Id
		public String getUserid() {
			return userid;
		}
		
		public void setUserid(String userid) {
			this.userid = userid;
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
		
		@Enumerated(EnumType.STRING)
		public AccountType getAccountType() {
			return accountType;
		}

		public void setAccountType(AccountType accountType) {
			this.accountType = accountType;
		}
		
}
