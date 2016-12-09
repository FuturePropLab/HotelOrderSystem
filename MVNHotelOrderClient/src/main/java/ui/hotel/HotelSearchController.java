package ui.hotel;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import Exception.NoSuchValueException;
import Exception.OutOfBoundsException;
import businesslogic.hotel.HotelDealController;
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
import javafx.scene.layout.FlowPane;
import tools.PriceRange;
import tools.RoomType;
import tools.SortType;
import tools.Star;
import ui.customer.BookHotelController;
import ui.main.DetailsController;
import vo.HotelDetailsVO;
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
	
	private HotelDealService hotelDealService;
	/**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	HotelDealService hotelDealService= HotelDealController.getInstance();
    	city.getItems().addAll(hotelDealService.getAllCity());
    	star.getItems().addAll("所有","1星","2星","3星","4星","5星");
    	roomType.getItems().addAll("标准间","单人间","双人间","豪华套房","总统套房");
    	theWayOfOrder.getItems().addAll("价格","星级","评分");
    	handleSearch();
    }
	
	@FXML
	private void handleSearch(){
		HotelDealService hotelDealService= HotelDealController.getInstance();
		try {
			System.out.println("DO SEARCH:   "+city.getValue() );
			SearchHotelVO searchHotelVO=new SearchHotelVO(city.getValue(), district.getValue(), businessCircle.getValue(),
					hotelName.getText(), getPriceRange(), getStar(), getRoomType(),orderedBefore.isSelected());
			System.out.println("ok????");
			List<HotelbriefVO> voList=hotelDealService.SearchHotel(searchHotelVO);
			System.out.println(voList==null);
			//SortType sortType = 
			System.out.println(getSortType());
			List<HotelbriefVO> voListsort = hotelDealService.SortHotel(voList, getSortType());
			//if(voList!=null && !voList.isEmpty())
			initHotelItems(voListsort);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@FXML
	private void handleCity(){
		//System.out.println("Before CLEAR:   "+city.getValue());
		district.getItems().clear();
		//System.out.println("AFTER CLEAR:   "+city.getValue());
		businessCircle.getItems().clear();
		HotelDealService hotelDealService= HotelDealController.getInstance();
		if(city.getValue()!=null && !"".equals(city.getValue())){
			district.getItems().addAll(hotelDealService.getAllDistrictByCity(city.getValue()));
		}
		
		
		handleSearch();
		
	}
	@FXML
	private void handleDistrict(){
		businessCircle.getItems().clear();
		HotelDealService hotelDealService= HotelDealController.getInstance();
		if(district.getValue()!=null && !"".equals(district.getValue())){
			businessCircle.getItems().addAll(hotelDealService.getBusineeCircleByDistrict(district.getValue()));
		}
		handleSearch();

	}
	@FXML
	private void handleKeyWords(){
		HotelDealService hotelDealService= HotelDealController.getInstance();
		List<HotelbriefVO> voList=hotelDealService.searchHotelListFuzzy(keyWords.getText());
		System.out.println(voList==null);
		System.out.println(getSortType());
		List<HotelbriefVO> voListsort = hotelDealService.SortHotel(voList, getSortType());
		if(voList!=null && !voList.isEmpty());
		//if(voList!=null && !voList.isEmpty())
		try {
			initHotelItems(voListsort);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//TODO:调用blservice模糊搜索
		
		
	}
	
	@FXML
	private void handleSort(){
		System.out.println("handleSort()");
		String citystr = city.getValue();
		String keystr = keyWords.getText();
		if(citystr!=null && !"".equals(citystr)){
			handleSearch();
		}else if(keystr!=null && !"".equals(keystr)){
			handleKeyWords();
		}
	}
	
	@FXML
	private void handleBusiness(){
		handleSearch();
		//
	}
	
	
	private void initHotelItems(List<HotelbriefVO> voList) throws IOException {
    	hotelList.getChildren().clear();
    	System.out.println("after clear!!!!!");
    	if(voList!=null && !voList.isEmpty())
		for(HotelbriefVO hotelInfoVO:voList){
			System.out.println(hotelInfoVO.hotelName);
			System.out.println(hotelInfoVO.priceRange.lowest);
			System.out.println(hotelInfoVO.priceRange.higest);
	    	FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(getClass().getResource("HotelItem.fxml"));
	    	SplitPane item = (SplitPane) loader.load();
	    	hotelList.getChildren().addAll(item);
	    	HotelItemController hotelItemController=loader.getController();
	    	//defense  by wsw
	    	Image image = null;
	    	if(hotelInfoVO.imageuri!=null)
	    		image = new Image(hotelInfoVO.imageuri.toString());
	    
	    	hotelItemController.setValues(image, hotelInfoVO.hotelName, hotelInfoVO.star, hotelInfoVO.mark, 
	    			hotelInfoVO.priceRange.lowest, hotelInfoVO.priceRange.higest, hotelInfoVO.hotelID, this);
		}
	}
	
	private RoomType getRoomType() throws NoSuchValueException{
		if(roomType.getValue()==null){
			return null;
		}
		RoomType[] types={null,RoomType.Standard,RoomType.Single,RoomType.Double,RoomType.Suites,RoomType.EluxeSuite};
		String[] texts={"所有","标准间","单人间","双人间","豪华套房","总统套房"};
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
		Star[] types={null,Star.one,Star.two,Star.three,Star.four,Star.five};
		String[] texts={"所有","1星","2星","3星","4星","5星"};
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
	
	private SortType getSortType(){
		if(theWayOfOrder.getValue()==null) 
			return SortType.Price;
		SortType[] types={SortType.Price,SortType.Star,SortType.grade};
		String[] texts={"价格","星级","评分"};
		int index;
		for(index=0;index<texts.length;index++){
			if(theWayOfOrder.getValue().equals(texts[index])){
				return types[index];
			}
		}
		return SortType.Price;
	}
	
	/**
	 * 跳转到酒店详情界面
	 */
	public void toHotelDetailUI(String hotelID) {
		try {
			rootLayoutController.changeDetails("../hotel/HotelDetail.fxml");
			//TODO 获取相应的酒店详细信息并设置好值
			//hotelDealService = HotelDealController.getInstance();
			//HotelDetailsVO hotelDeatails= hotelDealService.getHotelDetailsVO(hotelID);
			HotelDetailController hotelDetail = (HotelDetailController) rootLayoutController.getDetailsController();
			hotelDetail.initValue(hotelID);
			
			
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
			

			BookHotelController bookHotelController = 
					(BookHotelController) rootLayoutController.getDetailsController();
			

			bookHotelController = (BookHotelController)rootLayoutController.getDetailsController();

			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
