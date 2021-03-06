package ui.main;

import java.io.IOException;
import java.util.Stack;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDrawersStack;

import businesslogic.customer.CustomerDealController;
import businesslogic.hotel.HotelDealController;
import businesslogic.login.LoginController;
import businesslogic.login.State;
import businesslogicservice.CustomerDealService;
import businesslogicservice.HotelDealService;
import businesslogicservice.LoginService;
import bussinesslogic.message.MessageDealController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import tools.AccountType;
import ui.guid.GuideUIController;
import ui.order.OrderDetailsController;
import ui.utils.Choice;
import ui.utils.Dialogs;
import vo.CustomerVO;
import vo.HotelDetailsVO;
import vo.MessageVO;

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
	private StackPane rootLayout;
	@FXML
	private AnchorPane fullLayout;
	@FXML
	private AnchorPane details;
	@FXML
	private AnchorPane guid;
	@FXML
	private JFXDialog dialog;
	@FXML
	private Button acceptButton;

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
		} catch (IOException e) {
			e.printStackTrace();
		}
		Dialogs.init(rootLayout, dialog);
	}

	/**
	 * Closes the application.
	 */
	@FXML
	private void handleExit() {
		LoginController loginController = LoginController.getInstance();
		if(loginController.getLogState().state==State.login)
		loginController.logOut();
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
	 * 因为在jar包中执行软件时会加载FXML失败，
	 * 所以把fxml的以类所在文件路径为基础替换为以项目根路径为基础
	 * @param fxml 原fxml相对路径
	 * @return
	 */
	private String fixURL(String fxml) {
		if(fxml.startsWith("../")){
			fxml="/ui"+fxml.substring(2);
		}
		return fxml;
	}

	/**
	 * 用来切换rootlayout的details的板块
	 * @param fxml details所在的fxlm文件的名称（相对路径）
	 * @throws IOException FXMLLoader.load(URL location)加载失败时
	 */
	public void changeDetails(String fxml) throws IOException {
		//如果客户或者酒店没有填写完自己的基本信息，则强制跳转到填写信息的界面
		LoginService loginService=LoginController.getInstance();
		if(AccountType.Customer.equals(loginService.getLogState().accountType)){
			CustomerDealService customerDealService=CustomerDealController.getInstance();
			CustomerVO customerVO=customerDealService.getCustomerInfo(loginService.getLogState().accountID);
			if("".equals(customerVO.customerName) || "".equals(customerVO.gender) || "".equals(customerVO.telephone)){
				fxml="../customer/ClientInfo.fxml";
			}
		}else if(AccountType.Hotel.equals(loginService.getLogState().accountType)){
			HotelDealService hotelDealService=HotelDealController.getInstance();
			HotelDetailsVO hotelDetailsVO=hotelDealService.getHotelDetailsVO(loginService.getLogState().accountID);
			if("".equals(hotelDetailsVO.hotelName) || "".equals(hotelDetailsVO.hotelAddress)){
				fxml="../hotel/HotelDetail.fxml";
			}
		}
		
		fxml=fixURL(fxml);
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource(fxml));
		Parent child = (Parent) loader.load();
		details.getChildren().clear();
		details.getChildren().addAll(child);
		detailsController = loader.getController();
		detailsController.setRootLayoutController(this);
		formerViews.add(new View(child, detailsController,fxml));		
		
		//wsw add
		//zjy modified
		if(AccountType.Customer.equals(loginService.getLogState().accountType)){
			MessageDealController messageDealController = MessageDealController.getInstance();
			MessageVO messageVO = messageDealController.getMessage(loginService.getLogState().accountID);
			if(messageVO!=null && messageVO.message!=null){
				if(messageVO.OrderID==null){
					Dialogs.showMessage("恭喜", messageVO.message);
				}else{
					Dialogs.showChoise(messageVO.message, 
							new Choice("查看详情", event->{
								try {
									changeDetails("../order/OrderDetails.fxml");
									((OrderDetailsController)getDetailsController()).initValue(messageVO.OrderID);
								} catch (IOException e) {
									e.printStackTrace();
								}
							}), 
							new Choice("知道了", event->{}));
				}

			}
		}
	}
	
	/**
	 * 用来切换rootlayout的guid的板块
	 * @param fxml guid所在的fxlm文件的名称（相对路径）
	 * @throws IOException FXMLLoader.load(URL location)加载失败时
	 */
	public void changeGuid(String fxml) throws IOException {
		fxml=fixURL(fxml);
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
	 * @param fxml guid所在的fxlm文件的名称（相对路径）
	 * @throws IOException FXMLLoader.load(URL location)加载失败时
	 */
	public void changeFullLayout(String fxml) throws IOException {
		if (fxml == null) {
			fullLayoutController = null;
			fullLayout.getChildren().clear();
			fullLayout.setDisable(true);
			return;
		}
		fxml=fixURL(fxml);
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
		if(formerViews.size()<=1){
			return false;
		}
		formerViews.pop();
		View lastView=formerViews.peek();
		details.getChildren().clear();
		details.getChildren().addAll(lastView.parent);
		detailsController = lastView.detailsController;
		return true;
	}
	
	/**
	 * 刷新详情界面
	 * @return 如果没有当前的详情界面返回false，否则true
	 */
	public boolean syncDetail() {
		if(formerViews.isEmpty()){
			return false;
		}
		View presentView=formerViews.pop();
		try {
			changeDetails(presentView.fxml);
		} catch (IOException e) {
			e.printStackTrace();
		}
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
		private String fxml;
		
		private View(Parent parent, DetailsController detailsController,String fxml) {
			super();
			this.parent = parent;
			this.detailsController = detailsController;
			this.fxml=fxml;
		}
	}
}