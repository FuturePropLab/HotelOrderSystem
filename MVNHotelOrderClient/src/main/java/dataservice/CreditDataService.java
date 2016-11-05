package dataservice;

import java.util.List;

import po.CreditLogPO;
import tools.ResultMessage;

public interface CreditDataService {
	public ResultMessage add(CreditLogPO creditlog);
	
	public List<CreditLogPO>  getLogList(String customer_id);
}
