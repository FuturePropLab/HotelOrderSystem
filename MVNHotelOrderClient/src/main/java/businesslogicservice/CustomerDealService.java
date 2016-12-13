package businesslogicservice;

import java.rmi.RemoteException;
import java.util.List;

import tools.ResultMessage;
import tools.ResultMessage_Discount;
import tools.ResultMessage_Modify;
import vo.CustomerSearchVO;
import vo.CustomerVO;

public interface CustomerDealService {
	
	
	
	public ResultMessage_Modify changeCustomerInfo (CustomerVO customerInfo);
	public List<CustomerVO> searchCustomer(CustomerSearchVO customerSearchVO);
}
