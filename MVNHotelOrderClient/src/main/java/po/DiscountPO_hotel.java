package po;

import java.util.Date;

public class DiscountPO_hotel extends DiscountPO{

	private Date startDate;
	private Date EndDate;
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return EndDate;
	}
	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}

}
