package vo;

import java.net.URI;

import tools.HotelAddress;
import tools.HotelRoomInfo;
import tools.Star;
//cyy  12/5删掉用户名、密码、酒店设施、房间信息
/**
 * 酒店基本信息，即酒店详情界面上的信息，不包括设施服务、房间信息、评价信息
 * @author wshwbluebird
 * @author zjy
 */
public class HotelInputVO {
	public URI hotePictureURI;
	//public String username;//酒店工作人员账户名
	//public String password; //酒店工作人员账密码
	public String hotelID; //酒店的ID
	public String HotelName;//酒店名字
	public Star star; 
	public HotelAddress hotelAddress; //酒店地址
	//public HotelFacilityVO hotelFacilityVO;//酒店的设施信息
	public HotelDiscribtionsVO hotelInfoVO ; //酒店详情 介绍 图片 或者包括排版
	//public HotelRoomInfo hotelRoomInfo; //酒店的房间信息
	
	/**
	 * 注册用构造方法
	 * @param username
	 * @param password
	 */
	/*public HotelInputVO (String username ,String password){
		super();
		this.username = username;
		this.password = password;
	}*/
	
	/**
	 * 注册用构造方法
	 * @param username
	 * @param password
	 * @param HotelName
	 * @param star
	 */
	/*public HotelInputVO(String username ,String password, String HotelName,Star star){
		super();
		this.username = username;
		this.password = password;
		this.star = star;
		this.HotelName = HotelName;
	}*/
	
	/**
	 * 注册用构造方法
	 * @param username
	 * @param password
	 * @param HotelName
	 * @param star
	 * @param hotelAddress
	 */
	/*public HotelInputVO(String username ,String password, 
			String HotelName,Star star,HotelAddress hotelAddress){
		super();
		this.username = username;
		this.password = password;
		this.star = star;
		this.HotelName = HotelName;
		this.hotelAddress = hotelAddress;
	}*/
	
	/**
	 * 注册用构造方法
	 * @param username
	 * @param password
	 * @param hotelAddress
	 */
	/*public HotelInputVO(String username ,String password, HotelAddress hotelAddress){
		super();
		this.username = username;
		this.password = password;
		this.hotelAddress = hotelAddress;
	}*/
	
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
//		this.hotelFacilityVO = hotelFacilityVO;
		this.hotelInfoVO = hotelInfoVO;
//		this.hotelRoomInfo = hotelRoomInfo;
	}

	/**
	 * 这个构造方法才是正式使用的构造方法，其他重载的版本仅供测试使用
	 * @param hotePictureURI 酒店图片
	 * @param hotelID 酒店ID
	 * @param hotelName 酒店名称
	 * @param star 酒店星级
	 * @param hotelAddress 酒店地址
	 * @param hotelInfoVO 注意：这个是酒店简介板块信息
	 */
	public HotelInputVO(URI hotePictureURI, String hotelID, String hotelName, Star star, HotelAddress hotelAddress,
			HotelDiscribtionsVO hotelInfoVO) {
		super();
		this.hotePictureURI = hotePictureURI;
		this.hotelID = hotelID;
		this.HotelName = hotelName;
		this.star = star;
		this.hotelAddress = hotelAddress;
		this.hotelInfoVO = hotelInfoVO;
	}
	
}
