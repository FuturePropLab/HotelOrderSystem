package businesslogicservice;

import java.rmi.RemoteException;
import java.util.List;

import tools.ResultMessage;
import tools.ResultMessage2;
import tools.ResultMessage_Modify;
import vo.CustomerSearchVO;
import vo.CustomerVO;

public interface CustomerDealService {
	
	
	public CustomerVO getCustomerInfo(String customer_id) throws RemoteException, Exception;
	
	public ResultMessage_Modify changeCustomerInfo (CustomerVO customerInfo) throws RemoteException, Exception;
	public List<CustomerVO> searchCustomer(CustomerSearchVO customerSearchVO);
}
