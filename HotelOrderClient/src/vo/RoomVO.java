package vo;

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
	

}
