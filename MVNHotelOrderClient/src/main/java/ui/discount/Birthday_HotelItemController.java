package ui.discount;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import ui.discount.HotelDiscountController.ItemType;

/**
 * 生日特惠的单个item的界面的控制器
 * @author zjy
 *
 */
public class Birthday_HotelItemController extends HotelItemController{
	
	@FXML
	protected void handleDiscount(){
		title.setText(discount.getText()+"折");
		super.handleDiscount();
	}

	@Override
	protected ItemType getType() {
		return ItemType.BIRTHDAY;
	}

	@Override
	protected void setTitle() {
		handleDiscount();
	}
}
