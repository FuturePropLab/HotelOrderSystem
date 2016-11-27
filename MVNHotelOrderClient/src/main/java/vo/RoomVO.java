package vo;

import po.RoomPO;
import tools.RoomState;
import tools.RoomType;

/**
 *  单个房间的信息
 *  @author zjy
 */
public class RoomVO {
	public String hotelID; //酒店ID
	public String hotelName;//酒店名称
	public String roomID;  //房间号
	public RoomType roomType; //房间类型
	public double price; //房间价格
	public  RoomState state;
    
	/**
	 *  @param hotelID  酒店ID
	 *  @param hotelName  酒店名称
	 *  @param roomID  房间ID
	 *  @param roomType  房间类型
	 *  @param price  房间原始价格
	 */
	public RoomVO (String hotelID,String hotelName,String roomID, RoomType roomType,double price){
		this.price = price;
		this.roomID = roomID;
		this.roomType = roomType;
		this.hotelID = hotelID;
		this.hotelName = hotelName;
		state = RoomState.Available;
	}
	/**
	 * @author chenyuyan 11/24
	 * 增加一个构造方法
	 * @param hotel_id
	 * @param room_id
	 * @param state
	 */
	public RoomVO(String hotel_id, String room_id, RoomState state){
		this.hotelID = hotel_id;
		this.roomID = room_id;
		this.state = state;
	}
	/**
	 * @author chenyuyan 11/26
	 * 增加构造方法，持久化数据转化为vo
	 * @param roompo
	 */
	public RoomVO(RoomPO roompo){
		
		this.hotelID = roompo.getHotelID();
		this.hotelName = roompo.getHotelName();
		this.roomID = roompo.getRoomID();
		this.roomType = roompo.getRoomType();
		this.price = roompo.getPrice();
		this.state = roompo.getState();
		
		
		
	}
/**
 *@author chenyuyan 11/27
 *增加一个构造方法，为了添加房间是并不知道id，没有id的构造方法
 */
	public RoomVO (String hotelID,String hotelName, RoomType roomType,double price){
		this.price = price;
	
		this.roomType = roomType;
		this.hotelID = hotelID;
		this.hotelName = hotelName;
		state = RoomState.Available;
	}
}
