package businesslogic.account;

import org.junit.Test;

import vo.WebDesignerSearchVO;

//package businesslogic.account;
//
//import static org.junit.Assert.assertEquals;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import tools.ResultMessage;
//import vo.WebAccountVO;
//
///**
// * 测试WEB账户的相关方法
// * @author wshwbluebird
// *
// */
//public class TestAccountWeb {
//
//	businesslogic.account.Account account;
//	@Before
//	public  void testBeforeClass(){
//		this.account = new Account();
//	}
//	
//	@Test
//	public void testAddWebAccount() {
//		WebAccountVO webAccountVO = new WebAccountVO("zzjy", "zzjy", "123123");
//		assertEquals(ResultMessage.Exist,account.addWebAccount(webAccountVO));
//	}
//	
//	@Test
//	public void testModifyWebAccount() {
//		WebAccountVO webAccountVO = new WebAccountVO("zzjy", "zzjy", "123123");
//		assertEquals(ResultMessage.Exist,account.modifyWebAccount(webAccountVO));
//	}
//	@Test
//	public void testgetWebAccount() {
//		WebAccountVO webAccountVO = new WebAccountVO("zzjy", "zzjy", "qwer");
//		assertEquals(webAccountVO.id,account.getWebAccount("zzjy").id);
//		assertEquals(webAccountVO.name,account.getWebAccount("zzjy").name);
//		assertEquals(webAccountVO.password,account.getWebAccount("zzjy").password);
//	}
//
//}
public class TestAccountWeb{
	@Test
	public void testSearch(){
		WebDesignerSearchVO searchvo = new WebDesignerSearchVO();
		searchvo.name = "chenyuyan";
		
	}
	
	
	
	
}