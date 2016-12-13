package po;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StatePO {
		@Id
		String accountID;
		int mark;
		
		public StatePO(String accoutID){
			this.accountID = accoutID;
		}
		public StatePO(){
			
		}

		public String getAccountID() {
			return accountID;
		}

		public void setAccountID(String accountID) {
			this.accountID = accountID;
			this.mark = 0;
		}
		public int getMark() {
			return mark;
		}
		public void setMark(int mark) {
			this.mark = mark;
		}
		
		
		
		
		
}
