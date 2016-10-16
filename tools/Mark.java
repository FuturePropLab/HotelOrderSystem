package tools;

import Exception.OutOfBoundsException;

public class Mark {
	int mark;
	public Mark (int mark) throws OutOfBoundsException{
		if(mark<0 || mark>5){
			throw new OutOfBoundsException();
		}
		this.mark=mark;
	}
}
