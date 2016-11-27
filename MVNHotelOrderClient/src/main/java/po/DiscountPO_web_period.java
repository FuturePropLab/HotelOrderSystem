package po;
import java.util.Calendar;
public class DiscountPO_web_period extends DiscountPO_web{
	
	private double discount;
	
	private Calendar startdate;
	
	private Calendar enddate;
	
	public DiscountPO_web_period(double discount , Calendar startdate ,Calendar enddate ){
		this.discount=discount;
		this.startdate=startdate;
		this.enddate=enddate;
	}
	public Calendar getEnddate() {
		return enddate;
	}
	
	public void setEnddate(Calendar enddate) {
		this.enddate = enddate;
	}
	
	public Calendar getStartdate() {
		return startdate;
	}
	
	public void setStartdate(Calendar startdate) {
		this.startdate = startdate;
	}
	

	
}	
