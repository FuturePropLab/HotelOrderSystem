package ui.main;

import javafx.application.Application;
import javafx.stage.Stage;
import runner.ClientRunner;
import ui.main.MainUI;
/**
 * 整个软件的入口，包含main方法，启动软件的类
 * @author zjy
 *
 */
public class MainApp extends Application{

	@Override
	public void start(Stage primaryStage){
		ClientRunner cr = new ClientRunner();		
		MainUI mainUI=new MainUI(primaryStage);
	}

	public static void main(String[] args) {
		
		launch(args);
    }
}
