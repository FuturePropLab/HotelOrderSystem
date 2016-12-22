package ui.guid;

import com.jfoenix.controls.JFXPasswordField;

import businesslogic.account.CustomerAccountController;
import businesslogic.account.HotelAccountController;
import businesslogic.account.WebDesignerAccountController;
import businesslogic.login.LoginController;
import businesslogicservice.AccountCustomerService;
import businesslogicservice.AccountHotelService;
import businesslogicservice.AccountService;
import businesslogicservice.AccountWebService;
import businesslogicservice.LoginService;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import serviceFactory.AccountContollerUtil;
import tools.AccountType;
import tools.ResultMessage_Account;
import ui.utils.Dialogs;
import ui.utils.TextFieldUtil;

/**
 * 修改密码对话框界面
 * @author zjy
 *
 */
public class ResetPasswordController {
	@FXML
	private Button confirmReset;
	@FXML
	private JFXPasswordField newPassword;
	@FXML
	private JFXPasswordField confirmPassword;
	private EventHandler<ActionEvent> closeHandler;
	
	@FXML
	private void initialize(){
		TextFieldUtil.setValidator(newPassword);
		TextFieldUtil.setRepeatValidator(newPassword, confirmPassword);
	}

	@FXML
	private void handleConfirmReset(){
		if(!"".equals(newPassword.getText()) && !"".equals(confirmPassword.getText()) && 
				newPassword.getText().equals(confirmPassword.getText())){
			LoginService loginService=LoginController.getInstance();
			String username=loginService.getLogState().username;
			
			ResultMessage_Account result = null;
			if(AccountType.Customer.equals(loginService.getLogState().accountType)){
				AccountCustomerService accountCustomerService=CustomerAccountController.getInstance();
				result=accountCustomerService.resetPassword(username, confirmPassword.getText());
			}else if (AccountType.Hotel.equals(loginService.getLogState().accountType)) {
				AccountHotelService accountHotelService=HotelAccountController.getInstance();
				result=accountHotelService.resetPassword(username, confirmPassword.getText());
			}else if (AccountType.Web.equals(loginService.getLogState().accountType)) {
				AccountWebService accountWebService=WebDesignerAccountController.getInstance();
				result=accountWebService.resetPassword(username, confirmPassword.getText());
			}else if (AccountType.Administor.equals(loginService.getLogState().accountType)) {
				AccountCustomerService accountCustomerService=CustomerAccountController.getInstance();
				result=accountCustomerService.resetPassword(username, confirmPassword.getText());
			}
			
			if(ResultMessage_Account.Success.equals(result)){
				closeHandler.handle(new ActionEvent());
			}else {
				Dialogs.showMessage("阿欧", "修改密码失败了……");
			}
		}
	}
	
	/**
	 * 设置修改密码结束时的操作
	 * @param value
	 */
	public void setOnClose(EventHandler<ActionEvent> value) {
		this.closeHandler=value;
	}
}
