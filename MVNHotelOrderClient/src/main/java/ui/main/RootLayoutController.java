package ui.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tools.RoomType;
import ui.customer.BookHotelController;
import ui.customer.ClientInfoController;
import ui.customer.OrderAssessController;
import ui.guid.GuideUIController;
import ui.hotel.FacilitiesInfoController;

/**
 * The controller for the root layout. The root layout provides the basic
 * application layout.
 * 
 * @author zjy
 */
public class RootLayoutController {
	private FullLayoutController fullLayoutController;
	private DetailsController detailsController;
	private GuideUIController guideUIController;
	private Stage primaryStage;
	private Stack<View> formerViews;//存储界面跳转历史记录的栈
	@FXML
	private AnchorPane fullLayout;
	@FXML
	private AnchorPane details;
	@FXML
	private AnchorPane guid;

	public AnchorPane getDetails() {
		return details;
	}

	public AnchorPane getGuid() {
		return guid;
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public DetailsController getDetailsController() {
		return detailsController;
	}

	public void setDetails(AnchorPane details) {
		this.details = details;
	}

	public void setGuid(AnchorPane guid) {
		this.guid = guid;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		formerViews=new Stack<View>();
		try {
			 changeFullLayout("../login/Login.fxml");
//			 changeDetails("../order/OrderList.fxml");
//			changeDetails("../administor/UserAdmin.fxml");
//			OrderAssessController controller = (OrderAssessController) this.getDetailsController();
//			controller.initValue("-C4S90908105229");
//			changeDetails("../customer/ClientInfo.fxml");
//			ClientInfoController clientInfoController = (ClientInfoController) this.getDetailsController();
//			clientInfoController.initValue("CS2016112919423486");
//			BookHotelController bookHotelController = (BookHotelController)this.getDetailsController();
//			bookHotelController.setRoomType(RoomType.Double);
//			bookHotelController.setValue("CS001", "HT001");
//			changeDetails("../hotel/HotelDetail.fxml");
//			changeDetails("../customer/BookHotel.fxml");
//			BookHotelController bookHotelController = (BookHotelController)this.getDetailsController();
//			bookHotelController.setRoomType(RoomType.Double);
//			bookHotelController.setValue("CS001", "HT001");
//			changeFullLayout("../login/FacilitiesInfo.fxml");
//			FacilitiesInfoController facilitiesInfoController = (FacilitiesInfoController) this.getDetailsController();
			
			// changeDetails("../room/RoomInfo.fxml");
//			changeDetails("../order/OrderDetails.fxml");
//			 changeDetails("../discount/HotelDiscount.fxml");
//			changeDetails("../customer/OrderAssess.fxml");

//			changeGuid("../guid/GuideUI.fxml");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// // Initialize the person table with the two columns.
		// firstNameColumn.setCellValueFactory(
		// cellData -> cellData.getValue().firstNameProperty());
		// lastNameColumn.setCellValueFactory(
		// cellData -> cellData.getValue().lastNameProperty());
		//
		// // Clear person details.
		// showPersonDetails(null);
		//
		// // Listen for selection changes and show the person details when
		// changed.
		// personTable.getSelectionModel().selectedItemProperty().addListener(
		// (observable, oldValue, newValue) -> showPersonDetails(newValue));
	}

	/**
	 * Closes the application.
	 */
	@FXML
	private void handleExit() {
		System.exit(0);
	}

	/**
	 * Minimize the application.
	 */
	@FXML
	private void handleMinimize() {
		primaryStage.setIconified(true);
	}

	/**
	 * 用来切换rootlayout的details的板块
	 * 
	 * @param fxml
	 *            details所在的fxlm文件的名称（相对路径）
	 * @throws IOException
	 *             FXMLLoader.load(URL location)加载失败时
	 */
	public void changeDetails(String fxml) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource(fxml));
		Parent child = (Parent) loader.load();
		details.getChildren().clear();
		details.getChildren().addAll(child);
		detailsController = loader.getController();
		detailsController.setRootLayoutController(this);
		formerViews.add(new View(child, detailsController));
	}

	/**
	 * 用来切换rootlayout的guid的板块
	 * 
	 * @param fxml
	 *            guid所在的fxlm文件的名称（相对路径）
	 * @throws IOException
	 *             FXMLLoader.load(URL location)加载失败时
	 */
	public void changeGuid(String fxml) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource(fxml));
		Parent child = (Parent) loader.load();
		guid.getChildren().clear();
		guid.getChildren().addAll(child);
		guideUIController = loader.getController();
		guideUIController.setRootLayoutController(this);
	}

	/**
	 * 用来切换rootlayout的整个界面
	 * 
	 * @param fxml
	 *            guid所在的fxlm文件的名称（相对路径）
	 * @throws IOException
	 *             FXMLLoader.load(URL location)加载失败时
	 */
	public void changeFullLayout(String fxml) throws IOException {
		if (fxml == null) {
			fullLayoutController = null;
			fullLayout.getChildren().clear();
			fullLayout.setDisable(true);
			return;
		}
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource(fxml));
		Parent child = (Parent) loader.load();
		details.getChildren().clear();
		guid.getChildren().clear();
		fullLayout.getChildren().clear();
		fullLayout.getChildren().addAll(child);
		fullLayout.setDisable(false);
		fullLayoutController = loader.getController();
		fullLayoutController.setRootLayoutController(this);
	}
	
	/**
	 * 回到上一个界面
	 * @return 如果没有上一个界面返回false，否则true
	 */
	public boolean toLastView() {
		if(formerViews.isEmpty()){
			return false;
		}
		View lastView=formerViews.pop();
		details.getChildren().clear();
		details.getChildren().addAll(lastView.parent);
		detailsController = lastView.detailsController;
		return true;
	}
	
	/**
	 * 界面和控制器的集合类
	 * @author zjy
	 *
	 */
	private class View {
		private Parent parent;
		private DetailsController detailsController;
		
		private View(Parent parent, DetailsController detailsController) {
			super();
			this.parent = parent;
			this.detailsController = detailsController;
		}
	}
}