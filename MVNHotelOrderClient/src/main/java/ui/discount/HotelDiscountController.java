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
	private Accordion companyList;
	
	/**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	try {
        	ArrayList<TitledPane> titledPanes = new ArrayList<TitledPane>();
        	ArrayList<CompanyItemController> companyItemControllers = new ArrayList<CompanyItemController>();
        	FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("CompanyItem.fxml"));
        	TitledPane titledPane = (TitledPane) loader.load();
        	System.out.println(1);//test
        	CompanyItemController companyItemController=loader.getController();
        	titledPanes.add(titledPane);
        	companyItemControllers.add(companyItemController);
        	//TODO: 调用blservice查询该优惠策略的信息然后将组建的值设置好
        	
        	companyList.getPanes().addAll(titledPanes);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
