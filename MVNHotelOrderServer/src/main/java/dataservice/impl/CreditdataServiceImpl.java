package dataservice.impl;

import java.rmi.RemoteException;
import java.util.List;

import DataFactory.DataHelperUtils;
import dataservice.CreditDataService;
import dataservice.datahelper.CreditLogdataHelper;
import po.CreditLogPO;
import tools.ResultMessage;

public class CreditdataServiceImpl implements CreditDataService {

	private CreditLogdataHelper creditLogdataHelper;
	
	public CreditdataServiceImpl(){
		this.creditLogdataHelper = DataHelperUtils.getCreditLogdataHelper();
	}

	public ResultMessage add(CreditLogPO creditlog) throws RemoteException {
		ResultMessage rs = creditLogdataHelper.addCreditLog(creditlog);
		if(rs==ResultMessage.NotExist){
			CreditLogPO old = creditLogdataHelper.getCreditLogPO
					(creditlog.getOrderID());
			creditlog.setChangeValue(creditlog.getChangeValue()+old.getChangeValue());
			return creditLogdataHelper.modifyCreditLog(creditlog);
		}
		return rs;
	}

	public List<CreditLogPO> getLogList(String customer_id)  throws RemoteException{
		return creditLogdataHelper.getCreditLogPOList(customer_id);
	}

	public ResultMessage changeCredit(String customer_id, int result) throws RemoteException {
		return creditLogdataHelper.changeCredit(customer_id, result);
	}
	
	

}
