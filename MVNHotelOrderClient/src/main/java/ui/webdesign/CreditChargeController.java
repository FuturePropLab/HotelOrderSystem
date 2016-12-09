package ui.webdesign;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ui.main.DetailsController;

/**
 * 信用充值界面的控制器
 * @author zjy
 *
 */
public class CreditChargeController extends DetailsController{

	@FXML
	private TextField userName;
	@FXML
	private Label customerName;
	@FXML
	private Label credit;
	@FXML
	private Label plusVaule;
	@FXML
	private TextField amount;
	@FXML
	private Button charge;
	
	@FXML
	private void handleUserName(){
		
	}
	@FXML
	private void handleAmount(){
		plusVaule.setText(Integer.parseInt(amount.getText())*100+"");
	}
	@FXML
	private void handleCharge(){
		
	}
	
}
