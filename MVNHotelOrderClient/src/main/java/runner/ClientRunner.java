package runner;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import businesslogic.customer.CustomerDealController;
import businesslogicservice.CustomerDealService;
import dataservice.CustomerDataService;
import rmi.RemoteHelper;
import vo.CustomerSearchVO;

public class ClientRunner {
	private RemoteHelper remoteHelper;
	
	public ClientRunner() {
		linkToServer();
		

	}
	
	private void linkToServer() {
		try {
			remoteHelper = RemoteHelper.getInstance();
			System.out.println("ready to link");
			remoteHelper.setRemote(Naming.lookup("rmi://localhost:8888/DataRemoteObject"));
			System.out.println("linked");

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public void test(){
//		AccountCustomerService accountCustomerService = serviceFactory.AccountContollerUtil.getAccountCustomerServiceUtil();
//		System.out.println(accountCustomerService.getUsername("zhujusnyi"));
//		System.out.println(accountCustomerService.addAccount("wangshuaiwei", "zhujunyi"));
//		String id ;
//		System.out.println(id = accountCustomerService.getAccountID("wangshuaiwei"));
//		System.out.println(accountCustomerService.resetPassword(id, "zhujunyi"));
//		System.out.println(accountCustomerService.deleteAccount("RMI001"));;
		
//		AccountHotelService accountHotelService = serviceFactory.AccountContollerUtil.getAccoutHotelServiceUtil();
//		System.out.println(accountHotelService.addAccount("teddybear", "teddybear"));
//		AccountWebService accountWebService  = serviceFactory.AccountContollerUtil.getAccountWebDesignerServiceUtil();
//		System.out.println(accountWebService.addAccount("manager", "manager"));
		
	
		CustomerDataService customerDataService = RemoteHelper.getInstance().getCustomerDataService();
		
		//CustomerDataService customerDataService = RemoteHelper.getInstance().getCustomerDataService();
//		MemberType memberType = new MemberType("CS001");
//		memberType.setCompanyName("开心大酒店");
//		memberType.setType(MemberBelongType.Enterprise);
//		MemberPO memberPO = new MemberPO("CS001", memberType);
//		//memberType.setType();
//		
//		CustomerPO customerPO = new CustomerPO("CS001", "朱俊逸", "男", "1323383438", memberPO, 1000);
//		System.out.println(customerDataService.add(customerPO));
//		MemberType memberType = new MemberType("CS002");
//		memberType.setBirthday(new Date(1996-1900, 11, 25));
//		memberType.setType(MemberBelongType.Ordinary);
//		MemberPO memberPO = new MemberPO("CS002", memberType);
//		//memberType.setType();
//		
//		CustomerPO customerPO = new CustomerPO("CS002", "王帅惟", "男", "1505052205", memberPO, -20);
//		System.out.println(customerDataService.add(customerPO));
		
//		List<CustomerPO> customerlist = customerDataService.searchCustomer();
//		if(customerlist==null){
//			System.out.println("null");
//		}else{
//			Iterator<CustomerPO> it = customerlist.iterator();
//			while(it.hasNext()){
//				CustomerPO customerPO = it.next();
//				System.out.println(customerPO.getCustomerID());
//				System.out.println(customerPO.getCustomerName());
//				System.out.println(customerPO.getGender());
//				System.out.println(customerPO.getCredit());
//				MemberPO memberPO = customerPO.getMemberpo();
//				System.out.println(memberPO.getMemberType().getType());
//				//customerPO.setMemberpo(memberPO);
//				System.out.println();
//			}
//		}

		
	/*	CustomerInputVO customerInputVO =new CustomerInputVO("chenyuyan", "123456", "陈语嫣", "13962753208", "女");
		String id = "CS001";
		CustomerDealService customerDealService= new CustomerDealController();
		CustomerSignupService customerSignupService = new CustomerSignupController();
		System.out.println(customerSignupService.addCustomer(customerInputVO));
		try {
			System.out.print(customerDealService.getCustomerInfo(id).customerName);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		CustomerDealService customerDealService= new CustomerDealController();
		
		CustomerSearchVO searchvo = new CustomerSearchVO(null,"CS001");
		System.out.println(customerDealService.searchCustomer(searchvo).get(0).customerName);
		
		
	}
	
	public static void main(String[] args) throws RemoteException{
		ClientRunner cr = new ClientRunner();
		cr.test();
	}
}
