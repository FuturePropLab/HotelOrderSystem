package ui.discount;

import java.util.List;

import businesslogic.discount.DiscountHotelController;
import businesslogic.discount.DiscountWebController;
import businesslogic.hotel.HotelDealController;
import businesslogicservice.DiscountHotelService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import tools.DiscountState;
import tools.Strategy_webType;
import ui.administor.HotelController;
import vo.DiscountVO_hotel;
import vo.DiscountVO_web;

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
	protected void handleVIPLevel() {
		// TODO:调用blservice获取VIP信息并填写
		List<DiscountVO_web> list = DiscountWebController.getInstance().getWebDiscount(Strategy_webType.Level,
				DiscountState.valid);
		int levels = list.size();
		ObservableList<String> options = FXCollections.observableArrayList(// 可能有一些臆测成分。。待检测
				"Level 1");
		for (int i = 2; i < levels +1; i++) {
			options.add("Level " + i);
		}

		vipLevel = new ComboBox<String>(options);

		handleSave();
	}

	@FXML
	protected void handleDiscount() {
		super.handleDiscount();
	}

	@FXML
	protected void handleCity() {
		// TODO:调用blservice获取区的信息并填写 ,我暂时臆测了一下写了，待问@lwy
		if (city.getValue() != null) {
			List<String> districts = HotelDealController.getInstance().getAllDistrictByCity(city.getValue());
			for(String diString : districts){
				district.getItems().add(diString);
			}
		}
		
	}

	@FXML
	protected void handleDistrict() {
		// TODO:调用blservice获取商圈的信息并填写
		if (district.getValue() != null) {
			List<String> bList = HotelDealController.getInstance().getBusineeCircleByDistrict(district.getValue());
			for(String bString : bList){
				businessCircle.getItems().add(bString);
			}
		}
		
	}

	@FXML
	protected void handleBusinessCircle() {
		if (city.getValue() != null && district.getValue() != null && businessCircle.getValue() != null) {
			title.setText(city.getValue() + "-" + district.getValue() + "-" + businessCircle.getValue());
		}
		
		handleSave();
	}
	
	@FXML @Override
	protected void handleSave() {
//			DiscountWebService discountWebService = DiscountWebController.getInstance();
//			DiscountVO_web discountVO_web = new DiscountVO_web()
//			// TODO:调用blservice保存信息，如果某个子类item的信息和这个了类不一样，覆写此方法
//			if (discountID != null)
//				discountHotelService.editHotelDiscount(discountID, discountVO_hotel);
	}
	
	@Override
	protected Strategy_webType getType() {
		return Strategy_webType.VIP_district;
	}

	@Override
	protected void setTitle() {
		handleBusinessCircle();
	}

	@Override
	protected boolean isFinished() {
		return vipLevel.getValue() != null && city.getValue() != null && district.getValue() != null
				&& businessCircle.getValue() != null && !"".equals(discount.getText());
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
	 * @param state
	 *            状态
	 * @param discount
	 *            折扣
	 * @param vipLevel
	 *            VIP等级
	 * @param city
	 *            城市
	 * @param district
	 *            区
	 * @param businessCircle
	 *            商圈
	 */
	public void setValue(String state, double discount, int vipLevel, String city, String district,
			String businessCircle) {
		this.state.setText(state);
		this.discount.setText(discount + "");
		this.delete.setText("删 除");// 字中间有空格
		this.vipLevel.setValue("VIP" + vipLevel);
		this.city.setValue(city);
		this.district.setValue(district);
		this.businessCircle.setValue(businessCircle);
		setTitle();
	}

	@Override
	protected void handleDelete() {
		// TODO Auto-generated method stub
		
	}
}
