package vo;

import tools.AccountType;

/**
 * 
 * @author wshwbluebird
 *
 */
public class AccountVO {
	public String userid;
	public String username;
	public AccountType accountType;
	
	
	public AccountVO(String userid, String  username , AccountType accountType){
		this.userid = userid;
		this.username = username;
		this.accountType = accountType;
	}
}
