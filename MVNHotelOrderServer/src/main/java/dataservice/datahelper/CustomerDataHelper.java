package dataservice.datahelper;

import java.util.List;

import po.CustomerPO;
import tools.ResultMessage_Modify;
import tools.ResultMessage_signUp;

/**
 * 
 * @author wshwbluebird
 *
 */
public interface CustomerDataHelper {
	
	/**
	 * 注册是否成功
	 * @param customerInfo
	 * @return ResultMessage_signUp 
	 */
	public ResultMessage_signUp add(CustomerPO customerInfo);
	
	/**
	 * 通过客户id 获取customerPO
	 * @param customer_id
	 * @return CustomerPO
	 */
	public CustomerPO find(String customer_id);

	/**
	 * 传过来的CustomerPO 修改已经存在的CustomerPO
	 * @param customerInfo
	 * @return
	 */
	public ResultMessage_Modify modify(CustomerPO customerInfo);
	
	
	/**
	 * 所有的客户存储信息
	 * @return List<CustomerPO>
	 */
	public List<CustomerPO> searchCustomer();

}
