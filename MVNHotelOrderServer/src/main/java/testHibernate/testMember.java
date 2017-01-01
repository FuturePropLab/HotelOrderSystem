package testHibernate;

import java.time.LocalDate;

import DataFactory.DataHelperUtils;
import dataservice.datahelper.MemberDataHelper;
import dataservice.datahelper.impl.MemberDataHelperImpl;
import po.MemberPO;
import tools.MemberBelongType;
import tools.MemberType;

public class testMember {
		public static void main(String[] args) {
			
			MemberDataHelperImpl memberDataHelper = MemberDataHelperImpl.getInstance();
//     		MemberPO  memberPO = new MemberPO("CS2016112919423486");
//    
////			System.out.println(memberPO.getMemberType().getBirthday());
//			MemberType memberType  =new MemberType("CS2016112919423486");
//			memberType.setType(MemberBelongType.None);
//			//memberType.setBirthday(LocalDate.of(1996, 11, 25));
//			memberPO.setMemberType(memberType);
//			
//			System.out.println(memberDataHelperl.addMemberPO(memberPO));
		System.out.println(memberDataHelper.getLevel("CS001"));
			
	//		System.out.println(memberPO.getMemberType().getType());
//			System.out.println(memberPO.getCustomer_ID());
//			System.out.println(memberPO.getCustomer_ID());
		}
}
