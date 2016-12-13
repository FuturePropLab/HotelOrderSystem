package businesslogic.customer;

import java.rmi.RemoteException;
import java.util.List;

import businesslogicservice.CustomerDealService;
import tools.ResultMessage_Modify;
import vo.CustomerSearchVO;
import vo.CustomerVO;

public class CustomerDealController implements CustomerDealService {

	private Customer customer;
	private static CustomerDealController dealController;
	private CustomerDealController (){
		customer = new Customer();
	
	}
	
	public static CustomerDealController getInstance(){
		if(dealController==null) dealController=new CustomerDealController();
		return dealController;
	}
	
	
	
	
	public CustomerVO getCustomerInfo(String customer_id) throws RemoteException{
		// TODO Auto-generated method stub
		//Customer cus=new Customer();
		
		return customer.getCustomerInfo(customer_id);
	}

	public ResultMessage_Modify changeCustomerInfo(CustomerVO customerInfo){
		// TODO Auto-generated method stub
		//Customer cus=new Customer();
		try {
			return customer.changeCustomerInfo(customerInfo);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage_Modify.Failure;
		}
	}
	public List<CustomerVO> searchCustomer(CustomerSearchVO customerSearchVO){
		//Customer cus=new Customer();
		try {
			return customer.searchCustomer(customerSearchVO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
