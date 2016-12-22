package businesslogic.discount;

import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import po.DiscountPO_web;
import rmi.RemoteHelper;
import stub.DiscountWebData_stub;
import tools.ResultMessage_Discount;
import tools.ResultMessage_DiscountDetail;
import vo.DiscountVO_web;
/**
 * 
 * @author LWY
 * 网站营销人员制作网站策略，增删改查
 */
public class WebDiscount {

	private dataservice.DiscountWebDataService dataService;
	
	public WebDiscount(){
//		this.dataService=RemoteHelper.getInstance().getDiscountWebDAteService();
		this.dataService = new DiscountWebData_stub();//test!!
	}

	private FactoryDiscount factory= new FactoryDiscount();
	
	public ResultMessage_DiscountDetail addWebDiscount(DiscountVO_web dis) throws RemoteException {
		
		return dataService.addWebDiscount(factory.conversion(dis));
	}

	public ResultMessage_Discount editWebDiscount(DiscountVO_web dis) throws RemoteException {
		
		return dataService.editWebDiscount(factory.conversion(dis));
	}

	 public ResultMessage_Discount deleteDiscount(String  discountID) throws RemoteException {
		 
		return dataService.deleteWebDiscount(discountID);
	 }

	public List<DiscountVO_web> getWebDiscount() throws RemoteException {
		
		List<DiscountVO_web> res = new LinkedList<DiscountVO_web>();
		List<DiscountPO_web> list = dataService.getWebDiscount();
		
		Iterator<DiscountPO_web> iterator = list.iterator();
		while(iterator.hasNext()){
			res.add(factory.converToVO(iterator.next()));
		}
		
		return res;
	}
	
	/**
	 * 
	 * @param discount_id
	 * @return 将策略设置为无效
	 * @throws RemoteException 
	 */
	public ResultMessage_Discount invalidDiscount(String discountID) throws RemoteException{
		return dataService.invalidDiscount(discountID);
	}
}
