package ui.discount;

import com.jfoenix.controls.JFXTextField;

import businesslogic.discount.DiscountWebController;
import businesslogicservice.DiscountWebService;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.paint.Color;
import tools.DiscountState;
import tools.ResultMessage_Discount;
import tools.Strategy_webType;
import ui.utils.Dialogs;
import ui.utils.DoubleFormate;
import ui.utils.TextFieldUtil;
import vo.DiscountVO_web;

/**
 * 单个网站促销策略item的界面的控制器 还没写
 * 
 * @author zjy
 *
 */
public abstract class WebItemController {

	@FXML
	protected TitledPane title;
	@FXML
	protected Label state;
	@FXML
	protected JFXTextField discount;
	@FXML
	protected Hyperlink delete;// 确认和删除合一的按钮，名字叫delete
	@FXML
	protected TextField aditionalMessage;
	protected WebDiscountController webDiscountController;
	protected String discountID;
	protected double discountNumber;

	public void setWebStrategyController(WebDiscountController webDiscountController) {
		this.webDiscountController = webDiscountController;
	}

	@FXML
	private void initialize() {
		TextFieldUtil.setNumberValidator(discount);
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
	protected void handleDelete(){
		if (state.getText().equals("填写中")) {
			if (isFinished()) {
				setTitle();
				state.setText("进行中");
				state.setTextFill(Color.GREEN);
				delete.setText("删 除");// 字中间有空格
				add();
				
				webDiscountController.addNewItem(getType());
			}else {
				Dialogs.showMessage("策略未完成");
			}
		}else {
			disableControls();
			DiscountWebService discountWebService = DiscountWebController.getInstance();
			ResultMessage_Discount result=discountWebService.deleteDiscount(this.discountID);
			if(ResultMessage_Discount.Success.equals(result)){
				state.setText("已失效");
				state.setTextFill(Color.GREY);
			}
		}
	}
	
	@FXML	//调用blservice保存信息，如果某个子类item的信息和这个了类不一样，覆写此方法
	protected abstract void handleSave();
	
	protected void setTitle(){
		this.title.setText(discountNumber+"折");
	}

	protected abstract Strategy_webType getType();
	protected abstract boolean isFinished();
	protected abstract void add();

	protected void disableControls() {
		state.setText("已删除");
		state.setTextFill(Color.GRAY);
		title.setTextFill(Color.GRAY);
		discount.setEditable(false);
		discount.setDisable(true);
		delete.setDisable(true);
	}

	/**
	 * 设置策略的值
	 * @param title 标题
	 * @param state 状态
	 * @param discount 折扣
	 * @param discountID 折扣ID
	 */
	public void setValue(String title, String state,  double discount, String discountID) {
		this.title.setText(title);
		this.state.setText(state);
		this.state.setTextFill("进行中".equals(state)?Color.GREEN:Color.GREY);
		this.discount.setText(DoubleFormate.formateto(discount));
		this.delete.setText("删 除");// 字中间有空格
		this.discountID = discountID;
		setTitle();
	}
}
