package vo;

import java.net.URI;

import tools.HotelAddress;
import tools.HotelRoomInfo;
import tools.Star;

/**
 * 我改了 这个类的值可以很多为空
 * @author wshwbluebird
 *
 */
public class HotelInputVO {
	public URI hotePictureURI;
	public String username;//酒店工作人员账户名
	public String password; //酒店工作人员账密码
	public String hotelID; //酒店的ID
	public String HotelName;//酒店名字
	public Star star; 
	public HotelAddress hotelAddress; //酒店地址
	public HotelFacilityVO hotelFacilityVO;//酒店的设施信息
	public HotelDiscribtionsVO hotelInfoVO ; //酒店详情 介绍 图片 或者包括排版
	public HotelRoomInfo hotelRoomInfo; //酒店的房间信息
	
	/**
	 * 注册用构造方法
	 * @param username
	 * @param password
	 */
	public HotelInputVO (String username ,String password){
		super();
		this.username = username;
		this.password = password;
	}
	
	/**
	 * 注册用构造方法
	 * @param username
	 * @param password
	 * @param HotelName
	 * @param star
	 */
	public HotelInputVO(String username ,String password, String HotelName,Star star){
		super();
		this.username = username;
		this.password = password;
		this.star = star;
		this.HotelName = HotelName;
	}
	
	/**
	 * 注册用构造方法
	 * @param username
	 * @param password
	 * @param HotelName
	 * @param star
	 * @param hotelAddress
	 */
	public HotelInputVO(String username ,String password, 
			String HotelName,Star star,HotelAddress hotelAddress){
		super();
		this.username = username;
		this.password = password;
		this.star = star;
		this.HotelName = HotelName;
		this.hotelAddress = hotelAddress;
	}
	
	/**
	 * 注册用构造方法
	 * @param username
	 * @param password
	 * @param hotelAddress
	 */
	public HotelInputVO(String username ,String password, HotelAddress hotelAddress){
		super();
		this.username = username;
		this.password = password;
		this.hotelAddress = hotelAddress;
	}
	
	/**
	 * 修改用
	 * @param hotelID
	 * @param hotelAddress
	 */
	public HotelInputVO(String hotelID, HotelAddress hotelAddress){
		super();
		this.hotelID =  hotelID;
		this.hotelAddress = hotelAddress;
	}
	
	/**
	 * 修改用
	 * @param hotelID
	 * @param hotelFacility
	 * @param hotelInfo
	 * @param hotelRoomInfo
	 */
	public HotelInputVO(String hotelID,  HotelFacilityVO hotelFacilityVO,
			HotelDiscribtionsVO hotelInfoVO , HotelRoomInfo hotelRoomInfo){
		super();
		this.hotelID =  hotelID;
		this.hotelFacilityVO = hotelFacilityVO;
		this.hotelInfoVO = hotelInfoVO;
		this.hotelRoomInfo = hotelRoomInfo;
	}
	
	
	
}
