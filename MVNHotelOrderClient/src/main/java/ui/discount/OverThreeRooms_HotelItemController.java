package ui.discount;

import javafx.fxml.FXML;
import ui.discount.HotelDiscountController.ItemType;

/**
 * 三间房以上优惠的单个item的界面的控制器
 * @author zjy
 *
 */
public class OverThreeRooms_HotelItemController extends HotelItemController{
	
	@FXML
	protected void handleDiscount(){
		title.setText(discount.getText()+"折");
		super.handleDiscount();
	}
	
	@Override
	protected ItemType getType() {
		return ItemType.OVER_THREE_ROOMS;
	}

	@Override
	protected void setTitle() {
		handleDiscount();
	}
}
