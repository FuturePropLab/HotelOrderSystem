package businesslogic.member;

import java.rmi.RemoteException;

import businesslogic.customer.Customer;
import po.CustomerPO;
import stub.CustomerDeal_Stub;
import tools.MemberType;
import vo.CustomerVO;
import vo.MemberVO;

public class MockCustomer extends Customer{
	public CustomerVO getCustomerInfo(String customer_id) throws RemoteException{
//		CustomerDeal_Stub test=new CustomerDeal_Stub();
		//MockMember test2=new MockMember();
		//test2.customer_ID_test=customer_id;
//		CustomerPO cus = customerdata.find(customer_id);
		MemberType memberType = new MemberType(customer_id);
		MemberVO membervo = new MemberVO(customer_id,memberType);
		CustomerVO cus = new CustomerVO(customer_id,"cyy","Ů","12345",membervo,1000);
//		CustomerVO cusVO = new CustomerVO(cus);
		
//        MemberVO memberInfo = new MemberVO(cus.getMemberpo().getCustomer_ID(),cus.getMemberpo().getMemberType());
//		return new CustomerVO(cus.getCustomerID(),cus.getCustomerName(),cus.getGender(),cus.getTelephone(),memberInfo,cus.getCredit());
		//return test.getCustomerInfo(customer_id);
		return cus;
	}
}
