package runner;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import businesslogicservice.AccountCustomerService;
import businesslogicservice.AccountHotelService;
import businesslogicservice.AccountWebService;
import businesslogicservice.LoginService;
import dataservice.AccountDataService;
import po.AccountPO;
import rmi.RemoteHelper;
import serviceFactory.LoginServiceUtil;
import tools.AccountType;

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
		
	}
	
	public static void main(String[] args) throws RemoteException{
		ClientRunner cr = new ClientRunner();
		cr.test();
	}
}
