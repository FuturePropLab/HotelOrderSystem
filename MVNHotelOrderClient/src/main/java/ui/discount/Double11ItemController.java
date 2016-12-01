package ui.discount;

import java.util.Date;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import ui.discount.HotelDiscountController.ItemType;

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
	
	@Override
	protected ItemType getType() {
		return ItemType.DOUBLE11;
	}
	
	@Override
	protected void setTitle() {
		handleFestivalDate();
	}
	
	@Override
	protected boolean isFinished() {
		return startTime.getValue()!=null && endTime.getValue()!=null && festivalDate.getValue()!=null;
	}
	
	/**
	 * 设置节日日期
	 * @param endTime 节日日期
	 */
	public void setFestivalDate(Date festivalDate) {
		this.festivalDate.setPromptText(festivalDate.getYear()+"-"+festivalDate.getMonth()+"-"+festivalDate.getDate());
	}

}
