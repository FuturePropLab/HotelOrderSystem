package businesslogic.credit;

import tools.ResultMessage;
import vo.CustomerVO;
import vo.MemberVO;


/**
 *  代替customer类的桩代码
 * @author wshwbluebird
 *
 */
public class MockCustomer implements CustomerInfoforCredit{
	
	ResultMessage rm;
	CustomerVO customerVO;
	public CustomerVO getCustomerInfo(String customer_id) {
		customerVO = new CustomerVO("001", "xx",
		       "nan", "123",null,50);
		return customerVO;
	}

	public ResultMessage changeCustomerInfo(CustomerVO customerInfo) {
		return rm;
	}
	
	public MockCustomer(ResultMessage rm,CustomerVO customerVO){
		this.rm = rm;
		this.customerVO = customerVO;
	}
	public MockCustomer(){
		
	}
	
	
}
