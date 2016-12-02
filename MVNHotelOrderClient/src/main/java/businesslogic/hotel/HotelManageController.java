package businesslogic.hotel;

import java.net.URI;

import businesslogicservice.ManageHotelInfoService;
import tools.ResultMessage_Hotel;
import vo.HotelInputVO;

/**
 * 12.1
 * @author wshwbluebird
 *
 */
public class HotelManageController implements ManageHotelInfoService {
	 private Hotel hotel;
	 
	 private static HotelManageController manageHotelController = null;
	 private HotelManageController(){
		 hotel = new Hotel();
	 }

     public static HotelManageController getInstance(){
			if(manageHotelController==null)
				manageHotelController  =new HotelManageController();
			return manageHotelController;
	  }
	
     
     /*@
      * (non-Javadoc)
      * @see businesslogicservice.ManageHotelInfoService#addHotel(vo.HotelInputVO)
      */
	 public ResultMessage_Hotel addHotel(HotelInputVO hotelInputVO) {
	   	 return hotel.addHotel(hotelInputVO);
	 }

	 /*@
	  * (non-Javadoc)
	  * @see businesslogicservice.ManageHotelInfoService#saveHotelInfo(vo.HotelInputVO)
	  */
	 public ResultMessage_Hotel saveHotelInfo(HotelInputVO hotelInputVO) {
		 return hotel.saveHotelInfo(hotelInputVO);
	 }

	public ResultMessage_Hotel modifyHotelPicture(String hotelID, URI uri) {
		// TODO Auto-generated method stub
		return null;
	}

}
