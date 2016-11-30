package ui.discount;

import java.io.IOException;
import java.util.ArrayList;

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
	
	/**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	initAccordions(birthdayList,"BirthdayItem.fxml");
    	initAccordions(overThreeRoomsList,"OverThreeRoomsItem.fxml");
    	initAccordions(companyList,"CompanyItem.fxml");
    	initAccordions(double11List,"Double11Item.fxml");
    }
    
    
    private void initAccordions(Accordion accordion,String fxml) {
    	try {
        	ArrayList<TitledPane> titledPanes = new ArrayList<TitledPane>();
        	ArrayList<ItemController> itemControllers = new ArrayList<ItemController>();
        	
        	FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(fxml));
        	TitledPane titledPane = (TitledPane) loader.load();
        	ItemController itemController=loader.getController();
        	titledPanes.add(titledPane);
        	itemControllers.add(itemController);
        	
        	//TODO: 调用blservice查询该优惠策略的信息然后将组建的值设置好
        	
        	accordion.getPanes().addAll(titledPanes);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
