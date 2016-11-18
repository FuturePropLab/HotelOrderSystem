package Main;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Student {
	private String sno;
	private String sn;
	private String sd;
	private short sa;
	private String si;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public String getSd() {
		return sd;
	}
	public void setSd(String sd) {
		this.sd = sd;
	}
	public short getSa() {
		return sa;
	}
	public void setSa(short sa) {
		this.sa = sa;
	}
	public String getSi() {
		return si;
	}
	public void setSi(String si) {
		this.si = si;
	}
	
	
	
	
	
}
