package businesslogicservice;

import java.util.List;

import tools.ResultMessage;
import vo.HotelAccountVO;
import vo.HotelInfoVO;
import vo.HotelInputVO;
import vo.HotelSearchVO;

public interface AccountHotelService {
	/**
	 * 根据输入新增酒店
	 * @param hotelAccount
	 * @param hotelInputVO
	 * @return ResultMessage
	 */
	public ResultMessage addHotelAccount (HotelAccountVO hotelAccount,HotelInputVO hotelInputVO);
	
	/**
	 * 根据值对象修改持久化存储信息
	 * @param hotelAccount
	 * @return ResultMessage
	 */
	public ResultMessage modifyHotelAccount (HotelAccountVO hotelAccount);
	
	/**
	 * 根据ID获取酒店账户的值对象信息
	 * @param hotel_id
	 * @return HotelAccountVO
	 */
	public HotelAccountVO getHotelAccount(String hotel_id);
	/**
	 * 根据ID删除酒店的账户信息
	 * @param hotel_id
	 * @return ResultMessage
	 */
	public ResultMessage deleteHotelAccount (String hotel_id);
	
	/**
	 * 根据搜索信息获得所有符合条件的酒店信息列表
	 * @param hotelSearchVO
	 * @return List<HotelAccountVO>
	 */
	public List<HotelAccountVO>searchHotelAccount (HotelSearchVO hotelSearchVO);
	
	/**
	 * 根据酒店的ID 查看酒店的详细信息
	 * @param hotel_id
	 * @return HotelInfoPO 
	 */
	public HotelInfoVO getHotelDetail(String hotel_id);
}
