package dataservice.credit;

import po.ResultMessage;

import java.util.List;

import po.CreditLogPO;

public interface CreditService {
	public ResultMessage add(CreditLogPO creditlog);
	public List<CreditLogPO> getLogList(String customer_id);
	
}
