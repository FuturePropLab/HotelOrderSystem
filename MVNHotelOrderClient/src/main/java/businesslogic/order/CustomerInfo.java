package businesslogic.order;

import vo.CustomerVO;

/**
 * 客户信息的接口
 * @author zjy
 *
 */
public interface CustomerInfo {
	/**
	 * 获得客户信息
	 * @return 客户信息
	 */
	public CustomerVO getCustomer();
}
