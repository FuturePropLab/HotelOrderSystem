package ui.hotelworker;

import java.rmi.RemoteException;

import businesslogic.customer.CustomerDealController;
import businesslogic.order.OrderController;
import businesslogicservice.CustomerDealService;
import businesslogicservice.OrderService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import tools.OrderState;
import ui.main.DetailsController;
import ui.utils.DateFormat;
import ui.utils.Dialogs;
import vo.CustomerVO;
import vo.OrderVO;

/**
 * 入住和退房信息通用界面的控制器，包括延时入住
 * @author zjy
 */
public class CheckInAndOutInfoController extends DetailsController{
	private static final String orderStates[]={"未入住","已入住","异常订单","已撤销"};
	private static final String roomTypes[]={"单人间","双人间","标准间","豪华套房","总统套房"};

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
	private Label roomNumbers;//房间号码，来自订单，酒店工作人员不可以填写，每个号码之间用空格隔开
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
		if(rootLayoutController.toLastView()==false){
			System.err.println("no former view");
		}
	}
	
	/**
	 * 初始化组件的值
	 * @param orderID 订单的ID
	 */
	public void initValue(String orderID) {
		try {
			OrderService orderService=OrderController.getInstance();
			OrderVO orderVO=orderService.checkSingleOrder(orderID);
			
			CustomerDealService customerDealService=CustomerDealController.getInstance();
			CustomerVO customerVO=customerDealService.getCustomerInfo(orderVO.customerID);
			
			if(orderVO.orderState.equals(OrderState.Unexecuted)){
				this.date_from.setText(DateFormat.format_includingTime(orderVO.latestTime));
				this.date_to.setText(DateFormat.format_includingTime(orderVO.planedLeaveTime));
				this.orderID.setText(orderVO.orderID);
				this.orderState.setText(orderStates[orderVO.orderState.ordinal()]);
				this.price.setText(orderVO.price+"");
				this.customerName.setText(customerVO.customerName);
				this.roomType.setText(roomTypes[orderVO.roomType.ordinal()]);
				this.roomNumber.setText(orderVO.roomNumber.size()+"");
				String roomNumbers_String="";
				for(String room:orderVO.roomNumber){
					roomNumbers_String+=" "+room;
				}
				this.roomNumbers.setText(roomNumbers_String);
			}else if (orderVO.orderState.equals(OrderState.Executed)) {
				
			}else if (orderVO.orderState.equals(OrderState.Exception)) {
				
			}else {
				
			}
		} catch (RemoteException e) {
			Dialogs.showMessage("阿欧", "网络连接好像断开了……");
		}
	}
}
