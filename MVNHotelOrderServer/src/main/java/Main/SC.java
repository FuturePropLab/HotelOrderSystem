package Main;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SC {
	@Id
	private SCPK scpk;
	private String g;
	
	
   
	public SCPK getScpk() {
		return scpk;
	}
	public void setScpk(SCPK scpk) {
		this.scpk = scpk;
	}
	public String getG() {
		return g;
	}
	public void setG(String g) {
		this.g = g;
	}
	

	
	
}
