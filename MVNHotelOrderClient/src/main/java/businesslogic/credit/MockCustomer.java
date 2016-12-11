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
		if(customer_id=="001"){
		customerVO = new CustomerVO("001", "xx",
		       "nan", "123",null,50);
		return customerVO;}
		else if(customer_id=="002"){
			customerVO = new CustomerVO("002", "xx",
				       "nan", "123",null,80);
				return customerVO;
		}
		else{
			return null;
		}
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
