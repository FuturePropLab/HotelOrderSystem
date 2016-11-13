package businesslogic.member;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import businesslogic.customer.MemberInfo;
import tools.ApplyResult;
import tools.MemberType;
import tools.ResultMessage;
import vo.ApplyVO;
import vo.BackVO;
import vo.MemberVO;

public class TestMember {
	Member member =new Member();
	@Test
	public void test() {
		MemberType.Type type=MemberType.Type.Ordinary;
		ApplyVO applyVO=new ApplyVO("001",type );
		assertEquals(ResultMessage.NotExist, member.addApply(applyVO));
	}
	@Test
	public void test2() {
		
		assertEquals(new ArrayList<ApplyVO>(), member.getApplyList());
	}
	@Test
	public void test3() {
		
		MemberType.Type type=MemberType.Type.Ordinary;
		assertEquals(new BackVO("000000002", "reasion", ApplyResult.Succeed).customer_ID, member.getBack("000000002").customer_ID);
	}
	@Test
	public void test4() {
		
		assertEquals(new MemberVO("000000002", new MemberType("000000002")).customer_ID, member.getMemberInfo("000000002").customer_ID);
	}
	@Test
	public void test5() {
		MemberType type=new MemberType("000000002");
		MemberVO memberInfo=new MemberVO("000000002",type );
		assertEquals(ResultMessage.Exist, member.modifyMemberInfo(memberInfo));
	}

}
