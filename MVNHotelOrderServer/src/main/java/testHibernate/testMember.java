package testHibernate;

import DataFactory.DataHelperUtils;
import dataservice.datahelper.MemberDataHelper;
import dataservice.datahelper.impl.MemberDataHelperImpl;
import po.MemberPO;
import tools.MemberBelongType;
import tools.MemberType;

public class testMember {
		public static void main(String[] args) {
			MemberDataHelper memberDataHelper = DataHelperUtils.getMemberDataHelper();
			MemberPO  memberPO = memberDataHelper.getMemberByID("CS001");
			MemberType memberType  =new MemberType("CS001");
			memberType.setType(MemberBelongType.Enterprise);
			memberType.setCompanyName("朱俊毅的后宫");
			memberPO.setMemberType(memberType);
			
			System.out.println(memberDataHelper.modifyMemberPO(memberPO));
		
			
	//		System.out.println(memberPO.getMemberType().getType());
//			System.out.println(memberPO.getCustomer_ID());
//			System.out.println(memberPO.getCustomer_ID());
		}
}
