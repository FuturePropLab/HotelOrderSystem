package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.CustomerAccount;
import po.CustomerPO;
import tools.ResultMessage;
import tools.ResultMessage_Modify;
import tools.ResultMessage_signUp;
import vo.CustomerVO;

public interface CustomerDataService extends Remote{
	
	public ResultMessage_signUp add(CustomerPO customerInfo) throws RemoteException;
	
	public CustomerPO find(String customer_id)throws RemoteException;
	
	public ResultMessage_Modify  modify (CustomerPO customerInfo)throws RemoteException;
	
	/**
	 * @author chenyuyan 11/22
	 * 返回所有客户
	 */
	public List<CustomerPO> searchCustomer()throws RemoteException;
	
	
	public ResultMessage changeCustomerInfoAboutCredit(CustomerPO customerInfo) throws RemoteException;
	
	
	public List<CustomerAccount>  getCustomerAccount() throws RemoteException;
	
}
