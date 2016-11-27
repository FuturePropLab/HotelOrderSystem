package ui.hotel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Exception.NoSuchValueException;
import Exception.OutOfBoundsException;
import businesslogicservice.HotelDealService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import stub.HotelDeal_Stub;
import tools.DateRange;
import tools.PriceRange;
import tools.RoomType;
import tools.Star;
import ui.main.DetailsController;
import vo.HotelInfoVO;
import vo.SearchHotelVO;

/**
 * 酒店搜索界面的控制器
 * @author zjy
 */
public class HotelSearchController extends DetailsController{
	@FXML
	private ComboBox<String> city;
	@FXML
	private TextField district;
	@FXML
	private DatePicker checkInDate;
	@FXML
	private DatePicker checkOutDate;
	@FXML
	private TextField hotelName;
	@FXML
	private ComboBox<String> roomType;
	@FXML
	private ComboBox<String> theWayOfOrder;
	@FXML
	private ComboBox<String> star;
	@FXML
	private TextField price_from;
	@FXML
	private TextField price_to;
	@FXML
	private CheckBox orderedBefore;
	@FXML
	private Button search;
	
	/**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	city.getItems().addAll("南京","Option 1","Option 2");
    	star.getItems().addAll("1星","2星","3星","4星","5星");
    	roomType.getItems().addAll("标准间","单人间","双人间","豪华套房","总统套房");
    	theWayOfOrder.getItems().addAll("Option 1","Option 2","Option 3");
    }
	
	@FXML
	private void handleSearch(){
		HotelDealService hotelDealService=new HotelDeal_Stub();//stub
		try {
			SearchHotelVO searchHotelVO=new SearchHotelVO(city.getValue(), district.getText(), hotelName.getText(), 
					getRoomType(), getPriceRange(), 
					new DateRange(getDate(checkInDate),getDate(checkOutDate)), getStar(), orderedBefore.isSelected());
			List<HotelInfoVO> hotelList=hotelDealService.SearchHotel(searchHotelVO);
			//TODO
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private RoomType getRoomType() throws NoSuchValueException{
		if(roomType.getValue()==null){
			return null;
		}
		RoomType[] types={RoomType.Standard,RoomType.Single,RoomType.Double,RoomType.Suites,RoomType.EluxeSuite};
		String[] texts={"标准间","单人间","双人间","豪华套房","总统套房"};
		int index;
		for(index=0;index<texts.length;index++){
			if(roomType.getValue().equals(texts[index])){
				return types[index];
			}
		}
		throw new NoSuchValueException();
	}
	
	private Star getStar() throws NoSuchValueException{
		if(star.getValue()==null){
			return null;
		}
		Star[] types={Star.one,Star.two,Star.three,Star.four,Star.five};
		String[] texts={"1星","2星","3星","4星","5星"};
		int index;
		for(index=0;index<texts.length;index++){
			if(star.getValue().equals(texts[index])){
				return types[index];
			}
		}
		throw new NoSuchValueException();
	}
	
	private Date getDate(DatePicker datePicker) {
		if(datePicker.getValue()==null){
			return null;
		}
		return new Date(datePicker.getValue().getYear(), datePicker.getValue().getMonthValue(), 
				datePicker.getValue().getDayOfMonth());
	}
	
	private PriceRange getPriceRange() throws NumberFormatException, OutOfBoundsException {
		if(price_from.getText()==null || price_to.getText()==null){
			return null;
		}
		else if (price_from.getText().equals("") || price_to.getText().equals("")) {
			return null;
		}
		return new PriceRange(Integer.parseInt(price_from.getText()), Integer.parseInt(price_to.getText()));
	}
}
