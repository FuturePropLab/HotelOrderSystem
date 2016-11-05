package driver;

import businesslogicservice.RoomSingleService;
import tools.RoomType;
import vo.RoomVO;

public class RoomSingleService_Driver {
   public void drive(RoomSingleService roomSingleService){
	   System.out.println(roomSingleService.getSingleRoom("bsdf", "301").price);
	   RoomVO roomVo = new RoomVO("dasa",
			   "我的大酒店", "301", RoomType.Single, 203.00);
	   
	   System.out.println(roomSingleService.addSingleRoom("12312"));
	   System.out.println(roomSingleService.editSingleRoom("234", "401").roomType);
	   System.out.println(roomSingleService.deleteSingleRoom("234", "401"));
	   System.out.println(roomSingleService.saveSingleRoom(roomVo));
	   
   }
}
