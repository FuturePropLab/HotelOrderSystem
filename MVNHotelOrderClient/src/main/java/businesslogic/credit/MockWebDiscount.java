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

	private final int maxLevel = 10;// ϵͳĬ���������ߵȼ�

	private DiscountVO_web_level[] discountVO_web_level = new DiscountVO_web_level[maxLevel];
	/**
	 * ������վӪ�����ԣ�д�����ݿ�ͬʱ���߼��㻺��
	 */
	public ResultMessage_DiscountDetail addWebDiscount(DiscountVO_web dis) {

		ResultMessage_DiscountDetail resultMessage_DiscountDetail = ResultMessage_DiscountDetail.fail;

		if (dis.type == Strategy_webType.Level) {// �ȼ��ƶ��ɵ������ƶ�������ʧ��

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
	 * �༭�޸�
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
	 * �õ����в���
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
	 * ɾ��
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
	 * �������ͷ���
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
	 * @return ���ݲ���״̬�Ͳ������ͷ���
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
	 * ��ΪʧЧ
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
	 * @return ���ظ����ȼ����������ֵ
	 *         example������[20,50,90]��ʾ�ﵽ20����2������Ĭ��0����ֵ��ʼΪ1����������ֵ�ﵽ50����3��
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

		// ��ʼ����Ա�ȼ�����
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

	
	

