package vo;

import java.net.URI;
import java.util.List;

import tools.RoomDescription;
import tools.RoomType;

public class RoomDescriptionVO {
	public  RoomType roomType; //房间的类型
	public List<String>  description; //房间的描述
	public URI typeimage; //改种房间的图片
	
	public RoomDescriptionVO(RoomType roomType ,List<String>  description, URI typeimage){
		this.roomType = roomType;
		this.description = description;
		this.typeimage  =typeimage;
	}
	
	public RoomDescriptionVO(RoomDescription roomDescription){
		this.roomType = roomDescription.getRoomType();
		this.description = roomDescription.getDescription();
		this.typeimage  =roomDescription.getTypeimage();
	}
}
