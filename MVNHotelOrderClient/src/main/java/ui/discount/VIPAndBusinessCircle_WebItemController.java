package ui.discount;

import java.util.Date;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TitledPane;
import javafx.scene.paint.Color;
import ui.discount.WebDiscountController.ItemType;

/**
 * VIP会员特定商圈专属折扣的单个item的界面的控制器
 * 还没写
 * @author zjy
 *
 */
public class VIPAndBusinessCircle_WebItemController extends WebItemController{
	
	@FXML
	protected ComboBox<String> vipLevel;
	@FXML
	protected ComboBox<String> city;
	@FXML
	protected ComboBox<String> district;
	@FXML
	protected ComboBox<String> businessCircle;
	
	@FXML
	protected void handleVIPLevel(){
		//TODO:调用blservice获取VIP信息并填写
	}
	@FXML
	protected void handleDiscount(){
		super.handleDiscount();
	}
	@FXML
	protected void handleCity(){
		//TODO:调用blservice获取区的信息并填写
		
	}
	@FXML
	protected void handleDistrict(){
		//TODO:调用blservice获取商圈的信息并填写
	}
	@FXML
	protected void handleBusinessCircle(){
		if(city.getValue()!=null && district.getValue()!=null && businessCircle.getValue()!=null){
			title.setText(city.getValue()+"-"+district.getValue()+"-"+businessCircle.getValue());
		}
	}

	@Override
	protected ItemType getType() {
		return ItemType.VIPAndBusinessCircle;
	}

	@Override
	protected void setTitle() {
		handleBusinessCircle();
	}
	
	@Override
	protected boolean isFinished() {
		return vipLevel.getValue()!=null && city.getValue()!=null && district.getValue()!=null && 
				businessCircle.getValue()!=null && !"".equals(discount.getText());
	}
	
	@Override
	protected void disableControls() {
		super.disableControls();
		vipLevel.setDisable(true);
		city.setDisable(true);
		district.setDisable(true);
		businessCircle.setDisable(true);
	}
	
	/**
	 * 
	 * @param state 状态
	 * @param discount 折扣
	 * @param vipLevel VIP等级
	 * @param city 城市
	 * @param district 区
	 * @param businessCircle 商圈
	 */
	public void setValue(String state,double discount,int vipLevel, String city, String district, String businessCircle) {
		this.state.setText(state);
		this.discount.setText(discount+"");
		this.delete.setText("删 除");//字中间有空格
		this.vipLevel.setValue("VIP"+vipLevel);
		this.city.setValue(city);
		this.district.setValue(district);
		this.businessCircle.setValue(businessCircle);
		setTitle();
	}
}
