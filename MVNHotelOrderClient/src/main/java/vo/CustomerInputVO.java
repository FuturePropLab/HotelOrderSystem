package vo;

public class CustomerInputVO {
		public String username;  //客户输入的用户名
		public String password;	//客户输入的密码
		public String customerName;	//客户输入的客户姓名
		public String telephone;	//客户输入的电话
		public String gender;	//客户输入的性别
	
		
		public CustomerInputVO(String username,String password,
		String customerName, String telephone, String gender){
			this.username = username;
			this.password = password;
			this.customerName =customerName;
			this.telephone = telephone;
			this.gender = gender;					
		}
		
}
