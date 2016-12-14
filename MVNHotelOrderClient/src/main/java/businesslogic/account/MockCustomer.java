package businesslogic.account;

import java.util.ArrayList;
import java.util.List;

import businesslogic.customer.Customer;
import vo.CustomerSearchVO;
import vo.CustomerVO;
import vo.MemberVO;

 /**
  * MockCustomer 模拟实现同层调用接口
  * @author wshwbluebird
  *
  */
public class MockCustomer  implements CustomerInfo{
	private List<String> customerList;
	private CustomerVO customerVO;
	
	/**
	 * 实现接口
	 */
	public List<String> searchCustomer(CustomerSearchVO customerSearchVO){
		List<String> idList = new ArrayList<String>();
		idList.add("001");
		idList.add("002");
		
		return idList;
	}
	/**
	 * 初始化
	 */
	public MockCustomer( List<String> customerList,CustomerVO customerVO){
		this.customerList = customerList;
		this.customerVO = customerVO;
	}
	public MockCustomer() {
		// TODO Auto-generated constructor stub
	}
	public CustomerVO getCustomerDetail(String customer_id) {
		CustomerVO customerVO = new CustomerVO("001", "cyy",
		       "nan","12345", null,0);
		return customerVO;
	}

}
