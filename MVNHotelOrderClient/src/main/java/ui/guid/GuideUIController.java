package ui.guid;

import java.io.File;
import java.rmi.RemoteException;

import businesslogic.customer.CustomerDealController;
import businesslogic.login.LoginController;
import businesslogicservice.CustomerDealService;
import businesslogicservice.LoginService;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import tools.AccountType;
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
	private Label credit;
	@FXML
	private Label creditLabel;
	@FXML
	private Hyperlink logout;
	@FXML
	private ListView<String> guids;
	@FXML
	private ImageView messageImage;
	@FXML
	private AnchorPane messagePane;
	@FXML
	private Label message;
	protected RootLayoutController rootLayoutController;
	
	@FXML
	private void initialize() {
		LoginService loginService=LoginController.getInstance();
		LogVO logVO = loginService.getLogState();

		userName.setText(logVO.username);
		
		if(AccountType.Customer.equals(logVO.accountType)){
			guids.getItems().addAll(views[0],views[1],views[2],views[3]);
			CustomerDealService customerDealService=CustomerDealController.getInstance();
			try {
				CustomerVO customerVO = customerDealService.getCustomerInfo(logVO.accountID);
				credit.setText(customerVO.credit+"");
			} catch (RemoteException e) {
				Dialogs.showMessage("阿欧", "网络连接好像断开了……");
			}
			
			credit.setVisible(true);
			creditLabel.setVisible(true);
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
