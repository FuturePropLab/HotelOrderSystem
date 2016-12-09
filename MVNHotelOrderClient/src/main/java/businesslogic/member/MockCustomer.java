package businesslogic.member;

import java.rmi.RemoteException;

import businesslogic.customer.Customer;
import po.CustomerPO;
import stub.CustomerDeal_Stub;
import vo.CustomerVO;

public class MockCustomer extends Customer{
	public CustomerVO getCustomerInfo(String customer_id) throws RemoteException{
//		CustomerDeal_Stub test=new CustomerDeal_Stub();
		//MockMember test2=new MockMember();
		//test2.customer_ID_test=customer_id;
//		CustomerPO cus = customerdata.find(customer_id);
		CustomerDeal_Stub customerStub = new CustomerDeal_Stub();
		
		
		CustomerVO cus = customerStub.getCustomerInfo(customer_id);
//		CustomerVO cusVO = new CustomerVO(cus);
		
//        MemberVO memberInfo = new MemberVO(cus.getMemberpo().getCustomer_ID(),cus.getMemberpo().getMemberType());
//		return new CustomerVO(cus.getCustomerID(),cus.getCustomerName(),cus.getGender(),cus.getTelephone(),memberInfo,cus.getCredit());
		//return test.getCustomerInfo(customer_id);
		return cus;
	}
}
