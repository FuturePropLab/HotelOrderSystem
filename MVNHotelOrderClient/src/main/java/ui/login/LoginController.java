package ui.login;

import java.io.IOException;
import java.rmi.RemoteException;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import businesslogicservice.LoginService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import serviceFactory.LoginServiceUtil;
import tools.AccountType;
import tools.ResultMessage_LoginCheck;
import ui.discount.WebDiscountController;
import ui.hotel.HotelDetailController;
import ui.hotel.HotelSearchController;
import ui.main.FullLayoutController;
import ui.utils.Dialogs;
import ui.utils.TextFieldUtil;
/**
 * 
 * @author zjy
 *
 */
public class LoginController extends FullLayoutController{
	private static String accountTypes[]={"用户","酒店工作人员","网站营销人员","管理人员"};
	
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	@FXML
	private ComboBox<String> accountType;
	@FXML
	private Button loginButton;
	@FXML
	private TextField username_signup;
	@FXML
	private PasswordField password_signup;
	@FXML
	private PasswordField repeatPassword;
	@FXML
	private Button signupButton;
	
	@FXML
	private void initialize(){		
		accountType.getItems().addAll(accountTypes);
		accountType.setValue(accountTypes[0]);
		
		TextFieldUtil.setValidator((JFXTextField) username_signup);
		TextFieldUtil.setValidator((JFXPasswordField) password_signup);
		TextFieldUtil.setRepeatValidator((JFXPasswordField) password_signup,(JFXPasswordField) repeatPassword);
	}
	
	@FXML
	private void handleLogin(){
		ResultMessage_LoginCheck result;
		try {
			String accountTy = this.accountType.getValue();
			AccountType accountType  = null;
			if(accountTy.equals(accountTypes[0])) accountType = AccountType.Customer;
			else if(accountTy.equals(accountTypes[1]))  accountType = AccountType.Hotel;
			else if(accountTy.equals(accountTypes[2]))  accountType = AccountType.Web;
			else if(accountTy.equals(accountTypes[3]))  accountType = AccountType.Administor;
			else    return;
			
			
			result = LoginServiceUtil.getLoginService().login(username.getText(), password.getText(),accountType);
			if(result.equals(ResultMessage_LoginCheck.Success)){
				
				
				String accountID  =  LoginServiceUtil.getLoginService().getLogState().accountID;
				rootLayoutController.changeFullLayout(null);
				rootLayoutController.changeGuid("../guid/GuideUI.fxml");
				
				AccountType testType  = LoginServiceUtil.getLoginService().getLogState().accountType;
				System.out.println(testType);
				
				if( testType  == AccountType.Customer){			
					rootLayoutController.changeDetails("../hotel/HotelSearch.fxml");
					HotelSearchController controller =
							(HotelSearchController) rootLayoutController.getDetailsController();
					
				}else if(testType == AccountType.Hotel){
					System.out.println("Brfore into Detail Hotel : "+accountID);
					rootLayoutController.changeDetails("../hotel/HotelDetail.fxml");
					HotelDetailController hotelDetailController  =
							(HotelDetailController) rootLayoutController.getDetailsController();
					hotelDetailController.initValue(accountID);
				}else if(testType == AccountType.Web){
					rootLayoutController.changeDetails("../discount/WebStrategy.fxml");
					WebDiscountController webDiscountController =
							(WebDiscountController) rootLayoutController.getDetailsController();
					
				}
				
			
			
			}
			else if (result.equals(ResultMessage_LoginCheck.InvalidUsername)) {
				System.out.println("Invalid Username");
				Dialogs.showMessage("不存在这个用户名");
			}
			else if (result.equals(ResultMessage_LoginCheck.InvalidPassword)) {
				System.out.println("Invalid Password");
				Dialogs.showMessage("密码错误");
			}
			else if (result.equals(ResultMessage_LoginCheck.SystemError)) {
				System.err.println("login fail:SystemError");
			}else if(result.equals(ResultMessage_LoginCheck.hasOn)){
				Dialogs.showMessage("改用户已经在线");
			}
		} catch (RemoteException e) {
			System.out.println("connect error");//TODO
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@FXML
	private void handleSignUp(){
		LoginService loginService=businesslogic.login.LoginController.getInstance();
		//TODO:注册
	}
}
