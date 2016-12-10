package ui.guid;

import org.w3c.dom.css.ViewCSS;

import businesslogic.login.LoginController;
import businesslogicservice.LoginService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import tools.AccountType;
import ui.main.RootLayoutController;
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
	private ImageView headPortrait;
	@FXML
	private Label userName;
	@FXML
	private Label credit;
	@FXML
	private Label memberType;
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
		//TODO:设置组件的值
		
		
		if(AccountType.Customer.equals(logVO.accountType)){
			
		}
		guids.getItems().addAll(views);
		guids.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                	try {
						rootLayoutController.changeDetails(fxmls[getIndex(newValue)]);
					} catch (Exception e) {
						e.printStackTrace();
					}
                });
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
