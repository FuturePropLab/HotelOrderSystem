package businesslogic.account;

import tools.ResultMessage;
import vo.HotelInputVO;

/**
 * MockHotel 模拟实现同层调用接口
 * @author wshwbluebird
 *
 */
public class MockHotel implements HotelInfo {

	public ResultMessage addHotel(HotelInputVO vo) {
		if(vo!=null)  
			return ResultMessage.Exist;
		return ResultMessage.NotExist;

	}

}
