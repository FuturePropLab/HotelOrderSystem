package runner;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

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
			AccountDataService accountDataService= RemoteHelper.getInstance().getAccountDataService();
			System.out.println(accountDataService.addAccount(
					new AccountPO("RMI001", "rmiwsw", "zhujunyi", AccountType.Customer)));
		
	}
	
	public static void main(String[] args) throws RemoteException{
		ClientRunner cr = new ClientRunner();
		cr.test();
	}
}
