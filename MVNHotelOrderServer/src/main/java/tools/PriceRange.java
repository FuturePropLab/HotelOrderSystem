package tools;

import java.io.Serializable;

import Exception.OutOfBoundsException;

public class PriceRange implements Serializable{
	
	private static final long serialVersionUID = 7441593943480401110L;
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

	public double getLowest() {
		return lowest;
	}

	public void setLowest(double lowest) {
		this.lowest = lowest;
	}

	public double getHigest() {
		return higest;
	}

	public void setHigest(double higest) {
		this.higest = higest;
	}
	
	
	
}
