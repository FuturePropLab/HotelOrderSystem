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
public class BirthdayItemController extends ItemController{
	
	@FXML
	protected void handleDiscount(){
		super.handleDiscount();
		title.setText(discount.getText()+"折");
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
