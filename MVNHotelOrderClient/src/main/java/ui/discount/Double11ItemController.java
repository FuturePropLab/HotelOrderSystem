package ui.discount;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;

/**
 * 双11优惠的单个item的界面的控制器
 * @author zjy
 *
 */
public class Double11ItemController extends ItemController{
	@FXML
	private DatePicker festivalDate;
	
	@FXML
	protected void handleFestivalDate(){
		title.setText(festivalDate.getValue().getMonthValue()+"月"+festivalDate.getValue().getDayOfMonth()+"日");
	}
}
