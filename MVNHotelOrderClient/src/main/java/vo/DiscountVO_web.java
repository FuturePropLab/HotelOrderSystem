package vo;

import java.util.Date;

public class DiscountVO_web  {
	public String discount_id;
	public int lv;//会员等级
	public String district;
	public double discount;
	public Date startdate;
	public Date enddate;
	public int levelUpCredit;
	public DiscountVO_web( int lv,String district,double discount,Date start,Date End,int levelUpCredit){
		this.lv=lv;
		this.district=district;
		this.discount=discount;
		
		this.startdate=start;
		this.enddate=End;
		this.levelUpCredit=levelUpCredit;
	}
	
}