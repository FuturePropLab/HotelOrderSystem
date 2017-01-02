package ui.customer;

import java.io.IOException;
import java.net.URI;

import com.jfoenix.controls.JFXTextArea;

import Exception.OutOfBoundsException;
import businesslogic.hotel.HotelDealController;
import businesslogic.order.OrderController;
import businesslogicservice.OrderService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import tools.Mark;
import tools.OrderState;
import tools.ResultMessage;
import ui.main.DetailsController;
import ui.order.OrderDetailsController;
import ui.utils.Dialogs;
import ui.utils.ImageUtil;
import ui.utils.TextFieldUtil;
import vo.AssessVO;
import vo.HotelbriefVO;
import vo.OrderVO;

/**
 * 订单评价界面的控制器
 * @author zjy
 *
 */
public class OrderAssessController extends DetailsController{
	private static Image yellowStar=new Image(ImageUtil.getURL("star__selected.png"));
	private static Image greyStar=new Image(ImageUtil.getURL("star_unselected.png"));
	private static String starArray[]={"差评！","有些糟糕","一般般→_→","还不错哦","棒棒棒≧∇≦"};

	@FXML
	private ImageView hotelImage;
	@FXML
	private Label hotelName;
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
	private Label markLabel;
	@FXML
	private JFXTextArea assessment;
	@FXML
	private Button submit;
	@FXML
	private Button cancel;
	private String orderID;
	private int mark=5;//初始化时默认评分为4分
	
	@FXML
	private void initialize() {
		//对5个小星星增加3种监控，鼠标移动到上面时，鼠标离开时，鼠标点击时
		star_1.setOnMouseEntered(e -> changeStarValue(1));
		star_2.setOnMouseEntered(e -> changeStarValue(2));
		star_3.setOnMouseEntered(e -> changeStarValue(3));
		star_4.setOnMouseEntered(e -> changeStarValue(4));
		star_5.setOnMouseEntered(e -> changeStarValue(5));
		star_1.setOnMouseExited(e -> changeStarValue(mark));
		star_2.setOnMouseExited(e -> changeStarValue(mark));
		star_3.setOnMouseExited(e -> changeStarValue(mark));
		star_4.setOnMouseExited(e -> changeStarValue(mark));
		star_5.setOnMouseExited(e -> changeStarValue(mark));
		star_1.setOnMouseClicked(e -> changeStarValue(mark=1));
		star_2.setOnMouseClicked(e -> changeStarValue(mark=2));
		star_3.setOnMouseClicked(e -> changeStarValue(mark=3));
		star_4.setOnMouseClicked(e -> changeStarValue(mark=4));
		star_5.setOnMouseClicked(e -> changeStarValue(mark=5));
		
		TextFieldUtil.setValidator(assessment);
	}
	
	@FXML
	private void handleSubmit(){
		try {
			Mark mark=new Mark(this.mark);
			OrderService orderService=OrderController.getInstance();
			if(ResultMessage.Exist.equals(orderService.assessOrder(new AssessVO(orderID, mark, assessment.getText())))){
				Dialogs.showMessage("铛铛","评价成功了！");
				rootLayoutController.changeDetails("../order/OrderDetails.fxml");
				OrderDetailsController orderDetailsController=(OrderDetailsController) 
						rootLayoutController.getDetailsController();
				orderDetailsController.initValue(orderID);
			}else {
				Dialogs.showMessage("阿欧","评价失败了……");
			}
		} catch (OutOfBoundsException e) {
			System.err.println("can not create Mark:"+this.mark);
			return;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@FXML
	private void handleCancel(){
		rootLayoutController.toLastView();
	}
	
	/**
	 * 处理小星星的亮暗转换
	 * @param seletedStar 被选中小星星的index
	 */
	private void changeStarValue(int seletedStar) {
		if(seletedStar<1 || seletedStar>5){
			System.err.println("can not set star value:"+seletedStar);
			return;
		}
		star_1.setImage(seletedStar>=1?yellowStar:greyStar);
		star_2.setImage(seletedStar>=2?yellowStar:greyStar);
		star_3.setImage(seletedStar>=3?yellowStar:greyStar);
		star_4.setImage(seletedStar>=4?yellowStar:greyStar);
		star_5.setImage(seletedStar>=5?yellowStar:greyStar);
		markLabel.setText(starArray[seletedStar-1]);
	}
	
	public void initValue(String orderID) {
		//设置组件的值，如果订单不是已执行状态或者已经评价过，提示用户，调用handleCancel()
		this.orderID=orderID;
		OrderVO orderVO = OrderController.getInstance().checkSingleOrder(orderID);	
		if(!OrderState.Executed.equals(orderVO.orderState)){
			Dialogs.showMessage("亲：", "你已经评价过这个订单了，不能再次评价了哦！");
			handleCancel();
			return;
		}
		String hotelID = orderVO.hotelID;
		HotelbriefVO hotelbriefVO = HotelDealController.getInstance().getHotelInfo(hotelID);
		this.hotelName.setText(hotelbriefVO.hotelName);
		URI uri = hotelbriefVO.imageuri;
		if(uri!=null){
			Image image = new Image(uri.toString());
			this.hotelImage.setImage(image);
		}
		changeStarValue(this.mark);
	}
}
