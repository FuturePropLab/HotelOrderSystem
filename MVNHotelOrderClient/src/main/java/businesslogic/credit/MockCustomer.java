package businesslogic.credit;

import tools.ResultMessage;
import vo.CustomerVO;


/**
 *  代替customer类的桩代码
 * @author wshwbluebird
 *
 */
public class MockCustomer implements CustomerInfoforCredit{
	
	ResultMessage rm;
	CustomerVO customerVO;
	public CustomerVO getCustomerInfo(String customer_id) {
		return customerVO;
	}

	public ResultMessage changeCustomerInfo(CustomerVO customerInfo) {
		return rm;
	}
	
	public MockCustomer(ResultMessage rm,CustomerVO customerVO){
		this.rm = rm;
		this.customerVO = customerVO;
	}
}
