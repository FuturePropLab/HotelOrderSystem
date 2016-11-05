package businesslogicservice;

import java.util.List;

import tools.ResultMessage;
import vo.CustomerAccountVO;
import vo.CustomerSearchVO;

public interface AccountCustomerService {
	/**
	 * 通过客户的id 获取客户账户信息的值对象
	 * @param customer_id
	 * @return CustomerAccountVO
	 */
	public CustomerAccountVO getCustomerAccount(String customer_id);
	
	/**
	 * 通过customerAccount的值对象 修改已有的CustomerAccount数据，返回是否成功
	 * @param customerAccount
	 * @return ResultMessage
	 */
	public ResultMessage accountModify(CustomerAccountVO customerAccount);
	
	/**
	 * 通过搜索信息返回客户账户信息的列表
	 * @param SearchCondition
	 * @return List<CustomerAccountVO>
	 */
	public List<CustomerAccountVO> searchCustomerAccount(CustomerSearchVO vo);
}
