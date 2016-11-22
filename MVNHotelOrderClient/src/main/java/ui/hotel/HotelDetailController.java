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
import javafx.scene.control.Label;

/**
 * 酒店详情界面的控制器
 * @author zjy
 */
public class HotelDetailController extends DetailsController{
	@FXML
	private ImageView hotelImage;
	@FXML
	private Label EluxeSuite;
	@FXML
	private Label Suites;
	@FXML
	private Label Standard;
	@FXML
	private Label Double;
	@FXML
	private Label Single;
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
	private AnchorPane introduction;
	@FXML
	private AnchorPane facilities;
	@FXML
	private AnchorPane assessment;
	
	/**
	 * bookEluxeSuite被单击时调用
	 */
	@FXML
	private void handleBookEluxeSuite() {
		toBookHotelView();
		BookHotelController bookHotelController=(BookHotelController)rootLayoutController.getDetailsController();
		bookHotelController.setRoomType(RoomType.EluxeSuite);
	}
	/**
	 * bookSuites被单击时调用
	 */
	@FXML
	private void handleBookSuites() {
		toBookHotelView();
		BookHotelController bookHotelController=(BookHotelController)rootLayoutController.getDetailsController();
		bookHotelController.setRoomType(RoomType.Suites);
	}
	/**
	 * bookStandard被单击时调用
	 */
	@FXML
	private void handleBookStandard() {
		toBookHotelView();
		BookHotelController bookHotelController=(BookHotelController)rootLayoutController.getDetailsController();
		bookHotelController.setRoomType(RoomType.Standard);
	}
	/**
	 * bookDouble被单击时调用
	 */
	@FXML
	private void handleBookDouble() {
		toBookHotelView();
		BookHotelController bookHotelController=(BookHotelController)rootLayoutController.getDetailsController();
		bookHotelController.setRoomType(RoomType.Double);
	}
	/**
	 * bookSingle被单击时调用
	 */
	@FXML
	private void handleBookSingle() {
		toBookHotelView();
		BookHotelController bookHotelController=(BookHotelController)rootLayoutController.getDetailsController();
		bookHotelController.setRoomType(RoomType.Single);
	}
	
	private void toBookHotelView() {
		try {
			rootLayoutController.changeDetails("../customer/BookHotel.fxml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}