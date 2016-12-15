package businesslogic.member;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import businesslogic.customer.MemberInfo;
import tools.ApplyResult;
import tools.MemberBelongType;
import tools.MemberType;
import tools.ResultMessage;
import tools.ResultMessage_Member;
import vo.ApplyVO;
import vo.BackVO;
import vo.MemberVO;

public class TestMember {
	Member member =new Member();
	@Test
/*	public void test() {
		MemberBelongType type=MemberBelongType.Ordinary;
		ApplyVO applyVO=new ApplyVO("001",type );
		assertEquals(ResultMessage.NotExist, member.addApply(applyVO));
	}
	@Test
	public void test2() {
		
		assertEquals(new ArrayList<ApplyVO>(), member.getApplyList());
	}
	@Test
	public void test3() {
		
		MemberBelongType type=MemberBelongType.Ordinary;
		assertEquals(new BackVO("000000002", "reasion", ApplyResult.Succeed).customer_ID, member.getBack("000000002").customer_ID);
	}
	@Test
	public void test4() {
		
		assertEquals(new MemberVO("000000002", new MemberType("000000002")).customer_ID, member.getMemberInfo("000000002").customer_ID);
	}*/
	//@Test
	public void test5() {
		MemberType type=new MemberType("000000009");
		type.setType(MemberBelongType.Ordinary);
		MemberVO memberInfo=new MemberVO("000000009",type );
		assertEquals(ResultMessage_Member.Success, member.modifyMemberInfo(memberInfo));
		assertEquals(new MemberVO("000000002", new MemberType("000000002")).customer_ID, member.getMemberInfo("000000002").customer_ID);
	
		type=new MemberType("000000008");
		type.setType(MemberBelongType.Ordinary);
		memberInfo=new MemberVO("000000008",type );
		assertEquals(ResultMessage_Member.Success, member.modifyMemberInfo(memberInfo));
		
		type=new MemberType("000000007");
		type.setType(MemberBelongType.Enterprise);
		memberInfo=new MemberVO("000000007",type );
		assertEquals(ResultMessage_Member.Success, member.modifyMemberInfo(memberInfo));
	}

	/*public static void main(String []args){
		MemberType type=new MemberType("000000009");
		type.setType(MemberBelongType.Ordinary);
		MemberVO memberInfo=new MemberVO("000000009",type );
		Member member = new Member();
		ResultMessage_Member result= member.modifyMemberInfo(memberInfo);
		System.out.println(result);
	}*/

}
