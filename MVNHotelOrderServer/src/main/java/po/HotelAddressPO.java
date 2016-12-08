package po;

import javax.persistence.Entity;
import javax.persistence.Id;

import tools.HotelAddress;
 
@Entity
public class HotelAddressPO {
       private String hotelID;
       private String city;   // 城市
       private String district;  // 街区
       private String businessCircle; // 所在商圈
       private String addressDetail; //  地址
       
       public HotelAddressPO(){
    	   super();
       }
       
       public HotelAddressPO(String hotel_id , HotelAddress hotelAddress){
    	   this.hotelID = hotel_id;
    	   this.city = hotelAddress.getCity();
    	   this.district = hotelAddress.getDistrict();
    	   this.businessCircle = hotelAddress.getBusinessCircle();
    	   this.addressDetail = hotelAddress.getAddressDetail();
       }
     
    @Id	
	public String getHotelID() {
		return hotelID;
	}
	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getBusinessCircle() {
		return businessCircle;
	}
	public void setBusinessCircle(String businessCircle) {
		this.businessCircle = businessCircle;
	}
	public String getAddressDetail() {
		return addressDetail;
	}
	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}
       
    public String toAllString(){
    	String ans = "";
    	if(city!=null)  ans+=city;
    	if(district!=null) ans+=district;
    	if(businessCircle!=null) ans+=businessCircle;
		return ans; 
    	
    }
}
