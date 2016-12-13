package vo;

import java.util.Date;

public class FuzzySearchOrderVO {
		public String hotelID;
		public String customerID;
		public Date date ;
		public String keyword;
		public boolean unexe;
		public boolean exed;
		public boolean revoke;
		public boolean bad;
		
		public FuzzySearchOrderVO(String hotelID ,String customerID, Date date,String keyword,boolean unexe,boolean exed,
				boolean revoke,boolean bad){
			this.customerID = customerID;
			this.hotelID = hotelID;
			this.date = date;
			this.keyword = keyword;
			this.exed = exed;
			this.unexe = unexe;
			this.bad = bad;
			this.revoke = revoke;
		}
}
