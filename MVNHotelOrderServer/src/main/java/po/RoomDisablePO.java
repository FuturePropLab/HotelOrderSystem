package po;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RoomDisablePO implements Serializable{

	private static final long serialVersionUID = 1662489958388288717L;
		@Id
		private RoomDisablePK roomDisablePK;
		private Date end;
		
		public RoomDisablePO(){
			super();
		}
		
		/**
		 * 
		 * @param hotelID
		 * @param roomNO
		 * @param begin
		 * @param end
		 */
		public RoomDisablePO(String hotelID , String roomNO , Date begin , Date end){
			  this.roomDisablePK = new RoomDisablePK(hotelID, roomNO, begin);
			  this.end = end;
		}

		public RoomDisablePK getRoomDisablePK() {
			return roomDisablePK;
		}

		public void setRoomDisablePK(RoomDisablePK roomDisablePK) {
			this.roomDisablePK = roomDisablePK;
		}

		public Date getEnd() {
			return end;
		}

		public void setEnd(Date end) {
			this.end = end;
		}

	
		
		
}
