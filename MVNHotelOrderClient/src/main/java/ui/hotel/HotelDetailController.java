package ui.hotel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.jfoenix.controls.JFXTextField;

import businesslogic.hotel.HotelDealController;
import businesslogic.hotel.HotelManageController;
import businesslogic.login.LoginController;
import businesslogicservice.HotelDealService;
import businesslogicservice.LoginService;
import businesslogicservice.ManageHotelInfoService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import tools.AccountType;
import tools.HotelAddress;
import tools.ResultMessage_Hotel;
import tools.RoomType;
import ui.customer.BookHotelController;
import ui.main.DetailsController;
import ui.order.OrderListController;
import ui.room.RoomInfoController;
import ui.utils.Dialogs;
import ui.utils.DoubleFormate;
import ui.utils.StarHelper;
import ui.utils.TextFieldUtil;
import vo.CommentVO;
import vo.HotelDetailsVO;
import vo.HotelDiscribtionsVO;
import vo.HotelInputVO;
import vo.LogVO;

/**
 * 酒店详情界面的控制器
 * @author zjy
 */
public class HotelDetailController extends DetailsController{
	private static Image yellowStar=new Image("file:./target/resources/images/star__selected.png");
	private static Image greyStar=new Image("file:./target/resources/images/star_unselected.png");
	private static String starArray[]={"1星酒店","2星酒店","3星酒店","4星酒店","5星酒店"};

	@FXML
	private ImageView hotelImage;
	@FXML
	private Hyperlink EluxeSuite;
	@FXML
	private Hyperlink Suites;
	@FXML
	private Hyperlink Standard;
	@FXML
	private Hyperlink Double;
	@FXML
	private Hyperlink Single;
	@FXML
	private Button bookEluxeSuite;
	@FXML
	private Button bookSuites;
	@FXML
	private Button bookStandard;
	@FXML
	private Button bookDouble;
	@FXML
	private Button bookSingle;
	@FXML
	private Label hotelNameLabel;//除了酒店工作人员，其他用户可见
	@FXML
	private JFXTextField hotelNameTextField;//只有酒店工作人员可见
	@FXML
	private TextArea describtionTextArea;//只有酒店工作人员可见
	@FXML
	private Text describtionText;//除了酒店工作人员，其他用户可见
	@FXML
	private ImageView star_1;
	@FXML
	private ImageView star_2;
	@FXML
	private ImageView star_3;
	@FXML
	private ImageView star_4;
	@FXML
	private ImageView star_5;
	@FXML
	private Label starLabel;
	@FXML
	private HBox starHBox;//除了酒店工作人员，其他用户可见
	@FXML
	private ComboBox<String> starComboBox;//只有酒店工作人员可见
	@FXML
	private ImageView mark_1;
	@FXML
	private ImageView mark_2;
	@FXML
	private ImageView mark_3;
	@FXML
	private ImageView mark_4;
	@FXML
	private ImageView mark_5;
	@FXML
	private Label mark;
	@FXML
	private Hyperlink facilities;
	@FXML
	private Hyperlink assess;
	@FXML
	private Label address_Label;//除了酒店工作人员，其他用户可见
	@FXML
	private Label cityLabel;//除了酒店工作人员，其他用户可见
	@FXML
	private Label districtLabel;//除了酒店工作人员，其他用户可见
	@FXML
	private Label businessCircleLabel;//除了酒店工作人员，其他用户可见
	@FXML
	private ComboBox<String> cityComboBox;//只有酒店工作人员可见
	@FXML
	private ComboBox<String> districtComboBox;//只有酒店工作人员可见
	@FXML
	private ComboBox<String> businessCircleComboBox;//只有酒店工作人员可见
	@FXML
	private Label addressLabel;//除了酒店工作人员，其他用户可见
	@FXML
	private TextField addressTextField;//只有酒店工作人员可见
	@FXML
	private Hyperlink save;//只有酒店工作人员可见
	@FXML
	private Hyperlink historyOrders;//只有客户可见
	private File imageFile;
	
