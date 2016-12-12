package vo;

import po.AccountPO;

public class WebAccountVO {
	public String id;
	public String name;
	public String password;
	public WebAccountVO(String id,String name,String password){
		id=this.id;
		name=this.name;
		password=this.password;
	}
	
	public WebAccountVO(AccountPO accountPO){
		this.id = accountPO.getUserid();
		this.name = accountPO.getUsername();
		this.password = null;
	}
}
