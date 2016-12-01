package po;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import testHibernate.SCPK;
import tools.RoomType;

@Embeddable
public class RoomPK implements Serializable{
	private static final long serialVersionUID = -8989026014861620804L;
	private String hotelID;
	private RoomType roomtype;
	
	public RoomPK(){
		super();
	}
	
	public RoomPK(String hotelID,RoomType roomtype){
		this.hotelID  = hotelID;
		this.roomtype = roomtype;
	}

	public String getHotelID() {
		return hotelID;
	}

	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}
	@Enumerated(EnumType.STRING)
	public RoomType getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(RoomType roomtype) {
		this.roomtype = roomtype;
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof RoomPK ){
			RoomPK key = (RoomPK)o;
			if(this.getHotelID().equals(key.getHotelID())  && this.getRoomtype().equals(key.getRoomtype()))
				return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.hotelID.hashCode();
	}
	
	
}
