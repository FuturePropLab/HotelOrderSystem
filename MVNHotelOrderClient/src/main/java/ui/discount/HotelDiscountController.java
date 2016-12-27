package ui.discount;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import businesslogic.discount.DiscountHotelController;
import businesslogic.login.LoginController;
import businesslogicservice.DiscountHotelService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import tools.DiscountState;
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

	public String hotelID;

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		this.hotelID = LoginController.getInstance().getLogState().accountID;
		initAccordions();
	}
	@FXML
	private void initAccordions() {
		titledPanes.clear();
		hotelItemControllers.clear();
		birthdayList.getPanes().clear();
		companyList.getPanes().clear();
		double11List.getPanes().clear();

		DiscountHotelService discountHotelService = DiscountHotelController.getInstance();
		
		//初始化生日策略
		List<DiscountVO_hotel> birthVOs = discountHotelService.getHotelDiscountByType(hotelID,
				Strategy_hotelType.Birthday);
		Iterator<DiscountVO_hotel> iterator = birthVOs.iterator();
		while (iterator.hasNext()) {
			DiscountVO_hotel dis = iterator.next();
			Birthday_HotelItemController birthdayItemController = (Birthday_HotelItemController) addNewItem(
					Strategy_hotelType.Birthday);
			birthdayItemController.setValue("生日特惠", DiscountState.valid.equals(dis.discountState)?"进行中":"已删除", 
					dis.remarks, dis.discount * 10,dis.startDate, dis.endDate, dis.superimpose, dis.discountID, null); 
			// discount*10为转换为几折几折
		}
		
		//初始化预订多间房策略
		List<DiscountVO_hotel> overThreeVOs = discountHotelService.getHotelDiscountByType(hotelID,
				Strategy_hotelType.OrderMore);
		Iterator<DiscountVO_hotel> iterator_overThree = overThreeVOs.iterator();
		while (iterator_overThree.hasNext()) {
			DiscountVO_hotel dis = iterator_overThree.next();
			OverThreeRooms_HotelItemController overThreeRooms_HotelItemController = (OverThreeRooms_HotelItemController) 
					addNewItem(Strategy_hotelType.OrderMore);
			overThreeRooms_HotelItemController.setValue("预订多间优惠", DiscountState.valid.equals(dis.discountState)?
					"进行中":"已删除", dis.remarks,dis.discount * 10, dis.startDate, dis.endDate, 
					dis.superimpose, dis.discountID, null);
		}
		
		//初始合作企业促销策略
		List<DiscountVO_hotel> enterpriseVOs = discountHotelService.getHotelDiscountByType(hotelID,
				Strategy_hotelType.CooperateEnterprise);
		Iterator<DiscountVO_hotel> iterator_enterprise = enterpriseVOs.iterator();
		while (iterator_enterprise.hasNext()) {
			DiscountVO_hotel dis = iterator_enterprise.next();
			Company_HotelItemController company_HotelItemController = (Company_HotelItemController) addNewItem(
					Strategy_hotelType.CooperateEnterprise);
			company_HotelItemController.setValue("合作企业优惠", DiscountState.valid.equals(dis.discountState)?
					"进行中":"已删除", dis.remarks,dis.discount * 10, dis.startDate, dis.endDate, 
					dis.superimpose, dis.discountID, dis.enterpriseName);
			company_HotelItemController.setCompanyName(dis.enterpriseName);
		}
		
		//初始特定期间促销策略
		List<DiscountVO_hotel> periodVOs = discountHotelService.getHotelDiscountByType(hotelID,
				Strategy_hotelType.Period);
		Iterator<DiscountVO_hotel> iterator_period = periodVOs.iterator();
		while (iterator_period.hasNext()) {
			Period_HotelItemController period_HotelItemController = (Period_HotelItemController) addNewItem(
					Strategy_hotelType.Period);
			DiscountVO_hotel dis = iterator_period.next();
			period_HotelItemController.setValue("特定期间优惠", DiscountState.valid.equals(dis.discountState)?
					"进行中":"已删除", dis.remarks,dis.discount * 10, dis.startDate, dis.endDate, 
					dis.superimpose, dis.discountID, null);
			period_HotelItemController.setFestivalDate(dis.startDate, dis.endDate);
		}
		
		addNewItem(Strategy_hotelType.Birthday);
		addNewItem(Strategy_hotelType.OrderMore);
		addNewItem(Strategy_hotelType.CooperateEnterprise);
		addNewItem(Strategy_hotelType.Period);
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
	 * @param strategy_hotelType 促销策略类型
	 */
	public HotelItemController addNewItem(Strategy_hotelType strategy_hotelType) {
		switch (strategy_hotelType) {
		case Birthday:
			return addTitlePane(birthdayList, "BirthdayItem.fxml");
		case OrderMore:
			return addTitlePane(overThreeRoomsList, "OverThreeRoomsItem.fxml");
		case CooperateEnterprise:
			return addTitlePane(companyList, "CompanyItem.fxml");
		case Period:
			return addTitlePane(double11List, "Period_HotelItem.fxml");
		default:
			break;
		}
		return null;
	}

}
