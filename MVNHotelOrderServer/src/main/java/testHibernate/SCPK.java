package testHibernate;

import java.io.Serializable;

import javax.persistence.Embeddable;


@Embeddable 
public class SCPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8003471535311427928L;
		
	private String cno,sno;

	public String getCno() {
		return cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof SCPK ){
			SCPK key = (SCPK)o;
			if(this.getCno().equals(key.getCno())  && this.getSno().equals(key.getSno()))
				return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.cno.hashCode();
	}
	

}
