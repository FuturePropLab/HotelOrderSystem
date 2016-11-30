package businesslogic.hotel;

public class HotelFacility {
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
     
     public HotelFacility(){
    	this.airCondition = false;
    	this.gym = false;
    	this.healthHub = false;
    	this.TV = false;
    	this.hotWater = false;
    	this.computer = false;  	
    	this.wifi = false;
    	this.swimmingPool = false;
    	this.broadband = false;
    	this.parking = false;
    	this.elseFacility = "";  	
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