	private HotelDetailsVO hotelDetailsVO;
	
	/**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	LoginService login = LoginController.getInstance();
		AccountType account = login.getLogState().accountType;
    	
    	if(account.equals(AccountType.Customer)){
    		
    	}
    	else if (account.equals(AccountType.Hotel)) {
			hotelNameLabel.setVisible(false);
			hotelNameTextField.setVisible(true);
			describtionText.setVisible(false);
			describtionTextArea.setVisible(true);
			starHBox.setVisible(false);
			starComboBox.setVisible(true);
			address_Label.setVisible(false);
			cityLabel.setVisible(false);
			cityComboBox.setVisible(true);
			districtLabel.setVisible(false);
			districtComboBox.setVisible(true);
			businessCircleLabel.setVisible(false);
			businessCircleComboBox.setVisible(true);
			addressLabel.setVisible(false);
			addressTextField.setVisible(true);
			save.setVisible(true);
			bookEluxeSuite.setDisable(true);
			bookSuites.setDisable(true);
			bookStandard.setDisable(true);
			bookDouble.setDisable(true);
			bookSingle.setDisable(true);
			historyOrders.setVisible(false);
			
			starComboBox.getItems().addAll(starArray);
			cityComboBox.getItems().addAll("南京","Option 1","Option 2");
			TextFieldUtil.setValidator(hotelNameTextField);
			
			initValue(login.getLogState().accountID);
		}
    	else {
    		bookEluxeSuite.setDisable(true);
			bookSuites.setDisable(true);
			bookStandard.setDisable(true);
			bookDouble.setDisable(true);
			bookSingle.setDisable(true);
			historyOrders.setVisible(false);
		}
    }
	

	@FXML
	private void handleBookEluxeSuite() {
		toBookHotelView(RoomType.EluxeSuite);
	}
	@FXML
	private void handleBookSuites() {
		toBookHotelView(RoomType.Suites);
	}
	@FXML
	private void handleBookStandard() {
		toBookHotelView(RoomType.Standard);
	}
	@FXML
	private void handleBookDouble() {
		toBookHotelView(RoomType.Double);
	}
	@FXML
	private void handleBookSingle() {
		toBookHotelView(RoomType.Single);
	}
	@FXML
	private void handleEluxeSuite() {
		toRoomView(RoomType.EluxeSuite);
	}
	@FXML
	private void handleSuites() {
		toRoomView(RoomType.Suites);
	}
	@FXML
	private void handleStandard() {
		toRoomView(RoomType.Standard);
	}
	@FXML
	private void handleDouble() {
		toRoomView(RoomType.Double);
	}
	@FXML
	private void handleSingle() {
		toRoomView(RoomType.Single);
	}
	@FXML
	private void handleHotelImage() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("选择一张图片");
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("图片", "*.png", "*.jpg", "*.gif"));
		File selectedFile = fileChooser.showOpenDialog(rootLayoutController.getPrimaryStage());
		if (selectedFile != null) {
			hotelImage.setImage(new Image(selectedFile.toURI().toString()));
			imageFile=selectedFile;
		}
	}
	@FXML
	private void handleStarComboBox() {
		int starValue=0;
		for(;starValue<starArray.length;starValue++){
			if(starComboBox.getValue().equals(starArray[starValue])){
				break;
			}
		}
		starValue++;
		star_1.setImage(starValue>=1? yellowStar:greyStar);
		star_2.setImage(starValue>=2? yellowStar:greyStar);
		star_3.setImage(starValue>=3? yellowStar:greyStar);
		star_4.setImage(starValue>=4? yellowStar:greyStar);
		star_5.setImage(starValue>=5? yellowStar:greyStar);
	}
	@FXML
	private void handleFacilities() {
		try {
			rootLayoutController.changeDetails("../hotel/FacilitiesInfo.fxml");
			FacilitiesInfoController facilitiesInfoController=
					(FacilitiesInfoController)rootLayoutController.getDetailsController();
			facilitiesInfoController.setValues(HotelDealController.getInstance().gethotelFacilityVO(
					hotelDetailsVO.hotelID));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@FXML
	private void handleAssess() {
		//TODO:跳转到评价信息界面

		try {
			rootLayoutController.changeDetails("../hotel/HotelRankList.fxml");//跳转到酒店评价信息界面，
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	@FXML
	private void handleCityComboBox() {
		HotelDealService hotelDealService = HotelDealController.getInstance();
		List<String> districts = hotelDealService.getAllDistrictByCity(cityComboBox.getValue());
		districtComboBox.getItems().clear();
		districtComboBox.getItems().addAll(districts);	
	}
	@FXML
	private void handleDistrictComboBox() {
		HotelDealService hotelDealService = HotelDealController.getInstance();
		List<String> businessCircle = hotelDealService.getBusineeCircleByDistrict(districtComboBox.getValue());
		businessCircleComboBox.getItems().clear();
		businessCircleComboBox.getItems().addAll(businessCircle);	
	}
	@FXML
	private void handleSave() {
		HotelAddress hotelAddress = new HotelAddress(cityComboBox.getValue(), districtComboBox.getValue(), 
				businessCircleComboBox.getValue(), addressTextField.getText());
		ArrayList<String> discribes=new ArrayList<>();
		discribes.add(describtionTextArea.getText());
		HotelDiscribtionsVO hotelDiscribtionsVO=new HotelDiscribtionsVO(discribes, null);
		HotelInputVO hotelInputVO=new HotelInputVO(imageFile.toURI(), hotelDetailsVO.hotelID, hotelNameTextField.getText(), 
				StarHelper.getStar(starComboBox), hotelAddress, hotelDiscribtionsVO);
		
		ManageHotelInfoService manageHotelService = HotelManageController.getInstance();
		ResultMessage_Hotel resultMessage_Hotel = manageHotelService.saveHotelInfo(hotelInputVO);
		if(!ResultMessage_Hotel.success.equals(resultMessage_Hotel)){
			Dialogs.showMessage("保存失败");
		}else{
			Dialogs.showMessage("保存成功");
		}
	}
	@FXML
	private void handleHistoryOrders() {
		try {
			rootLayoutController.changeDetails("../order/OrderList.fxml");
			OrderListController orderListController=(OrderListController) rootLayoutController.getDetailsController();
			orderListController.search(hotelDetailsVO.hotelName, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void toBookHotelView(RoomType roomType) {
		LoginService loginService=LoginController.getInstance();
		if(loginService.getLogState().accountType.equals(AccountType.Customer)){
			try {
				rootLayoutController.changeDetails("../customer/BookHotel.fxml");
				BookHotelController bookHotelController=(BookHotelController)rootLayoutController.getDetailsController();
				bookHotelController.setValue(loginService.getLogState().accountID, hotelDetailsVO.hotelID);
				bookHotelController.setRoomType(roomType);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void toRoomView(RoomType roomType) {
		System.out.println("toRoomView:    is null? "+hotelDetailsVO.hotelRoomInfoVO.typeRoomInfo==null);
		try {
			rootLayoutController.changeDetails("../room/RoomInfo.fxml");
			RoomInfoController roomInfoController=(RoomInfoController)rootLayoutController.getDetailsController();
			//System.out.println("toRoomView:    is null? "+hotelDetailsVO.hotelRoomInfoVO.typeRoomInfo==null);
			for(int i=0;i<hotelDetailsVO.hotelRoomInfoVO.typeRoomInfo.size();i++){
				if(roomType.equals(hotelDetailsVO.hotelRoomInfoVO.typeRoomInfo.get(i).getRoomtype())){
					roomInfoController.setValue(hotelDetailsVO.hotelRoomInfoVO.typeRoomInfo.get(i));
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 通过酒店ID来初始化界面的各组件的值
	 * @param hotelID 酒店ID
	 */
	public void initValue(String hotelID) {
		HotelDealService hotelDealService=HotelDealController.getInstance();
		this.hotelDetailsVO=hotelDealService.getHotelDetailsVO(hotelID);
		if(hotelDetailsVO==null){
			System.err.println("hotelDetailsVO is null. At HotelDetailController.initVaule(String hotelID)");
		}
		if(hotelDetailsVO.hotelImage!=null){
			this.hotelImage.setImage(new Image(hotelDetailsVO.hotelImage.toString()));
			this.imageFile=new File(hotelDetailsVO.hotelImage);
		}
		else
		this.hotelImage.setImage(new Image("file:./target/resources/images/room.png"));	

		if(hotelDetailsVO.hotelName!=null){
			this.hotelNameLabel.setText(hotelDetailsVO.hotelName);
		this.hotelNameTextField.setText(hotelDetailsVO.hotelName);
			}
		if(hotelDetailsVO.hotelDiscribtionsVO.discribes!=null
				&& !hotelDetailsVO.hotelDiscribtionsVO.discribes.isEmpty()){
			this.describtionText.setText(hotelDetailsVO.hotelDiscribtionsVO.discribes.get(0));
			this.describtionTextArea.setText(hotelDetailsVO.hotelDiscribtionsVO.discribes.get(0));
		}
		
		this.starLabel.setText(hotelDetailsVO.star.ordinal()+"");
		this.star_1.setImage(hotelDetailsVO.star.ordinal()>=1? yellowStar:greyStar);
		this.star_2.setImage(hotelDetailsVO.star.ordinal()>=2? yellowStar:greyStar);
		this.star_3.setImage(hotelDetailsVO.star.ordinal()>=3? yellowStar:greyStar);
		this.star_4.setImage(hotelDetailsVO.star.ordinal()>=4? yellowStar:greyStar);
		this.star_5.setImage(hotelDetailsVO.star.ordinal()>=5? yellowStar:greyStar);
		this.starComboBox.setValue(starArray[hotelDetailsVO.star.ordinal()-1]);
		handleStarComboBox();
		double mark=hotelDealService.gethotelAssessVO(hotelID).averageMark;
		this.mark.setText(DoubleFormate.formateto(mark)+"");
		this.mark_1.setImage(mark>=1? yellowStar:greyStar);
		this.mark_2.setImage(mark>=2? yellowStar:greyStar);
		this.mark_3.setImage(mark>=3? yellowStar:greyStar);
		this.mark_4.setImage(mark>=4? yellowStar:greyStar);
		this.mark_5.setImage(mark>=5? yellowStar:greyStar);
		if(hotelDetailsVO.hotelAddress.getCity()!=null)
		this.cityLabel.setText(hotelDetailsVO.hotelAddress.getCity());
		if(hotelDetailsVO.hotelAddress.getDistrict()!=null)
		this.districtLabel.setText(hotelDetailsVO.hotelAddress.getDistrict());
		if(hotelDetailsVO.hotelAddress.getBusinessCircle()!=null)
		this.businessCircleLabel.setText(hotelDetailsVO.hotelAddress.getBusinessCircle());
		if(hotelDetailsVO.hotelAddress.getAddressDetail()!=null)
		this.addressLabel.setText(hotelDetailsVO.hotelAddress.getAddressDetail());
		this.cityComboBox.getItems().clear();
		this.cityComboBox.getItems().addAll(hotelDealService.getAllCity());
		this.cityComboBox.setValue(hotelDetailsVO.hotelAddress.getCity());
		handleCityComboBox();
		this.districtComboBox.setValue(hotelDetailsVO.hotelAddress.getDistrict());
		handleDistrictComboBox();
		this.businessCircleComboBox.setValue(hotelDetailsVO.hotelAddress.getBusinessCircle());
		this.addressTextField.setText(hotelDetailsVO.hotelAddress.getAddressDetail());
	}
}