package po;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import tools.RoomType;
import tools.TypeRoomInfo;

@Entity
public class TypeRoomInfoPO implements Serializable{
 
	private static final long serialVersionUID = 7723572381158309175L;

	  @Id
	  private RoomPK roomPK;
		
	  private String hotelName;//酒店名称
    
	  private int availableCount;  //!!!房间总数量 !!!!
    
	  private  Double price; //房间价格
	  
	  public TypeRoomInfoPO (String hotelID,String hotelName,RoomType roomtype,
    int availableCount,Double price){
		  this.availableCount = availableCount;
		  this.roomPK = new RoomPK(hotelID, roomtype);
		  this.hotelName = hotelName;
		  this.price = price;		  
	  }
	  
	  /*
	   * construct for hibernate 
	   */
	  public TypeRoomInfoPO(){
		  super();
	  }
	  
	  public TypeRoomInfoPO(TypeRoomInfo typeRoomInfo){
		  this(typeRoomInfo.getHotelID(), typeRoomInfo.getHotelName(), typeRoomInfo.getRoomtype(), 
				  typeRoomInfo.getAvailableCount(), typeRoomInfo.getPrice());
	  }


	 @Enumerated(EnumType.STRING)
	public RoomPK getRoomPK() {
		return roomPK;
	}

	public void setRoomPK(RoomPK roomPK) {
		this.roomPK = roomPK;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
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
