package ui.main;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainUI {
	private Stage primaryStage;
    private AnchorPane rootLayout;
    
	public MainUI(Stage primaryStage) {
		super();
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("AddressApp");
        this.primaryStage.getIcons().add(new Image("file:resources/images/close.png"));
        initRootLayout();
	}
	
	/**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainUI.class
                    .getResource("RootLayout.fxml"));
            rootLayout = (AnchorPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.initStyle(StageStyle.UNDECORATED);//设定窗口无边框

            // Give the controller access to the main app.
            RootLayoutController controller = loader.getController();
            controller.setPrimaryStage(primaryStage);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
