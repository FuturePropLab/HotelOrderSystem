package ui.webdesign;

import java.rmi.RemoteException;
import java.util.Date;

import businesslogic.account.CustomerAccountController;
import businesslogic.credit.CreditController;
import businesslogicservice.AccountCustomerService;
import businesslogicservice.CreditLogDealService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import tools.ResultMessage;
import tools.ResultMessage_Modify;
import ui.main.DetailsController;
import ui.utils.Dialogs;
import vo.CustomerVO;

/**
 * 信用充值界面的控制器
 * @author zjy
 *
 */
public class CreditChargeController extends DetailsController{

	@FXML
	private TextField userName;
	@FXML
	private Label customerName;
	@FXML
	private Label credit;
	@FXML
	private Label plusVaule;
	@FXML
	private TextField amount;
	@FXML
	private Button charge;
	private String customerID;//在没有查询到客户的时候一直为null
	
	@FXML
	private void handleUserName(){
		AccountCustomerService accountCustomerService=CustomerAccountController.getInstance();
		String customerID=accountCustomerService.getAccountID(userName.getText());
		if(!"".equals(customerID)){
			try {
				CustomerVO customerVO=accountCustomerService.getCustomerDetail(customerID);
				customerName.setText(customerVO.customerName);
				credit.setText(customerVO.credit+"");
				this.customerID=customerID;
			} catch (RemoteException e) {
				Dialogs.showMessage("阿欧", "查询用户失败了……");
			}
		}else {
			customerName.setText(null);
			credit.setText(0+"");
			this.customerID=null;
		}
	}
	@FXML
	private void handleAmount(){
		plusVaule.setText(Integer.parseInt(amount.getText())*100+"");
	}
	@FXML
	private void handleCharge(){
		if(this.customerID!=null){
			CreditLogDealService creditLogDealService=CreditController.getInstance();
			if(ResultMessage.Exist.equals(creditLogDealService.charge(
					customerID, Integer.parseInt(amount.getText()), new Date()))){
				Dialogs.showMessage("耶耶", "充值成功！≧∇≦");
			}else {
				Dialogs.showMessage("额", "充值失败了(⊙o⊙)…");
			}
		}else {
			Dialogs.showMessage("阿欧", "还没有找到要充值的客户哦");
		}
	}
	
}
