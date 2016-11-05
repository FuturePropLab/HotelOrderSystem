package ui.main;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
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

	public void setDetails(AnchorPane details) {
		this.details = details;
	}

	public void setGuid(AnchorPane guid) {
		this.guid = guid;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
//	/**
//     * Initializes the controller class. This method is automatically called
//     * after the fxml file has been loaded.
//     */
//    @FXML
//    private void initialize() {
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
//    }

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

}