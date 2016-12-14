package ui.login;

import java.io.IOException;
import java.rmi.RemoteException;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import businesslogic.customer.CustomerSignupController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import serviceFactory.LoginServiceUtil;
import tools.AccountType;
import tools.ResultMessage_LoginCheck;
import tools.ResultMessage_signUp;
import ui.customer.ClientInfoController;
import ui.discount.WebDiscountController;
import ui.hotel.HotelDetailController;
import ui.hotel.HotelSearchController;
import ui.main.FullLayoutController;
import ui.utils.Dialogs;
import ui.utils.TextFieldUtil;
import ui.utils.saveUsernameUtil;
import vo.CustomerInputVO;
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
		String[] str= saveUsernameUtil.getSave();
		this.username.setText(str[0]);
		this.accountType.setValue(str[1]);
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
				
				saveUsernameUtil.saveinfo(username.getText().trim(), accountTy);
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
					rootLayoutController.changeDetails("../webdesign/creditCharge.fxml");				
					
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
		//LoginService loginService=businesslogic.login.LoginController.getInstance();
		CustomerSignupController signupController = CustomerSignupController.getInstance();
		CustomerInputVO customerInputVO = 
				new CustomerInputVO(this.username_signup.getText(), this.password_signup.getText(), "", "", "");
		//CustomerAccountController customerAccountController = CustomerAccountController.getInstance();
		//System.out.println(this.username.getText()+"   "+this.password.getText());
		ResultMessage_signUp rs =signupController.addCustomer(customerInputVO);
		if(rs.equals(ResultMessage_signUp.Wrong)){
			Dialogs.showMessage("注册失败,请重新输入用户名和密码");
		//}else if(rs.equals(ResultMessage_Account.InvalidInput)){
		//	Dialogs.showMessage("注册失败,请输入5位以上的用户名 和6位以上的密码");
		}else if(rs.equals(ResultMessage_signUp.Success)){
			Dialogs.showMessage("恭喜您注册成功");
			accountType.setValue(accountTypes[0]);			
			try {
				ResultMessage_LoginCheck result
				= LoginServiceUtil.getLoginService().login(username_signup.getText(), password_signup.getText(),AccountType.Customer);
				if(result.equals(ResultMessage_LoginCheck.Success)){			
					saveUsernameUtil.saveinfo(username_signup.getText().trim(), "用户");
					String accountID  =  LoginServiceUtil.getLoginService().getLogState().accountID;
					rootLayoutController.changeFullLayout(null);
					rootLayoutController.changeGuid("../guid/GuideUI.fxml");
					
					AccountType testType  = LoginServiceUtil.getLoginService().getLogState().accountType;
					System.out.println(testType);
					
					if(testType == AccountType.Customer){			
						rootLayoutController.changeDetails("../customer/ClientInfo.fxml");
//						ClientInfoController controller =
//						(ClientInfoController) rootLayoutController.getDetailsController();
//				controller.initValue( LoginServiceUtil.getLoginService().getLogState().accountID);
			}			
				}
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}
}

