package businesslogic.customer;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import businesslogic.account.CustomerInfo;
import vo.CustomerSearchVO;
import vo.CustomerVO;import vo.SearchHotelVO;

/**
 * 实现账户类的方法
 * @author wshwbluebird
 *
 */
public class CustomerInfoImp implements CustomerInfo{
	
	Customer customer;
	private static CustomerInfoImp customerInfoImp = null;
	private CustomerInfoImp(){
		 this.customer = new Customer();
	}
	
	public static CustomerInfoImp getInstance(){
		if(customerInfoImp == null)
			customerInfoImp = new CustomerInfoImp();
		return customerInfoImp;		
	}
	
	/*@
	 * (non-Javadoc)
	 * @see businesslogic.account.CustomerInfo#searchCustomer(vo.CustomerSearchVO)
	 */
	public List<String> searchCustomer(CustomerSearchVO customerSearchVO) throws RemoteException {
		List<CustomerVO> VOlist = customer.searchCustomer(customerSearchVO);
		List<String> idList = new ArrayList<String>();
		Iterator<CustomerVO> it = VOlist.iterator();
		while(it.hasNext()){
			CustomerVO customerVO = it.next();
			idList.add(customerVO.customerID);
		}		
		return idList;
	}
	
	/*@
	 * (non-Javadoc)
	 * @see businesslogic.account.CustomerInfo#getCustomerDetail(java.lang.String)
	 */
	public CustomerVO getCustomerDetail(String customer_id) throws RemoteException {
		return customer.getCustomerInfo(customer_id);
	}

	public static void main(String[] args) throws RemoteException {
	     CustomerInfo customerInfo = new  CustomerInfoImp();
	     List<String> list = customerInfo.searchCustomer(new CustomerSearchVO("1", null, null));
	     Iterator<String>  it = list.iterator();
	     while(it.hasNext()){
	    	 System.out.println(it.next());
	     }
	}
}
