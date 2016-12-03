package po;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import tools.RoomType;

/**
 * @author wshwbluebird
 *
 */
@Entity
public class SingleRoomPO implements Serializable {
		
	private static final long serialVersionUID = -188356064056016101L;
		@Id
		private SingleRoomPK singleRoomPK;
		private RoomType roomType;
		public SingleRoomPO(){
			super();
		}
				
		public SingleRoomPO(String hotelID , String RoomNO, RoomType roomType){
			this.singleRoomPK =new SingleRoomPK(hotelID,RoomNO);
			this.roomType =roomType;
		}
		
		public SingleRoomPK getSingleRoomPK() {
			return singleRoomPK;
		}

		public void setSingleRoomPK(SingleRoomPK singleRoomPK) {
			this.singleRoomPK = singleRoomPK;
		}
		
		@Enumerated(EnumType.STRING)
		public RoomType getRoomType() {
			return roomType;
		}

		public void setRoomType(RoomType roomType) {
			this.roomType = roomType;
		}
		
	    
}
