package ui.room;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import businesslogic.login.LoginController;
import businesslogic.room.RoomManageController;
import businesslogic.room.RoomSingleController;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import tools.AccountType;
import tools.ResultMessage_Room;
import tools.RoomType;
import tools.TypeRoomInfo;
import ui.customer.BookHotelController;
import ui.main.DetailsController;
import ui.utils.DateFormat;
import ui.utils.Dialogs;
import vo.RoomDescriptionVO;

/**
 * 房间信息的控制器
 * @author zjy
 *
 */
public class RoomInfoController extends DetailsController{
	
	@FXML
	private ImageView roomImage;
	@FXML
	private TextField roomPrice;
	@FXML
	private TextArea roomDescribtion;
	@FXML
	private Hyperlink save;
	@FXML
	private Label avaliableRoom;
	@FXML
	private Label totalRoom;
	@FXML
	private DatePicker date_from;
	@FXML
	private DatePicker date_to;
	@FXML
	private TextField newRoomNum;
	@FXML
	private Hyperlink add;
	@FXML
	private FlowPane roomList;
	@FXML
	private AnchorPane roomManage;
	
	private AccountType accountType;
	
	private String acountID;
	
	private String hotelID;
	
	private String hotelName;
	
	private RoomType roomType;
	
	private File imageFile;
	
