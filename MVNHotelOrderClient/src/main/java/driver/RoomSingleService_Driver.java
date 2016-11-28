package driver;

import businesslogic.room.RoomDescription;
import businesslogicservice.RoomSingleService;
import tools.RoomType;
import vo.RoomVO;

public class RoomSingleService_Driver {
   public void drive(RoomSingleService roomSingleService){
	   System.out.println(roomSingleService.getSingleRoom("bsdf", "301").price);
	   
	   RoomDescription description = new RoomDescription("卫生间");
	   RoomVO roomVo = new RoomVO("dasa",
			   "我的大酒店", "301", RoomType.Single, 203.00,description);
	   
	   System.out.println(roomSingleService.addSingleRoom("12312",roomVo));
	   System.out.println(roomSingleService.editSingleRoom(roomVo));
	   System.out.println(roomSingleService.deleteSingleRoom("234", "401"));
	   System.out.println(roomSingleService.saveSingleRoom(roomVo));
	   
   }
}
