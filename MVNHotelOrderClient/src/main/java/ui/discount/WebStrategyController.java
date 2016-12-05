package ui.discount;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Accordion;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TitledPane;
import ui.main.DetailsController;

/**
 * 酒店优惠策略制定界面的控制器
 * @author zjy
 */
public class WebStrategyController extends DetailsController{

	@FXML 
	private CheckBox notStart;
	@FXML 
	private CheckBox ongoing;
	@FXML 
	private CheckBox deleted;
	@FXML 
	private Accordion specialDayList;
	@FXML 
	private Accordion VIPAndBusinessCircleList;
	@FXML 
	private Accordion VIPLevelAndDiscountList;
	private ArrayList<TitledPane> titledPanes = new ArrayList<TitledPane>();
	private ArrayList<StrategyItemController> strategyItemControllers = new ArrayList<StrategyItemController>();
	
	/**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	initAccordions();
    }
    @FXML
    private void handleFilter() {
    	//TODO:将显示出来的项目按三个checkbox过滤掉不显示的
    }
    
    
    private void initAccordions() {
    	//TODO: 调用blservice查询该策略的信息然后将组建的值设置好
    	
    	//下面是一个例子
    	SpecialDayItemController specialDayItemController=
    			(SpecialDayItemController)addTitlePane(specialDayList,"SpecialDayItem.fxml");
    	specialDayItemController.setValue("未开始", 2.2, new Date(2015, 10, 19), new Date(2015, 10, 20));
    	VIPAndBusinessCircleItemController vipAndBusinessCircleItemController=
    			(VIPAndBusinessCircleItemController)addTitlePane(VIPAndBusinessCircleList,"VIPAndBusinessCircleItem.fxml");
    	vipAndBusinessCircleItemController.setValue("未开始", 2.3, 1, "city", "district", "businessCircle");
    	VIPLevelAndDiscountItemController vipLevelAndDiscountItemController=
    			(VIPLevelAndDiscountItemController)addTitlePane(VIPLevelAndDiscountList,"VIPLevelAndDiscountItem.fxml");
    	vipLevelAndDiscountItemController.setValue("未开始", 2.4, 1, 200);
    	//上面是一个例子
    	
    	addNewItem(ItemType.SpecialDay);
    	addNewItem(ItemType.VIPAndBusinessCircle);
    	addNewItem(ItemType.VIPLevelAndDiscount);
    }
    private StrategyItemController addTitlePane(Accordion accordion,String fxml) {
    	try {       	
        	FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(fxml));
        	TitledPane titledPane = (TitledPane) loader.load();
        	StrategyItemController strategyItemController=loader.getController();
        	strategyItemController.setWebStrategyController(this);
        	titledPanes.add(titledPane);
        	strategyItemControllers.add(strategyItemController);
        	accordion.getPanes().add(titledPane);
        	return strategyItemController;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
    
    /**
     * 增加新的网站策略
     * @param itemType 网站策略类型
     */
    public void addNewItem(ItemType itemType) {
		switch (itemType) {
		case SpecialDay:
			addTitlePane(specialDayList,"SpecialDayItem.fxml");
			break;
		case VIPAndBusinessCircle:
			addTitlePane(VIPAndBusinessCircleList,"VIPAndBusinessCircleItem.fxml");
			break;
		case VIPLevelAndDiscount:
			VIPLevelAndDiscountItemController vipLevelAndDiscountItemController=
			(VIPLevelAndDiscountItemController)addTitlePane(VIPLevelAndDiscountList,"VIPLevelAndDiscountItem.fxml");
			vipLevelAndDiscountItemController.setLevel(VIPLevelAndDiscountList.getPanes().size());
			break;
		default:
			break;
		}
	}
    
    /**
     * 网站策略类型
     * @author zjy
     *
     */
    public enum ItemType{
    	SpecialDay,
    	VIPAndBusinessCircle,
    	VIPLevelAndDiscount,
	}
}
