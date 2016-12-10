package businesslogic.credit;

import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import businesslogic.discount.DiscountWebController;
import businesslogic.discount.WebDiscount;
import tools.DiscountState;
import tools.ResultMessage_Discount;
import tools.ResultMessage_DiscountDetail;
import tools.Strategy_webType;
import vo.DiscountVO_web;
import vo.DiscountVO_web_level;

public class MockWebDiscount extends WebDiscount{
	private WebDiscount web;

	private static DiscountWebController discountWebController;

	private List<DiscountVO_web> list;

	private final int maxLevel = 10;// 系统默认允许的最高等级

	private DiscountVO_web_level[] discountVO_web_level = new DiscountVO_web_level[maxLevel];
	/**
	 * 增加网站营销策略，写入数据库同时在逻辑层缓存
	 */
	public ResultMessage_DiscountDetail addWebDiscount(DiscountVO_web dis) {

		ResultMessage_DiscountDetail resultMessage_DiscountDetail = ResultMessage_DiscountDetail.fail;

		if (dis.type == Strategy_webType.Level) {// 等级制定由低往高制定，否则失败

			DiscountVO_web_level tempDis_web_lv = (DiscountVO_web_level) dis;

			if (tempDis_web_lv.level >= 1 && tempDis_web_lv.level < maxLevel) {

				if (discountVO_web_level[tempDis_web_lv.level - 1] != null)
					return ResultMessage_DiscountDetail.Existed;

				else {

					for (int i = 0; i < tempDis_web_lv.level - 1; i++) {
						if (discountVO_web_level[i] == null)
							return ResultMessage_DiscountDetail.Conflict;
					}

				}

				discountVO_web_level[tempDis_web_lv.level - 1] = tempDis_web_lv;

			} else {

				System.out.println("Invalid level !!");

			}
		}
		try {
			resultMessage_DiscountDetail = web.addWebDiscount(dis);
			if (resultMessage_DiscountDetail == ResultMessage_DiscountDetail.Success) {
				initWebDiscount();
			}
			return resultMessage_DiscountDetail;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 编辑修改
	 */
	public ResultMessage_Discount editWebDiscount(DiscountVO_web dis) {
		ResultMessage_Discount resultMessage_Discount = ResultMessage_Discount.Fail;
		try {
			resultMessage_Discount = web.editWebDiscount(dis);
			if (resultMessage_Discount == ResultMessage_Discount.Success) {
				initWebDiscount();
			}
			return resultMessage_Discount;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * 得到所有策略
	 */
	public List<DiscountVO_web> getWebDiscount() {

		List<DiscountVO_web> res = new LinkedList<DiscountVO_web>();

		if (list != null) {
			return res;
		}

		else
			return initWebDiscount();
	}

	/**
	 * 删除
	 */
	public ResultMessage_Discount deleteDiscount(String discountID) {
		ResultMessage_Discount resultMessage_Discount = ResultMessage_Discount.Fail;
		try {
			resultMessage_Discount = web.deleteDiscount(discountID);
			if (resultMessage_Discount == ResultMessage_Discount.Success) {
				Iterator<DiscountVO_web> iterator = list.iterator();
				while (iterator.hasNext()) {
					DiscountVO_web discountVO_web = iterator.next();
					if (discountVO_web.discountID.equals(discountID)) {
						iterator.remove();
					}
				}
			}
			return resultMessage_Discount;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 根据类型返回
	 */
	public List<DiscountVO_web> getWebDiscount(Strategy_webType type) {
		List<DiscountVO_web> res = new LinkedList<DiscountVO_web>();
		if (list == null)
			initWebDiscount();
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
		if (list == null)
			initWebDiscount();
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
	public ResultMessage_Discount invalidDiscount(String discountID) {
		ResultMessage_Discount resultMessage_Discount = ResultMessage_Discount.Fail;
		try {
			resultMessage_Discount =  web.invalidDiscount(discountID);
			if(resultMessage_Discount==ResultMessage_Discount.Success){
				Iterator< DiscountVO_web> iterator = list.iterator();
				while (iterator.hasNext()) {
					DiscountVO_web discountVO_web =  iterator.next();
					if(discountVO_web.discountID.equals(discountID)){
						discountVO_web.discountState = DiscountState.invalid;
					}
				}
			}
			return resultMessage_Discount;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage_Discount.Fail;
		}
	}

	/**
	 * 
	 * @return 返回各个等级的最低信用值
	 *         example：返回[20,50,90]表示达到20升入2级，（默认0信用值起始为1级），信用值达到50升到3级
	 * @throws RemoteException
	 */
	public int[] getLevelCredit() {

		if (list == null)
			getWebDiscount();

		int[] res = new int[maxLevel];
		int credit = 0;
		for (int i = 0; i < maxLevel; i++) {
			if (discountVO_web_level[i] == null)
				break;
			else {
				credit += discountVO_web_level[i].levelUpCredit;
				res[i] = credit;
			}
		}

		return res;
	}

	private List<DiscountVO_web> initWebDiscount() {

		List<DiscountVO_web> res = new LinkedList<DiscountVO_web>();
		try {
			res = web.getWebDiscount();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		list = res;

		// 初始化会员等级链表
		Iterator<DiscountVO_web> iterator = list.iterator();

		while (iterator.hasNext()) {

			DiscountVO_web discountVO_web = iterator.next();

			if (discountVO_web.type == Strategy_webType.Level) {

				DiscountVO_web_level tempDis_web_lv = (DiscountVO_web_level) discountVO_web;

				if (tempDis_web_lv.level >= 1 && tempDis_web_lv.level < maxLevel) {

					discountVO_web_level[tempDis_web_lv.level - 1] = tempDis_web_lv;

				} else {

					System.out.println("Invalid level !!");

				}
			}
		}

		return res;
	}
}

	
	

