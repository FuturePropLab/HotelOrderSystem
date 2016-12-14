package businesslogic.customer;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import businesslogic.account.CustomerAccountController;
import businesslogicservice.AccountCustomerService;
import dataservice.CustomerDataService;
import po.CustomerPO;
import po.MemberPO;
import stub.CustomerData_Stub;
import stub.CustomerDeal_Stub;
import stub.CustomerSignup_Stub;
import tools.MemberBelongType;
import tools.MemberType;
import tools.ResultMessage;
import tools.ResultMessage_Account;
import tools.ResultMessage_Modify;
import tools.ResultMessage_signUp;
import vo.CustomerInputVO;
import vo.CustomerSearchVO;
import vo.CustomerVO;
import vo.MemberVO;

public class Customer {
	
	private  CustomerDataService customerdata;
	private  CustomerDeal_Stub customerStub;
	
	public Customer(){
		this.customerdata = rmi.RemoteHelper.getInstance().getCustomerDataService();
	//	this.customerdata = new CustomerData_Stub();
	}
	/**
	 * chenyuyan 测试用构造方法
	 */
	public Customer(CustomerData_Stub stub){
		this.customerdata = stub;
	}
	/**
	 * 
	 * @param customerInput
	 * @return 添加客户
	 */
	 
	public ResultMessage_signUp addCustomer(CustomerInputVO customerInput) throws RemoteException{
//		CustomerSignup_Stub test=new CustomerSignup_Stub();
		
	
		
		ResultMessage_signUp re=ResultMessage_signUp.Success;
		//输入数据是否合法,
//		for(int i=0;i<customerInput.telephone.length();i++){
//			if(customerInput.telephone.charAt(i)>'9'||customerInput.telephone.charAt(i)<'0'){
//				re=ResultMessage_signUp.Wrong;
//			}
//		}
		if(re==ResultMessage_signUp.Success){
			 //Account customer = new Account();
			 AccountCustomerService account=CustomerAccountController.getInstance();
			 ResultMessage_Account result = account.addAccount(customerInput.username, customerInput.password);//密码，username，
			 if(result==ResultMessage_Account.Success){
			 String id = account.getAccountID(customerInput.username);
			 
			 MemberType memberType = new MemberType(id);
			 memberType.setType(MemberBelongType.None);
			 MemberPO memberpo=new MemberPO(id, memberType);
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
	 * @throws RemoteException 
	 */
	public CustomerVO getCustomerInfo(String customer_id) throws RemoteException{
		//CustomerDeal_Stub test=new CustomerDeal_Stub();
		//MockMember test2=new MockMember();
		//test2.customer_ID_test=customer_id;
//		customerdata = new CustomerData_Stub();//test
		CustomerPO cus = customerdata.find(customer_id);
	//	customerStub = new CustomerDeal_Stub();
		
		
//		CustomerVO cus = customerStub.getCustomerInfo(customer_id);
		if(cus==null) return null;
		CustomerVO cusVO = new CustomerVO(cus);
		
//        MemberVO memberInfo = new MemberVO(cus.getMemberpo().getCustomer_ID(),cus.getMemberpo().getMemberType());
//		return new CustomerVO(cus.getCustomerID(),cus.getCustomerName(),cus.getGender(),cus.getTelephone(),memberInfo,cus.getCredit());
		//return test.getCustomerInfo(customer_id);
		return cusVO;
	}
	/**
	 * 修改客户信息
	 * @param customerInfo
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMessage_Modify changeCustomerInfo(CustomerVO customerInfo) throws RemoteException{
//		CustomerDeal_Stub test=new CustomerDeal_Stub();
		//MemberVO membervo = customerInfo.membervo;
		//MemberPO memberpo = new MemberPO(membervo.customer_ID,membervo.memberType);	
		CustomerPO newcustomerInfo = new CustomerPO(customerInfo.customerID,customerInfo.customerName,customerInfo.gender,customerInfo.telephone,null,customerInfo.credit);
		
		
		return  customerdata.modify(newcustomerInfo);
		
	}
	
	
	
	/**
	 * @author wshwbluebird
	 * 搜索客户
	 * 如果搜索信息包括id 则 精确查找
	 * 如果搜索信息 不包括  则 模糊查找 
	 * @param customerSearchVO
	 * @return 符合条件的客户列表
	 * @throws RemoteException 
	 */
	public List<CustomerVO> searchCustomer(CustomerSearchVO customerSearchVO) throws RemoteException{
//		CustomerDeal_Stub test=new CustomerDeal_Stub();
		customerdata = new CustomerData_Stub();
		List <CustomerPO> customerPOlist = customerdata.searchCustomer();
		
		//show howmuch 
		System.out.println("in Customer.sesearchCustomer output: "+customerPOlist.size());
		
		List<CustomerVO> customerVOList = new ArrayList<CustomerVO>();
		
		
		//如果是根据 id查找 则进行精确查找
		if(customerSearchVO.userID!=null){
			String id = customerSearchVO.userID;
			Iterator<CustomerPO> it = customerPOlist.iterator();
			while(it.hasNext()){
				CustomerPO customerPO = it.next();
				if(customerPO.getCustomerID().equals(id)){
					//List<CustomerVO> customerVOList = new ArrayList<CustomerVO>();
					CustomerVO customerVO = new CustomerVO(customerPO);
					customerVOList.add(customerVO);
					return customerVOList;
				}				
			}
			return customerVOList;
		}
		
		Iterator<CustomerPO> it = customerPOlist.iterator();
		FuzzyCheck fuzzyCheck = new FuzzyCheck(customerSearchVO);
		
		//PO to VOs if available
		while(it.hasNext()){
			CustomerPO customerPO = it.next();
			if(fuzzyCheck.isPattern(customerPO)){
				CustomerVO customerVO = new CustomerVO(customerPO);
				customerVOList.add(customerVO);
			}			
		}
		return customerVOList;
	}
	/**
	 * @author chenyuyan
	 * 为了修改信用
	 * @param customerInfo
	 * @return
	 */
	public ResultMessage changeCustomerInfoAboutCredit(CustomerVO customerInfo) {
		// TODO Auto-generated method stub
		CustomerPO customerPO = new CustomerPO(customerInfo);
		customerPO.setMembervo(null);
		try {
			ResultMessage_Modify rm = customerdata.modify(customerPO);
			if(rm==ResultMessage_Modify.Success)  return ResultMessage.Exist;
			else return ResultMessage.NotExist;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.NotExist;
		}
	}

}