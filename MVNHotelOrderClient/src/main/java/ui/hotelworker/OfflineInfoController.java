package ui.hotelworker;

import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import ui.main.DetailsController;
import ui.utils.DateFormat;

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
	
	
	
	
	@FXML
	private void initialize() {
		roomType.getItems().addAll(roomTypes);
		roomType.setValue(roomTypes[1]);
		DateFormat.initDatePicker(date_from, date_to);
	}
	@FXML
	private void handleSearchRoom(){
		LocalDate from=date_from.getValue();
		LocalDate to=date_to.getValue();
		if(from!=null && to!=null && to.isAfter(from) && roomType.getValue()!=null){
			roomList.getChildren().clear();
			//TODO:调用blservice获取房间号码和状态，设置roomList的值，下面是一个例子
			Hyperlink room=new Hyperlink("8887");
			room.setFont(Font.font(24));
			room.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
				//TODO:调用blservice把这个房间设为不可用，如果成功，更新相关组件的值，如果失败，弹窗提示原因
			});
			roomList.getChildren().add(room);
			//上面是一个例子
		}
	}
	@FXML
	private void handleConfirm(){
		if(!"".equals(roomNumber.getText())){
			//TODO:调用blservice，如果这个房间是不可以状态，变为可用，否则提示这个房间没有人入住
		}
	}
}
