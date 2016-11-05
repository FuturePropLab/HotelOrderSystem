package vo;

/**
 * 搜索客户用的值对象
 * @author wshwbluebird
 *
 */
public class CustomerSearchVO {
		public String username; //客户的姓名
		public String telephone; //客户的电话
		public String userID; //客户的ID
		
		public  CustomerSearchVO(String username ,String telephone, String userID){
			this.telephone = telephone;
			this.userID = userID;
			this.username = username;
		}
	
		
}
