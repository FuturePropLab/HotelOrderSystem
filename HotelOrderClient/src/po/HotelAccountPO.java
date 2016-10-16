package po;

public class HotelAccountPO {
	private String id;
	private String name;
	private String password;
	public HotelAccountPO(String id,String name,String password){
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
	public String getPassword() {
		return password;
	}
	
}
