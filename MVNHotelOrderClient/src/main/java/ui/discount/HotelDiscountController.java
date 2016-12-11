package ui.discount;

import java.io.IOException;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import businesslogic.discount.DiscountHotelController;
import businesslogic.login.LoginController;
import businesslogicservice.DiscountHotelService;
import dataservice.DiscountHotelDataService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import po.DiscountPO_hotel;
import rmi.RemoteHelper;
import tools.Strategy_hotelType;
import ui.main.DetailsController;
import vo.DiscountVO_hotel;

/**
 * 酒店优惠策略制定界面的控制器
 * 
 * @author zjy
 */
public class HotelDiscountController extends DetailsController {

	@FXML
	private Accordion birthdayList;
	@FXML
	private Accordion overThreeRoomsList;
	@FXML
	private Accordion companyList;
	@FXML
	private Accordion double11List;
	private ArrayList<TitledPane> titledPanes = new ArrayList<TitledPane>();
	private ArrayList<HotelItemController> hotelItemControllers = new ArrayList<HotelItemController>();

	public String hotelID ;
//	= "HT001"; // 以后处理这个id的获取方式 @lwy

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		initAccordions();
		this.hotelID = LoginController.getInstance().getLogState().accountID;
	}

	private void initAccordions() {
		// TODO: 调用blservice查询该优惠策略的信息然后将组建的值设置好

		DiscountHotelService discountHotelService = DiscountHotelController.getInstance();
		List<DiscountVO_hotel> discountVO_hotels = discountHotelService.getHotelDiscount(hotelID);

		List<DiscountVO_hotel> birthVOs = discountHotelService.getHotelDiscountByType(hotelID,
				Strategy_hotelType.Birthday);
		Iterator<DiscountVO_hotel> iterator = birthVOs.iterator();
		while (iterator.hasNext()) {
			DiscountVO_hotel dis = iterator.next();
			Birthday_HotelItemController birthdayItemController = (Birthday_HotelItemController) addTitlePane(
					birthdayList, "BirthdayItem.fxml");
			birthdayItemController.setValue("生日特惠", dis.discountState.toString(), dis.remarks, dis.discount * 10,
					dis.startDate, dis.endDate, dis.superimpose,dis.discountID); // discount*10为转换为几折几折

		}

		List<DiscountVO_hotel> overThreeVOs = discountHotelService.getHotelDiscountByType(hotelID,
				Strategy_hotelType.OrderMore);
		Iterator<DiscountVO_hotel> iterator2 = overThreeVOs.iterator();
		while (iterator2.hasNext()) {
			DiscountVO_hotel dis2 = iterator2.next();
			OverThreeRooms_HotelItemController overThreeRooms_HotelItemController = (OverThreeRooms_HotelItemController) addTitlePane(
					overThreeRoomsList, "OverThreeRoomsItem.fxml");
			overThreeRooms_HotelItemController.setValue("预订多间优惠", dis2.discountState.toString(), dis2.remarks,
					dis2.discount * 10, dis2.startDate, dis2.endDate, dis2.superimpose,dis2.discountID);
		}

		List<DiscountVO_hotel> enterpriseVOs = discountHotelService.getHotelDiscountByType(hotelID,
				Strategy_hotelType.CooperateEnterprise);
		Iterator<DiscountVO_hotel> iterator3 = enterpriseVOs.iterator();
		while (iterator3.hasNext()) {
			DiscountVO_hotel dis3 = iterator3.next();
			Company_HotelItemController company_HotelItemController = (Company_HotelItemController) addTitlePane(
					companyList, "CompanyItem.fxml");
			company_HotelItemController.setValue("合作企业优惠", dis3.discountState.toString(), dis3.remarks,
					dis3.discount * 10, dis3.startDate, dis3.endDate, dis3.superimpose,dis3.discountID);
			company_HotelItemController.setCompanyName(dis3.enterpriseName);
		}
		
		List<DiscountVO_hotel> periodVOs = discountHotelService.getHotelDiscountByType(hotelID,
				Strategy_hotelType.Period);
		Iterator<DiscountVO_hotel> iterator4 = enterpriseVOs.iterator();
		while (iterator4.hasNext()) {
			Period_HotelItemController period_HotelItemController = (Period_HotelItemController) addTitlePane(double11List,
					"Period_HotelItem.fxml");
			DiscountVO_hotel dis4 = iterator4.next();
			period_HotelItemController.setValue("特定期间优惠", dis4.discountState.toString(), dis4.remarks,
					dis4.discount * 10, dis4.startDate, dis4.endDate, dis4.superimpose,dis4.discountID);
			period_HotelItemController.setFestivalDate(dis4.startDate, dis4.endDate);
		}

		addTitlePane(birthdayList, "BirthdayItem.fxml");
		addTitlePane(overThreeRoomsList, "OverThreeRoomsItem.fxml");
		addTitlePane(companyList, "CompanyItem.fxml");
		addTitlePane(double11List, "Period_HotelItem.fxml");
	}

	private HotelItemController addTitlePane(Accordion accordion, String fxml) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource(fxml));
			TitledPane titledPane = (TitledPane) loader.load();
			HotelItemController hotelItemController = loader.getController();
			hotelItemController.setHotelDiscountController(this);
			titledPanes.add(titledPane);
			hotelItemControllers.add(hotelItemController);
			accordion.getPanes().add(titledPane);
			return hotelItemController;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 增加新的促销策略
	 * 
	 * @param itemType
	 *            促销策略类型
	 */
	public void addNewItem(ItemType itemType) {
		switch (itemType) {
		case BIRTHDAY:
			addTitlePane(birthdayList, "BirthdayItem.fxml");
			break;
		case OVER_THREE_ROOMS:
			addTitlePane(overThreeRoomsList, "OverThreeRoomsItem.fxml");
			break;
		case COMPANY:
			addTitlePane(companyList, "CompanyItem.fxml");
			break;
		case DOUBLE11:
			addTitlePane(double11List, "Period_HotelItem.fxml");
			break;
		default:
			break;
		}
	}

	/**
	 * 促销策略类型
	 * 
	 * @author zjy
	 *
	 */
	public enum ItemType {
		BIRTHDAY, OVER_THREE_ROOMS, COMPANY, DOUBLE11
	}
}
