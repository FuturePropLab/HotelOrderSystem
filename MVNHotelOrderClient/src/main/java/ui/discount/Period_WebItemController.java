package ui.discount;

import java.util.Date;

import com.sun.org.apache.bcel.internal.generic.RET;
import com.sun.org.apache.bcel.internal.generic.RETURN;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.paint.Color;
import ui.discount.WebDiscountController.ItemType;

/**
 * 特定期间预订折扣的单个item的界面的控制器
 * 还没写
 * @author zjy
 *
 */
public class Period_WebItemController extends WebItemController{
	@FXML
	protected DatePicker startTime;
	@FXML
	protected DatePicker endTime;
	
	@FXML
	protected void handleStartTime(){
		//TODO: 开始时间在结束时间之后时处理
		if(endTime.getValue()!=null){
			if(startTime.getValue().compareTo(endTime.getValue())>=0){
				//怎么处理？？弹窗？
				return ;
			}
		}
		handleSave();
	}
	@FXML
	protected void handleEndTime(){
		//TODO: 开始时间在结束时间之后时处理
		if(startTime.getValue()!=null){
			if(startTime.getValue().compareTo(endTime.getValue())>=0){
				//怎么处理？？弹窗？
				return;
			}
		}
		handleSave();
	}	
	@FXML
	protected void handleDiscount(){
		title.setText(discount.getText()+"折");
		super.handleDiscount();
	}

	@Override
	protected ItemType getType() {
		return ItemType.SpecialDay;
	}

	@Override
	protected void setTitle() {
		handleDiscount();
	}
	
	@Override
	protected boolean isFinished() {
		return startTime.getValue()!=null && endTime.getValue()!=null && !"".equals(discount.getText());
	}
	
	@Override
	protected void disableControls() {
		super.disableControls();
		startTime.setEditable(false);
		endTime.setEditable(false);
	}
	
	/**
	 * 
	 * @param state 状态
	 * @param discount 折扣
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 */
	public void setValue(String state,double discount,Date startTime, Date endTime) {
		this.state.setText(state);
		this.discount.setText(discount+"");
		this.startTime.setPromptText(startTime.getYear()+"-"+startTime.getMonth()+"-"+startTime.getDate());
		this.endTime.setPromptText(endTime.getYear()+"-"+endTime.getMonth()+"-"+endTime.getDate());
		this.delete.setText("删 除");//字中间有空格
		setTitle();
	}
}
