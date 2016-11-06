package businesslogic.account;

import java.util.List;

import businesslogic.customer.Customer;
import vo.CustomerSearchVO;
import vo.CustomerVO;

 /**
  * MockCustomer 模拟实现同层调用接口
  * @author wshwbluebird
  *
  */
public class MockCustomer extends Customer implements CustomerInfo{
	private List<CustomerVO> customerList;
	private CustomerVO customerVO;
	
	/**
	 * 实现接口
	 */
	public List<CustomerVO> searchCustomer(CustomerSearchVO customerSearchVO) {
		return customerList;
	}
	/**
	 * 初始化
	 */
	public MockCustomer( List<CustomerVO> customerList,CustomerVO customerVO){
		this.customerList = customerList;
		this.customerVO = customerVO;
	}
	public CustomerVO getCustomerDetail(String customer_id) {
		return customerVO;
	}

}
