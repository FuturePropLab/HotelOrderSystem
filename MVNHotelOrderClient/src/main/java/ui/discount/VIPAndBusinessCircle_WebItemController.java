package ui.discount;

import java.util.List;

import businesslogic.discount.DiscountWebController;
import businesslogic.hotel.HotelDealController;
import businesslogicservice.DiscountWebService;
import businesslogicservice.HotelDealService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import tools.DiscountState;
import tools.Strategy_webType;
import ui.utils.Dialogs;
import vo.DiscountVO_web;
import vo.DiscountVO_web_district;
import vo.DiscountVO_web_level;

/**
 * VIP会员特定商圈专属折扣的单个item的界面的控制器 还没写
 * 
 * @author zjy
 *
 */
public class VIPAndBusinessCircle_WebItemController extends WebItemController {

	@FXML
	protected ComboBox<String> vipLevel;
	@FXML
	protected ComboBox<String> city;
	@FXML
	protected ComboBox<String> district;
	@FXML
	protected ComboBox<String> businessCircle;
	
	@FXML
	private void initialize() {
		DiscountWebService discountWebService = DiscountWebController.getInstance();
		HotelDealService hotelDealService=HotelDealController.getInstance();
		
		List<DiscountVO_web> getWebDiscount = discountWebService.getWebDiscount(Strategy_webType.Level, DiscountState.valid);
		for(int i=0;i<getWebDiscount.size();i++){
			this.vipLevel.getItems().add("VIP " + (i+1));
		}
		
		this.city.getItems().clear();
		this.city.getItems().addAll(hotelDealService.getAllCity());
	}

	@FXML
	protected void handleVIPLevel() {
		handleSave();
	}

	@FXML
	protected void handleCity() {
		HotelDealService hotelDealService=HotelDealController.getInstance();
		this.district.getItems().clear();
		this.district.getItems().addAll(hotelDealService.getAllDistrictByCity(this.city.getValue()));
		this.district.setValue(null);
	}

	@FXML
	protected void handleDistrict() {
		HotelDealService hotelDealService=HotelDealController.getInstance();
		this.businessCircle.getItems().clear();
		this.businessCircle.getItems().addAll(hotelDealService.getBusineeCircleByDistrict(this.district.getValue()));
		this.businessCircle.setValue(null);
	}

	@FXML
	protected void handleBusinessCircle() {
		setTitle();
		handleSave();
	}

	@FXML @Override
	protected void handleSave() {
		DiscountWebService discountWebService = DiscountWebController.getInstance();
		DiscountVO_web discountVO_web = new DiscountVO_web_district(Double.parseDouble(discount.getText())*0.1,
				vipLevel.getValue()==null?0:Integer.parseInt(vipLevel.getValue().split(" ")[1]), 
				city.getValue(), district.getValue(), businessCircle.getValue());
		discountVO_web.discountID = discountID;
		discountVO_web.discountState = DiscountState.valid;
		
		if (discountID != null)
			discountWebService.editWebDiscount(discountVO_web);
	}

	@Override
	protected Strategy_webType getType() {
		return Strategy_webType.VIP_district;
	}

	@Override
	protected void setTitle() {
		if (city.getValue() != null && district.getValue() != null && businessCircle.getValue() != null) {
			this.title.setText(businessCircle.getValue());
		}
	}

	@Override
	protected boolean isFinished() {
		return vipLevel.getValue() != null && city.getValue() != null && district.getValue() != null
				&& businessCircle.getValue() != null && discountNumber>0;
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
	 * 设置值
	 * @param vipLevel VIP等级
	 * @param city 城市
	 * @param district 区
	 * @param businessCircle 商圈
	 */
	public void setValue( int vipLevel, String city, String district,
			String businessCircle) {		
		this.vipLevel.setValue("VIP " + vipLevel);		
		this.city.setValue(city);
		handleCity();
		this.district.setValue(district);
		handleDistrict();
		this.businessCircle.setValue(businessCircle);
		setTitle();
	}

	@Override
	protected void add() {
		DiscountVO_web discountVO_web = new DiscountVO_web_district(Double.parseDouble(discount.getText())*0.1,
				Integer.valueOf(vipLevel.getValue().substring(4)), city.getValue(), district.getValue(),
				businessCircle.getValue());
		discountVO_web.discountID=this.discountID;
		discountVO_web.discountState =DiscountState.valid;
		DiscountWebService discountWebService = DiscountWebController.getInstance();
		discountWebService.addWebDiscount(discountVO_web);
	}
}
