package ui.webdesign;

import java.rmi.RemoteException;
import java.util.Date;

import com.jfoenix.controls.JFXTextField;

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
import ui.utils.TextFieldUtil;
import vo.CustomerVO;

/**
 * 信用充值界面的控制器
 * @author zjy
 *
 */
public class CreditChargeController extends DetailsController{

	@FXML
	private JFXTextField userName;
	@FXML
	private Label customerName;
	@FXML
	private Label credit;
	@FXML
	private Label plusVaule;
	@FXML
	private JFXTextField amount;
	@FXML
	private Button charge;
	private String customerID;//在没有查询到客户的时候一直为null
	
	@FXML
	private void initialize() {
		TextFieldUtil.setValidator(userName);
		TextFieldUtil.setNumberValidator(amount);
	}
	@FXML
	private void handleUserName(){
		AccountCustomerService accountCustomerService=CustomerAccountController.getInstance();
		String customerID=accountCustomerService.getAccountID(userName.getText());
		if(customerID!=null &&!"".equals(customerID) &&!"INVALID_INPUT".equals(customerID) 
				&&!"USERNAME_NOT_EXITS".equals(customerID)){
			try {
				CustomerVO customerVO=accountCustomerService.getCustomerDetail(customerID);
				if(customerVO!=null && customerVO.customerName!=null){
					customerName.setText(customerVO.customerName);
					credit.setText(customerVO.credit+"");
					this.customerID=customerID;
				}else {
					customerName.setText("没有这个用户");
					credit.setText(0+"");
					this.customerID=null;
				}
			} catch (RemoteException e) {
				Dialogs.showMessage("阿欧", "查询用户失败了……");
			}
		}else {
			customerName.setText("没有这个用户");
			credit.setText(0+"");
			this.customerID=null;
		}
	}
	@FXML
	private void handleAmount(){
		if("".equals(amount.getText())){ 
			//amount.setText("0");
			plusVaule.setText("0");
			return;
		}
		try{
			plusVaule.setText(Integer.parseInt(amount.getText())*100+"");
		}catch(NumberFormatException e){
			System.out.println(amount.getText()+" is not a number");
		}
	}
	@FXML
	private void handleCharge(){
		//检测充值输入是否是整数
		int amount=0;
		try{
			amount=Integer.parseInt(this.amount.getText());
		}catch(NumberFormatException e){
			return;
		}
		
		if(this.customerID!=null){
			CreditLogDealService creditLogDealService=CreditController.getInstance();
			if(ResultMessage.Exist.equals(creditLogDealService.charge(
					customerID, amount, new Date()))){
				Dialogs.showMessage("耶耶", "充值成功！≧∇≦");
			}else {
				Dialogs.showMessage("额", "充值失败了(⊙o⊙)…");
			}
		}else {
			Dialogs.showMessage("阿欧", "还没有找到要充值的客户哦");
		}
	}
	
}
