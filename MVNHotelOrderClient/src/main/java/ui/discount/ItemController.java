package ui.discount;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.paint.Color;

/**
 * 单个优惠item的界面的控制器
 * @author zjy
 *
 */
public class ItemController {

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
	protected Hyperlink delete;
	
	/**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    protected void initialize() {
    	//TODO: 将组建的值设置好
    }

	@FXML
	protected void handleDiscount(){
		double num = 0;
		try {
			num=Double.parseDouble(discount.getText());
		} catch (NumberFormatException e) {
			System.out.println("discount is not a number");// TODO: 折扣数不正确时处理
		}
		if(num<0||num>10){
			System.out.println("discount is not between 0 and 10");
		}
	}
	@FXML
	protected void handleStartTime(){
		//TODO: 开始时间在结束时间之后时处理
	}
	@FXML
	protected void handleEndTime(){
		//TODO: 开始时间在结束时间之后时处理
	}
	@FXML
	protected void handleDelete(){
		state.setText("已删除");
		state.setTextFill(Color.GRAY);
		title.setTextFill(Color.GRAY);
		aditionalMessage.setEditable(false);
		discount.setEditable(false);
		startTime.setEditable(false);
		endTime.setEditable(false);
		superposition.setDisable(true);
		delete.setDisable(true);
		//TODO: 调用blservice删除策略
	}
}
