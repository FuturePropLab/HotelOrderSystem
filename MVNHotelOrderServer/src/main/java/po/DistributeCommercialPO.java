package po;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DistributeCommercialPO {
		
		private String distribute;
		private String businessCircle;
	
		@Id
		public String getDistribute() {
			return distribute;
		}
		public void setDistribute(String distribute) {
			this.distribute = distribute;
		}
		public void setBusinessCircle(String businessCircle) {
			this.businessCircle = businessCircle;
		}
		public String getBusinessCircle() {
			return businessCircle;
		}
		
		
}
