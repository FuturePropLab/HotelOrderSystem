package ui.hotelworker;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import ui.main.DetailsController;

/**
 * 入住和退房信息通用界面的控制器，包括延时入住
 * @author zjy
 */
public class CheckInAndOutInfoController extends DetailsController{

	@FXML
	private Label date_from;
	@FXML
	private Label date_to;
	@FXML
	private Label orderID;
	@FXML
	private Label orderState;
	@FXML
	private Label price;
	@FXML
	private Label customerName;
	@FXML
	private Label roomType;
	@FXML
	private Label roomNumber;//房间数量
	@FXML
	private Label roomNumbers;//房间号码，来自订单，酒店工作人员不可用填写，每个号码之间用空格隔开
	@FXML
	private Label planedLeaveDate;//预计离开日期，如果是退房，就不显示
	@FXML
	private Label planedLeaveTime;//预计离开时间，如果是退房，就不显示
	@FXML
	private Button confirm;//如果是入住，就显示“确认入住”，如果是退房，就显示“确认退房”
	@FXML
	private Button cancel;
	
	
	@FXML
	private void handleConfirm(){
		//TODO:调用blservice填写入住或退房信息
		//入住时间或实际退房时间即为酒店工作人员操作时的系统时间
		//如果是异常订单，提示酒店工作人员是延时入住
		//如果退房成功，将房间变为可用
	}
	@FXML
	private void handleCancel(){
		//TODO:返回上个界面
	}
	
	/**
	 * 初始化组件的值
	 * @param orderID 订单的ID
	 */
	public void initValue(String orderID) {
		//TODO:初始化组件的值
	}
}
