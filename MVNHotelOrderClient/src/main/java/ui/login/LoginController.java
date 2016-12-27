package ui.login;

import java.io.IOException;
import java.rmi.RemoteException;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextField;

import businesslogic.customer.CustomerSignupController;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import serviceFactory.LoginServiceUtil;
import tools.AccountType;
import tools.ResultMessage_LoginCheck;
import tools.ResultMessage_signUp;
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
	private JFXPasswordField password;
	@FXML
	private ComboBox<String> accountType;
	@FXML
	private Button loginButton;
	@FXML
	private JFXSpinner spinner;
	@FXML
	private JFXTextField username_signup;
	@FXML
	private JFXPasswordField password_signup;
	@FXML
	private JFXPasswordField repeatPassword;
	@FXML
	private Button signupButton;
	
	@FXML
	private void initialize(){		
		accountType.getItems().addAll(accountTypes);
		accountType.setValue(accountTypes[0]);
		
		TextFieldUtil.setValidator(username_signup);
		TextFieldUtil.setValidator(password_signup);
		TextFieldUtil.setRepeatValidator(password_signup,repeatPassword);
		String[] str= saveUsernameUtil.getSave();
		if(str.length>1){
			this.username.setText(str[0]);
			this.accountType.setValue(str[1]);
		}
	}
	
	@FXML
	private void handleLogin(){
		loginButton.setVisible(false);
		spinner.setVisible(true);
		
		LoginBackService service=new LoginBackService();
		service.setOnSucceeded(event->{
			try {
				if(service.result.equals(ResultMessage_LoginCheck.Success)){
					saveUsernameUtil.saveinfo(username.getText().trim(), service.accountTy);
					String accountID  =  LoginServiceUtil.getLoginService().getLogState().accountID;
					rootLayoutController.changeFullLayout(null);
					rootLayoutController.changeGuid("../guid/GuideUI.fxml");
					
					AccountType loginType  = LoginServiceUtil.getLoginService().getLogState().accountType;
					
					if( loginType  == AccountType.Customer){			
						rootLayoutController.changeDetails("../hotel/HotelSearch.fxml");							
					}else if(loginType == AccountType.Hotel){
						rootLayoutController.changeDetails("../hotel/HotelDetail.fxml");
						HotelDetailController hotelDetailController  =
								(HotelDetailController) rootLayoutController.getDetailsController();
						hotelDetailController.initValue(accountID);
					}else if(loginType == AccountType.Web){
						rootLayoutController.changeDetails("../webdesign/CreditCharge.fxml");
					}else if (loginType == AccountType.Administor) {
						rootLayoutController.changeDetails("../administor/UserAdmin.fxml");
					}
				}
				else if (service.result.equals(ResultMessage_LoginCheck.InvalidUsername)) {
					System.out.println("Invalid Username");
					Dialogs.showMessage("不存在这个用户名");
				}
				else if (service.result.equals(ResultMessage_LoginCheck.InvalidPassword)) {
					System.out.println("Invalid Password");
					Dialogs.showMessage("密码错误");
				}
				else if (service.result.equals(ResultMessage_LoginCheck.SystemError)) {
					System.err.println("login fail:SystemError");
				}else if(service.result.equals(ResultMessage_LoginCheck.hasOn)){
					Dialogs.showMessage("该用户已经在线");
				}
			} catch (RemoteException e) {
				System.out.println("connect error");
				Dialogs.showMessage("阿欧","网络连接没有成功耶");
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				loginButton.setVisible(true);
				spinner.setVisible(false);
			}
		});
		service.start();
	}
	
	@FXML
	private void handleSignUp(){
		if("".equals(password_signup.getText()) || "".equals(repeatPassword.getText()) || 
				!password_signup.getText().equals(repeatPassword.getText())){
			return;
		}
		
		CustomerSignupController signupController = CustomerSignupController.getInstance();
		CustomerInputVO customerInputVO = 
				new CustomerInputVO(this.username_signup.getText(), this.password_signup.getText(), "", "", "");
		ResultMessage_signUp rs =signupController.addCustomer(customerInputVO);
		if(rs.equals(ResultMessage_signUp.Wrong)){
			Dialogs.showMessage("注册失败了,可能是这个用户名已经存在了哦");
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
					}			
				}
			} catch (RemoteException e) {
				Dialogs.showMessage("阿欧","注册失败了，是不是网络的问题？");
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		}
	}
	
	/**
	 * 登陆的后台线程
	 * @author zjy
	 *
	 */
	private class LoginBackService extends Service<Void> {
		private ResultMessage_LoginCheck result;
		private String accountTy = accountType.getValue();
		private AccountType loginType;
		
		
		public LoginBackService() {
			super();
			if(accountTy.equals(accountTypes[0])) loginType = AccountType.Customer;
			else if(accountTy.equals(accountTypes[1]))  loginType = AccountType.Hotel;
			else if(accountTy.equals(accountTypes[2]))  loginType = AccountType.Web;
			else if(accountTy.equals(accountTypes[3]))  loginType = AccountType.Administor;
			else    return ;
		}
		
		@Override
		protected Task<Void> createTask() {
			return new Task<Void>() {
				@Override
				protected Void call() throws Exception {
					result = LoginServiceUtil.getLoginService().login(username.getText(), password.getText(),loginType);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					return null;
				}
			};
		}
	}
}

