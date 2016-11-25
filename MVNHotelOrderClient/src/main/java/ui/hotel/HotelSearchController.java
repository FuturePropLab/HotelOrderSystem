package ui.hotel;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import ui.main.DetailsController;

/**
 * 酒店搜索界面的控制器
 * @author zjy
 */
public class HotelSearchController extends DetailsController{
	@FXML
	private SplitMenuButton city;
	@FXML
	private TextField address;
	@FXML
	private DatePicker checkInDate;
	@FXML
	private DatePicker checkOutDate;
	@FXML
	private SplitMenuButton hotelName;
	@FXML
	private SplitMenuButton roomType;
	@FXML
	private SplitMenuButton discount;
	@FXML
	private SplitMenuButton theWayOfOrder;
	@FXML
	private TextField star_from;
	@FXML
	private TextField star_to;
	@FXML
	private TextField mark_from;
	@FXML
	private TextField mark_to;
	@FXML
	private TextField price_from;
	@FXML
	private TextField price_to;
	@FXML
	private CheckBox orderedBefore;
	@FXML
	private Button search;
	
	@FXML
	private void handleSearch(){
		//TODO
	}
}
