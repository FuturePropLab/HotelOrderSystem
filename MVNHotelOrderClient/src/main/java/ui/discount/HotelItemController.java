package ui.discount;

import java.time.LocalDate;

import businesslogic.discount.DiscountHotelController;
import businesslogic.login.LoginController;
import businesslogicservice.DiscountHotelService;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.paint.Color;
import tools.DiscountState;
import tools.Strategy_hotelType;
import ui.utils.Dialogs;
import vo.DiscountVO_hotel;

/**
 * 单个酒店优惠item的界面的控制器
 * 
 * @author zjy
 *
 */
public abstract class HotelItemController {

	@FXML
	protected TitledPane title;
	@FXML
	protected Label state;
	@FXML
	protected TextField aditionalMessage;
	@FXML
	protected TextField discount;
	@FXML
	protected DatePicker startTime;
	@FXML
	protected DatePicker endTime;
	@FXML
	protected CheckBox superposition;
	@FXML
	protected Hyperlink delete;// 确认和删除合一的按钮，名字叫delete
	protected HotelDiscountController hotelDiscountController;

	private String hotelID;
	private String discountID;
	private String enterpriseName;

	public void setHotelDiscountController(HotelDiscountController hotelDiscountController) {
		this.hotelDiscountController = hotelDiscountController;
	}
	
	@FXML
	protected void handleDiscount() {
//		double num = 0;
//		try {
//			num = Double.parseDouble(discount.getText());
//		} catch (NumberFormatException e) {
//			System.out.println("discount is not a number");// TODO: 折扣数不正确时处理
//			Dialogs.showMessage("折扣格式不正确");
//			discount.setText("");
//			return;
//		}
//		if (num < 0 || num > 10) {
//			System.out.println("discount is not between 0 and 10");
//			Dialogs.showMessage("折扣数应在0~10之间");
//			discount.setText("");
//			return;
//		}
//		if (discountID != null)
//			handleSave();
	}

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
			if (discountID != null)
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
			if (discountID != null)
				handleSave();
		}
	}

	@FXML
	protected void handleDelete() {
		if (state.getText().equals("填写中")) {
			if (isFinished()) {
				setTitle();
				state.setText("未开始");

				// TODO: 调用blservice新增策略
				delete.setText("删 除");// 字中间有空格
				DiscountHotelService discountHotelService = DiscountHotelController.getInstance();
				DiscountVO_hotel discountVO_hotel = new DiscountVO_hotel(Double.parseDouble(discount.getText()) * 0.1,
						startTime.getValue(), endTime.getValue(), aditionalMessage.getText(),
						superposition.isSelected(),getType(), enterpriseName);
				discountHotelService.addHotelDiscount(hotelID, discountVO_hotel);
				hotelDiscountController.addNewItem(getType());
			} else {
				Dialogs.showMessage("策略未完成");
			}
		} else {
			disableControls();
			// TODO: 调用blservice删除策略
			DiscountHotelService discountHotelService = DiscountHotelController.getInstance();
			if (discountID != null)
				discountHotelService.deleteHotelDiscount(hotelID, discountID);
			hotelDiscountController.addNewItem(getType());
		}
	}

	@FXML
	protected void handleSave() {
		DiscountHotelService discountHotelService = DiscountHotelController.getInstance();
		DiscountVO_hotel discountVO_hotel = new DiscountVO_hotel(Double.parseDouble(discount.getText()) * 0.1,
				startTime.getValue(), endTime.getValue(), aditionalMessage.getText(), superposition.isSelected(),
				getType(), enterpriseName);
		discountVO_hotel.discountID=discountID;
		discountVO_hotel.discountState=DiscountState.valid;//策略狀態問題有待解決
		// TODO:调用blservice保存信息，如果某个子类item的信息和这个了类不一样，覆写此方法
		if (discountID != null)
			discountHotelService.editHotelDiscount(hotelID, discountVO_hotel);
	}

	protected abstract Strategy_hotelType getType();

	protected abstract void setTitle();

	/**
	 * 检查是否填写完毕
	 * 
	 * @return
	 */
	protected boolean isFinished() {
		return startTime.getValue() != null && endTime.getValue() != null && !"".equals(discount.getText());
	}

	protected void disableControls() {
		state.setText("已删除");
		state.setTextFill(Color.GRAY);
		title.setTextFill(Color.GRAY);
		aditionalMessage.setEditable(false);
		discount.setEditable(false);
		startTime.setEditable(false);
		endTime.setEditable(false);
		superposition.setDisable(true);
		delete.setDisable(true);
	}

	/**
	 * 
	 * @param title
	 *            标题
	 * @param state
	 *            状态
	 * @param aditionalMessage
	 *            备注
	 * @param discount
	 *            折扣
	 * @param startTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @param superposition
	 *            能否与其它折扣叠加
	 */
	public void setValue(String title, String state, String aditionalMessage, double discount, LocalDate startTime,
			LocalDate endTime, boolean superposition, String discountID, String enterpriseName) {
		this.title.setText(title);
		this.state.setText(state);
		this.aditionalMessage.setText(aditionalMessage);
		this.discount.setText(discount + "");
		this.startTime.setPromptText(startTime.toString());
		this.endTime.setPromptText(endTime.toString());
		this.superposition.setSelected(superposition);
		this.delete.setText("删 除");// 字中间有空格
		this.hotelID = LoginController.getInstance().getLogState().accountID;
		this.discountID = discountID;
		this.enterpriseName = enterpriseName;
		setTitle();
		this.discount.focusedProperty().addListener(e->{
			double num = 0;
			try {
				num = Double.parseDouble(this.discount.getText());
			} catch (NumberFormatException e1) {
				System.out.println("discount is not a number");// TODO: 折扣数不正确时处理
				Dialogs.showMessage("折扣格式不正确");
				this.discount.setText("");
				return;
			}
			if (num < 0 || num > 10) {
				System.out.println("discount is not between 0 and 10");
				Dialogs.showMessage("折扣数应在0~10之间");
				this.discount.setText("");
				return;
			}
			if (discountID != null)
				handleSave();
		});
	}
}
