package runner;

import java.awt.Window.Type;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;

import businesslogic.member.Member;
import businesslogicservice.AccountCustomerService;
import businesslogicservice.AccountHotelService;
import businesslogicservice.AccountWebService;
import businesslogicservice.LoginService;
import dataservice.AccountDataService;
import dataservice.CustomerDataService;
import po.AccountPO;
import po.CustomerPO;
import po.MemberPO;
import rmi.RemoteHelper;
import serviceFactory.LoginServiceUtil;
import tools.AccountType;
import tools.MemberBelongType;
import tools.MemberType;

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
	
	
	public void test() throws RemoteException{
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
//		MemberType memberType = new MemberType("CS001");
//		memberType.setCompanyName("开心大酒店");
//		memberType.setType(MemberBelongType.Enterprise);
//		MemberPO memberPO = new MemberPO("CS001", memberType);
//		//memberType.setType();
//		
//		CustomerPO customerPO = new CustomerPO("CS001", "朱俊逸", "男", "1323383438", memberPO, 1000);
//		System.out.println(customerDataService.add(customerPO));
		MemberType memberType = new MemberType("CS002");
		memberType.setBirthday(new Date(1996-1900, 11, 25));
		memberType.setType(MemberBelongType.Ordinary);
		MemberPO memberPO = new MemberPO("CS002", memberType);
		//memberType.setType();
		
		CustomerPO customerPO = new CustomerPO("CS002", "王帅惟", "男", "1505052205", memberPO, -20);
		System.out.println(customerDataService.add(customerPO));
		
	}
	
	public static void main(String[] args) throws RemoteException{
		ClientRunner cr = new ClientRunner();
		cr.test();
	}
}
