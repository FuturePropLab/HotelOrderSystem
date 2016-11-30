package po;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CityDistributePO {
		private String city;
		private String distribute;
		
		@Id
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getDistribute() {
			return distribute;
		}
		public void setDistribute(String distribute) {
			this.distribute = distribute;
		}
	
		
		
}
