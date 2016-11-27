package po;
/**
 * 
 * @author LWY
 *
 */
public class DiscountPO_web_lv extends DiscountPO_web{
	
	private double discount;
	
	private int lv;
	
	private int levelUpCredit;
	
	public DiscountPO_web_lv(double discount,int lv,int levelUpCredit){
		this.discount=discount;
		this.lv=lv;
		this.levelUpCredit=levelUpCredit;
	}
	public int getLv() {
		return lv;
	}
	
	public void setLv(int lv) {
		this.lv = lv;
	}
	
	public int getLevelUpCredit() {
		return levelUpCredit;
	}
	
	public void setLevelUpCredit(int levelUpCredit) {
		this.levelUpCredit = levelUpCredit;
	}
	
	
}
