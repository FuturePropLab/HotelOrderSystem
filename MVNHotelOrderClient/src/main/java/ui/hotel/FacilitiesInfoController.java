package ui.hotel;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import businesslogic.hotel.HotelDealController;
import businesslogic.hotel.HotelManageController;
import businesslogicservice.ManageHotelInfoService;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import tools.HotelRoomInfo;
import tools.ResultMessage_Hotel;
import ui.main.DetailsController;
import vo.HotelDiscribtionsVO;
import vo.HotelFacilityVO;
import vo.HotelInputVO;

/**
 * 酒店详情界面的控制器
 * @Attention
 * 创建这个对象的时候必须要执行setValues
 * @author zjy
 */
public class FacilitiesInfoController extends DetailsController{
	@FXML
	private ImageView facilitiesImage;
	@FXML
	private Label hotelName;
	@FXML
	private CheckBox wifi;
	@FXML
	private CheckBox noneSmoke;//无烟房
	@FXML
	private CheckBox diningHall;//餐厅
	@FXML
	private CheckBox parkingLot;//免费停车场
	@FXML
	private CheckBox elevator;//电梯
	@FXML
	private CheckBox conferenceHall;//会议厅
	@FXML
	private CheckBox morningCall;//叫醒服务
	@FXML
	private CheckBox frontdeskservice;//24小时前台服务
	@FXML
	private CheckBox luggageStorage;//行李寄存
	@FXML
	private CheckBox breakfast;//供应早餐
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
	

	private String hotelID = "HT001" ; //@author wsw  这个应该在初始化这个界面的时候就传过来的
	
	private ManageHotelInfoService manageInfoService;

	
    @FXML
    private void initialize() {
//    	HotelDealController hotelDealController = HotelDealController.getInstance();
//    	HotelFacilityVO hotelFacilityVO = hotelDealController.gethotelFacilityVO(hotelID);
    	//if(hotelFacilityVO!=null)
    	setValues(new HotelFacilityVO("hotelID", "hotelName", null, true, true, true, true, true, true, true, true, 
    			true, true, "other"));
//    	setValues(hotelFacilityVO);
    }
    
    @FXML
    private void handleSave() {

    	//TODO:调用blservice保存信息
    	HotelFacilityVO hotelFacilityVO = null;
    	URL url = null;
    try {
		hotelFacilityVO = new HotelFacilityVO(hotelID,hotelName.getText(),url.toURI(),Boolean.valueOf(wifi.getText()).booleanValue(),Boolean.valueOf(noneSmoke.getText()).booleanValue(),Boolean.valueOf(diningHall.getText()).booleanValue(),Boolean.valueOf(parkingLot.getText()).booleanValue(),Boolean.valueOf(elevator.getText()).booleanValue(),Boolean.valueOf(conferenceHall.getText()).booleanValue(),Boolean.valueOf(morningCall.getText()).booleanValue(),Boolean.valueOf(frontdeskservice.getText()).booleanValue(),Boolean.valueOf(luggageStorage.getText()).booleanValue(),Boolean.valueOf(breakfast.getText()).booleanValue(),other.getText());
	} catch (URISyntaxException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    	//String hotelID, String hotelName, URI facilityImage, boolean wifi, boolean noneSmoke,
		//boolean diningHall, boolean parkingLot, boolean elevator, boolean conferenceHall, boolean morningCall,
		//boolean frontdeskservice, boolean luggageStorage, boolean breakfast, String other
		HotelInputVO hotelInfoVO = new HotelInputVO(hotelID, hotelFacilityVO, null,null);
    	manageInfoService = HotelManageController.getInstance();
    	ResultMessage_Hotel result = manageInfoService.saveHotelInfo(hotelInfoVO);

    	
    }
    @FXML
    private void handleFacilitiesImage() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("选择一张图片");
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("图片", "*.png", "*.jpg", "*.gif"));
		File selectedFile = fileChooser.showOpenDialog(rootLayoutController.getPrimaryStage());
		if (selectedFile != null) {
			facilitiesImage.setImage(new Image(selectedFile.toURI().toString()));
		}
    }
    
    public void setValues(HotelFacilityVO hotelFacilityVO) {
    	if(hotelFacilityVO==null){
    		System.out.println("HotelFacilityVO is null. At FacilitiesInfoController.setValues(HotelFacilityVO)");
    		return;
    	}
    	if(hotelFacilityVO.facilityImage!=null){
    		facilitiesImage.setImage(new Image(hotelFacilityVO.facilityImage.toString()));
    	}
    	System.out.println("Fac UI :  "+hotelFacilityVO.hotelName);
    	hotelName.setText(hotelFacilityVO.hotelName);
    	
		Label[] facilities={facility1,facility2,facility3,facility4,facility5,service1,service2,service3,
				service4,service5,service6};
		CheckBox[] facilitiesCheckbox={wifi,noneSmoke,diningHall,parkingLot,elevator,conferenceHall,morningCall,
				frontdeskservice,luggageStorage,breakfast};
		boolean[] AllFacilities={hotelFacilityVO.wifi,hotelFacilityVO.noneSmoke,hotelFacilityVO.diningHall,
				hotelFacilityVO.parkingLot,hotelFacilityVO.elevator,hotelFacilityVO.conferenceHall,
				hotelFacilityVO.morningCall,hotelFacilityVO.frontdeskservice,hotelFacilityVO.luggageStorage,
				hotelFacilityVO.breakfast};
		String[] texts={"wifi无线上网","无烟房","餐厅","免费停车场","电梯","会议厅","叫醒服务","24小时前台服务","行李寄存",
				"供应早餐"};
		
    	if(false){//TODO:如果不是酒店工作人员
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
    	else {//TODO:如果是酒店工作人员
			for(Label label:facilities){
				label.setVisible(false);
			}
			for(int i=0;i<facilitiesCheckbox.length;i++){
				facilitiesCheckbox[i].setVisible(true);
				facilitiesCheckbox[i].setSelected(AllFacilities[i]);
			}
			other.setVisible(true);
			other.setText(hotelFacilityVO.other);
			save.setVisible(true);
		}
    }
}
