package businesslogic.credit;

import tools.ResultMessage;
import vo.CustomerVO;

/**
 * 客户模块调用接口
 * @author wshwbluebird
 *
 */
public interface CustomerInfoforCredit {
	/**
	 * 调用客户模块 获取客户信息
	 * @param customer_id
	 * @return CustomerVO
	 */
	public CustomerVO getCustomerInfo(String customer_id);
	
	
	/**
	 * 调用客户模块修改客户信息
	 * @param customerInfo
	 * @return
	 */
	public ResultMessage changeCustomerInfo (CustomerVO customerInfo);
}
