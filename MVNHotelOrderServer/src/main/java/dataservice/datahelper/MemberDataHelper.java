package dataservice.datahelper;

import po.MemberPO;
import tools.ResultMessage_Member;

public interface MemberDataHelper {
		/**
		 * 
		 * @param memberPO
		 * @return
		 */
		public ResultMessage_Member modifyMemberPO(MemberPO memberPO);
		
		/**
		 * 
		 * @param customerID
		 * @return
		 */
		
		public MemberPO getMemberByID (String customerID);

}
