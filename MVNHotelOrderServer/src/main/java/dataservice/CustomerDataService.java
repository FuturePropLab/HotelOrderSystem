package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.CustomerPO;
import tools.ResultMessage_Modify;
import tools.ResultMessage_signUp;

public interface CustomerDataService extends Remote {
	
	/**
	 * 新增客户 及其默认的客户会员信息
	 * @param customerInfo
	 * @return ResultMessage_signUp
	 * @throws RemoteException
	 */
	public ResultMessage_signUp add(CustomerPO customerInfo)throws RemoteException;
	
	/**
	 * 根据客户的id 返回客户的全部信息，不包括账户信息，但是包括会员信息
	 * @param customer_id
	 * @return CustomerPO
	 * @throws RemoteException
	 */
	public CustomerPO find(String customer_id)throws RemoteException;
	
	/**
	 * 
	 * @param customerInfo
	 * @return ResultMessage_Modify
	 * @throws RemoteException
	 */
	public ResultMessage_Modify  modify (CustomerPO customerInfo)throws RemoteException;
	
	/**
	 * @author chenyuyan 11/22
	 * 返回所有客户
	 */
	public List<CustomerPO> searchCustomer()throws RemoteException;
	
	
	
	
}
