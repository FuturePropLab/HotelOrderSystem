package ui.discount;

import java.time.LocalDate;
import java.util.Date;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import tools.Strategy_webType;
import ui.utils.Dialogs;

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
	protected void handleStartTime() {
		// TODO: 开始时间在结束时间之后时处理
		LocalDate startDate = startTime.getValue();
		LocalDate endDate;
		if (startDate != null && endTime.getValue() != null) {
			endDate = endTime.getValue();
			if (startDate.compareTo(endDate) >= 0) {
				Dialogs.showMessage("开始日期应在结束日期之前！");
				startTime.setValue(null);
				return;
			}
			handleSave();
		}
	}

	@FXML
	protected void handleEndTime() {
		// TODO: 开始时间在结束时间之后时处理
		LocalDate endDate = endTime.getValue();
		LocalDate startDate;
		if (endDate != null && startTime.getValue() != null) {
			startDate = startTime.getValue();
			if (startDate.compareTo(endDate) >= 0) {
				Dialogs.showMessage("结束日期应在开始日期之后！");
				endTime.setValue(null);
				return;
			}
			handleSave();
		}
	}

	@FXML
	protected void handleDiscount() {
		title.setText(discount.getText() + "折");
		super.handleDiscount();
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
		return startTime.getValue() != null && endTime.getValue() != null && !"".equals(discount.getText());
	}

	@Override
	protected void disableControls() {
		super.disableControls();
		startTime.setEditable(false);
		endTime.setEditable(false);
	}

	/**
	 * 
	 * @param state
	 *            状态
	 * @param discount
	 *            折扣
	 * @param startTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 */
	public void setValue(String state, double discount, Date startTime, Date endTime) {
		this.state.setText(state);
		this.discount.setText(discount + "");
		this.startTime.setPromptText(startTime.toString());
		this.endTime.setPromptText(endTime.toString());
		this.delete.setText("删 除");// 字中间有空格
		setTitle();
	}

	@Override
	protected void handleDelete() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void handleSave() {
		// TODO Auto-generated method stub

	}
}
