package runner;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import businesslogic.login.LoginController;
import dataservice.LoginCheckService;
import rmi.RemoteHelper;
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
			remoteHelper.setRemote(Naming.lookup("rmi://114.212.43.162:8888/DataRemoteObject"));
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
//		LoginController loginController = new LoginController();
//		System.out.println("ans:  "+loginController.login("zhujunyi", "zhujunyi",AccountType.Customer));
	}
	
	public static void main(String[] args) throws RemoteException{
		ClientRunner cr = new ClientRunner();
		cr.test();
	}
}
