package ui.credit;

import java.io.IOException;

import businesslogic.credit.CreditController;
import businesslogicservice.CreditLogDealService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import ui.hotel.HotelDetailController;
import ui.main.DetailsController;
import ui.order.OrderDetailsController;
import ui.order.OrderItemController;
import vo.CreditlogVO;

/**
 * 信用变化记录界面的控制器
 * @author zjy
 */
public class CreditChangLogController extends DetailsController{

	@FXML
	private AnchorPane creditList;
	
	
	private CreditItemController addItem(CreditlogVO creditlogVO) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("CreditItem.fxml"));
			AnchorPane item = (AnchorPane) loader.load();
			creditList.getChildren().addAll(item);
			CreditItemController creditItemController = loader.getController();
			creditItemController.initValue(creditlogVO, this);
			return creditItemController;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 初始化组件的值
	 * @param customerID 客户ID
	 */
	public void initValue(String customerID) {
		creditList.getChildren().clear();
		CreditLogDealService creditLogDealService=CreditController.getInstance();
		for(CreditlogVO creditlogVO:creditLogDealService.getLogList(customerID)){
			addItem(creditlogVO);
		}
	}
	
	/**
	 * 跳转到订单详情界面
	 * @param orderID 订单ID
	 */
	public void toOrderDetailView(String orderID) {
		try {
			rootLayoutController.changeDetails("../order/OrderDetails.fxml");
			OrderDetailsController orderDetailsController=(OrderDetailsController) 
					rootLayoutController.getDetailsController();
			orderDetailsController.initValue(orderID);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 跳转到酒店详情界面
	 * @param hotelID 酒店ID
	 */
	public void toHotelDetailView(String hotelID) {
		try {
			rootLayoutController.changeDetails("../hotel/HotelDetail.fxml");
			HotelDetailController hotelDetailController=(HotelDetailController) 
					rootLayoutController.getDetailsController();
			hotelDetailController.initValue(hotelID);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
