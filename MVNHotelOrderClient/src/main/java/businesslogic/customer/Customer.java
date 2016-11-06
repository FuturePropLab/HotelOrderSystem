package businesslogic.customer;

import java.util.List;

import stub.CustomerDeal_Stub;
import stub.CustomerSignup_Stub;
import tools.ResultMessage;
import tools.ResultMessage2;
import vo.CustomerInputVO;
import vo.CustomerSearchVO;
import vo.CustomerVO;

public class Customer {
	/**
	 * 
	 * @param customerInput
	 * @return 成功
	 */
	public ResultMessage2 addCustomer(CustomerInputVO customerInput){
		CustomerSignup_Stub test=new CustomerSignup_Stub();
		
		return test.addCustomer(customerInput);
		
	}
	/**
	 * 获取客户信息
	 * @param customer_id
	 * @return 客户信息
	 */
	public CustomerVO getCustomerInfo(String customer_id){
		CustomerDeal_Stub test=new CustomerDeal_Stub();
		//MockMember test2=new MockMember();
		//test2.customer_ID_test=customer_id;
		return test.getCustomerInfo(customer_id);
		
	}
	/**
	 * 修改客户信息
	 * @param customerInfo
	 * @return
	 */
	public ResultMessage changeCustomerInfo(CustomerVO customerInfo){
		CustomerDeal_Stub test=new CustomerDeal_Stub();
		
		return  test.changeCustomerInfo(customerInfo);
		
	}
	/**
	 * 搜索客户信息
	 * @param customerSearchVO
	 * @return 客户信息列表
	 */
	public List<CustomerVO> searchCustomer(CustomerSearchVO customerSearchVO){
		CustomerDeal_Stub test=new CustomerDeal_Stub();
		
		return  test.searchCustomer(customerSearchVO);
	}
}
