package businesslogic.order;

import java.util.Date;

/**
 *订单的退房信息
 * @author zjy
 *
 */
public class CheckOutInfo {
	public Date checkOutTime;//实际离开时间
	
	/**
	 * 
	 * @param date 实际离开时间
	 */
	public CheckOutInfo(Date date) {
		super();
		this.checkOutTime = date;
	}


	/**
	 * 
	 * @return 退房信息填写完毕则返回true，否则返回false
	 */
	public boolean filled() {
		return checkOutTime!=null;
	}
}
