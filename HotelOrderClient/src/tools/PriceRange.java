package tools;

import Exception.OutOfBoundsException;

public class PriceRange {
	double lowest;
	double higest;
	
	public PriceRange(double lowest,double higest) throws OutOfBoundsException{
		if(lowest<0 || higest<0 ||lowest>higest){
			throw new OutOfBoundsException();
		}
		
		this.lowest=lowest;
		this.higest=higest;
	}
}
