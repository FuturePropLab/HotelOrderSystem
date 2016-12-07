package dataservice;

import java.util.List;

import po.CreditLogPO;
import tools.ResultMessage;

public interface CreditDataService {
	
	/**
	 * 
	 * @param creditlog
	 * @return
	 */
	public ResultMessage add(CreditLogPO creditlog);
	
	
	/**
	 * 
	 * @param customer_id
	 * @return
	 */
	public List<CreditLogPO>  getLogList(String customer_id);
	
	
	/**
	 * 修改客户信用值
	 * @author chenyuyan 12/1
	 * @param customer_id
	 * @param result
	 * @return
	 */
//	public ResultMessage changeCredit(String customer_id,int result);
//	public ResultMessage setLevel(int level,String customer_id);
}
