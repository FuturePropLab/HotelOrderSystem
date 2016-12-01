package tools;

import java.io.Serializable;



public class TypeRoomInfo implements Serializable{
	
	 
	private static final long serialVersionUID = 6650204031779388668L;

	private String hotelID;
		
	  private String hotelName;//酒店名称
	  
	  private RoomType roomtype;
    
	  private int availableCount; //!!!房间总数量 !!!!
    
	  private  Double price; //房间价格
	  
	  /**
	   * 
	   * @param hotelID
	   * @param hotelName
	   * @param roomtype
	   * @param availableCount
	   * @param price
	   */
	  public TypeRoomInfo (String hotelID,String hotelName,RoomType roomtype,
    int availableCount,Double price){
		  this.availableCount = availableCount;
		  this.hotelID = hotelID;
		  this.hotelName = hotelName;
		  this.price = price;
		  this.roomtype = roomtype;
	  }
	  /**
	   * 
	   * @param hotelID
	   * @param roomtype
	   * @param availableCount
	   * @param price
	   */
	  public TypeRoomInfo (String hotelID,RoomType roomtype, int availableCount,Double price){
			 this.availableCount = availableCount;
			 this.hotelID = hotelID;
			 this.hotelName = null;
			 this.price = price;
			 this.roomtype = roomtype;
	 }
	  
	public String getHotelID() {
		return hotelID;
	}

	public String getHotelName() {
		return hotelName;
	}

	public RoomType getRoomtype() {
		return roomtype;
	}

	public int getAvailableCount() {
		return availableCount;
	}

	public Double getPrice() {
		return price;
	}

	public void setRoomtype(RoomType roomtype) {
		this.roomtype = roomtype;
	}

	public void setAvailableCount(int availableCount) {
		this.availableCount = availableCount;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
      
}
