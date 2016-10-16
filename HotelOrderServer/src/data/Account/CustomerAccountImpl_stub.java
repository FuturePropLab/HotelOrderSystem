package data.Account;

import java.util.LinkedList;
import java.util.List;

import dataservice.Account.Customer;
import po.CustomerAccountPO;
import po.SearchCondition;
import tools.ResultMessage;

public class CustomerAccountImpl_stub implements Customer{

	@Override
	public ResultMessage modifyCustomer(CustomerAccountPO cusPO) {
		// TODO Auto-generated method stub
		if(cusPO!=null) return ResultMessage.Exist;
		else return ResultMessage.NotExist;
	}

	@Override
	public CustomerAccountPO getCustomer(String customer_id) {
		// TODO Auto-generated method stub
		CustomerAccountPO cuspo=new CustomerAccountPO();
		return cuspo;
	}

	@Override
	public List<CustomerAccountPO> searchCustomerList(SearchCondition searchCondition) {
		// TODO Auto-generated method stub
		List<CustomerAccountPO> list=new LinkedList();
		return list;
	}

}
