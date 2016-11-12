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
	 * @return �ɹ�
	 */
	public ResultMessage2 addCustomer(CustomerInputVO customerInput){
		CustomerSignup_Stub test=new CustomerSignup_Stub();
		
		return test.addCustomer(customerInput);
		
	}
	/**
	 * ��ȡ�ͻ���Ϣ
	 * @param customer_id
	 * @return �ͻ���Ϣ
	 */
	public CustomerVO getCustomerInfo(String customer_id){
		CustomerDeal_Stub test=new CustomerDeal_Stub();
		//MockMember test2=new MockMember();
		//test2.customer_ID_test=customer_id;
		return test.getCustomerInfo(customer_id);
		
	}
	/**
	 * �޸Ŀͻ���Ϣ
	 * @param customerInfo
	 * @return
	 */
	public ResultMessage2 changeCustomerInfo(CustomerVO customerInfo){
		CustomerDeal_Stub test=new CustomerDeal_Stub();
		
		return  test.changeCustomerInfo(customerInfo);
		
	}
	/**
	 * �����ͻ���Ϣ
	 * @param customerSearchVO
	 * @return �ͻ���Ϣ�б�
	 */
	public List<CustomerVO> searchCustomer(CustomerSearchVO customerSearchVO){
		CustomerDeal_Stub test=new CustomerDeal_Stub();
		
		return  test.searchCustomer(customerSearchVO);
	}
}
