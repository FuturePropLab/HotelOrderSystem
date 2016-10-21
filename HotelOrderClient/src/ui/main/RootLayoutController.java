package ui.main;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
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

}