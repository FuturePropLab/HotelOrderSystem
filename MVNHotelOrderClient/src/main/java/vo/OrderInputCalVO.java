package vo;

import java.time.LocalDate;

import businesslogic.member.MemberController;
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
	 * @param roomType
	 *            房间类型
	 * @param numberOfRooms
	 *            预订的房间数量
	 */
	public OrderInputCalVO(double price, String customerID, String hotelID, LocalDate startDate, LocalDate endDate,
			RoomType roomType, int numberOfRooms) {
		super();
		this.price = price;
		this.customerID = customerID;
		this.startDate = startDate;
		this.endDate = endDate;
		this.hotelID = hotelID;
		this.roomType = roomType;
		this.numberOfRooms = numberOfRooms;

		setMemberBelongType(customerID);
		setDays(startDate, endDate);
		if (memberBelongType == MemberBelongType.Ordinary) {
			setBirthday(customerID);
		} else if (memberBelongType == MemberBelongType.Enterprise) {

		}
	}

	public double price;// 订房单价
	public String customerID;
	public String hotelID;
	public LocalDate startDate;
	public LocalDate endDate;
	public RoomType roomType;
	public int numberOfRooms;

	public int days;// 计算需要,为订多少天
	public MemberBelongType memberBelongType;
	public LocalDate birthday;
	public String enterprise;

	/**
	 * @param price
	 * 
	 * @param customer_ID
	 * 
	 * @param hotelID
	 * 
	 * @param startDate
	 * @param endDate
	 * 
	 * @param roomType
	 * 
	 * @param hotelID
	 * @param numberOfRooms
	 * 
	 */

	public void setDays(LocalDate start, LocalDate end) {
		this.days = (int)(end.toEpochDay()-start.toEpochDay());

	}

	public void setBirthday(String customerID) {
		MemberController member = MemberController.getInstance();
		this.birthday = member.getMemberInfo(customerID).memberType.getBirthday();
	}

	public void setMemberBelongType(String customerID) {
		MemberController memberController = MemberController.getInstance();
		memberBelongType = memberController.getMemberInfo(customerID).memberType.getType();
	}

	public void setEnterprise(String customerID) {
		MemberController memberController = MemberController.getInstance();
		enterprise = memberController.getMemberInfo(customerID).memberType.getCompanyName();
	}
}
