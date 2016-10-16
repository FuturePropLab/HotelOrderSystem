package vo;

import tools.RoomState;
import tools.RoomType;

public class RoomVO {
	public String hotelID; //酒店ID
	public String hotelName;//酒店名称
	public String roomID;  //房间号
	public RoomType roomType; //房间类型
	public Double price; //房间价格
	public  RoomState state;
    
	public RoomVO (String hotelID,String hotelName,String roomID, RoomType roomType,Double price){
		this.price = price;
		this.roomID = roomID;
		this.roomType = roomType;
		this.hotelID = hotelID;
		this.hotelName = hotelName;
		state = RoomState.Available;
	}
	

}
