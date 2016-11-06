package po;

/**
 * 
 * @author wshwbluebird
 *
 */
public class WebAccountPO {
	private String id;
	private String name;
	private String password;
	public WebAccountPO(String id,String name,String password){
		id=this.id;
		name=this.name;
		password=this.password;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
