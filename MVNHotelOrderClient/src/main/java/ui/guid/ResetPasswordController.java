package ui.guid;

import com.jfoenix.controls.JFXPasswordField;

import businesslogic.account.CustomerAccountController;
import businesslogic.login.LoginController;
import businesslogicservice.AccountCustomerService;
import businesslogicservice.LoginService;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
			AccountCustomerService accountCustomerService=CustomerAccountController.getInstance();
			ResultMessage_Account result=accountCustomerService.resetPassword(username, confirmPassword.getText());
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
