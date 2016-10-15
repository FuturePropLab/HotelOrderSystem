package dataservice.Account;

import java.util.List;

public interface Customer {
	public ResultMessage modifyCustomer(CustomerAccountPO);

	public CustomerAccountPO getCustomer(String customer_id);

	public List<CustoemerAccountPO> searchCustomerList(SearchCondition searchCondition);

}
