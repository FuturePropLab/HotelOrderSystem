package tools;

import java.io.Serializable;

import po.HotelFacilityPO;


public class HotelFacility  implements Serializable{
     /**
	 * 
	 */
	private static final long serialVersionUID = 7380253760906799517L;
	/**
	 * 
	 */

	     private boolean swimmingPool;
	     private boolean healthHub;
	     private boolean gym;
	     private boolean parking;
	     
	     private boolean airCondition;
	     private boolean wifi;
	     private boolean hotWater;
	     private boolean broadband;
	     private boolean tv;
	     private boolean computer;
	     private String elseFacility;
 
     public HotelFacility(String elseFacility){
    	 super();
    	this.airCondition = false;
    	this.gym = false;
    	this.healthHub = false;
    	this.tv = false;
    	this.hotWater = false;
    	this.computer = false;  	
    	this.wifi = false;
    	this.swimmingPool = false;
    	this.broadband = false;
    	this.parking = false;
    	this.elseFacility = elseFacility;  	
     }
     
     public HotelFacility(){
    	 super();
     }
     
     public HotelFacility(HotelFacilityPO hotelFacilityPO){
    	 super();
     	this.airCondition = hotelFacilityPO.isAirCondition();
     	this.gym = hotelFacilityPO.isGym();
     	this.healthHub = hotelFacilityPO.isHealthHub();
     	this.tv = hotelFacilityPO.isTV();
     	this.hotWater = hotelFacilityPO.isHotWater();
     	this.computer = hotelFacilityPO.isComputer();	
     	this.wifi = hotelFacilityPO.isWifi();
     	this.swimmingPool = hotelFacilityPO.isSwimmingPool();
     	this.broadband = hotelFacilityPO.isBroadband();
     	this.parking = hotelFacilityPO.isParking();
     	this.elseFacility = hotelFacilityPO.getElseFacility();  	
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



	public boolean isTv() {
		return tv;
	}

	public void setTv(boolean tv) {
		this.tv = tv;
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
