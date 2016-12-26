package ui.discount;

import java.time.LocalDate;

import com.jfoenix.controls.JFXTextField;

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
import tools.ResultMessage_Discount;
import tools.Strategy_hotelType;
import ui.utils.DateFormat;
import ui.utils.Dialogs;
import ui.utils.TextFieldUtil;
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
	protected JFXTextField discount;
	@FXML
	protected DatePicker startTime;
	@FXML
	protected DatePicker endTime;
	@FXML
	protected CheckBox superposition;
	@FXML
	protected Hyperlink delete;// 确认和删除合一的按钮，名字叫delete
	protected HotelDiscountController hotelDiscountController;

	protected double discountNumber;
	private String hotelID;
	private String discountID;
	private String enterpriseName;

	public void setHotelDiscountController(HotelDiscountController hotelDiscountController) {
		this.hotelDiscountController = hotelDiscountController;
	}
	
	@FXML
	private void initialize() {
		TextFieldUtil.setNumberValidator(discount);
		DateFormat.initDatePicker(startTime, endTime);
	}
	
	@FXML
	protected void handleDiscount() {
		double num = 0;
		try {
			num = Double.parseDouble(discount.getText());
		} catch (NumberFormatException e) {
			System.out.println("discount is not a number");
			this.discountNumber=0;
			return;
		}
		if (num < 0 || num > 10) {
			System.out.println("discount is not between 0 and 10");
			this.discountNumber=0;
			return;
		}
		this.discountNumber=num;
		handleSave();
	}
	@FXML
	protected void handleStartTime() {
		handleSave();
	}
	@FXML
	protected void handleEndTime() {
		handleSave();
	}
	
	/**
	 * 这个方法是处理确定和删除合一按钮的监听方法
	 */
	@FXML
	protected void handleDelete() {
		if (state.getText().equals("填写中")) {
			if (isFinished()) {
				setTitle();
				state.setText("进行中");
				state.setTextFill(Color.GREEN);
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
			DiscountHotelService discountHotelService = DiscountHotelController.getInstance();
			if (discountID != null){
				ResultMessage_Discount result=discountHotelService.deleteHotelDiscount(hotelID, discountID);
				if(ResultMessage_Discount.Success.equals(result)){
					state.setText("已删除");
					state.setTextFill(Color.GREY);
				}
			}
		}
	}

	@FXML
	protected void handleSave() {
		if (isFinished()) {
			DiscountHotelService discountHotelService = DiscountHotelController.getInstance();
			DiscountVO_hotel discountVO_hotel = new DiscountVO_hotel(Double.parseDouble(discount.getText()) * 0.1,
					startTime.getValue(), endTime.getValue(), aditionalMessage.getText(), superposition.isSelected(),
					getType(), enterpriseName);
			discountVO_hotel.discountID=discountID;
			discountVO_hotel.discountState="已删除".equals(this.state.getText())?DiscountState.invalid:DiscountState.valid;
			discountHotelService.editHotelDiscount(hotelID, discountVO_hotel);
		}else {
			Dialogs.showMessage("策略未完成");
		}
	}

	protected abstract Strategy_hotelType getType();

	protected abstract void setTitle();

	/**
	 * 检查是否填写完毕
	 * 
	 * @return
	 */
	protected boolean isFinished() {
		return startTime.getValue() != null && endTime.getValue() != null && discountNumber>0;
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
		this.state.setTextFill(DiscountState.valid.equals("进行中")?Color.GREEN:Color.GREY);
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
				System.out.println("discount is not a number");
				this.discount.setText("");
				return;
			}
			if (num < 0 || num > 10) {
				System.out.println("discount is not between 0 and 10");
				this.discount.setText("");
				return;
			}
			if (discountID != null)
				handleSave();
		});
	}
}
