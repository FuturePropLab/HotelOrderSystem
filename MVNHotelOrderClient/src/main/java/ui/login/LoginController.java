package ui.login;

import businesslogicservice.LoginService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import tools.AccountType;

public class LoginController {
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
	private void handleLogin(){
		System.out.println(username.getText());
		System.out.println(password.getText());
		loginService.login(username.getText(), password.getText());
	}
}
