package po;


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
