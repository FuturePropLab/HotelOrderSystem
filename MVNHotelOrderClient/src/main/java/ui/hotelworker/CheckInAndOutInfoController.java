package ui.hotelworker;

import java.rmi.RemoteException;
import java.util.Date;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXDialog.DialogTransition;

import businesslogic.customer.CustomerDealController;
import businesslogic.order.OrderController;
import businesslogicservice.CustomerDealService;
import businesslogicservice.OrderService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import tools.OrderState;
import tools.ResultMessage;
import ui.main.DetailsController;
import ui.utils.Choice;
import ui.utils.DateFormat;
import ui.utils.Dialogs;
import vo.CustomerVO;
import vo.ExecutionInfoVO;
import vo.OrderVO;

/**
 * 入住和退房信息通用界面的控制器，包括延时入住
 * @author zjy
 */
public class CheckInAndOutInfoController extends DetailsController{
//	private static final String orderStates[]={"未入住","已入住","异常订单","已撤销"};
//	private static final String roomTypes[]={"单人间","双人间","标准间","豪华套房","总统套房"};

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
	private Label planedLeaveDateLable;//预计离开时间的标签，如果是退房，就不显示
	@FXML
	private DatePicker planedLeaveDate;//预计离开日期，如果是退房，就不显示
	@FXML
	private DatePicker planedLeaveTime;//预计离开时间，如果是退房，就不显示
	@FXML
	private Button confirm;//如果是入住，就显示“确认入住”，如果是退房，就显示“确认退房”
	@FXML
	private Button cancel;
	private String ID;//订单的ID
	private String customerID;
	private OrderState state;
	
	
	@FXML
	private void handleConfirm(){
		//入住时间或实际退房时间即为酒店工作人员操作时的系统时间
		//如果是异常订单，提示酒店工作人员是延时入住
		//如果退房成功，将房间变为可用
		
		if(OrderState.Unexecuted.equals(state)){
			if(planedLeaveDate.getValue()!=null && planedLeaveTime.getValue()!=null){
				ExecutionInfoVO executionInfoVO=new ExecutionInfoVO(ID, null, DateFormat.getDate(
						(JFXDatePicker)planedLeaveDate, (JFXDatePicker)planedLeaveTime), new Date(), null);
				OrderService orderService=OrderController.getInstance();
				ResultMessage result=orderService.executionModify(executionInfoVO);
				if(ResultMessage.Exist.equals(result)){
					Dialogs.showMessage("叮咚","更新入住信息成功", DialogTransition.CENTER);
				}else{
					Dialogs.showMessage("诶哟", "更新入住信息失败了_(:з」∠)_   "+"订单ID"+ID+"   订单状态："+state.toString(), 
							DialogTransition.CENTER);
				}
			}else{
				Dialogs.showMessage("诶哟", "你得先填写预计退房时间哟", DialogTransition.CENTER);
			}
		}else if (OrderState.Executed.equals(state)) {
			checkOut();
		}else if (OrderState.Exception.equals(state)) {
			Dialogs.showChoise("这是一份异常订单，你确定要帮客户办理延时入住吗", 
					new Choice("是的", e->checkOut()), new Choice("不了", e->{}));
		}else {
			System.out.println("this is a revoked order.");
		}
	}
	@FXML
	private void handleCancel(){
		if(rootLayoutController.toLastView()==false){
			System.err.println("no former view");
		}
	}
	
	private void checkOut(){
		ExecutionInfoVO executionInfoVO=new ExecutionInfoVO(ID, null, null, null, new Date());
		OrderService orderService=OrderController.getInstance();
		ResultMessage result=orderService.executionModify(executionInfoVO);
		if(ResultMessage.Exist.equals(result)){
			Dialogs.showMessage("叮咚","更新退房信息成功", DialogTransition.CENTER);
		}else{
			Dialogs.showMessage("诶哟", "更新退房信息失败了_(:з」∠)_   "+"订单ID"+ID+"   订单状态："+state.toString(), 
					DialogTransition.CENTER);
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
			
			this.ID=orderVO.orderID;
			this.state=orderVO.orderState;
			this.date_from.setText(DateFormat.format_includingTime(orderVO.latestTime));
			this.date_to.setText(DateFormat.format_includingTime(orderVO.planedLeaveTime));
			this.orderID.setText(orderVO.orderID);
			this.orderState.setText(orderVO.orderState.toString());
			this.price.setText(orderVO.price+"");
			this.customerName.setText(customerVO.customerName);
			this.roomType.setText(orderVO.roomType.toString());
			this.roomNumber.setText(orderVO.roomNumber.size()+"");
			String roomNumbers_String="";
			for(String room:orderVO.roomNumber){
				roomNumbers_String+=" "+room;
			}
			this.roomNumbers.setText(roomNumbers_String);
			
			if(orderVO.orderState.equals(OrderState.Unexecuted)){
				this.orderState.setTextFill(Color.LIGHTGREEN);
				confirm.setText("确认入住");
			}else if (orderVO.orderState.equals(OrderState.Executed)) {
				this.orderState.setTextFill(Color.valueOf("#ee8a11"));//棕色
				this.planedLeaveDateLable.setVisible(false);
				this.planedLeaveDate.setVisible(false);
				this.planedLeaveTime.setVisible(false);
				confirm.setText("确认退房");
			}else if (orderVO.orderState.equals(OrderState.Exception)) {
				this.orderState.setTextFill(Color.RED);
				confirm.setText("确认入住");
			}else {
				System.err.println("can not handle revoked order!s");
			}
		} catch (RemoteException e) {
			Dialogs.showMessage("阿欧", "网络连接好像断开了……");
		}
	}
}
