package tools;

import java.io.Serializable;

/**
 * 酒店的地址信息类
 * @author wshwbluebird
 *
 */
public class HotelAddress implements Serializable{
	private static final long serialVersionUID = 3740034410193502363L;
	 String city;   // 城市
	 String district;  // 街区
	 String businessCircle; // 所在商圈
	 String addressDetail; //  地址
	 
	 public HotelAddress(String city , String district,String businessCircle,String addressDetail){
		 this.city = city;
		 this.district = district;
		 this.businessCircle = businessCircle;
		 this.addressDetail = addressDetail;
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
	 
	 
	/**
	 * 重写toString方法
	 */
	@Override
	public String toString() {
		String ans = city+"市"+district+"区"+addressDetail;
		return ans;
	}
	 
}
