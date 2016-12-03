package stub;

import java.util.ArrayList;
import java.util.List;

import dataservice.CustomerDataService;
import po.CustomerPO;
import po.MemberPO;
import tools.MemberBelongType;
import tools.MemberType;
import tools.ResultMessage;
import tools.ResultMessage_Modify;
import tools.ResultMessage_signUp;
import vo.CustomerVO;
import vo.MemberVO;

public class CustomerData_Stub implements CustomerDataService {

	
	public ResultMessage_signUp add(CustomerPO customerInfo) {
		if(customerInfo!=null)  return ResultMessage_signUp.Success;
				return ResultMessage_signUp.Wrong;
	}

	
	public CustomerPO find(String customer_id) {
		MemberType memberType = new MemberType("123");
		MemberVO membervo = new MemberVO("123",memberType);
		MemberPO memberpo = new  MemberPO("123",memberType);
		CustomerPO customerPO = new CustomerPO(customer_id, "王帅惟", 
				"男", "15055022805", memberpo,123);
		
		return customerPO;
	}

	
	public ResultMessage_Modify modify(CustomerPO customerInfo) {
		if(customerInfo!=null)  return ResultMessage_Modify.Success;
				return ResultMessage_Modify.Failure;
	}

/**
 * 这个数据是王帅惟加的!!!!!!!
 */
	public List<CustomerPO> searchCustomer() {
		MemberType memberType = new MemberType("0000");
		memberType.setType(MemberBelongType.None);
		MemberPO memberpo  = new MemberPO("0000", memberType);
		CustomerPO customerPO1  = new CustomerPO("CS001", "王帅惟", "男", "15050522805", memberpo,34);
		CustomerPO customerPO2  = new CustomerPO("CS002", "王二惟", "男", "15210262516", memberpo,34);
		CustomerPO customerPO3  = new CustomerPO("CS003", "朱俊逸", "男", "33315334222", memberpo,34);
		CustomerPO customerPO4  = new CustomerPO("CS004", "朱俊俏", "男", "33323334222", memberpo,34);
		CustomerPO customerPO5  = new CustomerPO("CS005", "陈语嫣", "女", "15210262536", memberpo,34);
		CustomerPO customerPO6  = new CustomerPO("CS006", "陈雪飞", "女", "34340843437", memberpo,34);
		CustomerPO customerPO7  = new CustomerPO("CS001", "王四惟", "男", "15050522805", memberpo,34);
		CustomerPO customerPO8  = new CustomerPO("CS002", "王三惟", "男", "12345662516", memberpo,32);
		CustomerPO customerPO9  = new CustomerPO("CS003", "朱俊仪", "男", "33315334222", memberpo,34);
		CustomerPO customerPO10  = new CustomerPO("CS004", "朱俊毅", "男", "33323334222", memberpo,34);
		CustomerPO customerPO11  = new CustomerPO("CS005", "陈语文", "女", "15210262536", memberpo,34);
		CustomerPO customerPO12  = new CustomerPO("CS006", "陈数学", "女", "2237428622", memberpo,34);
		List<CustomerPO> list= new ArrayList();
		list.add(customerPO1);
		list.add(customerPO2);
		list.add(customerPO3);
		list.add(customerPO4);
		list.add(customerPO5);
		list.add(customerPO6);
		
		list.add(customerPO7);
		list.add(customerPO8);
		list.add(customerPO9);
		list.add(customerPO10);
		list.add(customerPO11);
		list.add(customerPO12);
		return list;
	}


public ResultMessage changeCustomerInfoAboutCredit(CustomerVO customerInfo) {
	// TODO Auto-generated method stub
	return null;
}

}
