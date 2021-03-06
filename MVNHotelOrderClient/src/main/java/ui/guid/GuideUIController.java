package ui.guid;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;

import com.jfoenix.controls.JFXColorPicker;
import com.jfoenix.controls.JFXDialogLayout;

import businesslogic.customer.CustomerDealController;
import businesslogic.login.LoginController;
import businesslogicservice.CustomerDealService;
import businesslogicservice.LoginService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import tools.AccountType;
import tools.ResultMessage_LoginCheck;
import ui.main.RootLayoutController;
import ui.utils.Dialogs;
import vo.CustomerVO;
import vo.LogVO;

/**
 * 导航界面的控制器
 * @author zjy
 *
 */
public class GuideUIController {
	private static final String views[]={"浏览酒店","查看订单","我的信息","信用记录","制定酒店促销策略","酒店信息",
			"更新入住退房信息","线下入住退房","制定网站促销策略","信用充值","用户管理"};
	private static final String fxmls[]={"../hotel/HotelSearch.fxml","../order/OrderList.fxml",
			"../customer/ClientInfo.fxml","../credit/CreditChangLog.fxml","../discount/HotelDiscount.fxml",
			"../hotel/HotelDetail.fxml","../hotelworker/CheckInAndOutInfo.fxml","../hotelworker/OfflineInfo.fxml",
			"../discount/WebDiscount.fxml","../webdesign/CreditCharge.fxml","../administor/UserAdmin.fxml"};

	@FXML
	private ImageView headPortrait;		//TODO:设置头像
	@FXML
	private Label userName;
	@FXML
	private Hyperlink resetPassword;
	@FXML
	private Hyperlink logout;
	@FXML
	private Button back;
	@FXML
	private Button sync;
	@FXML
	private ListView<String> guids;
	@FXML
	private ImageView messageImage;
	@FXML
	private AnchorPane messagePane;
	@FXML
	private Label message;
	@FXML
	private JFXColorPicker colorPicker;
	@FXML
	private AnchorPane guidPane;
	@FXML
	private AnchorPane toolsPane;
	protected RootLayoutController rootLayoutController;
	
	@FXML
	private void initialize() {
		LoginService loginService=LoginController.getInstance();
		LogVO logVO = loginService.getLogState();

		userName.setText(logVO.username);
		
		if(AccountType.Customer.equals(logVO.accountType)){
			guids.getItems().addAll(views[0],views[1],views[2],views[3]);
		}else if (AccountType.Hotel.equals(logVO.accountType)) {
			guids.getItems().addAll(views[1],views[4],views[5],views[7]);
		}else if (AccountType.Web.equals(logVO.accountType)) {
			guids.getItems().addAll(views[1],views[8],views[9]);
		}else if (AccountType.Administor.equals(logVO.accountType)) {
			guids.getItems().addAll(views[1],views[10]);
		}
		else {
			System.err.println("can not get login state");
		}
//		guids.getItems().addAll(views);
//		guids.setCellFactory((ListView<String> l) -> new ListCell<String>(){
//			@Override
//			protected void updateItem(String item, boolean empty) {
//				super.updateItem(item, empty);
//			}
//			
//		});
		guids.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
        	try {
				rootLayoutController.changeDetails(fxmls[getIndex(newValue)]);
			} catch (Exception e) {
				e.printStackTrace();
			}
        });
		//((JFXListView<String>)guids).depthProperty().set(1);
	}
	@FXML
	private void handleHeadPortrait() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("选择一张图片");
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("图片", "*.png", "*.jpg", "*.gif"));
		File selectedFile = fileChooser.showOpenDialog(rootLayoutController.getPrimaryStage());
		if (selectedFile != null) {
			headPortrait.setImage(new Image(selectedFile.toURI().toString()));
			//TODO:保存头像
		}
	}
	@FXML
	private void handleResetPassword(){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("ResetPassword.fxml"));
			Dialogs.showResetPassword(loader.load(), loader.getController());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@FXML
	private void handleLogout() {
		LoginService loginService=LoginController.getInstance();
		ResultMessage_LoginCheck result=loginService.logOut();
		if(ResultMessage_LoginCheck.Success.equals(result)){
			try {
				rootLayoutController.changeFullLayout("../login/Login.fxml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			Dialogs.showMessage("啊哦", "登出失败了……可能是网络原因……");
		}
	}
	@FXML
	private void handleBack() {
		if(rootLayoutController.toLastView()==false){
			System.out.println("no last view.");
		}
	}
	@FXML
	private void handleSync() {
		if(rootLayoutController.syncDetail()==false){
			System.out.println("no present view.");
		}
	}
	@FXML
	private void handleColorPicker() {
		Background background=new Background(new BackgroundFill(colorPicker.getValue(), null, null));
		guidPane.setBackground(background);
		guids.setBackground(background);
		toolsPane.setBackground(background);
	}
	
	private int getIndex(String name) {
		for(int index=0;index<views.length;index++){
			if(views[index].equals(name)){
				return index;
			}
		}
		System.err.println("can not find the index of:"+name);
		return 0;
	}
	
	/**
	 * 设置根界面控制器
	 * @param rootLayoutController
	 */
	public void setRootLayoutController(RootLayoutController rootLayoutController) {
		this.rootLayoutController = rootLayoutController;
	}
}
