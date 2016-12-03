package ui.room;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import javafx.event.EventType;
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
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import tools.TypeRoomInfo;
import ui.main.DetailsController;

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
	
	@FXML
	private void handleRoomImage(){
		if(true){
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("选择一张图片");
			fileChooser.getExtensionFilters().addAll(new ExtensionFilter("图片", "*.png", "*.jpg", "*.gif"));
			File selectedFile = fileChooser.showOpenDialog(rootLayoutController.getPrimaryStage());
			if (selectedFile != null) {
				roomImage.setImage(new Image(selectedFile.toURI().toString()));
			}
		}
	}
	@FXML
	private void handleSave(){
		if(false){//TODO:如果是客户
			try {
				rootLayoutController.changeDetails("../customer/BookHotel.fxml");
				//TODO:设置填写订单界面的信息
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else{//TODO:如果是酒店工作人员
			//TODO:调用blservice保存类型房间信息
		}
	}
	@FXML
	private void handleDate(){
		LocalDate from=date_from.getValue();
		LocalDate to=date_to.getValue();
		if(from!=null && to!=null && to.isAfter(from)){
			roomList.getChildren().clear();
			//TODO:调用blservice获取房间号码和状态，设置avaliableRoom totalRoom roomList的值，下面是一个例子
			Hyperlink room=new Hyperlink("8887");
			room.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
				//TODO:调用blservice删除这个房间
			});
			roomList.getChildren().add(room);
		}
	}
	@FXML
	private void handleAdd(){
		String roomNum=newRoomNum.getText();
		if(roomNum!=null && !"".equals(roomNum)){
			//TODO:调用blservice添加房间
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
		//TODO:如果图片不是null，替换图片
		roomPrice.setText(typeRoomInfo.getPrice()+"");
		//TODO:加上这句roomDescribtion.setText(typeRoomInfo.getDescribtion());
		
		if(false){//TODO:如果是客户
			roomPrice.setEditable(false);
			roomDescribtion.setEditable(false);
			save.setText("预订");
			roomManage.setVisible(false);
		}
		else if (true) {//TODO:如果是酒店工作人员
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
	

}
