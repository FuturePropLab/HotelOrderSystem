package dataservice.impl;

import java.util.List;

import dataservice.CustomerDataService;
import po.CustomerPO;
import po.MemberPO;
import tools.ResultMessage_Modify;
import tools.ResultMessage_signUp;

/**
 * 
 * @author wshwbluebird
 *
 */
public class CustomerDataServiceImpl implements CustomerDataService {
	
	public ResultMessage_signUp add(CustomerPO customerInfo) {
		System.out.println(customerInfo.getCustomeID());
		System.out.println(customerInfo.getCredit());
		MemberPO memberPO = customerInfo.getMemberpo();
		if(memberPO!=null){
			System.out.println(memberPO.getCustomer_ID());
			System.out.println(memberPO.getMemberType().getCompanyName());
		}
		return null;
	}

	public CustomerPO find(String customer_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage_Modify modify(CustomerPO customerInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CustomerPO> searchCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

}
