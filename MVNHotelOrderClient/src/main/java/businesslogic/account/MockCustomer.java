package businesslogic.account;

import java.util.ArrayList;
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
	private List<CustomerVO> list;
	
	/**
	 * 实现接口
	 */
	public List<CustomerVO> searchCustomer(CustomerSearchVO customerSearchVO) {
		if(customerSearchVO!=null){
			CustomerVO customerVO1 = new CustomerVO("wsw", "bbd", "male", "15210262516", null);
			CustomerVO customerVO2 = new CustomerVO("wsw2", "bbd2", "male", "15210262516", null);
			list.add(customerVO1);
			list.add(customerVO2);
			return list;
		}
		return list;
	}
	/**
	 * 初始化
	 */
	public MockCustomer(){
		list = new ArrayList<CustomerVO>();
	}

}
