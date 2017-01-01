package ui.credit;

import java.io.IOException;
import java.util.List;

import businesslogic.credit.CreditController;
import businesslogic.login.LoginController;
import businesslogicservice.CreditLogDealService;
import businesslogicservice.LoginService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import tools.AccountType;
import ui.hotel.HotelDetailController;
import ui.main.DetailsController;
import ui.order.OrderDetailsController;
import ui.order.OrderItemController;
import vo.CreditlogVO;
import vo.LogVO;

/**
 * 信用变化记录界面的控制器
 * @author zjy
 */
public class CreditChangLogController extends DetailsController{

	@FXML
	private FlowPane creditList;
		
	@FXML
	private void initialize() {
		LoginService loginService=LoginController.getInstance();
		CreditLogDealService creditLogDealService=CreditController.getInstance();
		LogVO logVO=loginService.getLogState();
		
		if(AccountType.Customer.equals(logVO.accountType)){
			this.creditList.getChildren().clear();
			List<CreditlogVO> voList=creditLogDealService.getLogList(logVO.accountID);
			if(voList==null || voList.size()==0){
				Label label=new Label("没有信用记录");
				label.setFont(Font.font(24));
				this.creditList.getChildren().addAll(label);
				return;
			}
			voList.sort((v1,v2)->v2.ChangDate.compareTo(v1.ChangDate));
			
			for(CreditlogVO creditlogVO:voList){
				addItem(creditlogVO);
			}
		}else {
			System.err.println("can not find credit log of "+logVO.accountType);
		}
		
	}
	
	
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
