package tools;

import java.net.URI;
import java.util.List;

import vo.RoomDescriptionVO;

public class RoomDescription{
		RoomType roomType; //房间的类型
		List<String>  description;
		URI typeimage;
		
		public RoomDescription(){
			
		}
		public RoomDescription(RoomDescriptionVO roomDescriptionVO){
			this.typeimage = roomDescriptionVO.typeimage;
			this.roomType  = roomDescriptionVO.roomType;
			this.description = roomDescriptionVO.description;
		}
		
		public RoomType getRoomType() {
			return roomType;
		}
		public void setRoomType(RoomType roomType) {
			this.roomType = roomType;
		}
		public List<String> getDescription() {
			return description;
		}
		public void setDescription(List<String> description) {
			this.description = description;
		}
		public URI getTypeimage() {
			return typeimage;
		}
		public void setTypeimage(URI typeimage) {
			this.typeimage = typeimage;
		}
		
		
		
}
