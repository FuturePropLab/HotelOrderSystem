package po;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import tools.Star;

/**
 * 酒店的简单信息!!
 * @author wshwbluebird
 *
 */

@Entity
public class HotelBasePO {
		private String hotelID;
		private String hotelName;
		private double grade;
		private Star star;
		
		public HotelBasePO (){
			super();
		}
		
		public HotelBasePO(HotelPO hotelPO){
			this.hotelID =  hotelPO.getHotelID();
			this.hotelName = hotelPO.getHotelName();
			this.grade = hotelPO.getGrade();
			this.star = hotelPO.getStar();
		}
		@Id
		public String getHotelID() {
			return hotelID;
		}

		public void setHotelID(String hotelID) {
			this.hotelID = hotelID;
		}

		public String getHotelName() {
			return hotelName;
		}

		public void setHotelName(String hotelName) {
			this.hotelName = hotelName;
		}

		public double getGrade() {
			return grade;
		}

		public void setGrade(double grade) {
			this.grade = grade;
		}

		@Enumerated(EnumType.STRING)
		public Star getStar() {
			return star;
		}

		public void setStar(Star star) {
			this.star = star;
		}
        
		
		
}
