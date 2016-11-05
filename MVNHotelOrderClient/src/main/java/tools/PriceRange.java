package tools;

import Exception.OutOfBoundsException;

/**
 *  价格的范围，从x到y
 *  @author zjy
 */
public class PriceRange {
	double lowest;
	double higest;
	
	/**
	 *  @param lowest  最低价
	 *  @param higest  最高价
	 *  @exception OutOfBoundsException  最低价或最高价小于0，或者最低价高于最高价
	 */
	public PriceRange(double lowest,double higest) throws OutOfBoundsException{
		if(lowest<0 || higest<0 ||lowest>higest){
			throw new OutOfBoundsException();
		}
		
		this.lowest=lowest;
		this.higest=higest;
	}
}
