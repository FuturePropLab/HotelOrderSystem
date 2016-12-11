package ui.discount;

import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import tools.Strategy_hotelType;
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
	protected void handleFestivalDate(){
		if(festivalDate_from.getValue()!=null && festivalDate_to.getValue()!=null){
			title.setText(festivalDate_from.getValue().getMonthValue()+"月"+festivalDate_from.getValue().getDayOfMonth()+"日"
					+"-"+festivalDate_to.getValue().getMonthValue()+"月"+festivalDate_to.getValue().getDayOfMonth()+"日");
		}
		handleSave();
	}
	
	@FXML
	protected void handleFromTime() {
		// TODO: 开始时间在结束时间之后时处理
		LocalDate startDate = festivalDate_from.getValue();
		LocalDate endDate;
		if (startDate != null && festivalDate_to.getValue() != null) {
			endDate = festivalDate_to.getValue();
			if (startDate.compareTo(endDate) >= 0) {
				Dialogs.showMessage("开始日期应在结束日期之前！");
				festivalDate_from.setValue(null);
			}
		}

	}

	@FXML
	protected void handleToTime() {
		// TODO: 开始时间在结束时间之后时处理
		LocalDate endDate = festivalDate_to.getValue();
		LocalDate startDate;
		if (endDate != null && festivalDate_from.getValue() != null) {
			startDate = festivalDate_from.getValue();
			if (startDate.compareTo(endDate) >= 0) {
				Dialogs.showMessage("结束日期应在开始日期之后！");
				festivalDate_to.setValue(null);
			}
		}
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
		return startTime.getValue()!=null && endTime.getValue()!=null && festivalDate_from.getValue()!=null 
				&& festivalDate_to.getValue()!=null;
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
		this.festivalDate_from.setPromptText(startDate.toString());
		this.festivalDate_to.setPromptText(endDate.toString());
	}

}
