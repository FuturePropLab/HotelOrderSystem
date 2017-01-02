package ui.hotel;

import java.io.File;
import java.net.URI;

import businesslogic.hotel.HotelDealController;
import businesslogic.hotel.HotelManageController;
import businesslogic.login.LoginController;
import businesslogicservice.LoginService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import tools.AccountType;
import tools.ResultMessage_Hotel;
import ui.main.DetailsController;
import ui.utils.Dialogs;
import vo.HotelFacilityVO;

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
	private Button save;
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
	
	private File imageFile;
	
	private String hotelID;
	
    @FXML
    private void initialize() {
    	
//    	if(this.hotelID==null){
//    		this.hotelID = LoginController.getInstance().getLogState().accountID;
//    		HotelDealController hotelDealController = HotelDealController.getInstance();
//    		HotelFacilityVO hotelFacilityVO = hotelDealController.gethotelFacilityVO(hotelID);
////    	setValues(new HotelFacilityVO("hotelID", "hotelName", null, true, true, true, true, true, true, true, true, 
////    			true, true, "other"));
//    		setValues(hotelFacilityVO);
//    	}
    }
    
    @FXML
    private void handleSave() {
    	System.out.println("NOT there  ??????????/andleSave");
    	URI uri = null;
    	if(imageFile!=null){
    		System.out.println("save facility image:  "+imageFile.getAbsolutePath());
    		uri = imageFile.toURI();
    	}
    	System.out.println(uri);
    	
    	HotelFacilityVO hotelFacilityVO = new HotelFacilityVO(hotelID,hotelName.getText(),uri,
    			wifi.isSelected(),noneSmoke.isSelected(),diningHall.isSelected(),parkingLot.isSelected(),
    			elevator.isSelected(),conferenceHall.isSelected(),morningCall.isSelected(),
    			frontdeskservice.isSelected(),luggageStorage.isSelected(),breakfast.isSelected(),other.getText());
    	HotelManageController hotelManageController = HotelManageController.getInstance();
    	ResultMessage_Hotel result = hotelManageController.modifyFacility(hotelFacilityVO);
    	System.out.println(result);
    	if(result==ResultMessage_Hotel.success){
    		Dialogs.showMessage("修改成功");
    	}else{
    		Dialogs.showMessage("失败成功");
    	}
    }
    @FXML
    private void handleFacilitiesImage() {
    	LoginService loginService=LoginController.getInstance();
    	if(AccountType.Hotel.equals(loginService.getLogState().accountType)){
    		FileChooser fileChooser = new FileChooser();
    		fileChooser.setTitle("选择一张图片");
    		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("图片", "*.png", "*.jpg", "*.gif"));
    		File selectedFile = fileChooser.showOpenDialog(rootLayoutController.getPrimaryStage());
    		if (selectedFile != null) {
    			facilitiesImage.setImage(new Image(selectedFile.toURI().toString()));
    			imageFile=selectedFile;
    		}
    	}
    }
    
    /**
     * 设置界面各组件的值
     * @param hotelFacilityVO
     */
    public void setValues(HotelFacilityVO hotelFacilityVO) {
    	if(hotelFacilityVO==null){
    		System.err.println("HotelFacilityVO is null. At FacilitiesInfoController.setValues(HotelFacilityVO)");
    		return;
    	}
    	if(hotelFacilityVO.facilityImage!=null){
    		facilitiesImage.setImage(new Image(hotelFacilityVO.facilityImage.toString()));
    		imageFile=new File(hotelFacilityVO.facilityImage);
    	}
//    	System.out.println("Fac UI :  "+hotelFacilityVO.hotelName);
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
		
		LoginService login = LoginController.getInstance();
		AccountType account = login.getLogState().accountType;
		this.hotelID = hotelFacilityVO.hotelID;
		
    	if(!account.equals(AccountType.Hotel)){
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
    	else {
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
