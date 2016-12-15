package dataservice.datahelper;

import java.util.List;

import po.CreditLogPO;
import tools.ResultMessage;

public interface CreditLogdataHelper {
	
		public ResultMessage addCreditLog(CreditLogPO creditLogPO);
		
		public ResultMessage modifyCreditLog(CreditLogPO creditLogPO);
		
		public List<CreditLogPO> getCreditLogPOList(String customerID);
		
		
		/**
		 * 直接数据库的信用记录中的值改为result
		 * 
		 * @param customer_id
		 * @param result
		 * @return
		 */
		public ResultMessage changeCredit(String customer_id, int result);
}
