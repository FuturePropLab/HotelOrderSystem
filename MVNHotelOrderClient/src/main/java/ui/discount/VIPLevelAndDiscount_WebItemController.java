package ui.discount;

import com.jfoenix.controls.JFXTextField;

import businesslogic.discount.DiscountWebController;
import businesslogicservice.DiscountWebService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import tools.DiscountState;
import tools.Strategy_webType;
import ui.utils.Dialogs;
import ui.utils.TextFieldUtil;
import vo.DiscountVO_web;
import vo.DiscountVO_web_level;

/**
 * 制定会员等级及其折扣的单个item的界面的控制器
 * 
 * @author zjy
 *
 */
public class VIPLevelAndDiscount_WebItemController extends WebItemController {

	@FXML
	protected Label level;
	@FXML
	protected JFXTextField credit;
	private int creditNumber;
	
	@FXML
	private void initialize() {
		TextFieldUtil.setNumberValidator(credit);
	}

	@FXML
	protected void handleCredit() {
		int num = 0;
		try {
			num = Integer.parseInt(credit.getText());
		} catch (NumberFormatException e) {
			System.out.println("credit is not a number.");
			creditNumber=0;
			return;
		}
		if (num < 0) {
			System.out.println("credit is not bigger tan 0.");
			creditNumber=0;
			return;
		}
		this.creditNumber=num;
		handleSave();
	}

	@Override
	protected Strategy_webType getType() {
		return Strategy_webType.Level;
	}

	@Override
	protected void setTitle() {
		title.setText(level.getText());
	}

	@Override
	protected boolean isFinished() {
		return creditNumber>0 && discountNumber>0;
	}

	@Override
	protected void disableControls() {
		super.disableControls();
		credit.setDisable(true);
	}

	public void setLevel(int level) {
		this.level.setText("VIP " + level);
	}

	/**
	 * 设置值
	 * @param level VIP等级
	 * @param credit 最低信用值
	 */
	public void setValue( int level, int credit) {
		this.level.setText("VIP " + level);
		this.credit.setText("" + credit);
		this.creditNumber=credit;
		setTitle();
	}

	@Override
	protected void add() {
		DiscountVO_web discountVO_web = new DiscountVO_web_level(Strategy_webType.Level,
				Double.parseDouble(discount.getText()), Integer.valueOf(level.getText()),
				Integer.valueOf(credit.getText()));
		DiscountWebService discountWebService = DiscountWebController.getInstance();
		discountWebService.addWebDiscount(discountVO_web);
	}

	@Override
	protected void handleSave() {
		DiscountVO_web discountVO_web = new DiscountVO_web_level(Strategy_webType.Level, 
				Double.parseDouble(discount.getText())*0.1,Integer.parseInt(level.getText().split(" ")[1]), 
				Integer.parseInt(credit.getText()));
		
		discountVO_web.discountID = discountID;
		discountVO_web.discountState = DiscountState.valid;
		if (discountID != null)
			DiscountWebController.getInstance().editWebDiscount(discountVO_web);
	}
}
