package runner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataservice.AccountDataService;
import dataservice.LoginCheckService;
import po.AccountPO;
import rmi.RemoteHelper;
import tools.AccountType;

public class ClientRunner {
	private RemoteHelper remoteHelper;
	
	public ClientRunner() {
		linkToServer();
		

	}
	
	private void linkToServer(){
		try {
			File file = new File("TxtData/port.txt");
			InputStreamReader reader = new InputStreamReader(new FileInputStream(
					file), "UTF-8");
			BufferedReader br = new BufferedReader(reader);
			String str = br.readLine();
			String port = str.trim();
			br.close();
			reader.close();
			System.out.println(port);
			remoteHelper = RemoteHelper.getInstance();
			System.out.println("ready to link");
			remoteHelper.setRemote(Naming.lookup("rmi://"+port+":8888/DataRemoteObject"));
			System.out.println("linked");

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void test() throws RemoteException{	
		
		
		//HotelDealService hotelDealService = HotelDealController.getInstance();
		//System.out.println(hotelDealService.getHotelDetailsVO("HT2016122011121686").star);
		
		AccountDataService accountDataService = remoteHelper.getInstance().getAccountDataService();
		//System.out.println(accountDataService);
		//System.out.println(accountDataService.addAccount(new AccountPO("AD001", "admin","admin", AccountType.Administor)));
		//LoginCheckService loginCheckService = RemoteHelper.getInstance().getLoginCheckService();
		System.out.print(accountDataService.deleteAccount("HT001"));
		
//		MessgeDataService messgeDataService = RemoteHelper.getInstance().getMessgeDataService();
//		System.out.println(messgeDataService.writeMessage("HT001", "您的订单已经变为异常请注意", null));
//		System.out.println(messgeDataService.getMessage("HT001").getMessage());
//		System.out.println(messgeDataService.getMessage("HT001"));
		
//		
//	   OrderController orderController  =OrderController.getInstance();
//	   FuzzySearchOrderVO fuzzySearchOrderVO = 
//			   new FuzzySearchOrderVO(null, null, null, null, true, true, true, true);
//	   System.out.println(orderController.CheckOrderList(fuzzySearchOrderVO).size());
		
//		OrderDataService orderDataService = RemoteHelper.getInstance().getOrderDataService();
//		OrderPO orderPO =   orderDataService.findOrder("4C4S0240117691721521024486");
//		System.out.println(orderPO==null);
//		CreditDataService creditDataService = RemoteHelper.getInstance().getCreditDataService();
//		CreditLogPO creditLogPO =new CreditLogPO
//				("CS001", ActionType.Charge, null, new Date(), 400, 100);
//		System.out.println(creditDataService.add(creditLogPO));	
//		List<CreditLogPO> lsit = creditDataService.getLogList("CS001");
//		lsit.forEach(t->System.out.println(t.getActionType()+"   "+t.getMoney()));
		
		//System.out.println(creditDataService.changeCredit("CS001", 500));
//		
//		
//		MemberDataService memberDataService  =RemoteHelper.getInstance().getMemberDataService();
//		MemberPO memberPO  =memberDataService.getMember("CS001");
//		System.out.println(memberPO.getMemberType().getCompanyName());
		 
	}
	
	public static void main(String[] args) throws RemoteException{
		ClientRunner cr = new ClientRunner();
		cr.test();
	}
}
