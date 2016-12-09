package ui.credit;

import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;

/**
 * 单条信用变化记录界面的控制器
 * @author zjy
 */
public class CreditItemController {
	private static final String reasons[]={"完成订单","撤销订单","超时未入住","延时入住","异常订单申诉成功","信用充值",};
	
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
}
