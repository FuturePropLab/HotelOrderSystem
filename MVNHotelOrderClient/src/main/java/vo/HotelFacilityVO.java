package vo;
/**
 * 酒店设施服务信息
 * @author zjy
 *
 */
public class HotelFacilityVO {
	
	public String hotelID;
	public boolean wifi;
	public boolean noneSmoke;//无烟房
	public boolean diningHall;//餐厅
	public boolean parkingLot;//免费停车场
	public boolean elevator;//电梯
	public boolean conferenceHall;//会议厅
	public boolean morningCall;//叫醒服务
	public boolean frontdeskservice;//24小时前台服务
	public boolean luggageStorage;//行李寄存
	public boolean breakfast;//供应早餐
	public String other;
	
	/**
	 * 
	 * @param hotelID 酒店ID
	 * @param wifi 是否有wifi
	 * @param noneSmoke 无烟房
	 * @param diningHall 餐厅
	 * @param parkingLot 免费停车场
	 * @param elevator 电梯
	 * @param conferenceHall 会议厅
	 * @param morningCall 叫醒服务
	 * @param frontdeskservice 24小时前台服务
	 * @param luggageStorage 行李寄存
	 * @param breakfast 供应早餐
	 * @param other 其它
	 */
	public HotelFacilityVO(String hotelID, boolean wifi, boolean noneSmoke, boolean diningHall, boolean parkingLot,
			boolean elevator, boolean conferenceHall, boolean morningCall, boolean frontdeskservice,
			boolean luggageStorage, boolean breakfast, String other) {
		super();
		this.hotelID = hotelID;
		this.wifi = wifi;
		this.noneSmoke = noneSmoke;
		this.diningHall = diningHall;
		this.parkingLot = parkingLot;
		this.elevator = elevator;
		this.conferenceHall = conferenceHall;
		this.morningCall = morningCall;
		this.frontdeskservice = frontdeskservice;
		this.luggageStorage = luggageStorage;
		this.breakfast = breakfast;
		this.other = other;
	}
}
