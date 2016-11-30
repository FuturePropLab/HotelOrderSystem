package ui.discount;

import javafx.fxml.FXML;

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
}
