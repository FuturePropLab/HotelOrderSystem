package ui.hotel;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import Exception.NoSuchValueException;
import Exception.OutOfBoundsException;
import businesslogicservice.HotelDealService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import stub.HotelDeal_Stub;
import tools.PriceRange;
import tools.RoomType;
import tools.Star;
import ui.main.DetailsController;
import vo.HotelbriefVO;
import vo.SearchHotelVO;

/**
 * 酒店搜索界面的控制器
 * @author zjy
 */
public class HotelSearchController extends DetailsController{
	@FXML
	private TextField keyWords;
	@FXML
	private ComboBox<String> city;
	@FXML
	private ComboBox<String> district;//区，如栖霞区
	@FXML
	private ComboBox<String> businessCircle;//商圈
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
	@FXML
	private FlowPane hotelList;
	
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
    	handleSearch();
    }
	
	@FXML
	private void handleSearch(){
		HotelDealService hotelDealService=new HotelDeal_Stub();//TODO:stub换成实例化的service
		try {
			SearchHotelVO searchHotelVO=new SearchHotelVO(city.getValue(), district.getValue(), businessCircle.getValue(),
					hotelName.getText(), getPriceRange(), getStar(), getRoomType(),orderedBefore.isSelected());
			List<HotelbriefVO> voList=hotelDealService.SearchHotel(searchHotelVO);
			initHotelItems(voList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@FXML
	private void handleCity(){
		//TODO:调用blservice设置district的值
	}
	@FXML
	private void handleDistrict(){
		//TODO:调用blservice设置businessCircle的值
	}
	@FXML
	private void handleKeyWords(){
		//TODO:调用blservice模糊搜索
	}
	
	private void initHotelItems(List<HotelbriefVO> voList) throws IOException {
    	hotelList.getChildren().clear();
		for(HotelbriefVO hotelInfoVO:voList){
	    	FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(getClass().getResource("HotelItem.fxml"));
	    	SplitPane item = (SplitPane) loader.load();
	    	hotelList.getChildren().addAll(item);
	    	HotelItemController hotelItemController=loader.getController();
	    	hotelItemController.setValues(new Image(hotelInfoVO.imageuri.toString()), hotelInfoVO.hotelName, hotelInfoVO.star, hotelInfoVO.mark, 
	    			hotelInfoVO.priceRange.lowest, hotelInfoVO.priceRange.higest, hotelInfoVO.hotelID, this);
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
	
	/**
	 * 跳转到酒店详情界面
	 */
	public void toHotelDetailUI(String hotelID) {
		try {
			rootLayoutController.changeDetails("../hotel/HotelDetail.fxml");
			//TODO 获取相应的酒店详细信息并设置好值
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 跳转到订单填写界面
	 */
	public void toBookHotelUI(String hotelID) {
		try {
			rootLayoutController.changeDetails("../customer/BookHotel.fxml");
			//TODO 在订单填写界面写上相应的酒店信息
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
