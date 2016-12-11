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
 * 单个网站促销策略item的界面的控制器
 * 还没写
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
	protected Hyperlink delete;//确认和删除合一的按钮，名字叫delete
	protected WebDiscountController webDiscountController;


	public void setWebStrategyController(WebDiscountController webDiscountController) {
		this.webDiscountController = webDiscountController;
	}
	
	@FXML
	protected void handleDiscount(){
		double num = 0;
		try {
			num=Double.parseDouble(discount.getText());
		} catch (NumberFormatException e) {
			System.out.println("discount is not a number");// TODO: 折扣数不正确时处理
			discount.setText("");
			Dialogs.showMessage("折扣数非正确数字格式");
		}
		if(num<0||num>10){
			System.out.println("discount is not between 0 and 10");
			Dialogs.showMessage("折扣数应为0~10");
			return;
		}

		handleSave();
	}
	
	@FXML
	protected void handleDelete(){
		if(state.getText().equals("填写中")){
			if(isFinished()){
				setTitle();
				state.setText("未开始");
				
				//TODO: 调用blservice增加策略
				DiscountVO_web discountVO_web = new DiscountVO_web();
				delete.setText("删 除");//字中间有空格
				webDiscountController.addNewItem(getType());
			}
			else {
				System.out.println("the strategy is not finished");//TODO:弹窗提示未完成
			}
		}
		else {
			disableControls();
			//TODO: 调用blservice删除策略
			DiscountWebService discountWebService = DiscountWebController.getInstance();
//			String discountID = null; 
//			discountWebService.deleteDiscount(discountID);
		}
	}
	@FXML
	protected void handleSave() {
		//TODO:调用blservice保存信息，如果某个子类item的信息和这个了类不一样，覆写此方法
	}
	
	protected abstract Strategy_webType getType() ;
	protected abstract void setTitle() ;
	
	/**
	 * 检查是否填写完毕
	 * @return
	 */
	protected boolean isFinished() {
		return !"".equals(discount.getText());
	}
	
	protected void disableControls() {
		state.setText("已删除");
		state.setTextFill(Color.GRAY);
		title.setTextFill(Color.GRAY);
		discount.setEditable(false);
		delete.setDisable(true);
	}
}
