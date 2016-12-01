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
	 * @param resultCredit
	 * @return
	 */
	public ResultMessage changeCredit(String customer_id,int resultCredit);
}
