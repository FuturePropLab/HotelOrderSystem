package vo;

/**
 * 搜索客户用的值对象
 * @author wshwbluebird
 *
 */
public class CustomerSearchVO {
		//多余 public String username; //客户的姓名
		public String telephone; //客户的电话
		public String userID; //客户的ID
		public String customerName;//客户的姓名
		public String gender ;  //客户的性别
		
		/**
		 * 非常不推荐
		 * @deprecated
		 * @param telephone
		 * @param userID
		 */
		public  CustomerSearchVO(String telephone, String userID){
			this.telephone = telephone;
			this.userID = userID;			
		}
		
		/**
		 * 
		 * @param userID
		 */
		public  CustomerSearchVO(String userID){
			this.userID = userID;			
		}
		
		/**
		 * 非常不推荐
		 * @param userID
		 * @param telephone
		 * @param customernName
		 * @param gender
		 * @deprecated
		 */
		
		public CustomerSearchVO(String userID, String telephone,String customernName ,String gender){
			this.customerName = customernName;
			this.telephone = telephone;
			this.userID = userID;
			this.gender = gender;
		}
		
		/**
		 * 
		 * @param telephone
		 * @param customernName
		 * @param gender 
		 */
		public CustomerSearchVO( String telephone,String customernName ,String gender){
			this.customerName = customernName;
			this.telephone = telephone;
			this.gender = gender;
		}
	
		
}
