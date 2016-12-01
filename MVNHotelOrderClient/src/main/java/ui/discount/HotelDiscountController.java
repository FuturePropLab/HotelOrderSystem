package ui.discount;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import ui.main.DetailsController;

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
	private ArrayList<ItemController> itemControllers = new ArrayList<ItemController>();
	
	/**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	initAccordions();
    }
    
    
    private void initAccordions() {
    	//TODO: 调用blservice查询该优惠策略的信息然后将组建的值设置好
    	
    	//下面是一个例子
    	BirthdayItemController birthdayItemController=(BirthdayItemController)addTitlePane(birthdayList,"BirthdayItem.fxml");
    	birthdayItemController.setValue("title", "未开始", "无", 9.5, new Date(2015, 10, 19), new Date(2015, 10, 20), true);
    	OverThreeRoomsItemController overThreeRoomsItemController=(OverThreeRoomsItemController)addTitlePane(overThreeRoomsList,"OverThreeRoomsItem.fxml");
    	overThreeRoomsItemController.setValue("title", "未开始", "无", 9.5, new Date(2015, 10, 19), new Date(2015, 10, 20), true);
    	CompanyItemController companyItemController=(CompanyItemController)addTitlePane(companyList,"CompanyItem.fxml");
    	companyItemController.setValue("title", "未开始", "无", 9.5, new Date(2015, 10, 19), new Date(2015, 10, 20), true);
    	companyItemController.setCompanyName("companyName");
    	Double11ItemController double11ItemController=(Double11ItemController)addTitlePane(double11List,"Double11Item.fxml");
    	double11ItemController.setValue("title", "未开始", "无", 9.5, new Date(2015, 10, 19), new Date(2015, 10, 20), true);
    	double11ItemController.setFestivalDate(new Date(2015, 10, 19),new Date(2015, 10, 19));
    	//上面是一个例子
    	
    	addTitlePane(birthdayList,"BirthdayItem.fxml");
    	addTitlePane(overThreeRoomsList,"OverThreeRoomsItem.fxml");
    	addTitlePane(companyList,"CompanyItem.fxml");
    	addTitlePane(double11List,"Double11Item.fxml");
    }
    private ItemController addTitlePane(Accordion accordion,String fxml) {
    	try {       	
        	FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(fxml));
        	TitledPane titledPane = (TitledPane) loader.load();
        	ItemController itemController=loader.getController();
        	itemController.setHotelDiscountController(this);
        	titledPanes.add(titledPane);
        	itemControllers.add(itemController);
        	accordion.getPanes().add(titledPane);
        	return itemController;
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
