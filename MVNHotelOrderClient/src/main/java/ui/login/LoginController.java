package ui.login;

import java.io.IOException;
import java.rmi.RemoteException;

import businesslogicservice.LoginService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import tools.AccountType;
import tools.ResultMessage_LoginCheck;
import ui.main.FullLayoutController;
/**
 * 
 * @author zjy
 *
 */
public class LoginController extends FullLayoutController{
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	@FXML
	private ChoiceBox<AccountType> accountType;
	@FXML
	private Button loginButton;
	private LoginService loginService;//对象的创建目前是个问题
	
	@FXML
	private void initialize() {
		loginService=new businesslogic.login.LoginController();
	}
	
	@FXML
	private void handleLogin(){
		ResultMessage_LoginCheck result;
		try {
			result = loginService.login(username.getText(), password.getText(),AccountType.Customer);
			if(result.equals(ResultMessage_LoginCheck.Success)){
				rootLayoutController.changeDetails("../hotel/HotelDetail.fxml");
				rootLayoutController.changeGuid("GuideUI.fxml");
			}
			else if (result.equals(ResultMessage_LoginCheck.InvalidUsername)) {
				System.out.println("Invalid Username");//TODO
			}
			else if (result.equals(ResultMessage_LoginCheck.InvalidPassword)) {
				System.out.println("Invalid Password");//TODO
			}
			else if (result.equals(ResultMessage_LoginCheck.SystemError)) {
				//TODO
			}
		} catch (RemoteException e) {
			System.out.println("connect error");//TODO
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
