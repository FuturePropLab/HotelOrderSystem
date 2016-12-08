package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.CreditLogPO;
import tools.ResultMessage;

public interface CreditDataService extends Remote{
	
	/**
	 * 
	 * @param creditlog
	 * @return
	 */
	public ResultMessage add(CreditLogPO creditlog)throws RemoteException;
	
	
	/**
	 * 
	 * @param customer_id
	 * @return
	 */
	public List<CreditLogPO>  getLogList(String customer_id)throws RemoteException;
	
	
	/**
	 * 修改客户信用值
	 * @author chenyuyan 12/1
	 * @param customer_id
	 * @param result
	 * @return
	 */
	public ResultMessage changeCredit(String customer_id,int result) throws RemoteException;


}
