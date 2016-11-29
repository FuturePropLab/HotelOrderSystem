package po;

import java.util.ArrayList;
import java.util.Date;

import businesslogic.room.RoomDescription;
import tools.RoomState;
import tools.RoomType;

public class RoomPO {

	private String hotelID; //酒店ID
	private String hotelName;//酒店名称
	private String roomID;  //房间号
	private RoomType roomType; //房间类型
	private Double price; //房间价格
	private  RoomState state;
	private RoomDescription description;//房间描述
	private  ArrayList<Date> BookedDate;//客房的预定时间列表
    
	public RoomPO (String hotelID,String hotelName,String roomID, RoomType roomType,Double price,RoomDescription description){
		this.price = price;
		this.roomID = roomID;
		this.roomType = roomType;
		this.hotelID = hotelID;
		this.hotelName = hotelName;
		state = RoomState.Available;
		this.description = description;
	}
	/**
	 * @author chenyuyan 11/24
	 * 增加一个构造方法，
	 * @return
	 */
	public RoomPO(String hotelID,String roomID,RoomState roomstate,ArrayList<Date> BookedDate){
		this.hotelID = hotelID;
		this.roomID = roomID;
		this.state = roomstate;
		this.BookedDate = BookedDate;
		
		
	}
	
	public String getHotelID() {
		return hotelID;
	}

	public String getHotelName() {
		return hotelName;
	}

	public String getRoomID() {
		return roomID;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public Double getPrice() {
		return price;
	}

	public RoomState getState() {
		return state;
	}

	public void setRoomID(String roomID) {
		this.roomID = roomID;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setState(RoomState state) {
		this.state = state;
	}
	
	
	
}
