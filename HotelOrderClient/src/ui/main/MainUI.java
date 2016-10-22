package ui.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
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
			HotelDetailController controller = (HotelDetailController) replaceSceneContent("../hotel/HotelDetail.fxml");
		} catch (Exception e) {
			Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, e);
		}
    }
    
    private Initializable replaceSceneContent(String fxml) throws Exception {  
        FXMLLoader loader = new FXMLLoader();  
        InputStream in = MainUI.class.getResourceAsStream(fxml);  
        loader.setBuilderFactory(new JavaFXBuilderFactory());  
        loader.setLocation(MainUI.class.getResource(fxml));  
        AnchorPane page;  
        try {  
            page = (AnchorPane) loader.load(in);  
        } finally {  
            in.close();  
        }   
        Scene scene = new Scene(page);  
        primaryStage.setScene(scene);  
        primaryStage.sizeToScene();  
        return (Initializable) loader.getController();  
    }  
}
