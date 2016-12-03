package po;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class SingleRoomPK implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7853683766585973290L;
	private String hotelID;
	private String RoomNO;
	
	public  SingleRoomPK(){
		super();
	}
	
	public SingleRoomPK(String hotelID , String RoomNO){
		this.hotelID = hotelID;
		this.RoomNO = RoomNO;
	}
	
	
	public String getHotelID() {
		return hotelID;
	}



	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}



	public String getRoomNO() {
		return RoomNO;
	}



	public void setRoomNO(String roomNO) {
		RoomNO = roomNO;
	}



	@Override
	public boolean equals(Object o){
		if(o instanceof SingleRoomPK ){
			SingleRoomPK key = (SingleRoomPK)o;
			if(this.getHotelID().equals(key.getHotelID())  && this.RoomNO.equals(key.RoomNO))
				return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.hotelID.hashCode();
	}
	
	 
}
