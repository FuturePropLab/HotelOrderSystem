package ui.order;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import businesslogic.order.OrderController;
import businesslogicservice.OrderService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import tools.HotelAddress;
import ui.main.DetailsController;
import vo.OrderVO;
import vo.SearchOrderInfoVO;
/**
 * 订单列表的控制器
 * @author zjy
 *
 */
public class OrderListController extends DetailsController{

	@FXML
	private TextField keyWords;
	@FXML
	private ImageView search;
	@FXML
	private DatePicker date;
	@FXML
	private CheckBox unexecuted;
	@FXML
	private CheckBox executed;
	@FXML
	private CheckBox exception;
	@FXML
	private CheckBox revoked;
	@FXML
	private FlowPane orderList;
	
	
	@FXML
    private void handleSearch() {
		OrderService orderService=OrderController.getInstance();
		String string= "".equals(keyWords.getText())? null:keyWords.getText();
		String customerID=null;//TODO:如果是客户就获取客户ID
		String hotelID=null;//TODO:如果是酒店工作人员就获取酒店ID
		List<OrderVO> orderVOs=orderService.CheckOrderList(new SearchOrderInfoVO(
				string, customerID, hotelID, null, null, getDate(), null));
		orderVOs.addAll(orderService.CheckOrderList(customerID==null? 
				new SearchOrderInfoVO(null, customerID, null, string, null, getDate(), null)
				:new SearchOrderInfoVO(null, null, hotelID, null, string, getDate(), null)));

		orderList.getChildren().clear();
		if(orderVOs!=null){
			for(OrderVO orderVO:orderVOs){
				OrderItemController orderItemController=addItem();
				//TODO:通过酒店ID得到下面的酒店的信息
				Image hotelImage=null;
				String hotelName="hotelname";
				HotelAddress hotelAddress=null;
				orderItemController.setValue(hotelImage, hotelName, hotelAddress, orderVO.latestTime, 
						orderVO.planedLeaveTime, orderVO.roomType, orderVO.roomNumber.size(), orderVO.price, 
						orderVO.orderState, orderVO.orderID);
			}
		}
		handleFilter();
    }
    @FXML
    private void handleFilter() {
    	//TODO:将显示出来的项目按4个checkbox过滤掉不显示的
    }
    
    
    private Date getDate() {
		if(date.getValue()==null){
			return null;
		}
		return new Date(date.getValue().getYear(), date.getValue().getMonthValue(), date.getValue().getDayOfMonth());
	}
    
    private OrderItemController addItem() {
    	try {
        	FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("OrderItem.fxml"));
        	AnchorPane orderItem = (AnchorPane) loader.load();
        	orderList.getChildren().addAll(orderItem);
        	OrderItemController orderItemController=loader.getController();
        	orderItemController.setOrderListController(this);
        	return orderItemController;
    	}catch(IOException e){
    		e.printStackTrace();
    	}
    	return null;
	}
}
