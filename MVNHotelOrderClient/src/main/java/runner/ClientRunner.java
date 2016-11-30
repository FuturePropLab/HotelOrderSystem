package runner;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.List;

import businesslogicservice.AccountCustomerService;
import rmi.RemoteHelper;
import vo.AccountVO;
import vo.CustomerSearchVO;
import vo.CustomerVO;

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
		AccountCustomerService accountCustomerService = serviceFactory.AccountContollerUtil.getAccountCustomerServiceUtil();
		CustomerSearchVO customerSearchVO = new CustomerSearchVO(null,"李",null);
		List<AccountVO> cAccountVOs = accountCustomerService.searchCustomerAccount(customerSearchVO);
		Iterator<AccountVO> it = cAccountVOs.iterator();
		while(it.hasNext()){
			AccountVO accountVO = it.next();
			System.out.println(accountVO.userid+"  "+accountVO.username+"  "+accountVO.accountType);
		}
		CustomerVO customerVO = accountCustomerService.getCustomerDetail("CS002");
		System.out.println(customerVO.customerName+" "+customerVO.telephone);
		
		
	}
	
	public static void main(String[] args) throws RemoteException{
		ClientRunner cr = new ClientRunner();
		cr.test();
	}
}
