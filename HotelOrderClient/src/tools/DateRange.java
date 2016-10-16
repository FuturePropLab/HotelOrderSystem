package tools;

import java.util.Date;

import Exception.OutOfBoundsException;

public class DateRange {
	Date earliest;
	Date latest;
	
	public DateRange(Date earliest,Date latest) throws OutOfBoundsException{
		if(earliest.after(latest)){
			throw new OutOfBoundsException();
		}
		
		this.earliest=earliest;
		this.latest=latest;
	}
}
