package ui.discount;

import java.time.LocalDate;
import java.util.Date;

import businesslogic.discount.DiscountWebController;
import businesslogicservice.DiscountWebService;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.paint.Color;
import tools.DiscountState;
import tools.ResultMessage_Discount;
import tools.Strategy_webType;
import ui.utils.DateFormat;
import ui.utils.Dialogs;
import vo.DiscountVO_web;
import vo.DiscountVO_web_district;
import vo.DiscountVO_web_level;
import vo.DiscountVO_web_period;

/**
 * 特定期间预订折扣的单个item的界面的控制器 还没写
 * 
 * @author zjy
 *
 */
public class Period_WebItemController extends WebItemController {
	@FXML
	protected DatePicker startTime;
	@FXML
	protected DatePicker endTime;
	
	@FXML
	private void initialize() {
		DateFormat.initDatePicker(startTime, endTime);
	}

	@FXML
	protected void handleStartTime() {
		handleSave();
	}

	@FXML
	protected void handleEndTime() {
		handleSave();
	}

	@Override
	protected Strategy_webType getType() {
		return Strategy_webType.Period;
	}

	@Override
	protected void setTitle() {
		handleDiscount();
	}

	@Override
	protected boolean isFinished() {
		return startTime.getValue() != null && endTime.getValue() != null && discountNumber>0;
	}

	@Override
	protected void disableControls() {
		super.disableControls();
		startTime.setEditable(false);
		endTime.setEditable(false);
	}


	/**
	 * 设置值
	 * @param startDate 开始时间
	 * @param endDate 结束时间
	 */
	public void setValue( LocalDate startDate, LocalDate endDate) {
		this.startTime.setValue(startDate);
		this.endTime.setValue(endDate);
		setTitle();
	}

	@Override
	protected void add() {
		DiscountVO_web discountVO_web = new DiscountVO_web_period(startTime.getValue(), endTime.getValue(),
				Double.parseDouble(discount.getText()));
		DiscountWebService discountWebService = DiscountWebController.getInstance();
		discountWebService.addWebDiscount(discountVO_web);
	}

	@FXML@Override
	protected void handleSave() {
		DiscountVO_web discountVO_web = new DiscountVO_web_period(startTime.getValue(), endTime.getValue(),
				Double.parseDouble(discount.getText())*0.1);
		discountVO_web.discountID=discountID;
		discountVO_web.discountState =DiscountState.valid;
		DiscountWebService discountWebService = DiscountWebController.getInstance();
		discountWebService.editWebDiscount(discountVO_web);
	}
}
