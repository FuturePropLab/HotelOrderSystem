package dataservice;

import java.util.List;
import po.CustomerAccountPO;
import po.SearchCondition;
import tools.ResultMessage;

public interface AccountCustomerData {
	public ResultMessage modifyCustomer(CustomerAccountPO CusPO);

	public CustomerAccountPO getCustomer(String customer_id);

	public List<CustomerAccountPO> searchCustomerList(SearchCondition searchCondition);

}
