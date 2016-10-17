package tools;

import Exception.OutOfBoundsException;

/**
 *  酒店的评分，0.0-5.0的double值
 *  @author zjy
 */
public class Mark {
	double mark;
	
	/**
	 *  @param mark  评分，只能在0.0-5.0之间
	 *  @exception OutOfBoundsException  评分不在0.0-5.0之间
	 */
	public Mark (double mark) throws OutOfBoundsException{
		if(mark<0 || mark>5){
			throw new OutOfBoundsException();
		}
		this.mark=mark;
	}
}
