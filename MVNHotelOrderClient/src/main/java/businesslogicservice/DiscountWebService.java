package businesslogicservice;

import java.rmi.RemoteException;
import java.util.List;

import tools.ResultMessage_Discount;
import tools.ResultMessage_DiscountDetail;
import tools.Strategy_webType;
import vo.DiscountVO_web;
/**
 * 
 * @author LWY
 *
 */
public interface DiscountWebService {

	public ResultMessage_DiscountDetail addWebDiscount (DiscountVO_web dis) throws RemoteException;
	
	public ResultMessage_Discount editWebDiscount (DiscountVO_web dis) throws RemoteException;
	/**
	 * 得到網站的所有促銷策略
	 * @return
	 * @throws RemoteException 
	 */
	public List<DiscountVO_web> getWebDiscount () throws RemoteException;
	/**
	 * 
	 * @param type
	 * @return 根據類型得到網站促銷策略
	 */
	public List<DiscountVO_web> getWebDiscount(Strategy_webType type) ;
	
	public ResultMessage_Discount deleteDiscount (String discountID) throws RemoteException;
	
	/**
	 * 
	 * @param discount_id
	 * @return 将策略设置为无效
	 * @throws RemoteException 
	 */
	public ResultMessage_Discount invalidDiscount(String discount_id) throws RemoteException;
	
}
