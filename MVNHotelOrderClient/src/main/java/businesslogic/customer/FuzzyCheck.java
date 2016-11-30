package businesslogic.customer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import po.CustomerPO;
import vo.CustomerSearchVO;

/**
 * 模糊查找
 * @author wshwbluebird
 *
 */
public class FuzzyCheck {
	   //基本预知信息
		String gender;
		String telephone;
		String customerName;
		
		//正则正则表达匹配
		String reTelephone;
		String reCustomerName;
		
		/**
		 * 初始化
		 * @param customerSearchVO
		 */
		public FuzzyCheck(CustomerSearchVO customerSearchVO){
			this.gender = customerSearchVO.gender;
			this.telephone = customerSearchVO.telephone;
			this.customerName = customerSearchVO.customerName;
			
			reTelephone = ".*";
			reCustomerName = ".*";
			
			//书写正则表达式
			if(telephone!=null){
				for(int i = 0 ; i < telephone.length(); i++){
					reTelephone = reTelephone + telephone.charAt(i) + ".*";
				}
			}
			System.out.println("电话正则:   "+reTelephone);
			if(customerName!=null){
				for(int i = 0 ; i < customerName.length(); i++){
					reCustomerName= reCustomerName + customerName.charAt(i)  +".*";
				}
			}
			System.out.println("姓名正则:   "+reCustomerName);
			
		}
		
		/**
		 * 检查这个po是否符合搜索标准
		 * @param customerPO
		 * @return
		 */
		public boolean isPattern(CustomerPO customerPO){
			boolean b = isPattern_Gender(customerPO.getGender())&&
						isPattern_CustomerName(customerPO.getCustomerName())&&
						isPattern_Telephone(customerPO.getTelephone());
			return b;
			
		}
		
		//判断性别是否匹配
		private boolean isPattern_Gender(String Gender_po){
			if(gender == null)  return true;
			else return gender.equals(Gender_po);
		}
		
		//判断电话是否匹配
		private boolean isPattern_Telephone(String inputTelephone_po){
			if(telephone == null)  return true;
			Pattern pattern = Pattern.compile(reTelephone);
	    	Matcher matcher = pattern.matcher(inputTelephone_po);
	    	return matcher.matches();
		}
		
		//判断客户姓名是否匹配
		private boolean isPattern_CustomerName(String CustomerName_po){
			if(customerName == null)  return true;
			Pattern pattern = Pattern.compile(reCustomerName);
	    	Matcher matcher = pattern.matcher(CustomerName_po);
	    	return matcher.matches();
		}

}
