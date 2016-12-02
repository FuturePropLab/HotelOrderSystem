package ui.hotel;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import tools.RoomType;
import ui.customer.BookHotelController;
import ui.main.DetailsController;
import ui.main.RootLayoutController;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

/**
 * 酒店详情界面的控制器
 * @author zjy
 */
public class HotelDetailController extends DetailsController{
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
	private Label hotelName;
	@FXML
	private TextArea describtion;
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
	private Label star;
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
	private Label address;
	
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
	private void handleHotelImage() {
		//TODO
	}
	@FXML
	private void handleHotelName() {
		//TODO
	}
	@FXML
	private void handleDescribtion() {
		//TODO
	}
	@FXML
	private void handleStar() {
		//TODO
	}
	@FXML
	private void handleFacilities() {
		//TODO
	}
	@FXML
	private void handleAssess() {
		//TODO
	}
	@FXML
	private void handleAddress() {
		//TODO
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
}