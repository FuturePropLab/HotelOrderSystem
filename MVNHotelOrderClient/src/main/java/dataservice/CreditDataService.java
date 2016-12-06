package dataservice;

import java.util.List;

import po.CreditLogPO;
import tools.ResultMessage;

public interface CreditDataService {
	public ResultMessage add(CreditLogPO creditlog);
	
	public List<CreditLogPO>  getLogList(String customer_id);
	
	
	/**
	 * @author chenyuyan 12/1
	 * �޸Ŀͻ�����ֵ
	 * @param customer_id
	 * @param result
	 * @return
	 */
	public ResultMessage changeCredit(String customer_id,double result);
	public ResultMessage setLevel(int level,String customer_id);
}
