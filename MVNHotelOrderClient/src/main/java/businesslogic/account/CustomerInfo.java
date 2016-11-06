package businesslogic.account;

import java.util.List;

import vo.CustomerSearchVO;
import vo.CustomerVO;
/**
 * 客户调用的接口
 * @author wshwbluebird
 *
 */
public interface CustomerInfo {
		/**
		 * 同层调用客户模块的搜索客户的方法
		 * @param customerSearchVO
		 * @return List<CustomerVO>
		 */
		public List<CustomerVO> searchCustomer(CustomerSearchVO customerSearchVO);
		
		/**
		 * 同层调用客户模块的获取客户基本信息的方法
		 * @param customer_id
		 * @return CustomerVO
		 */
		public CustomerVO getCustomerDetail(String customer_id);
}
