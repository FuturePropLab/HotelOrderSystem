package po;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;


@Embeddable
public class RoomDisablePK implements Serializable {
	/**
	 * 
	 */
	
	private static final long serialVersionUID = -632870926291931246L;
	private String hotelID;
	private String roomNO;
	private Date begin;
	public RoomDisablePK(){
		
	}
	
	public RoomDisablePK(String hotelID, String roomNO , Date begin){
		this.begin = begin;
		this.hotelID = hotelID;
		this.roomNO = roomNO;
	}
	public String getHotelID() {
		return hotelID;
	}
	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}
	public String getRoomNO() {
		return roomNO;
	}
	public void setRoomNO(String roomNO) {
		roomNO = roomNO;
	}
	public Date getBegin() {
		return begin;
	}
	public void setBegin(Date begin) {
		this.begin = begin;
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof RoomDisablePK ){
			RoomDisablePK key = (RoomDisablePK)o;
			if(this.getHotelID().equals(key.getHotelID())  && this.roomNO.equals(key.roomNO) && 
					this.getBegin().equals(key.getBegin()))
				return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.hotelID.hashCode();
	}
	
	
}
