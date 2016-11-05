package businesslogic.account;

import java.util.List;

import vo.CustomerSearchVO;
import vo.CustomerVO;
/**
 * 同层调用的接口
 * @author wshwbluebird
 *
 */
public interface CustomerInfo {
		public List<CustomerVO>searchCustomer(CustomerSearchVO customerSearchVO);
}
