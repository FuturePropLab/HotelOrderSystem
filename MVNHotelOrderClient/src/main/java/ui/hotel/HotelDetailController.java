package ui.hotel;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import tools.RoomType;
import ui.customer.BookHotelController;
import ui.main.DetailsController;
import ui.room.RoomInfoController;

/**
 * 酒店详情界面的控制器
 * @author zjy
 */
public class HotelDetailController extends DetailsController{
	private static Image yellowStar=new Image("file:./target/resources/images/star__selected.png");
	private static Image greyStar=new Image("file:./target/resources/images/star_unselected.png");
	private static String starArray[]={"1星酒店","2星酒店","3星酒店","4星酒店","5星酒店"};
	
	@FXML
	private ImageView hotelImage;
	@FXML
	private Hyperlink EluxeSuite;
	@FXML
	private Hyperlink Suites;
	@FXML
	private Hyperlink Standard;
	@FXML
	private Hyperlink Double;
	@FXML
	private Hyperlink Single;
	@FXML
	private Button bookEluxeSuite;
	@FXML
	private Button bookSuites;
	@FXML
	private Button bookStandard;
	@FXML
	private Button bookDouble;
	@FXML
	private Button bookSingle;
	@FXML
	private Label hotelNameLabel;//除了酒店工作人员，其他用户可见
	@FXML
	private TextField hotelNameTextField;//只有酒店工作人员可见
	@FXML
	private TextArea describtionTextArea;//只有酒店工作人员可见
	@FXML
	private Text describtionText;//除了酒店工作人员，其他用户可见
	@FXML
	private ImageView star_1;
	@FXML
	private ImageView star_2;
	@FXML
	private ImageView star_3;
	@FXML
	private ImageView star_4;
	@FXML
	private ImageView star_5;
	@FXML
	private Label starLabel;//除了酒店工作人员，其他用户可见
	@FXML
	private ComboBox<String> starComboBox;//只有酒店工作人员可见
	@FXML
	private ImageView mark_1;
	@FXML
	private ImageView mark_2;
	@FXML
	private ImageView mark_3;
	@FXML
	private ImageView mark_4;
	@FXML
	private ImageView mark_5;
	@FXML
	private Label mark;
	@FXML
	private Hyperlink facilities;
	@FXML
	private Hyperlink assess;
	@FXML
	private Label cityLabel;//除了酒店工作人员，其他用户可见
	@FXML
	private Label districtLabel;//除了酒店工作人员，其他用户可见
	@FXML
	private Label businessCircleLabel;//除了酒店工作人员，其他用户可见
	@FXML
	private ComboBox<String> cityComboBox;//只有酒店工作人员可见
	@FXML
	private ComboBox<String> districtComboBox;//只有酒店工作人员可见
	@FXML
	private ComboBox<String> businessCircleComboBox;//只有酒店工作人员可见
	@FXML
	private Label addressLabel;//除了酒店工作人员，其他用户可见
	@FXML
	private TextField addressTextField;//只有酒店工作人员可见
	@FXML
	private Hyperlink save;//只有酒店工作人员可见
	private String hotelID;//TODO:initialize()里设置
	
	/**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	//TODO:从blservice获取数据设置好值
    	if(false){//TODO:如果是客户
    		
    	}
    	else if (true) {//TODO:如果是酒店工作人员
			hotelNameLabel.setVisible(false);
			hotelNameTextField.setVisible(true);
			describtionText.setVisible(false);
			describtionTextArea.setVisible(true);
			starLabel.setVisible(false);
			starComboBox.setVisible(true);
			cityLabel.setVisible(false);
			cityComboBox.setVisible(true);
			districtLabel.setVisible(false);
			districtComboBox.setVisible(true);
			businessCircleLabel.setVisible(false);
			businessCircleComboBox.setVisible(true);
			addressLabel.setVisible(false);
			addressTextField.setVisible(true);
			save.setVisible(true);
			bookEluxeSuite.setDisable(true);
			bookSuites.setDisable(true);
			bookStandard.setDisable(true);
			bookDouble.setDisable(true);
			bookSingle.setDisable(true);
			
			starComboBox.getItems().addAll(starArray);
			cityComboBox.getItems().addAll("南京","Option 1","Option 2");
		}
    	else {
    		bookEluxeSuite.setDisable(true);
			bookSuites.setDisable(true);
			bookStandard.setDisable(true);
			bookDouble.setDisable(true);
			bookSingle.setDisable(true);
		}
    }
	
	/**
	 * bookEluxeSuite被单击时调用
	 */
	@FXML
	private void handleBookEluxeSuite() {
		toBookHotelView(RoomType.EluxeSuite);
	}
	/**
	 * bookSuites被单击时调用
	 */
	@FXML
	private void handleBookSuites() {
		toBookHotelView(RoomType.Suites);
	}
	/**
	 * bookStandard被单击时调用
	 */
	@FXML
	private void handleBookStandard() {
		toBookHotelView(RoomType.Standard);
	}
	/**
	 * bookDouble被单击时调用
	 */
	@FXML
	private void handleBookDouble() {
		toBookHotelView(RoomType.Double);
	}
	/**
	 * bookSingle被单击时调用
	 */
	@FXML
	private void handleBookSingle() {
		toBookHotelView(RoomType.Single);
	}
	@FXML
	private void handleEluxeSuite() {
		toRoomView(RoomType.EluxeSuite);
	}
	@FXML
	private void handleSuites() {
		toRoomView(RoomType.Suites);
	}
	@FXML
	private void handleStandard() {
		toRoomView(RoomType.Standard);
	}
	@FXML
	private void handleDouble() {
		toRoomView(RoomType.Double);
	}
	@FXML
	private void handleSingle() {
		toRoomView(RoomType.Single);
	}
	@FXML
	private void handleHotelImage() {
		//TODO:如果是酒店工作人员就允许他上传图片更换图片，如果是其它用户就不做任何事
	}
	@FXML
	private void handleStarComboBox() {
		int starValue=0;
		for(;starValue<=5;starValue++){
			if(starComboBox.getValue().equals(starArray[starValue])){
				break;
			}
		}
		starValue++;
		star_1.setImage(starValue>=1? yellowStar:greyStar);
		star_2.setImage(starValue>=2? yellowStar:greyStar);
		star_3.setImage(starValue>=3? yellowStar:greyStar);
		star_4.setImage(starValue>=4? yellowStar:greyStar);
		star_5.setImage(starValue>=5? yellowStar:greyStar);
	}
	@FXML
	private void handleFacilities() {
		//TODO:跳转到设施服务界面
	}
	@FXML
	private void handleAssess() {
		//TODO:跳转到评价信息界面
	}
	@FXML
	private void handleCityComboBox() {
		//TODO:从blservice获取相应城市的区的信息
	}
	@FXML
	private void handleDistrictComboBox() {
		//TODO:从blservice获取相应区的商圈的信息
	}
	@FXML
	private void handleSave() {
		//TODO:调用blservice保存酒店信息
	}
	
	private void toBookHotelView(RoomType roomType) {
		try {
			rootLayoutController.changeDetails("../customer/BookHotel.fxml");
			BookHotelController bookHotelController=(BookHotelController)rootLayoutController.getDetailsController();
			bookHotelController.setRoomType(roomType);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void toRoomView(RoomType roomType) {
		try {
			rootLayoutController.changeDetails("../room/RoomInfo.fxml");
			RoomInfoController roomInfoController=(RoomInfoController)rootLayoutController.getDetailsController();
			roomInfoController.setRoomType(roomType);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}