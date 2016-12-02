package ui.room;

import tools.RoomType;
import ui.main.DetailsController;

/**
 * 房间信息的控制器
 * @author zjy
 *
 */
public class RoomInfoController extends DetailsController{
	private RoomType roomType;

	public void setRoomType(RoomType roomType) {
		this.roomType=roomType;
		
	}

}
