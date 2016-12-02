package po;

import vo.DiscountVO_web_level;

/**
 * 
 * @author LWY
 *
 */
public class DiscountPO_web_level extends DiscountPO_web{
	
	private double discount;//折扣
	
	private int level;//会员等级
	
	private int levelUpCredit;//升级所需信用
	
	public DiscountPO_web_level(double discount,int lv,int levelUpCredit){
		this.discount=discount;
		this.level=lv;
		this.levelUpCredit=levelUpCredit;
	}
	public DiscountPO_web_level(DiscountVO_web_level discountVO_web) {
		// TODO Auto-generated constructor stub
		this.discount=discountVO_web.discount;
		this.level=discountVO_web.level;
		this.levelUpCredit=discountVO_web.levelUpCredit;
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
