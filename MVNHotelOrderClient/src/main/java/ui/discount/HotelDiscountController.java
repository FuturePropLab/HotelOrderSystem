package ui.discount;

import java.io.IOException;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import businesslogic.discount.DiscountHotelController;
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
 * @author zjy
 */
public class HotelDiscountController extends DetailsController{

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
	
	
	private String hotelID = "HT001";  //以后处理这个id的获取方式  @lwy
	
	/**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	initAccordions();
    }
    
    
    private void initAccordions()  {
    	//TODO: 调用blservice查询该优惠策略的信息然后将组建的值设置好
    	
//    	
//    	DiscountHotelService discountHotelService = DiscountHotelController.getInstance();
//    	
//    	DiscountHotelDataService hotelDataService = RemoteHelper.getInstance().getDiscountHotelDataService();
    	//List<DiscountVO_hotel> discountVO_hotels = discountHotelService.getHotelDiscount(hotelID);
//    			discountHotelService.getHotelDiscountByType(hotelID, Strategy_hotelType.CooperateEnterprise);
  
//    	while(it.hasNext()){
//    		DiscountVO_hotel dis = it.next();
//    		BirthdayItemController birthdayItemController=(BirthdayItemController)addTitlePane(birthdayList,"BirthdayItem.fxml");
//        	birthdayItemController.setValue("biaoti", dis.discountState.toString(), 
//        			dis.remarks, dis.discount, (Date)dis.startDate, (Date)dis.endDate, true);
//        	
//    	}
    	//下面是一个例子
    	Birthday_HotelItemController birthday_HotelItemController=(Birthday_HotelItemController)addTitlePane(birthdayList,"BirthdayItem.fxml");
    	birthday_HotelItemController.setValue("title", "未开始", "无", 9.5, LocalDate.of(2016, 12, 4),LocalDate.of(2016, 12, 6), true);
    	OverThreeRooms_HotelItemController overThreeRooms_HotelItemController=(OverThreeRooms_HotelItemController)addTitlePane(overThreeRoomsList,"OverThreeRoomsItem.fxml");
    	overThreeRooms_HotelItemController.setValue("title", "未开始", "无", 9.5, LocalDate.of(2016, 12, 4),LocalDate.of(2016, 12, 6), true);
//    	while(it.hasNext()){
        	Company_HotelItemController company_HotelItemController=(Company_HotelItemController)addTitlePane(companyList,"CompanyItem.fxml");
//
//    		DiscountPO_hotel dis = it.next();
//    		System.out.println(dis.getDiscount_id());
//    		companyItemController.setValue("biaoti", dis.getDiscountState().toString(), 
//        			dis.getRemarks(), dis.getDiscount(), new Date(), new Date(), dis.isSuperimpose());
//    		companyItemController.setCompanyName(dis.getEnterpriseName());
//    		addTitlePane(companyList,"CompanyItem.fxml");
////        	
//    	}
    	
    	company_HotelItemController.setValue("title", "未开始", "无", 9.5, LocalDate.of(2016, 12, 4),LocalDate.of(2016, 12, 6), true);
    	company_HotelItemController.setCompanyName("companyName");
    	Period_HotelItemController period_HotelItemController=(Period_HotelItemController)addTitlePane(double11List,"Double11Item.fxml");
    	period_HotelItemController.setValue("title", "未开始", "无", 9.5, LocalDate.of(2016, 12, 4),LocalDate.of(2016, 12, 6), true);
    	period_HotelItemController.setFestivalDate(LocalDate.of(2016, 12, 4),LocalDate.of(2016, 12, 6));
    	//上面是一个例子
    	
    	addTitlePane(birthdayList,"BirthdayItem.fxml");
    	addTitlePane(overThreeRoomsList,"OverThreeRoomsItem.fxml");
    	
    	addTitlePane(double11List,"Double11Item.fxml");
    }
    private HotelItemController addTitlePane(Accordion accordion,String fxml) {
    	try {       	
        	FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(fxml));
        	TitledPane titledPane = (TitledPane) loader.load();
        	HotelItemController hotelItemController=loader.getController();
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
     * @param itemType 促销策略类型
     */
    public void addNewItem(ItemType itemType) {
		switch (itemType) {
		case BIRTHDAY:
			addTitlePane(birthdayList,"BirthdayItem.fxml");
			break;
		case OVER_THREE_ROOMS:
			addTitlePane(overThreeRoomsList,"OverThreeRoomsItem.fxml");
			break;
		case COMPANY:
			addTitlePane(companyList,"CompanyItem.fxml");
			break;
		case DOUBLE11:
			addTitlePane(double11List,"Double11Item.fxml");
			break;
		default:
			break;
		}
	}
    
    /**
     * 促销策略类型
     * @author zjy
     *
     */
    public enum ItemType{
		BIRTHDAY,
		OVER_THREE_ROOMS,
		COMPANY,
		DOUBLE11
	}
}
