package ui.discount;

import java.util.Date;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ui.discount.WebDiscountController.ItemType;

/**
 * 制定会员等级及其折扣的单个item的界面的控制器
 * 还没写
 * @author zjy
 *
 */
public class VIPLevelAndDiscount_WebItemController extends WebItemController{
	
	@FXML
	protected Label level;
	@FXML
	protected TextField credit;
	
	@FXML
	protected void handleCredit(){
		double num = 0;
		try {
			num=Double.parseDouble(credit.getText());
		} catch (NumberFormatException e) {
			System.out.println("credit is not a number.");// TODO: 信用值不正确时处理
		}
		if(num<0){
			System.out.println("discount is not bigger tan 0.");
		}
	}

	@Override
	protected ItemType getType() {
		return ItemType.VIPLevelAndDiscount;
	}

	@Override
	protected void setTitle() {
		title.setText(level.getText());
	}
	
	@Override
	protected boolean isFinished() {
		return !"".equals(credit.getText()) && !"".equals(discount.getText());
	}
	
	@Override
	protected void disableControls() {
		super.disableControls();
		credit.setDisable(true);
	}
	
	public void setLevel(int level) {
		this.level.setText("VIP"+level);
	}
	
	/**
	 * 
	 * @param state 状态
	 * @param discount 折扣
	 * @param level VIP等级
	 * @param credit 至少的信用值
	 */
	public void setValue(String state,double discount,int level, int credit) {
		this.state.setText(state);
		this.discount.setText(discount+"");
		this.delete.setText("删 除");//字中间有空格
		this.level.setText("VIP"+level);
		this.credit.setText(""+credit);
		setTitle();
	}
}
