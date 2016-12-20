package dataservice.datahelper;

import java.rmi.RemoteException;
import java.util.List;
import java.util.regex.Pattern;

import po.HotelAddressPO;
import po.HotelBasePO;
import po.HotelFacilityPO;
import po.OrderAssessPO;
import tools.HotelAddress;
import tools.HotelFacility;
import tools.HotelRoomInfo;
import tools.ResultMessage_Hotel;
import tools.RoomType;
import tools.Star;
import tools.TypeRoomInfo;

public interface HotelDataHelper {
	
	  /**
	   * 
	   * @param hotelName
	   * @return
	   */
	  public String getHotelID(String hotelName);
	  
	  /**
	   * 
	   * @param hotelID
	   * @return
	   */
	  public HotelBasePO getHotelBasePO(String hotelID);
	  
	  /**
	   * 
	   * @param hotelID
	   * @return
	   */
	  public HotelAddressPO getHotelAddressPO(String hotelID);
	  
	  /**
	   * 
	   * @param hotelID
	   * @return
	   */
	  public List<TypeRoomInfo> getTypeRoomInfoList(String hotelName);
	  
	  /**
	   * 
	   * @param hotelID
	   * @return
	   */
	  public HotelFacilityPO getHotelFacilityPO(String hotelID);
	  
	  /**
	   * 
	   * @param hotelAddressPO
	   * @return
	   */
	  public ResultMessage_Hotel addHotelAddressPO(HotelAddressPO  hotelAddressPO);
	  
	  /**
	   * 
	   * @param hotelAddressPO
	   * @return
	   */
	  public ResultMessage_Hotel modifyHotelAddressPO(HotelAddressPO  hotelAddressPO);
	  
	  /**
	   * 
	   * @param hotelBasePO
	   * @return
	   */
	  public ResultMessage_Hotel addHotelBasePO(HotelBasePO  hotelBasePO);
	  
	  /**
	   * 
	   * @param hotelBasePO
	   * @return
	   */
	  public ResultMessage_Hotel modifyHotelBasePO(HotelBasePO  hotelBasePO);
	  
	 /**
	  * 
	  * @param hotelFacilityPO
	  * @return
	  */
	  public ResultMessage_Hotel addHotelFacilityPO(HotelFacilityPO hotelFacilityPO);
	  
	  /**
	   * 
	   * @param hotelFacilityPO
	   * @return
	   */
	  public ResultMessage_Hotel modifyHotelFacilityPO(HotelFacilityPO hotelFacilityPO);
	  
	  /**
	   * 
	   * @param typeRoomInfo
	   * @return
	   */
	  public ResultMessage_Hotel addTypeRoomInfo(TypeRoomInfo typeRoomInfo);
	  
	  /**
	   * 
	   * @param typeRoomInfo
	   * @return
	   */
	  public ResultMessage_Hotel modifyTypeRoomInfo(TypeRoomInfo typeRoomInfo);
	  
	  /**
	   * 
	   * @param hotelRoomInfo
	   * @return
	   */
	  public ResultMessage_Hotel  modifyHotelRoomInfo(HotelRoomInfo hotelRoomInfo);
	  
	  /**
	   * 
	   * @param hotelID
	   * @return
	   */
	  public HotelRoomInfo getHotelRoomInfo(String hotelID);
	  
	  /**
	   * 
	   * @param hotelAddress
	   * @return
	   */
	  public List<String> getHotelIDListByAddress(HotelAddress hotelAddress);
	  	  
	  public boolean isvalidBase(String hotelID, Star star ,String regex);
	  
	  
	  /**
	   * 
	   * @param hotelID
	   * @param roomType
	   * @return
	   */
	  public boolean isvalidRoomType(String hotelID, RoomType roomType);
	  
	  
	  /**
	   * 
	   * @param hotelID
	   * @param roomType
	   * @param low
	   * @param high
	   * @return
	   */
	  public boolean isvalidRoomType(String hotelID,RoomType roomType, double low , double high);
	  
	  
	  
	  /**
	   * 
	   * @param regex
	   * @return
	   */
	  public List<String> getIDListByFuzzy(String regex);
	  	 
	  /**
	   * 
	   * @param hotelID
	   * @return
	   */
	  public List<OrderAssessPO> gethotelAssessVO(String hotelID);
	  
	  /**
	   * 
	   * @param customerID
	   * @param hotelID
	   * @return
	   */
	  public  boolean isbooked(String customerID , String hotelID);
	  
	  
	  /**
	   * 
	   * @param hotelID
	   * @param hotelName
	   * @return
	   */
	  public ResultMessage_Hotel modifyHotelName(String hotelID , String hotelName);
	  
	  

	  
	  
}
