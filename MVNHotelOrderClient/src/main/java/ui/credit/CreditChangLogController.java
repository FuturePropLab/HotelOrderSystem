package ui.credit;

import com.jfoenix.controls.JFXMasonryPane;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import ui.main.DetailsController;

/**
 * 信用变化记录界面的控制器
 * @author zjy
 */
public class CreditChangLogController extends DetailsController{

	@FXML
	private AnchorPane creditList;
	
	
	@FXML
	private void initialize() {
		
	}
	
	/**
	 * 初始化组件的值
	 * @param customerID 客户ID
	 */
	public void initValue(String customerID) {
		//TODO:初始化组件的值
	}
}
