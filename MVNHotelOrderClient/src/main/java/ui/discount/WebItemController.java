package ui.discount;

import businesslogic.discount.DiscountWebController;
import businesslogicservice.DiscountWebService;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.paint.Color;
import tools.Strategy_webType;
import ui.utils.Dialogs;
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
	protected TextField discount;
	@FXML
	protected Hyperlink delete;// 确认和删除合一的按钮，名字叫delete
	@FXML
	protected TextField aditionalMessage;
	protected WebDiscountController webDiscountController;

	protected String discountID;

	public void setWebStrategyController(WebDiscountController webDiscountController) {
		this.webDiscountController = webDiscountController;
	}

	@FXML
	protected void handleDiscount() {
		double num = 0;
		try {
			num = Double.parseDouble(discount.getText());
		} catch (NumberFormatException e) {
			System.out.println("discount is not a number");// TODO: 折扣数不正确时处理
			discount.setText("");
			Dialogs.showMessage("折扣数非正确数字格式");
			return;
		}
		if (num < 0 || num > 10) {
			System.out.println("discount is not between 0 and 10");
			Dialogs.showMessage("折扣数应为0~10");
			discount.setText("");
			return;
		}

		handleSave();
	}

	@FXML
	protected abstract void handleDelete();

	@FXML
	protected abstract void handleSave();
	// TODO:调用blservice保存信息，如果某个子类item的信息和这个了类不一样，覆写此方法

	protected abstract Strategy_webType getType();

	protected abstract void setTitle();

	/**
	 * 检查是否填写完毕
	 * 
	 * @return
	 */
	protected abstract boolean isFinished();

	protected void disableControls() {
		state.setText("已删除");
		state.setTextFill(Color.GRAY);
		title.setTextFill(Color.GRAY);
		discount.setEditable(false);
		delete.setDisable(true);
	}

	public void setValue(String title, String state,  double discount, String discountID) {
		this.title.setText(title);
		this.state.setText(state);
		this.discount.setText(discount + "");
		this.delete.setText("删 除");// 字中间有空格
		this.discountID = discountID;
		setTitle();
	}
}
