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
 * 合作企业的单个item的界面的控制器
 * @author zjy
 *
 */
public class CompanyItemController extends ItemController{

	@FXML
	private TextField companyName;

	@FXML
	private void handleCompanyName(){
		title.setText(companyName.getText());
	}
}
