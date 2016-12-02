package businesslogicservice;

import java.net.URI;

import tools.ResultMessage_Hotel;
import vo.HotelbriefVO;
import vo.HotelInputVO;

/**
 * 12.1!!!!!!!!!朱俊毅可以加 !!!!
 * @author wshwbluebird
 *
 */
public interface ManageHotelInfoService {
	/**
	 * 添加酒店  酒店注册时调用这个方法 hotelInputVO的初始化必须有用户名和密码
	 * @param hotelInputVO
	 * @return ResultMessage_Hotel
	 */
	public ResultMessage_Hotel addHotel(HotelInputVO hotelInputVO);
	
	
	/**
	 * 修改酒店的信息 管理酒店 或者注册账号之后补充信息调用这个方法 hotelInputVO的初始化必须hotelID
	 * @param hotelInputVOs
	 * @return
	 */
	public ResultMessage_Hotel saveHotelInfo (HotelInputVO hotelInputVO);
	
	
	public ResultMessage_Hotel modifyHotelPicture(String hotelID,URI uri);
	
}
