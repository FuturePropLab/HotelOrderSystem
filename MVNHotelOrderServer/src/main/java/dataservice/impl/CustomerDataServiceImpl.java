package dataservice.impl;

import java.util.List;

import dataservice.CustomerDataService;
import dataservice.datahelper.CustomerDataHelper;
import po.CustomerPO;
import tools.ResultMessage_Modify;
import tools.ResultMessage_signUp;

/**
 * 
 * @author wshwbluebird
 *
 */
public class CustomerDataServiceImpl implements CustomerDataService {
	
	
	private CustomerDataHelper customerDataHelper;
	
	public CustomerDataServiceImpl(){
		this.customerDataHelper =  DataFactory.DataHelperUtils.getCustomerDataHelper();
	}
	public ResultMessage_signUp add(CustomerPO customerInfo) {
		return customerDataHelper.add(customerInfo);
	}

	public CustomerPO find(String customer_id) {
		return customerDataHelper.find(customer_id);
	}

	public ResultMessage_Modify modify(CustomerPO customerInfo) {
		if(customerInfo.getMemberpo()!=null)  return ResultMessage_Modify.Failure;
		return customerDataHelper.modify(customerInfo);
	}

	public List<CustomerPO> searchCustomer() {
		return customerDataHelper.searchCustomer();
	}

}
