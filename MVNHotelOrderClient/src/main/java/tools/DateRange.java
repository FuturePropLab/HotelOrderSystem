package tools;

import java.util.Date;

import Exception.OutOfBoundsException;

/**
 *  日期的范围，从date1到date2
 *  @author zjy
 */
public class DateRange {
	Date earliest;
	Date latest;
	
	/**
	 *  @param earliest  开始日期
	 *  @param latest  结束日期
	 *  @exception OutOfBoundsException  结束日期在开始日期之后
	 */
	public DateRange(Date earliest,Date latest) throws OutOfBoundsException{
		if(earliest!=null && earliest.after(latest)){
			throw new OutOfBoundsException();
		}
		
		this.earliest=earliest;
		this.latest=latest;
	}
}
