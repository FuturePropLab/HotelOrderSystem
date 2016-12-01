package tools;

import java.io.Serializable;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import po.TypeRoomInfoPO;

public class TypeRoomInfo implements Serializable{
	
	 private static final long serialVersionUID = 6650204031779388668L;

	  private String hotelID;
		
	  private String hotelName;//酒店名称
	  
	  private RoomType roomtype;
    
	  private int availableCount;  //!!!房间总数量 !!!!
    
	  private  Double price; //房间价格
	  
	  public TypeRoomInfo (String hotelID,String hotelName,RoomType roomtype,
    int availableCount,Double price){
		  this.availableCount = availableCount;
		  this.hotelID = hotelID;
		  this.hotelName = hotelName;
		  this.price = price;
		  this.roomtype = roomtype;
	  }
	  
	  /*
	   * construct for hibernate 
	   */
	  public TypeRoomInfo(){
		  super();
	  }
	  public TypeRoomInfo(TypeRoomInfoPO typeRoomInfoPO){
		  this.availableCount = typeRoomInfoPO.getAvailableCount();
		  this.hotelID = typeRoomInfoPO.getRoomPK().getHotelID();
		  this.hotelName = typeRoomInfoPO.getHotelName();
		  this.price = typeRoomInfoPO.getPrice();
		  this.roomtype = typeRoomInfoPO.getRoomPK().getRoomtype();
	
	  }
	  
	public String getHotelID() {
		return hotelID;
	}

	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	
	public RoomType getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(RoomType roomtype) {
		this.roomtype = roomtype;
	}

	public int getAvailableCount() {
		return availableCount;
	}

	public void setAvailableCount(int availableCount) {
		this.availableCount = availableCount;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	  
	
      
}
