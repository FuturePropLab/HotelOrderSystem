package po;

import java.io.Serializable;

import javax.persistence.Entity;

import tools.DiscountState;
import tools.Strategy_webType;

/**
 * 
 * @author wsw
 *
 */
@Entity
public class DiscountPO_web_level extends DiscountPO_web implements Serializable{
	private static final long serialVersionUID = 3590904834832537625L;

	private int level;// 会员等级

	private int levelUpCredit;// 升级所需信用

	/**
	 * 
	 * @param discount
	 * @param lv
	 * @param levelUpCredit
	 * @param discountState
	 * @param remarks
	 * @param type
	 */
	//???
	public DiscountPO_web_level(double discount, int lv, int levelUpCredit,DiscountState discountState,String remarks,Strategy_webType type) {
		setDiscount(discount);
		this.level = lv;
		this.levelUpCredit = levelUpCredit;
		super.setDiscountState(discountState); 
		super.setRemarks(remarks);
		super.setType(type);
	}

	public DiscountPO_web_level(){
		
	}
	
	public int getLv() {
		return level;
	}

	public void setLv(int lv) {
		this.level = lv;
	}

	public int getLevelUpCredit() {
		return levelUpCredit;
	}

	public void setLevelUpCredit(int levelUpCredit) {
		this.levelUpCredit = levelUpCredit;
	}

}
