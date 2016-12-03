package ui.hotel;

import java.awt.Checkbox;
import java.net.URI;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import tools.HotelFacility;
import ui.main.DetailsController;
import vo.HotelFacilityVO;

/**
 * 酒店详情界面的控制器
 * 目前没有任何要控制的内容
 * @author zjy
 */
public class FacilitiesInfoController extends DetailsController{
	@FXML
	private ImageView facilitiesImage;
	@FXML
	private Label hotelName;
	@FXML
	private Checkbox wifi;
	@FXML
	private Checkbox noneSmoke;//无烟房
	@FXML
	private Checkbox diningHall;//餐厅
	@FXML
	private Checkbox parkingLot;//免费停车场
	@FXML
	private Checkbox elevator;//电梯
	@FXML
	private Checkbox conferenceHall;//会议厅
	@FXML
	private Checkbox morningCall;//叫醒服务
	@FXML
	private Checkbox frontdeskservice;//24小时前台服务
	@FXML
	private Checkbox luggageStorage;//行李寄存
	@FXML
	private Checkbox breakfast;//供应早餐
	@FXML
	private TextField other;
	@FXML
	private Hyperlink save;
	@FXML
	private Label facility1;
	@FXML
	private Label facility2;
	@FXML
	private Label facility3;
	@FXML
	private Label facility4;
	@FXML
	private Label facility5;
	@FXML
	private Label service1;
	@FXML
	private Label service2;
	@FXML
	private Label service3;
	@FXML
	private Label service4;
	@FXML
	private Label service5;
	@FXML
	private Label service6;	
	private HotelFacilityVO hotelFacilityVO;
	
	
	/**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	if(hotelFacilityVO.facilityImage!=null){
    		facilitiesImage.setImage(new Image(hotelFacilityVO.facilityImage.toString()));
    	}
    	hotelName.setText(hotelFacilityVO.hotelName);
    	
		Label[] facilities={facility1,facility2,facility3,facility4,facility5,service1,service2,service3,
				service4,service5,service6};
		Checkbox[] facilitiesCheckbox={wifi,noneSmoke,diningHall,parkingLot,elevator,conferenceHall,morningCall,
				frontdeskservice,luggageStorage,breakfast};
		boolean[] AllFacilities={hotelFacilityVO.wifi,hotelFacilityVO.noneSmoke,hotelFacilityVO.diningHall,
				hotelFacilityVO.parkingLot,hotelFacilityVO.elevator,hotelFacilityVO.conferenceHall,
				hotelFacilityVO.morningCall,hotelFacilityVO.frontdeskservice,hotelFacilityVO.luggageStorage,
				hotelFacilityVO.breakfast};
		String[] texts={"wifi无线上网","无烟房","餐厅","免费停车场","电梯","会议厅","叫醒服务","24小时前台服务","行李寄存",
				"供应早餐"};
		
    	if(true){//TODO:如果不是酒店工作人员
    		for(Label label:facilities){//先把Lable清空
    			label.setText(null);
    		}
    		int facilitiyPointer=0;//如果有某项服务就加上一条
    		for(int i=0;i<AllFacilities.length;i++){
    			if(i==5){
    				facilitiyPointer=5;
    			}
    			if(AllFacilities[i]){
    				facilities[facilitiyPointer++].setText(texts[i]);
    			}
    		}
    		if(hotelFacilityVO.other!=null && !"".equals(hotelFacilityVO.other)){
    			facilities[facilitiyPointer].setText(hotelFacilityVO.other);
    		}
    		
    	}
    	else if (true) {//TODO:如果是酒店工作人员
			for(Label label:facilities){
				label.setVisible(false);
			}
			for(Checkbox checkbox:facilitiesCheckbox){
				checkbox.setVisible(true);
			}
			other.setVisible(true);
			save.setVisible(true);
		}
    }
    
    @FXML
    private void handleSave() {
    	//TODO:调用blservice保存信息
    }
    @FXML
    private void handleFacilitiesImage() {
    	//TODO:如果是酒店工作人员，就弹出文件选择器更换图片
    }
}
