package businesslogic.customer;

import java.util.ArrayList;
import java.util.List;

import businesslogic.account.Account;
import businesslogic.account.CustomerAccountController;
import businesslogicservice.AccountCustomerService;
import dataservice.CustomerDataService;
import po.CustomerPO;
import po.MemberPO;
import stub.CustomerDeal_Stub;
import stub.CustomerSignup_Stub;
import tools.ResultMessage;
import tools.ResultMessage2;
import tools.ResultMessage_Account;
import tools.ResultMessage_Modify;
import tools.ResultMessage_signUp;
import vo.CustomerInputVO;
import vo.CustomerSearchVO;
import vo.CustomerVO;
import vo.MemberVO;

public class Customer {
	/**
	 * 
	 * @param customerInput
	 * @return 添加客户
	 */
	private  CustomerDataService customerdata; 
	public ResultMessage_signUp addCustomer(CustomerInputVO customerInput){
		CustomerSignup_Stub test=new CustomerSignup_Stub();
		ResultMessage_signUp re=ResultMessage_signUp.Success;
		//输入数据是否合法
		for(int i=0;i<customerInput.telephone.length();i++){
			if(customerInput.telephone.charAt(i)>'9'&&customerInput.telephone.charAt(i)<'0'){
				re=ResultMessage_signUp.Wrong;
			}
		}
		if(re==ResultMessage_signUp.Success){
			 //Account customer = new Account();
			 AccountCustomerService account=CustomerAccountController.getInstance();
			 ResultMessage_Account result = account.addAccount(customerInput.username, customerInput.password);//密码，username，
			 if(result==ResultMessage_Account.Success){
			 String id = account.getAccountID(customerInput.username);
			 
			
			 MemberPO memberpo=null;
			 int credit = 0;
			 
			 CustomerPO customerinfo = new CustomerPO(id,customerInput.customerName,customerInput.gender,customerInput.telephone,memberpo,credit);
			 re=customerdata.add(customerinfo);
			//CustomerPO customerinfo = new CustomerPO(customerInput.username,customerInput.password,customerInput.customerName,customerInput.telephone,customerInput.gender);
			 }
		}
		
		
		
		
		//return test.addCustomer(customerInput);
		return re;
		
	}
	/**
	 * 获得客户信息
	 * @param customer_id
	 * @return 客户信息
	 */
	public CustomerVO getCustomerInfo(String customer_id){
		//CustomerDeal_Stub test=new CustomerDeal_Stub();
		//MockMember test2=new MockMember();
		//test2.customer_ID_test=customer_id;
		CustomerPO cus = customerdata.find(customer_id);
		
        MemberVO memberInfo = new MemberVO(cus.getMemberpo().getCustomer_ID(),cus.getMemberpo().getMemberType());
		return new CustomerVO(cus.getCustomeID(),cus.getCustomerName(),cus.getGender(),cus.getTelephone(),memberInfo,cus.getCredit());
		//return test.getCustomerInfo(customer_id);
		
	}
	/**
	 * 修改客户信息
	 * @param customerInfo
	 * @return
	 */
	public ResultMessage_Modify changeCustomerInfo(CustomerVO customerInfo){
		CustomerDeal_Stub test=new CustomerDeal_Stub();
		MemberVO membervo = customerInfo.membervo;
		MemberPO memberpo = new MemberPO(membervo.customer_ID,membervo.memberType);	
		CustomerPO newcustomerInfo = new CustomerPO(customerInfo.customerID,customerInfo.customerName,customerInfo.gender,customerInfo.telephone,memberpo,customerInfo.credit);
		
		
		return  customerdata.modify(newcustomerInfo);
		
	}
	/**
	 * 搜索客户
	 * @param customerSearchVO
	 * @return 符合条件的客户列表
	 */
	public List<CustomerVO> searchCustomer(CustomerSearchVO customerSearchVO){
		CustomerDeal_Stub test=new CustomerDeal_Stub();
		List <CustomerPO> customerPO=new ArrayList<CustomerPO>();
		
		customerPO=customerdata.searchCustomer();
		
		List <CustomerVO> customerVO = new ArrayList<CustomerVO>();
		
		int flag=0;//一个标志，用来判断是否已经筛选过啦
		String id = customerSearchVO.userID;
		
		String telephone = customerSearchVO.telephone;
		
		if(id!=null){
			flag=1;
			for (int i=0;i<customerPO.size();i++){
				if(customerPO.get(i).getCustomeID()==id){
					customerVO.add(new CustomerVO(customerPO.get(i)));
					
				}
			}
		}
		if(telephone!=null){
			if(flag==0){
				for(int i=0;i<customerPO.size();i++){
					if(customerPO.get(i).getTelephone()==telephone){
						customerVO.add(new CustomerVO(customerPO.get(i)));
					}
				}
			}else{
				for(int i2=0;i2<customerVO.size();i2++){
					if(customerVO.get(i2).telephone!=telephone){
						customerVO.remove(customerVO.get(i2));
						i2--;
					}
				}
			}
		}
		
		//return  test.searchCustomer(customerSearchVO);
		return customerVO;
		
	}
}
