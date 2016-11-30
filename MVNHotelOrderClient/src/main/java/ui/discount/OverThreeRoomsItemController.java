package ui.discount;

import javafx.fxml.FXML;

/**
 * 三间房以上优惠的单个item的界面的控制器
 * @author zjy
 *
 */
public class OverThreeRoomsItemController extends ItemController{
	
	@FXML
	protected void handleDiscount(){
		super.handleDiscount();
		title.setText(discount.getText()+"折");
	}
}
