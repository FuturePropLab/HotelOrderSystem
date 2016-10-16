package dataservice.Account;

import java.util.List;
import po.CustomerAccountPO;
import po.SearchCondition;
import stub.ResultMessage;

public interface Customer {
	public ResultMessage modifyCustomer(CustomerAccountPO CusPO);

	public CustomerAccountPO getCustomer(String customer_id);

	public List<CustomerAccountPO> searchCustomerList(SearchCondition searchCondition);

}
