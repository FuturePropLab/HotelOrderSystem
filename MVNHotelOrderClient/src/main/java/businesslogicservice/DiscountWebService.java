package businesslogicservice;

import java.rmi.RemoteException;
import java.util.List;

import tools.DiscountState;
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

	public ResultMessage_DiscountDetail addWebDiscount (DiscountVO_web dis) ;
	
	public ResultMessage_Discount editWebDiscount (DiscountVO_web dis) ;
	/**
	 * 得到網站的所有促銷策略
	 * @return
	 * @throws RemoteException 
	 */
	public List<DiscountVO_web> getWebDiscount () ;
	/**
	 * 
	 * @param type
	 * @return 根據類型得到網站促銷策略
	 */
	public List<DiscountVO_web> getWebDiscount(Strategy_webType type) ;
	public List<DiscountVO_web> getWebDiscount(Strategy_webType type,DiscountState discountState) ;
	
	/**
	 * 
	 * @return 返回各个等级的最低信用值
	 *         example：返回[20,50,90]表示达到20升入2级，（默认0信用值起始为1级），信用值达到50升到3级
	 */
	public int[] getLevelCredit();
	
	public ResultMessage_Discount deleteDiscount (String discountID) ;
	
	/**
	 * 
	 * @param discount_id
	 * @return 将策略设置为无效
	 * @throws RemoteException 
	 */
	public ResultMessage_Discount invalidDiscount(String discount_id);
	
}
