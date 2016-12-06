package ui.order;

import Exception.CustomerCreditNotEnoughException;
import businesslogic.order.OrderController;
import businesslogicservice.OrderService;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import ui.main.Dialogs;
import vo.OrderInputVO;

/**
 * 订单预览界面的控制器
 * @author zjy
 *
 */
public class OrderPreviewController {
	private static Image yellowStar=new Image("file:./target/resources/images/star__selected.png");
	private static Image greyStar=new Image("file:./target/resources/images/star_unselected.png");

	@FXML
	private Hyperlink hotelName;
	@FXML
	private Label date_from;
	@FXML
	private Label date_to;
	@FXML
	private Label roomType;
	@FXML
	private Label roomNumber;//房间数量
	@FXML
	private Label price;
	@FXML
	private Label latestDate;
	@FXML
	private Label planedLeaveDate;
	@FXML
	private Label people;//预计入住人数
	@FXML
	private Label children;//有无儿童
	@FXML
	private Label customerName;
	@FXML
	private Label hotelAddress;
	@FXML
	private ImageView star_1;
	@FXML
	private ImageView star_2;
	@FXML
	private ImageView star_3;
	@FXML
	private ImageView star_4;
	@FXML
	private ImageView star_5;
	@FXML
	private Hyperlink confirm;
	@FXML
	private Hyperlink cancel;
	private OrderInputVO orderInputVO;
	
	@FXML
	private void handleConfirm() {
		OrderService orderService=OrderController.getInstance();
		try {
			orderService.createOrders(orderInputVO);
		} catch (CustomerCreditNotEnoughException e) {
			Dialogs.showMessage("你的信用值是："+e.credit,"你的信用值不足，不能下单，请联系网站促销人员进行充值");
		}
	}
	@FXML
	private void handleCancel() {
		//TODO:返回填写订单界面
	}
}
