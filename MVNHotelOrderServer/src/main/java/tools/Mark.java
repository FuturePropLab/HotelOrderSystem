package tools;

import java.io.Serializable;

import Exception.OutOfBoundsException;

/**
 *  酒店的评分，0.0-5.0的double值
 *  @author zjy
 */
public class Mark implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9087306203033224497L;
	private double mark;
	
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
	
	/**
	 * 
	 * @return 评分的值
	 */
	public double getValue() {
		return mark;
	}
}
