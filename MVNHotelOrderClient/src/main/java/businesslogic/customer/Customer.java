package businesslogic.customer;

import java.util.List;

import po.CustomerPO;
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
	 * @return 添加客户
	 */
	public ResultMessage2 addCustomer(CustomerInputVO customerInput){
		CustomerSignup_Stub test=new CustomerSignup_Stub();
		ResultMessage2 re=ResultMessage2.success;
		for(int i=0;i<customerInput.telephone.length();i++){
			if(customerInput.telephone.charAt(i)>'9'&&customerInput.telephone.charAt(i)<'0'){
				re=ResultMessage2.fail;
			}
		}
		if(re==ResultMessage2.success){
		
		
		}
		
		
		
		
		return test.addCustomer(customerInput);
		
	}
	/**
	 * 获得客户信息
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
	public ResultMessage2 changeCustomerInfo(CustomerVO customerInfo){
		CustomerDeal_Stub test=new CustomerDeal_Stub();
		
		return  test.changeCustomerInfo(customerInfo);
		
	}
	/**
	 * 搜索客户
	 * @param customerSearchVO
	 * @return 符合条件的客户列表
	 */
	public List<CustomerVO> searchCustomer(CustomerSearchVO customerSearchVO){
		CustomerDeal_Stub test=new CustomerDeal_Stub();
		
		return  test.searchCustomer(customerSearchVO);
	}
}
