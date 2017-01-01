package ui.discount;

import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import tools.Strategy_hotelType;
import ui.utils.DateFormat;
import ui.utils.Dialogs;

/**
 * 双11优惠的单个item的界面的控制器
 * @author zjy
 *
 */
public class Period_HotelItemController extends HotelItemController{
	@FXML
	private DatePicker festivalDate_from;
	@FXML
	private DatePicker festivalDate_to;
	
	@FXML
	private void initialize() {
		DateFormat.initDatePicker(festivalDate_from, festivalDate_to);
	}
	
	@FXML
	protected void handleFestivalDate(){
		if(festivalDate_from.getValue()!=null && festivalDate_to.getValue()!=null){
			title.setText(festivalDate_from.getValue().getMonthValue()+"月"+festivalDate_from.getValue().getDayOfMonth()+"日"
					+"-"+festivalDate_to.getValue().getMonthValue()+"月"+festivalDate_to.getValue().getDayOfMonth()+"日");
		}
		handleSave();
	}
	
	@FXML
	protected void handleFromTime() {
		handleSave();
	}

	@FXML
	protected void handleToTime() {
		handleSave();
	}

	@Override
	protected Strategy_hotelType getType() {
		return Strategy_hotelType.Period;
	}
	
	@Override
	protected void setTitle() {
		handleFestivalDate();
	}
	
	@Override
	protected boolean isFinished() {
		return startTime.getValue()!=null && endTime.getValue()!=null && discountNumber>0 && 
				festivalDate_from.getValue()!=null && festivalDate_to.getValue()!=null;
	}
	
	@Override
	protected void disableControls() {
		super.disableControls();
		festivalDate_from.setEditable(false);
		festivalDate_to.setEditable(false);
	}
	
	/**
	 * 设置节日日期
	 * @param endTime 节日日期
	 */
	public void setFestivalDate(LocalDate startDate,LocalDate endDate) {
		this.festivalDate_from.setValue(startDate);
		this.festivalDate_to.setValue(endDate);
	}

}
