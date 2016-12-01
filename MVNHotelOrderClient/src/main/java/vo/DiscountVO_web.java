package vo;

import java.time.LocalDate;

public class DiscountVO_web {

	public String discount_id;
	public int lv;// 会员等级
	public String city;
	public String district;
	public String businessCircle;
	public double discount;
	public LocalDate startdate;
	public LocalDate enddate;
	public int levelUpCredit;

	public DiscountVO_web(int lv, String city, String district, String businessCircle, double discount, LocalDate start,
			LocalDate End, int levelUpCredit) {
		this.lv = lv;
		this.district = district;
		this.discount = discount;
		this.businessCircle = businessCircle;
		this.city = city;
		this.startdate = start;
		this.enddate = End;
		this.levelUpCredit = levelUpCredit;
	}

}