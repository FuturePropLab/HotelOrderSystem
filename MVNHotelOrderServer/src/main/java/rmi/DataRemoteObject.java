package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;

import dataservice.AccountDataService;
import dataservice.CreditDataService;
import dataservice.CustomerDataService;
import dataservice.DiscountHotelDataService;
import dataservice.DiscountWebDataService;
import dataservice.HotelDataService;
import dataservice.LoginCheckService;
import dataservice.MemberDataService;
import dataservice.OrderDataService;
import dataservice.RoomDataService;
import dataservice.datahelper.MemberDataHelper;
import dataservice.impl.AccountDataServiceImpl;
import dataservice.impl.CreditdataServiceImpl;
import dataservice.impl.CustomerDataServiceImpl;
import dataservice.impl.DiscountHotelDataServiceImpl;
import dataservice.impl.DiscountWebServiceImpl;
import dataservice.impl.HotelDataServiceImpl;
import dataservice.impl.LoginCheckServiceImpl;
import dataservice.impl.MemberDataServiceImpl;
import dataservice.impl.OrderDataServiceImpl;
import dataservice.impl.RoomDataServiceImpl;
import po.AccountPO;
import po.CreditLogPO;
import po.CustomerPO;
import po.DiscountPO_hotel;
import po.DiscountPO_web;
import po.HotelPO;
import po.ImageInfoPO;
import po.MemberPO;
import po.OrderAssessPO;
import po.OrderPO;
import po.SearchOrderInfo;
import tools.AccountType;
import tools.ResultMessage;
import tools.ResultMessage_Account;
import tools.ResultMessage_Discount;
import tools.ResultMessage_DiscountDetail;
import tools.ResultMessage_Hotel;
import tools.ResultMessage_LoginCheck;
import tools.ResultMessage_Member;
import tools.ResultMessage_Modify;
import tools.ResultMessage_Room;
import tools.ResultMessage_signUp;
import tools.RoomType;
import tools.StandardSearch;