	@FXML
	private void initialize() {
		DateFormat.initDatePicker(date_from, date_to);
	}
	@FXML
	private void handleRoomImage(){
		if(true){
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("选择一张图片");
			fileChooser.getExtensionFilters().addAll(new ExtensionFilter("图片", "*.png", "*.jpg", "*.gif"));
			File selectedFile = fileChooser.showOpenDialog(rootLayoutController.getPrimaryStage());
			if (selectedFile != null) {
				roomImage.setImage(new Image(selectedFile.toURI().toString()));
				this.imageFile = selectedFile;
			}
			
		}
	}
	@FXML
	private void handleSave(){
		if(this.accountType==AccountType.Customer){//TODO:如果是客户
			try {
				rootLayoutController.changeDetails("../customer/BookHotel.fxml");
				BookHotelController bookHotelController = (BookHotelController) rootLayoutController.getDetailsController();
				bookHotelController.setRoomType(roomType);
				bookHotelController.setValue(acountID, hotelID);
				//TODO:设置填写订单界面的信息
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else{//TODO:如果是酒店工作人员
			//TODO:调用blservice保存类型房间信息
			String pricestr = this.roomPrice.getText();
			//检测 是否为数字
			double savePrice = Double.parseDouble(pricestr);
			String roomStrInfo = this.roomDescribtion.getText();
			List<String > infoLsit = new ArrayList<>();
			infoLsit.add(roomStrInfo);
			System.out.println(infoLsit.get(0));
			System.out.println(roomType);
			RoomManageController roomManageController = RoomManageController.getInstance();
			RoomDescriptionVO roomDescriptionVO = new RoomDescriptionVO
					(this.roomType,  infoLsit , imageFile==null?null:imageFile.toURI());
			
			//System.out.println(imageFile.toURI().toString());
			ResultMessage_Room rs1 = 
			roomManageController.saveRoomInfo(hotelID, roomDescriptionVO);
			ResultMessage_Room rs2 = 
			roomManageController.changePrice(hotelID, this.roomType, savePrice);
			System.out.println(rs1);
			System.out.println(rs2);
			
			if(rs1==ResultMessage_Room.success && rs2 ==rs1){
				Dialogs.showMessage("修改成功");
			}else{
				Dialogs.showMessage("修改失败");
			}
		}
	}
	@FXML
	private void handleDate(){
		LocalDate from=date_from.getValue();
		LocalDate to=date_to.getValue();
		if(from!=null && to!=null && to.isAfter(from)){
			RoomManageController roomManageController = RoomManageController.getInstance();
			roomList.getChildren().clear();
			//TODO:调用blservice获取房间号码和状态，设置avaliableRoom totalRoom roomList的值，下面是一个例子
			int  allRoomNum = roomManageController.getAllNumberByType(hotelID, roomType);
			int availableNum = roomManageController.getAvaiableNumberByTime
					(hotelID, roomType, DateFormat.getDate(date_from),  DateFormat.getDate(date_to));
						
			this.avaliableRoom .setText(String.valueOf(availableNum));
			this.totalRoom.setText(String.valueOf(allRoomNum));			
			List<String> roomlist = roomManageController.getAllRoomByType(hotelID, roomType);
			List<String> availableRoomLsit = roomManageController.getAvaiableRoomBytime
					(hotelID, roomType, DateFormat.getDate(date_from),  DateFormat.getDate(date_to));
			
			
			RoomSingleController roomSingleController = 
					RoomSingleController.getInstance();
			//roomSingleController.deleteSingleRoom(hotelID, roomNO);
			
			
			//添加可以删除的房间
			for (int i = 0; i < availableRoomLsit.size(); i++) {
				String roomNO = availableRoomLsit.get(i);
				roomlist.remove(roomNO);
				Hyperlink room=new Hyperlink(roomNO);
				room.setFont(Font.font(24));
				room.setOnAction(e-> {
					//TODO:调用blservice删除这个房间，如果删除成功，更新相关组件的值，如果失败，弹窗提示原因
					ResultMessage_Room rs = roomSingleController.deleteSingleRoom(hotelID, roomNO);
					if(rs==ResultMessage_Room.success){
						Dialogs.showMessage("删除成功");
						this.roomList.getChildren().remove(room);
					}else{
						Dialogs.showMessage("删除失败");
					}
				});
				this.roomList.getChildren().add(room);
				
			}
			
			
			//添加不可以删除的房间
			for (int i = 0; i < roomlist.size(); i++) {
				String roomNO = roomlist.get(i);
				roomlist.remove(roomNO);
				Hyperlink room=new Hyperlink(roomNO);
				room.setDisable(true);
				room.setFont(Font.font(24));
				this.roomList.getChildren().add(room);				
			}
			
			
			
		}
	}
	@FXML
	private void handleAdd(){
		String roomNum=newRoomNum.getText();
		if(roomNum!=null && !"".equals(roomNum)){
			RoomSingleController roomSingleController = RoomSingleController.getInstance();
			ResultMessage_Room rs = roomSingleController.addSingleRoom(hotelID, roomNum, roomType);
			if(rs==ResultMessage_Room.success){
				Dialogs.showMessage("添加成功");
				Hyperlink room=new Hyperlink(roomNum);
				room.setFont(Font.font(24));
				room.setOnAction(e-> {
					//TODO:调用blservice删除这个房间，如果删除成功，更新相关组件的值，如果失败，弹窗提示原因
					ResultMessage_Room rsinner = roomSingleController.deleteSingleRoom(hotelID, roomNum);
					if(rsinner==ResultMessage_Room.success){
						Dialogs.showMessage("删除成功");
						this.roomList.getChildren().remove(room);
					}else{
						Dialogs.showMessage("删除失败");
					}
				});
				this.roomList.getChildren().add(room);
			}else{
				Dialogs.showMessage("添加失败 ，该房间号已经存在!!!");
			}
		}
	}
	
	/**
	 * 设置房间类型的值
	 * @param typeRoomInfo 该类型的房间信息
	 */
	public void setValue(TypeRoomInfo typeRoomInfo) {
    	if(typeRoomInfo==null){  		
    		System.out.println("TypeRoomInfo is null. At RoomInfoController.setValues(TypeRoomInfo)");
    		return;
    	}
    	
  		this.accountType = LoginController.getInstance().getLogState().accountType;
		this.acountID = LoginController.getInstance().getLogState().accountID;
		this.roomType = typeRoomInfo.getRoomtype();
		this.hotelID = typeRoomInfo.getHotelID();
		this.hotelName = typeRoomInfo.getHotelName();
		RoomManageController roomManageController = RoomManageController.getInstance();
		RoomDescriptionVO roomDescriptionVO = roomManageController.getRoomInfo(hotelID, roomType);
		
		//如果图片不是null，替换图片
		if(roomDescriptionVO.typeimage !=null){
			this.imageFile = new File(roomDescriptionVO.typeimage);
			this.roomImage.setImage(new Image(roomDescriptionVO.typeimage.toString()));
		}else{
			this.imageFile = new File("./target/resources/images/room.png");
			this.roomImage.setImage(new Image(imageFile.toURI().toString()));
		}
		roomPrice.setText(typeRoomInfo.getPrice()+"");
		//TODO:加上这句
		if(roomDescriptionVO.description!=null && !roomDescriptionVO.description.isEmpty())
		roomDescribtion.setText(roomDescriptionVO.description.get(0));
		
		//TODO  单个的房间信息
		
		if(accountType==AccountType.Customer){//TODO:如果是客户
			roomPrice.setEditable(false);
			roomDescribtion.setEditable(false);
			save.setText("预订");
			roomManage.setVisible(false);
		}
		else if (accountType==AccountType.Hotel) {//TODO:如果是酒店工作人员
			date_from.setValue(LocalDate.now());
			date_to.setValue(LocalDate.now().plusDays(1));
			handleDate();
		}
		else{
			roomPrice.setEditable(false);
			roomDescribtion.setEditable(false);
			save.setVisible(false);
			roomManage.setVisible(false);
		}
	}
	
//	
//	/**
//	 * 
//	 * @param roomType
//	 */
//	public void setRoomType(RoomType roomType) {
//		// TODO Auto-generated method stub
//		
//	}
	

}
