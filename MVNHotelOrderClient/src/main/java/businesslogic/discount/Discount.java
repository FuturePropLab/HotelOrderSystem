package businesslogic.discount;

import java.util.List;

import stub.DiscountCal_stub;
import stub.Discount_stub;
import vo.DiscountSearchVO;
import vo.DiscountVO;
import vo.OrderInputVO;

public class Discount {
	DiscountType discountType;
	/**
	 * 
	 * @param orderInput
	 * @return ���϶��������������Żݲ���
	 */

	public List<DiscountVO> getSuitableDiscount(OrderInputVO orderInput) {
		// TODO Auto-generated method stub
		DiscountCal_stub test=new DiscountCal_stub();
		return test.getSuitableDiscount(orderInput);
	}
	/**
	 * 
	 * @param discount_id
	 * @return ������Ϊ��Ч��ʧЧ���Żݲ��� 
	 */
	public DiscountVO invalidDiscount(String discount_id) {
		DiscountCal_stub test=new DiscountCal_stub();
		return test.invalidDiscount(discount_id);
		
}
	/**
	 * 
	 * @param dsvo
	 * @return �����Żݲ��� 
	 */
	public List<DiscountVO> CheckDiscount(DiscountSearchVO dsvo){
		DiscountCal_stub test=new DiscountCal_stub();
		return test.CheckDiscount(dsvo);
	}
}
