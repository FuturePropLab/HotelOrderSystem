package dataservice.datahelper;

import java.util.List;

public interface AddressDataHelper {
		
	/**
	 * 根据城市名称 返回 它拥有的区
	 * @param city
	 * @return  区List<String>
	 */
	public List<String> getDistributeList(String city);
	
	/**
	 * 根据区的名字 返回拥有的 商圈名称
	 * @param district
	 * @return 商圈List<String>
	 */
	public List<String> getBusinessCircleList(String district);
}
