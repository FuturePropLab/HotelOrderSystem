package ui.login;

import java.io.IOException;
import java.rmi.RemoteException;

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
import ui.discount.WebStrategyController;
import ui.hotel.HotelDetailController;
import ui.hotel.HotelSearchController;
import ui.main.FullLayoutController;
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
	private void initialize(){
		
		accountType.getItems().addAll(accountTypes);
	}
	
	@FXML
	private void handleLogin(){
		ResultMessage_LoginCheck result;
		try {
			String accountTy = accountType.getValue();
			AccountType accountType  = null;
			if(accountTy.equals(accountTypes[0])) accountType = AccountType.Customer;
			else if(accountTy.equals(accountTypes[1]))  accountType = AccountType.Hotel;
			else if(accountTy.equals(accountTypes[2]))  accountType = AccountType.Web;
			else  accountType = AccountType.Administor;
			
			
			result = LoginServiceUtil.getLoginService().login(username.getText(), password.getText(),accountType);
			if(result.equals(ResultMessage_LoginCheck.Success)){
				
				
				String accountID  =  LoginServiceUtil.getLoginService().getLogState().accountID;
				rootLayoutController.changeFullLayout(null);
				rootLayoutController.changeGuid("GuideUI.fxml");
				
				
				AccountType testType  = LoginServiceUtil.getLoginService().getLogState().accountType;
				System.out.println(testType);
				
				if( testType  == AccountType.Customer){
					
					rootLayoutController.changeDetails("../hotel/HotelSearch.fxml");
					HotelSearchController controller =
							(HotelSearchController) rootLayoutController.getDetailsController();
					
				}else if(testType == AccountType.Hotel){
					rootLayoutController.changeDetails("../hotel/HotelDetail.fxml");
					HotelDetailController hotelDetailController  =
							(HotelDetailController) rootLayoutController.getDetailsController();
					hotelDetailController.initValue(accountID);
				}else if(testType == AccountType.Web){
					rootLayoutController.changeDetails("../discount/WebStrategy.fxml");
					WebStrategyController webStrategyController =
							(WebStrategyController) rootLayoutController.getDetailsController();
					
				}
				
			
			
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
