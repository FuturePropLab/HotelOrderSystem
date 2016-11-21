package ui.main;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * The controller for the root layout. The root layout provides the basic
 * application layout.
 * 
 * @author zjy
 */
public class RootLayoutController {
	private Stage primaryStage;
	@FXML
	private AnchorPane details;
	@FXML
	private AnchorPane guid;

	public AnchorPane getDetails() {
		return details;
	}

	public AnchorPane getGuid() {
		return guid;
	}

	public void setDetails(AnchorPane details) {
		this.details = details;
	}

	public void setGuid(AnchorPane guid) {
		this.guid = guid;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	/**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        try {
			changeDetails("../hotel/HotelDetail.fxml");
	        changeGuid("GuideUI.fxml");
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
//        // Initialize the person table with the two columns.
//        firstNameColumn.setCellValueFactory(
//                cellData -> cellData.getValue().firstNameProperty());
//        lastNameColumn.setCellValueFactory(
//                cellData -> cellData.getValue().lastNameProperty());
//
//        // Clear person details.
//        showPersonDetails(null);
//
//        // Listen for selection changes and show the person details when changed.
//        personTable.getSelectionModel().selectedItemProperty().addListener(
//                (observable, oldValue, newValue) -> showPersonDetails(newValue));
    }

	/**
     * Closes the application.
     */
    @FXML
    private void handleExit() {
        System.exit(0);
    }
    
    /**
     * Minimize the application.
     */
    @FXML
    private void handleMinimize() {
    	primaryStage.setIconified(true);
    }
    
    /**
     * 用来切换rootlayout的details的板块
     * @param fxml details所在的fxlm文件的名称（相对路径）
     * @throws IOException FXMLLoader.load(URL location)加载失败时
     */
    public void changeDetails(String fxml) throws IOException {
    	Parent child = (Parent) FXMLLoader.load(getClass().getResource(fxml));
    	details.getChildren().addAll(child);
	}

    /**
     * 用来切换rootlayout的guid的板块
     * @param fxml guid所在的fxlm文件的名称（相对路径）
     * @throws IOException FXMLLoader.load(URL location)加载失败时
     */
    public void changeGuid(String fxml) throws IOException {
    	Parent child = (Parent) FXMLLoader.load(getClass().getResource(fxml));
    	guid.getChildren().addAll(child);
	}
}