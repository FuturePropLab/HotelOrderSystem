package ui.main;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ui.hotel.HotelDetailController;

public class MainUI {
	private Stage primaryStage;
    private AnchorPane rootLayout;
    private RootLayoutController rootLayoutController;
    
	public MainUI(Stage primaryStage) {
		super();
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("AddressApp");
        this.primaryStage.getIcons().add(new Image("file:resources/images/close.png"));
        initRootLayout();
        showHotelDetails();
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
            rootLayoutController= loader.getController();
            rootLayoutController.setPrimaryStage(primaryStage);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    /**
     * Shows the hotel details inside the root layout.
     */
    public void showHotelDetails() {
        try {
            // Load hotel details.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainUI.class.getResource("../hotel/HotelDetail.fxml"));
            AnchorPane hotelDetails = (AnchorPane) loader.load();

            // Set hotel details into the center of root layout.
            rootLayoutController.setDetails(hotelDetails);
            primaryStage.show();
            HotelDetailController controller = loader.getController();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
