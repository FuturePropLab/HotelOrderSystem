package businesslogic.strategy;

import vo.OrderInputCalVO;

/**
 * 
 * @author 三间及以上预定的策略：第三间及以上的房间享有折扣
 *
 */
public class OrderMoreStrategy implements HotelStrategyInterface {

	public double calculate(OrderInputCalVO orderInputCalVO,double discount) {
		
		double res=-1;
		
		final int maxNoDiscount=2;//刚好获得优惠的房间数量-1       软编码哈哈哈
		
		if(orderInputCalVO.numberOfRooms>maxNoDiscount){
			
			res=orderInputCalVO.days*
					(orderInputCalVO.price*maxNoDiscount+orderInputCalVO.price*(orderInputCalVO.numberOfRooms-maxNoDiscount)*discount);
			
			
		}
		else res= orderInputCalVO.days*orderInputCalVO.numberOfRooms*orderInputCalVO.price;
		
		return res;
	}

}
