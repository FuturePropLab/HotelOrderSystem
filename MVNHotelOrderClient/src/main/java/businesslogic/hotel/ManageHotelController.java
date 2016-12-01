package businesslogic.hotel;

import businesslogicservice.ManageHotelInfoService;
import tools.ResultMessage_Hotel;
import vo.HotelInputVO;

/**
 * 12.1
 * @author wshwbluebird
 *
 */
public class ManageHotelController implements ManageHotelInfoService {
	 private Hotel hotel;
	 
	 private static ManageHotelController manageHotelController = null;
	 private ManageHotelController(){
		 hotel = new Hotel();
	 }

     public static ManageHotelController getInstance(){
			if(manageHotelController==null)
				manageHotelController  =new ManageHotelController();
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

}
