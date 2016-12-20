package ui.hotelworker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import businesslogic.login.LoginController;
import businesslogic.room.RoomManageController;
import businesslogic.room.RoomSingleController;
import businesslogicservice.LoginService;
import businesslogicservice.RoomManageService;
import businesslogicservice.RoomSingleService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import tools.ResultMessage_Room;
import tools.RoomType;
import ui.main.DetailsController;
import ui.utils.DateFormat;
import ui.utils.Dialogs;

/**
 * 线下入住和退房信息界面的控制器
 * @author zjy
 */
public class OfflineInfoController extends DetailsController{
	private static final String[] roomTypes={"所有","标准间","单人间","双人间","豪华套房","总统套房"};

	@FXML
	private DatePicker date_from;
	@FXML
	private DatePicker date_to;
	@FXML
	private ComboBox<String> roomType;
	@FXML
	private FlowPane roomList;
	@FXML
	private TextField roomNumber;
	@FXML
	private Button confirm;
	private String hotelID;
	
	
	
	@FXML
	private void initialize() {
		roomList.getChildren().clear();
		roomType.getItems().addAll(roomTypes);
		roomType.setValue(roomTypes[1]);
		DateFormat.initDatePicker(date_from, date_to);
		
		LoginService loginService=LoginController.getInstance();
		this.hotelID=loginService.getLogState().accountID;
		handleSearchRoom();
	}
	@FXML
	private void handleSearchRoom(){
		LocalDate from=date_from.getValue();
		LocalDate to=date_to.getValue();
		if(from!=null && to!=null && to.isAfter(from) && roomType.getValue()!=null){
			roomList.getChildren().clear();
			
			RoomManageService roomManageService=RoomManageController.getInstance();
			RoomSingleService roomSingleService = RoomSingleController.getInstance();
			RoomType roomType=geRoomType();
			List<String> roomlist = new ArrayList<String>();
			List<String> availableRoomLsit=new ArrayList<String>();
			if(roomType==null){
				roomlist.addAll(roomManageService.getAllRoomByType(hotelID, RoomType.Single));
				roomlist.addAll(roomManageService.getAllRoomByType(hotelID, RoomType.Double));
				roomlist.addAll(roomManageService.getAllRoomByType(hotelID, RoomType.Standard));
				roomlist.addAll(roomManageService.getAllRoomByType(hotelID, RoomType.Suites));
				roomlist.addAll(roomManageService.getAllRoomByType(hotelID, RoomType.EluxeSuite));
				availableRoomLsit = roomManageService.getAvaiableRoomBytime
						(hotelID, RoomType.Single, DateFormat.getDate(date_from),  DateFormat.getDate(date_to));
				availableRoomLsit = roomManageService.getAvaiableRoomBytime
						(hotelID, RoomType.Double, DateFormat.getDate(date_from),  DateFormat.getDate(date_to));
				availableRoomLsit = roomManageService.getAvaiableRoomBytime
						(hotelID, RoomType.Standard, DateFormat.getDate(date_from),  DateFormat.getDate(date_to));
				availableRoomLsit = roomManageService.getAvaiableRoomBytime
						(hotelID, RoomType.Suites, DateFormat.getDate(date_from),  DateFormat.getDate(date_to));
				availableRoomLsit = roomManageService.getAvaiableRoomBytime
						(hotelID, RoomType.EluxeSuite, DateFormat.getDate(date_from),  DateFormat.getDate(date_to));
			}else {
				roomlist = roomManageService.getAllRoomByType(hotelID, roomType);
				availableRoomLsit = roomManageService.getAvaiableRoomBytime
						(hotelID, roomType, DateFormat.getDate(date_from),  DateFormat.getDate(date_to));
			}
			
			List<Hyperlink> rooms =roomlist.stream().map(room->new Hyperlink(room)).collect(Collectors.toList());
			roomList.getChildren().addAll(rooms);
			//为每个房间设置监听方法
			rooms.forEach(room->{
				room.setFont(Font.font(24));
				room.setOnAction(e -> {
					ResultMessage_Room result = roomSingleService.addDisable(hotelID, room.getText(), new Date(), null);
					if(ResultMessage_Room.success.equals(result)){
						Dialogs.showMessage("噢耶","变更房间信息成功");
						room.setDisable(true);
					}else{
						Dialogs.showMessage("啊咧","变更房间信息失败");
					}
				});
			});
			//把不可用的房间变为不可选定
			for(Hyperlink room:rooms){
				if(!availableRoomLsit.contains(room.getText())){
					room.setDisable(true);
				}
			}
			
		}
	}
	@FXML
	private void handleConfirm(){
		if(!"".equals(roomNumber.getText())){
			RoomSingleService roomSingleService = RoomSingleController.getInstance();
			ResultMessage_Room result=roomSingleService.deleteDisable(hotelID, roomNumber.getText(), null);
			if(ResultMessage_Room.success.equals(result)){
				Dialogs.showMessage("噢耶", "变更房间信息成功");
			}else {
				Dialogs.showMessage("啊咧","变更房间信息失败，也许是这个房间并没有被登记为有人入住");
			}
		}
	}
	
	
	private RoomType geRoomType() {
		if(roomType.getValue()==null){
			return null;
		}else if (roomType.getValue().equals(roomTypes[2])) {
			return RoomType.Single;
		}else if (roomType.getValue().equals(roomTypes[3])) {
			return RoomType.Double;
		}else if (roomType.getValue().equals(roomTypes[1])) {
			return RoomType.Standard;
		}else if (roomType.getValue().equals(roomTypes[4])) {
			return RoomType.Suites;
		}else if (roomType.getValue().equals(roomTypes[5])) {
			return RoomType.EluxeSuite;
		}

		return null;
	}
}
