package ui.credit;

import businesslogic.hotel.HotelDealController;
import businesslogic.order.OrderController;
import businesslogicservice.HotelDealService;
import businesslogicservice.OrderService;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import tools.ActionType;
import ui.utils.DateFormat;
import vo.CreditlogVO;
import vo.HotelbriefVO;
import vo.OrderVO;

/**
 * 单条信用变化记录界面的控制器
 * @author zjy
 */
public class CreditItemController {
	private static final String reasons[]={"完成订单","撤销订单","超时未入住","异常订单申诉成功","信用充值",};
	
	@FXML
	private Label reason;
	@FXML
	private Label value;//信用变化度
	@FXML
	private Label time;//信用变化时间
	@FXML
	private Label price;//如果是充值就是充值金额，否则是订单的总价
	@FXML
	private Hyperlink hotelName;
	@FXML
	private Label orderIDLable;
	@FXML
	private Hyperlink orderID;
	private String hotelID;
	private CreditChangLogController changLogController;
	
	@FXML
	private void handleHotelName(){
		changLogController.toHotelDetailView(hotelID);
	}
	@FXML
	private void handleOrderID(){
		changLogController.toOrderDetailView(orderID.getText());
	}
	
	/**
	 * 初始化组件的值
	 * @param creditlogVO
	 */
	public void initValue(CreditlogVO creditlogVO,CreditChangLogController changLogController) {
		this.changLogController=changLogController;
		this.reason.setText(reasons[creditlogVO.actionType.ordinal()]);
		this.reason.setTextFill(creditlogVO.changeValue>=0? Color.GREEN:Color.RED);
		this.value.setText(creditlogVO.changeValue>0?"+":"" + creditlogVO.changeValue);
		this.time.setText(DateFormat.format_includingTime(creditlogVO.ChangDate));
		if(creditlogVO.actionType.equals(ActionType.Charge)){
			this.price.setText(creditlogVO.money+"");
			this.hotelName.setVisible(false);
			this.orderIDLable.setVisible(false);
			this.orderID.setVisible(false);
		}else {
			OrderService orderService=OrderController.getInstance();
			OrderVO orderVO=orderService.checkSingleOrder(creditlogVO.orderID);
			HotelDealService hotelDealService=HotelDealController.getInstance();
			HotelbriefVO hotelbriefVO=hotelDealService.getHotelInfo(orderVO.hotelID);
			this.price.setText(orderVO.value+"");
			this.hotelName.setText(hotelbriefVO.hotelName);
			this.orderIDLable.setVisible(true);
			this.orderID.setText(creditlogVO.orderID);
			this.hotelID=orderVO.hotelID;
		}
	}
}
