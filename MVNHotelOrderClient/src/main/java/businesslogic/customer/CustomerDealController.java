package businesslogic.customer;

import java.util.List;

import businesslogicservice.CustomerDealService;
import tools.ResultMessage;
import tools.ResultMessage2;
import tools.ResultMessage_Modify;
import vo.CustomerSearchVO;
import vo.CustomerVO;

public class CustomerDealController implements CustomerDealService {

	public CustomerVO getCustomerInfo(String customer_id) {
		// TODO Auto-generated method stub
		Customer cus=new Customer();
		
		return cus.getCustomerInfo(customer_id);
	}

	public ResultMessage_Modify changeCustomerInfo(CustomerVO customerInfo) {
		// TODO Auto-generated method stub
		Customer cus=new Customer();
		return cus.changeCustomerInfo(customerInfo);
	}
	public List<CustomerVO> searchCustomer(CustomerSearchVO customerSearchVO){
		Customer cus=new Customer();
		return ((CustomerDealService) cus).searchCustomer(customerSearchVO);
	}
}
