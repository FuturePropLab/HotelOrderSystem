package dataservice.datahelper;

import java.util.List;

import po.CreditLogPO;
import tools.ResultMessage;

public interface CreditLogdataHelper {
	
		public ResultMessage addCreditLog(CreditLogPO creditLogPO);
		
		public ResultMessage modifyCreditLog(CreditLogPO creditLogPO);
		
		public List<CreditLogPO> getCreditLogPOList(String customerID);
		
		public ResultMessage changeCredit(String customer_id, int result);
}
