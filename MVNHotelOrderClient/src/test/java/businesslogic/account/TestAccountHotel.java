package businesslogic.account;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import tools.AccountType;
import tools.ResultMessage;
import tools.ResultMessage_Account;
import tools.Star;
import vo.HotelAccountVO;
//import vo.HotelInfoVO;
import vo.HotelInputVO;
import vo.HotelSearchVO;

/**
 *  测试HOTEL账户的相关方法
 * @author wshwbluebird
 *
 */
public class TestAccountHotel {
	public Account account;
//	businesslogic.account.Account account;
//	@Before
//	public  void testBeforeClass(){
//		 List<HotelInfoVO> hotelList = new ArrayList<HotelInfoVO>();
//		 HotelInfoVO hotelInfoVO1 = new HotelInfoVO("aaa", "BIG1", "xxxx", "xxxx",null , "good",
//				 "null", null, Star.five);
//		 HotelInfoVO hotelInfoVO2 = new HotelInfoVO("bbb", "BIG2", "xxxx", "xxxx",null , "good",
//				 "null", null, Star.five);
//		 HotelInfoVO hotelInfoVO3 = new HotelInfoVO("cc", "BIG3", "xxxx", "xxxx",null , "good",
//				 "null", null, Star.five);
//		 hotelList.add(hotelInfoVO1);
//		 hotelList.add(hotelInfoVO2);
//		 hotelList.add(hotelInfoVO3);
//		
//		HotelInfo hotelInfo  = new MockHotel(hotelList, hotelInfoVO1);
//		this.account = new Account(hotelInfo);
//	}
//	
//	@Test
//	public void testAddHotelAccount() {
//		HotelAccountVO hotelAccount = new HotelAccountVO("qwe", "qwe", "123123");
//		HotelInputVO hotelInputVO = new HotelInputVO("qwe", "qwe", "qwe", Star.five);
//		assertEquals(ResultMessage.Exist,account.addHotelAccount(hotelAccount, hotelInputVO));
//	}
//	
//	@Test
//	public void testModifyHotelAccount() {
//		HotelAccountVO hotelAccount = new HotelAccountVO("qwe", "qwe", "123123");
//		assertEquals(ResultMessage.Exist,account.modifyHotelAccount(hotelAccount));
//	}
//	@Test
//	public void testDeleteHotelAccount() {
//		assertEquals(ResultMessage.Exist,account.deleteHotelAccount("123"));
//	}
//	
//	@Test
//	public void testGetHotelAccount() {
//		HotelAccountVO hotelAccount = new HotelAccountVO("123", "荣华大酒店", "ingedg");
//		assertEquals(hotelAccount.id,account.getHotelAccount("123").id);
//		assertEquals(hotelAccount.name,account.getHotelAccount("123").name);
//		assertEquals(hotelAccount.password,account.getHotelAccount("123").password);
//	}
//	
//	@Test
//	public void testSearchHotelAccount() {
//		HotelSearchVO hotelSearchVO = new HotelSearchVO(null, null, null, null, null, Star.five);
//		assertEquals(3, account.searchHotelAccount(hotelSearchVO).size());
//		assertEquals("aaa", account.searchHotelAccount(hotelSearchVO).get(0).id);
//		assertEquals("bbb", account.searchHotelAccount(hotelSearchVO).get(1).id);
//	}
//
	
	@Test
	public void testAddHotelAccount(){
		account = new Account();
		assertEquals(ResultMessage_Account.InvalidInput,account.addAccount("cyy", "123", AccountType.Hotel));
		assertEquals(ResultMessage_Account.Success, account.addAccount("jinlinghotel", "123456", AccountType.Hotel));
	}
	@Test
	public void testRestPassword(){
		account = new Account();
		assertEquals(ResultMessage_Account.Success, account.resetPassword("123455", "123456"));
				
	}
	
	
}
