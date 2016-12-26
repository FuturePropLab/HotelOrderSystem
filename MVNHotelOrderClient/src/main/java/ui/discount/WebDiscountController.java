package ui.discount;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import businesslogic.discount.DiscountWebController;
import businesslogicservice.DiscountWebService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Accordion;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TitledPane;
import tools.DiscountState;
import tools.Strategy_webType;
import ui.main.DetailsController;
import vo.DiscountVO_web;
import vo.DiscountVO_web_district;
import vo.DiscountVO_web_level;
import vo.DiscountVO_web_period;

/**
 * 酒店优惠策略制定界面的控制器
 * 
 * @author zjy
 */
public class WebDiscountController extends DetailsController {

	@FXML
	private CheckBox valid;
	@FXML
	private CheckBox invalid;
	@FXML
	private Accordion specialDayList;
	@FXML
	private Accordion VIPAndBusinessCircleList;
	@FXML
	private Accordion VIPLevelAndDiscountList;
	private ArrayList<TitledPane> titledPanes = new ArrayList<TitledPane>();
	private ArrayList<WebItemController> webItemControllers = new ArrayList<WebItemController>();

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		initAccordions();
	}
	@FXML
	private void initAccordions() {
		DiscountWebService discountWebService = DiscountWebController.getInstance();
		List<DiscountVO_web> listP = new LinkedList<DiscountVO_web>();
		List<DiscountVO_web> listV = new LinkedList<DiscountVO_web>();
		List<DiscountVO_web> listL = new LinkedList<DiscountVO_web>();

		if (valid.isSelected()) {
			listP.addAll(discountWebService.getWebDiscount(Strategy_webType.Period, DiscountState.valid));
			listL.addAll(discountWebService.getWebDiscount(Strategy_webType.Level, DiscountState.valid));
			listV.addAll(discountWebService.getWebDiscount(Strategy_webType.VIP_district, DiscountState.valid));
		}
		if (invalid.isSelected()) {
			listP.addAll(discountWebService.getWebDiscount(Strategy_webType.Period, DiscountState.invalid));
			listL.addAll(discountWebService.getWebDiscount(Strategy_webType.Level, DiscountState.invalid));
			listV.addAll(discountWebService.getWebDiscount(Strategy_webType.VIP_district, DiscountState.invalid));
		}

		// 特点期间促销策略
		Iterator<DiscountVO_web> iterator = listP.iterator();
		while (iterator.hasNext()) {
			DiscountVO_web_period discountVO_web_period = (DiscountVO_web_period) iterator.next();
			Period_WebItemController period_WebItemController = (Period_WebItemController) addNewItem(
					Strategy_webType.Period);
			period_WebItemController.setValue(
					discountVO_web_period.startDate.toString() + " - " + discountVO_web_period.endDate.toString(),
					DiscountState.valid.equals(discountVO_web_period.discountState)?"进行中":"已失效", 
					discountVO_web_period.discount,discountVO_web_period.discountID);
			period_WebItemController.setValue(discountVO_web_period.startDate, discountVO_web_period.endDate);
		}

		// 商圈促销策略
		Iterator<DiscountVO_web> iterator2 = listV.iterator();
		while (iterator2.hasNext()) {
			DiscountVO_web_district discountVO_web_district = (DiscountVO_web_district) iterator2.next();
			VIPAndBusinessCircle_WebItemController vipAndBusinessCircleItemController = 
					(VIPAndBusinessCircle_WebItemController) addNewItem(Strategy_webType.VIP_district);
			vipAndBusinessCircleItemController.setValue(discountVO_web_district.businessCircle,
					DiscountState.valid.equals(discountVO_web_district.discountState)?"进行中":"已失效", 
					discountVO_web_district.discount,discountVO_web_district.discountID);
			vipAndBusinessCircleItemController.setValue(discountVO_web_district.level, discountVO_web_district.city,
					discountVO_web_district.district, discountVO_web_district.businessCircle);
		}

		// 会员等级促销策略
		Iterator<DiscountVO_web> iterator3 = listL.iterator();
		while (iterator3.hasNext()) {
			DiscountVO_web_level discountVO_web_level = (DiscountVO_web_level) iterator3.next();
			VIPLevelAndDiscount_WebItemController vipLevelAndDiscountItemController = 
					(VIPLevelAndDiscount_WebItemController) addNewItem(Strategy_webType.Level);
			vipLevelAndDiscountItemController.setValue(String.valueOf(discountVO_web_level.level),
					DiscountState.valid.equals(discountVO_web_level.discountState)?"进行中":"已失效", 
					discountVO_web_level.discount,discountVO_web_level.discountID);
			vipLevelAndDiscountItemController.setValue(discountVO_web_level.level, discountVO_web_level.levelUpCredit);
		}

		addNewItem(Strategy_webType.Period);
		addNewItem(Strategy_webType.VIP_district);
		addNewItem(Strategy_webType.Level);
	}

	private WebItemController addTitlePane(Accordion accordion, String fxml) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource(fxml));
			TitledPane titledPane = (TitledPane) loader.load();
			WebItemController webItemController = loader.getController();
			webItemController.setWebStrategyController(this);
			titledPanes.add(titledPane);
			webItemControllers.add(webItemController);
			accordion.getPanes().add(titledPane);
			return webItemController;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 增加新的网站策略
	 * 
	 * @param strategy_webType
	 *            网站策略类型
	 */
	public WebItemController addNewItem(Strategy_webType strategy_webType) {
		switch (strategy_webType) {
		case Period:
			return addTitlePane(specialDayList, "Period_WebItem.fxml");
		case VIP_district:
			return addTitlePane(VIPAndBusinessCircleList, "VIPAndBusinessCircleItem.fxml");
		case Level:
			VIPLevelAndDiscount_WebItemController vipLevelAndDiscountItemController = 
			(VIPLevelAndDiscount_WebItemController) addTitlePane(
					VIPLevelAndDiscountList, "VIPLevelAndDiscountItem.fxml");
			vipLevelAndDiscountItemController.setLevel(VIPLevelAndDiscountList.getPanes().size());
			return vipLevelAndDiscountItemController;
		default:
			break;
		}
		return null;
	}

}
