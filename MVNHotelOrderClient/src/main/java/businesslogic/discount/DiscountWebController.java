package businesslogic.discount;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import businesslogicservice.DiscountWebService;
import tools.DiscountState;
import tools.ResultMessageDiscount;
import tools.ResultMessage_strategy;
import tools.Strategy_webType;
import vo.DiscountVO_web;
import vo.DiscountVO_web_level;

/**
 * 
 * @author LWY
 *
 */
public class DiscountWebController implements DiscountWebService {

	private WebDiscount web;

	private static DiscountWebController discountWebController;

	private List<DiscountVO_web> list;

	private DiscountVO_web_level[] discountVO_web_level = new DiscountVO_web_level[4];// 默认最高等级为LV5

	private DiscountWebController() {
		web = new WebDiscount();
	}

	/**
	 * 單件
	 * 
	 * @return
	 */
	public static DiscountWebController getInstance() {
		if (discountWebController == null)
			discountWebController = new DiscountWebController();
		return discountWebController;
	}
	
	/**
	 * 增加网站营销策略，写入数据库同时在逻辑层缓存
	 */
	public ResultMessage_strategy addWebDiscount(DiscountVO_web dis) {

		if (dis.type == Strategy_webType.Level) {// 等级制定由低往高制定，否则失败

			DiscountVO_web_level tempDis_web_lv = (DiscountVO_web_level) dis;

			if (tempDis_web_lv.level >= 1 && tempDis_web_lv.level < 5) {
				
				if(discountVO_web_level[tempDis_web_lv.level - 1]!=null) return ResultMessage_strategy.Existed;
				
				else {
					
					for(int i = 0 ;i <tempDis_web_lv.level-1;i++){
						if(discountVO_web_level[i]==null) return ResultMessage_strategy.Conflict;
					}
					
				}
				
				discountVO_web_level[tempDis_web_lv.level - 1] = tempDis_web_lv;

			} else {
				
				System.out.println("Invalid level !!");
//				return ResultMessage_strategy.Conflict;

			}
		}

		return web.addWebDiscount(dis);
	}

	public ResultMessageDiscount editWebDiscount(DiscountVO_web dis) {

		return web.editWebDiscount(dis);

	}

	/**
	 * 得到所有策略
	 */
	public List<DiscountVO_web> getWebDiscount() {

		List<DiscountVO_web> res = web.getWebDiscount();

		list = res;

		Iterator<DiscountVO_web> iterator = list.iterator();

		while (iterator.hasNext()) {

			DiscountVO_web discountVO_web = iterator.next();

			if (discountVO_web.type == Strategy_webType.Level) {

				DiscountVO_web_level tempDis_web_lv = (DiscountVO_web_level) discountVO_web;

				if (tempDis_web_lv.level >= 1 && tempDis_web_lv.level < 5) {

					discountVO_web_level[tempDis_web_lv.level - 1] = tempDis_web_lv;

				} else {

					System.out.println("Invalid level !!");

				}
			}
		}

		return res;
	}

	public ResultMessageDiscount deleteDiscount(String discountID) {

		return web.deleteDiscount(discountID);
	}

	/**
	 * 根据类型返回
	 */
	public List<DiscountVO_web> getWebDiscount(Strategy_webType type) {
		List<DiscountVO_web> res = new LinkedList<DiscountVO_web>();
		Iterator<DiscountVO_web> iterator = list.iterator();
		while (iterator.hasNext()) {
			DiscountVO_web discountVO_web = (DiscountVO_web) iterator.next();
			if (discountVO_web.type == type) {
				res.add(discountVO_web);
			}
		}
		return res;
	}

	/**
	 * 
	 * @param type
	 * @param discountState
	 * @return 根据策略状态和策略类型返回
	 */
	public List<DiscountVO_web> getWebDiscount(Strategy_webType type, DiscountState discountState) {

		List<DiscountVO_web> res = new LinkedList<DiscountVO_web>();
		Iterator<DiscountVO_web> iterator = list.iterator();
		while (iterator.hasNext()) {
			DiscountVO_web discountVO_web = (DiscountVO_web) iterator.next();
			if (discountVO_web.type == type && discountVO_web.discountState == discountState) {
				res.add(discountVO_web);
			}
		}
		return res;
	}

	/**
	 * 设为失效
	 */
	public ResultMessageDiscount invalidDiscount(String discountID) {

		return web.invalidDiscount(discountID);
	}

	/**
	 * 
	 * @return 返回各个等级的最低信用值
	 *         example：返回[20,50,90]表示达到20升入2级，（默认0信用值起始为1级），信用值达到50升到3级
	 */
	public int[] getLevelCredit() {

		if (list == null)	getWebDiscount();
		
		int [] res = new int [4];
		int credit=0;
		for(int i = 0 ; i<4;i++){
			if(discountVO_web_level[i]==null) break;
			else {
				credit+=discountVO_web_level[i].levelUpCredit;
				res[i]=credit;
			}
		}
		
		return res;
	}
}