public class DataRemoteObject extends UnicastRemoteObject implements
LoginCheckService ,AccountDataService,CustomerDataService,
HotelDataService,RoomDataService, DiscountWebDataService,DiscountHotelDataService,
OrderDataService,CreditDataService, MemberDataService{
	/**
	 *  RMI 接口
	 */
	private static final long serialVersionUID = 4029039744279087114L;
	private LoginCheckService loginCheckService;
	private AccountDataService accountDataService;
	private CustomerDataService customerDataService;
	private HotelDataService hotelDataService;
	private RoomDataService roomDataService;
	private DiscountWebDataService discountWebDataService;
	private DiscountHotelDataService discountHotelDataService;
	private OrderDataService orderDataService;
	private CreditDataService creditDataService;
	private MemberDataService memberDataService;
	protected DataRemoteObject() throws RemoteException {
		//用loginCheckServiceIMPL 实现
		loginCheckService = new LoginCheckServiceImpl();
		accountDataService = new AccountDataServiceImpl();
		customerDataService = new CustomerDataServiceImpl();
		hotelDataService = new HotelDataServiceImpl();
		roomDataService = new RoomDataServiceImpl();
		discountWebDataService = new DiscountWebServiceImpl();
		discountHotelDataService = new DiscountHotelDataServiceImpl();
		orderDataService = new OrderDataServiceImpl();
		creditDataService = new CreditdataServiceImpl();
		memberDataService = new MemberDataServiceImpl();

	}
	/**
	 * LoginCheckService的接口方法
	 */
	public ResultMessage_LoginCheck checkLogin(String username, String password,AccountType accountType)  throws RemoteException{		
		//System.out.println("远程调用方法 : loginCheckService.checkLogin ");
		return loginCheckService.checkLogin(username, password,accountType);
	}
	
	public String getUserID(String username, String password) throws RemoteException  {
		return loginCheckService.getUserID(username, password);
	}
	
	/**
	 * AccountDataService 的接口方法
	 * @throws RemoteException 
	 */
	public ResultMessage_Account resetPassword(String userid, String newPassword) throws RemoteException {
		return accountDataService.resetPassword(userid, newPassword);
	}
	public AccountPO getAccountByUserName(String username) throws RemoteException {
		return accountDataService.getAccountByUserName(username);
	}
	public AccountPO getAccountByID(String userid) throws RemoteException {
		return accountDataService.getAccountByID(userid);
	}
	public ResultMessage_Account addAccount(AccountPO accountPO) throws RemoteException {
		return accountDataService.addAccount(accountPO);
	}
	public ResultMessage_Account deleteAccount(String userid) throws RemoteException {
		return accountDataService.deleteAccount(userid);
	}
	public List<AccountPO> getAccountList(List<String> idList,AccountType accountType) throws RemoteException {
		return accountDataService.getAccountList(idList,accountType);
	}
	
	/**
	 * customer 类的数据相关内容
	 */
	public ResultMessage_signUp add(CustomerPO customerInfo) throws RemoteException {
		return customerDataService.add(customerInfo);
	}
	public CustomerPO find(String customer_id) throws RemoteException {
		return customerDataService.find(customer_id);
	}
	public ResultMessage_Modify modify(CustomerPO customerInfo) throws RemoteException {
		return customerDataService.modify(customerInfo);
	}
	public List<CustomerPO> searchCustomer() throws RemoteException {
		return customerDataService.searchCustomer();
	}
	
	/**
	 * Hoteldata related 
	 */
	public ResultMessage_Hotel addHotel(HotelPO hotelPO) throws RemoteException {
		return hotelDataService.addHotel(hotelPO);
	}
	public ResultMessage_Hotel modifyHotel(HotelPO hotelPO) throws RemoteException {
		return hotelDataService.modifyHotel(hotelPO);
	}
	public HotelPO getHotel(String hotel_id) throws RemoteException {
		return hotelDataService.getHotel(hotel_id);
	}
	public List<HotelPO> searchHotelList(StandardSearch standardSearch) throws RemoteException {
		return hotelDataService.searchHotelList(standardSearch);
	}
	public ImageInfoPO getImage(String filename) throws RemoteException {
		return hotelDataService.getImage(filename);
	}
	public ResultMessage_Hotel upload(String filename, byte[] file) throws RemoteException {
		return hotelDataService.upload(filename, file);		
	}
	public byte[] download(String filename) throws RemoteException{
		return hotelDataService.download(filename);
	}
	public ResultMessage_Hotel makeDir(String dir) throws RemoteException {
		return hotelDataService.makeDir(dir);
	}
	public ResultMessage_Hotel modifyHotelInfoString(String hotelID, List<String> discribes) throws RemoteException {
		return hotelDataService.modifyHotelInfoString(hotelID, discribes);
	}
	public List<String> getHotelInfoString(String hotelID) throws RemoteException {
		return hotelDataService.getHotelInfoString(hotelID);
	}
	public List<String> getAllDistrictByCity(String city) throws RemoteException  {
		return hotelDataService.getAllDistrictByCity(city);
	}
	public List<String> getBusineeCircleByDistrict(String district) throws RemoteException {
		return hotelDataService.getBusineeCircleByDistrict(district);
	}
	public List<HotelPO> searchHotelListFuzzy(String input) throws RemoteException {
		return hotelDataService.searchHotelListFuzzy(input);
	}
	
	/**
	 * room
	 */
	public ResultMessage_Room addRoom(String hotelID, String RoomNO, RoomType roomtype) throws RemoteException {
		return roomDataService.addRoom(hotelID, RoomNO, roomtype);
	}
	public ResultMessage_Room deleteRoom(String hotelID, String RoomNO) throws RemoteException {
		return roomDataService.deleteRoom(hotelID, RoomNO);
	}
	public ResultMessage_Room addRecord(String hotelID, String RoomNO, Date begin, Date end) throws RemoteException {
		return roomDataService.addRecord(hotelID, RoomNO, begin, end);
	}
	public ResultMessage_Room deleteRecord(String hotelID, String RoomNO, Date begin) throws RemoteException {
		return roomDataService.deleteRecord(hotelID, RoomNO, begin);
	}
	public List<String> getAvailbleRoomNoByType(String hotelID, RoomType roomType, Date begin, Date end)
			throws RemoteException {
		return roomDataService.getAvailbleRoomNoByType(hotelID, roomType, begin, end);
	}
	public int getTotalNumberRoomByType(String hotelID, RoomType roomType) throws RemoteException {
		return roomDataService.getTotalNumberRoomByType(hotelID, roomType);
	}
	public int getAvaiableNumberRoomByType(String hotelID, RoomType roomType, Date begin, Date end)
			throws RemoteException {
		return roomDataService.getAvaiableNumberRoomByType(hotelID, roomType, begin, end);
	}
	public ResultMessage_Room modifyRoomInfoString(String hotelID, RoomType roomType, List<String> discribes)
			throws RemoteException {
		return roomDataService.modifyRoomInfoString(hotelID, roomType, discribes);
	}
	public List<String> getRoomInfoString(String hotelID, RoomType roomType) throws RemoteException {
		return roomDataService.getRoomInfoString(hotelID, roomType);
	}
	
	
	/**
	 * discount web part
	 */
	public ResultMessage_DiscountDetail addWebDiscount(DiscountPO_web dis) throws RemoteException {
		return discountWebDataService.addWebDiscount(dis);
	}
	public ResultMessage_Discount editWebDiscount(DiscountPO_web discountPO_web) throws RemoteException {
		return discountWebDataService.editWebDiscount(discountPO_web);
	}
	public List<DiscountPO_web> getWebDiscount() throws RemoteException {
		return discountWebDataService.getWebDiscount();
	}
	public ResultMessage_Discount deleteWebDiscount(String discountID) throws RemoteException {
		return discountWebDataService.deleteWebDiscount(discountID);
	}
	public ResultMessage_Discount invalidDiscount(String discountID) throws RemoteException {
		return discountWebDataService.invalidDiscount(discountID);
	}
	
	/**
	 * discount hotel
	 */
	public ResultMessage_DiscountDetail addHotelDiscount(String hotelID, DiscountPO_hotel dis) throws RemoteException {
		return discountHotelDataService.addHotelDiscount(hotelID, dis);
	}
	public ResultMessage_Discount editHotelDiscount(String hotelID, DiscountPO_hotel dis) throws RemoteException {
		return discountHotelDataService.editHotelDiscount(hotelID, dis);
	}
	public List<DiscountPO_hotel> getHotelDiscount(String hotelID) throws RemoteException {
		return discountHotelDataService.getHotelDiscount(hotelID);
	}
	public ResultMessage_Discount deleteHotelDiscount(String hotelID, String discountID) throws RemoteException {
		return discountHotelDataService.invalidDiscount(discountID);
	}
	
	/**
	 * order 
	 */
	public ResultMessage add(OrderPO order) throws RemoteException {
		return orderDataService.add(order);
	}
	public OrderPO findOrder(String order_id) throws RemoteException {
		return orderDataService.findOrder(order_id);
	}
	public ResultMessage modify(OrderPO order) throws RemoteException {
		return orderDataService.modify(order);
	}
	public List<OrderPO> searchOrder(SearchOrderInfo searchOrderInfo) throws RemoteException {
		return orderDataService.searchOrder(searchOrderInfo);
	}
	
	
	/**
	 * credit 
	 */
	public ResultMessage add(CreditLogPO creditlog) throws RemoteException {
		return creditDataService.add(creditlog);
	}
	public List<CreditLogPO> getLogList(String customer_id) throws RemoteException {
		return creditDataService.getLogList(customer_id);
	}
	public ResultMessage changeCredit(String customer_id, int result) throws RemoteException {
		return creditDataService.changeCredit(customer_id, result);
	}
	public ResultMessage_Member modifyMember(MemberPO member) throws RemoteException{
		return memberDataService.modifyMember(member);
	}
	public MemberPO getMember(String customer_id) throws RemoteException{
		return memberDataService.getMember(customer_id);
	}
	public List<String> getAllComment(String hotelID) throws RemoteException {
		return orderDataService.getAllComment(hotelID);
	}
	public List<OrderAssessPO> gethotelAssessVO(String hotelID) throws RemoteException {
		return hotelDataService.gethotelAssessVO(hotelID);
	}

}
