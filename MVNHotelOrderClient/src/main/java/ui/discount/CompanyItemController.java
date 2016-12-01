package ui.discount;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.paint.Color;
import ui.discount.HotelDiscountController.ItemType;

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
	
	@Override
	protected ItemType getType() {
		return ItemType.COMPANY;
	}
	
	@Override
	protected void setTitle() {
		handleCompanyName();
	}
	
	@Override
	protected boolean isFinished() {
		return startTime.getValue()!=null && endTime.getValue()!=null && companyName.getText()!=null 
				&& companyName.getText().length()>0;
	}
	
	/**
	 * 设置公司名称
	 * @param companyName 公司名称
	 */
	public void setCompanyName(String companyName) {
		this.companyName.setText(companyName);
	}

}
