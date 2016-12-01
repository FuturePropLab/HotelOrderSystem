package runner;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.List;

import dataservice.HotelDataService;
import po.HotelPO;
import rmi.RemoteHelper;
import tools.HotelAddress;
import tools.HotelRoomInfo;
import tools.TypeRoomInfo;

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
//		CustomerSearchVO customerSearchVO = new CustomerSearchVO(null,"李",null);
//		List<AccountVO> cAccountVOs = accountCustomerService.searchCustomerAccount(customerSearchVO);
//		Iterator<AccountVO> it = cAccountVOs.iterator();
//		while(it.hasNext()){
//			AccountVO accountVO = it.next();
//			System.out.println(accountVO.userid+"  "+accountVO.username+"  "+accountVO.accountType);
//		}
//		CustomerVO customerVO = accountCustomerService.getCustomerDetail("CS002");
//		System.out.println(customerVO.customerName+" "+customerVO.telephone);
		
		HotelDataService hotelDataService  =RemoteHelper.getInstance().getHotelDataService();
		HotelPO hotelPO = hotelDataService.getHotel("HT001");
		System.out.println(hotelPO.getHotelName());//sdf
		System.out.println(hotelPO.getStar());
		
		HotelAddress hotelAddress =  hotelPO.getHotelAddress();
		System.out.println(hotelAddress.toString());
		
		HotelRoomInfo hotelRoomInfo = hotelPO.getHotelRoom();
		List<TypeRoomInfo> list = hotelRoomInfo.getTypeRoomInfo();
		Iterator<TypeRoomInfo> it = list.iterator();
		while(it.hasNext()){
			TypeRoomInfo typeRoomInfo  = it.next();
			System.out.println(typeRoomInfo.getRoomtype() + "  "+ typeRoomInfo.getPrice());
		}
		
		
	}
	
	public static void main(String[] args) throws RemoteException{
		ClientRunner cr = new ClientRunner();
		cr.test();
	}
}
