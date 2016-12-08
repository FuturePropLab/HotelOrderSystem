package po;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import tools.HotelFacility;
 
@Entity
public class HotelFacilityPO implements Serializable{
	
		 /**
	 * 
	 */
	private static final long serialVersionUID = -8412278370429311327L;
		String hotelID;
	  	 boolean swimmingPool;
	     boolean healthHub;
	     boolean gym;
	     boolean parking;
	     
	     boolean airCondition;
	     boolean wifi;
	     boolean hotWater;
	     boolean broadband;
	     boolean TV;
	     boolean computer;
	     String elseFacility;
	     
	     public HotelFacilityPO(){
	      	super();
	     }
	     
	     public HotelFacilityPO(String hotelID , HotelFacility hotelFacility){
	    	 this.hotelID = hotelID;
	    	 this.swimmingPool = hotelFacility.isSwimmingPool();
	    	 this.healthHub =  hotelFacility.isHealthHub();
	    	 this.gym = hotelFacility.isGym();
	    	 this.parking = hotelFacility.isParking();
	    	 this.airCondition = hotelFacility.isAirCondition();
	    	 this.wifi = hotelFacility.isWifi();
	    	 this.hotWater = hotelFacility.isHotWater();
	    	 this.computer = hotelFacility.isComputer();
	    	 this.TV = hotelFacility.isTv();
	    	 this.elseFacility = hotelFacility.getElseFacility();
	     }

	     
	     @Id 
		public String getHotelID() {
			return hotelID;
		}

		public void setHotelID(String hotelID) {
			this.hotelID = hotelID;
		}

		public boolean isSwimmingPool() {
			return swimmingPool;
		}

		public void setSwimmingPool(boolean swimmingPool) {
			this.swimmingPool = swimmingPool;
		}

		public boolean isHealthHub() {
			return healthHub;
		}

		public void setHealthHub(boolean healthHub) {
			this.healthHub = healthHub;
		}

		public boolean isGym() {
			return gym;
		}

		public void setGym(boolean gym) {
			this.gym = gym;
		}

		public boolean isParking() {
			return parking;
		}

		public void setParking(boolean parking) {
			this.parking = parking;
		}

		public boolean isAirCondition() {
			return airCondition;
		}

		public void setAirCondition(boolean airCondition) {
			this.airCondition = airCondition;
		}

		public boolean isWifi() {
			return wifi;
		}

		public void setWifi(boolean wifi) {
			this.wifi = wifi;
		}

		public boolean isHotWater() {
			return hotWater;
		}

		public void setHotWater(boolean hotWater) {
			this.hotWater = hotWater;
		}

		public boolean isBroadband() {
			return broadband;
		}

		public void setBroadband(boolean broadband) {
			this.broadband = broadband;
		}

		public boolean isTV() {
			return TV;
		}

		public void setTV(boolean tV) {
			TV = tV;
		}

		public boolean isComputer() {
			return computer;
		}

		public void setComputer(boolean computer) {
			this.computer = computer;
		}

		public String getElseFacility() {
			return elseFacility;
		}

		public void setElseFacility(String elseFacility) {
			this.elseFacility = elseFacility;
		}
	     
	     
}
