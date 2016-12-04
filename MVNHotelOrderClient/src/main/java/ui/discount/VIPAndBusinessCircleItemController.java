package ui.discount;

import javafx.fxml.FXML;
import ui.discount.HotelDiscountController.ItemType;

/**
 * VIP会员特定商圈专属折扣的单个item的界面的控制器
 * 还没写
 * @author zjy
 *
 */
public class VIPAndBusinessCircleItemController extends StrategyItemController{
	
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
