package ui.discount;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import tools.Strategy_hotelType;

/**
 * 合作企业的单个item的界面的控制器
 * @author zjy
 *
 */
public class Company_HotelItemController extends HotelItemController{

	@FXML
	private TextField companyName;

	@FXML
	private void handleCompanyName(){
		title.setText(companyName.getText());
		enterpriseName=companyName.getText();
		handleSave();
	}
	
	@Override
	protected Strategy_hotelType getType() {
		return Strategy_hotelType.CooperateEnterprise;
	}
	
	@FXML@Override
	protected void setTitle() {
		handleCompanyName();
	}
	
	@Override
	protected boolean isFinished() {
		return startTime.getValue()!=null && endTime.getValue()!=null && discountNumber>0 
				&& companyName.getText().length()>0;
	}
	
	@Override
	protected void disableControls() {
		super.disableControls();
		companyName.setEditable(false);
	}
	
	/**
	 * 设置公司名称
	 * @param companyName 公司名称
	 */
	public void setCompanyName(String companyName) {
		this.companyName.setText(companyName);
		setTitle();
	}

}
