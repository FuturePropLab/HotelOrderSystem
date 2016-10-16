package driver;

import dataservice.MemberService;
import po.MemberPO;
import tools.MemberType;
import tools.ResultMessage;

public class MemberDataService_Driver {
	private static final String customer_ID_test="000000002";
	
	public boolean drive(MemberService memberService) {
		ResultMessage result=memberService.addmember(customer_ID_test);
		if(result.equals(ResultMessage.NotExist)){
			return false;
		}
		
		result=memberService.modifymember(new MemberPO(customer_ID_test, new MemberType(customer_ID_test)));
		
		return true;
	}

}
