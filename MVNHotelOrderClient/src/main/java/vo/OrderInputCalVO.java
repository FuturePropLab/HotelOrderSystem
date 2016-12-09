package vo;

import java.time.LocalDate;

import businesslogic.hotel.HotelDealController;
import businesslogic.member.MemberController;
import businesslogicservice.HotelDealService;
import tools.MemberBelongType;
import tools.RoomType;

/**
 * 输入订单信息供计算
 * 
 * @author LWY
 */
public class OrderInputCalVO {
	/**
	 * 
	 * @param price
	 *            订房的单价
	 * @param customerID
	 *            客户ID
	 * @param hotelID
	 *            酒店ID
	 * @param startDate
	 *            订单开始时间
	 * @param endDate
	 *            预计离开时间
	 * @param orderDate
	 *            下单时间
	 * @param roomType
	 *            房间类型
	 * @param numberOfRooms
	 *            预订的房间数量
	 */
	public OrderInputCalVO(double price, String customerID, String hotelID, LocalDate startDate, LocalDate endDate,
			LocalDate orderDate, RoomType roomType, int numberOfRooms) {
		super();
		this.price = price;
		this.customerID = customerID;
		this.startDate = startDate;
		this.endDate = endDate;
		this.hotelID = hotelID;
		this.roomType = roomType;
		this.numberOfRooms = numberOfRooms;
		this.orderDate = orderDate;
		setMemberBelongType(customerID);
		setDays(startDate, endDate);
		setLevel(customerID);
		setCircle(hotelID);
		if (memberBelongType == MemberBelongType.Ordinary) {
			setBirthday(customerID);

		} else if (memberBelongType == MemberBelongType.Enterprise) {
			setMemberBelongType(customerID);
		}
	}

	public double price;// 订房单价
	public String customerID;
	public String hotelID;
	public LocalDate startDate;
	public LocalDate endDate;// 住房结束时间
	public LocalDate orderDate;
	public RoomType roomType;
	public int numberOfRooms;

	/**
	 * 以下为计算需要，初始化时生成
	 */
	public int days;// 计算需要,为订多少天
	public MemberBelongType memberBelongType;
	public LocalDate birthday;
	public String enterprise;
	public int level;
	public String city;
	public String district;
	public String businessCircle;

	public void setDays(LocalDate start, LocalDate end) {

		this.days = (int) (end.toEpochDay() - start.toEpochDay());

	}

	public void setCircle(String hotelID) {
		HotelDealService hotelDealService = HotelDealController.getInstance();
		city = hotelDealService.getHotelInfo(hotelID).hotelAddress.getCity();
		district = hotelDealService.getHotelInfo(hotelID).hotelAddress.getDistrict();
		businessCircle = hotelDealService.getHotelInfo(hotelID).hotelAddress.getBusinessCircle();
	}

	public void setBirthday(String customerID) {
		MemberController member = MemberController.getInstance();
		this.birthday = member.getMemberInfo(customerID).memberType.getBirthday();
//		this.birthday = LocalDate.of(2016, 12, 4);
	}

	public void setMemberBelongType(String customerID) {
		MemberController memberController = MemberController.getInstance();
		memberBelongType = memberController.getMemberInfo(customerID).memberType.getType();
	}

	public void setEnterprise(String customerID) {
		MemberController memberController = MemberController.getInstance();
		enterprise = memberController.getMemberInfo(customerID).memberType.getCompanyName();
	}

	public void setLevel(String customerID) {
		MemberController memberController = MemberController.getInstance();
		level = memberController.getMemberInfo(customerID).memberType.getLevel();
	}
}
