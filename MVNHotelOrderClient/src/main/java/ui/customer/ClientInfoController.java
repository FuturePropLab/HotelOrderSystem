package ui.customer;

import java.io.IOException;
import java.time.LocalDate;

import businesslogic.customer.CustomerDealController;
import businesslogic.login.LoginController;
import businesslogic.member.MemberController;
import businesslogicservice.LoginService;
import businesslogicservice.MemberService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import tools.MemberBelongType;
import tools.MemberType;
import tools.ResultMessage;
import tools.ResultMessage_Member;
import tools.ResultMessage_Modify;
import ui.main.DetailsController;
import ui.utils.Dialogs;
import vo.CustomerVO;
import vo.LogVO;
import vo.MemberVO;

/**
 * 客户信息界面的控制器
 * @author zjy
 *
 */
public class ClientInfoController extends DetailsController{

	@FXML
	private TextField customerName;
	@FXML
	private TextField contactWay;
	@FXML
	private ComboBox<String> gender;
	@FXML
	private Label credit;
	@FXML
	private Button save;
	@FXML
	private Label memberType;
	@FXML
	private Button applyMember;//只有不是会员才能看到
	@FXML
	private Label memberTypeInfo;//如果是普通会员显示“生日”，如果是企业会员显示“企业名称”，不是会员就不显示
	@FXML
	private Label memberInfo;//如果是普通会员显示生日日期，如果是企业会员显示企业的名称，不是会员就不显示
	@FXML
	private Label levelLable;//如果是会员显示，否则不显示
	@FXML
	private Label level;//如果是会员显示，否则不显示
	@FXML
	private ComboBox<String> memberType_apply;
	@FXML
	private Label memberTypeInfo_apply;//如果申请普通会员显示“生日”，如果申请企业会员显示“企业名称”
	@FXML
	private DatePicker birthday_apply;
	@FXML
	private TextField companyName_apply;
	@FXML
	private Button apply;
	@FXML
	private AnchorPane memberMessage;
	@FXML
	private AnchorPane applyMessage;
	
	private String customerID;
	
	
	@FXML
	private void initialize(){
		memberType_apply.getItems().setAll("普通会员","企业会员");
		memberType_apply.setValue("普通会员");
		this.gender.getItems().clear();
		this.gender.getItems().addAll("男","女");
		
		LoginService loginService=LoginController.getInstance();
		LogVO logVO=loginService.getLogState();
		this.customerID=logVO.accountID;
		
		try {
			CustomerVO customerVO  =CustomerDealController.getInstance().getCustomerInfo(customerID);
			if(customerVO!=null){
				this.gender.setValue(customerVO.gender);
				this.credit.setText(String.valueOf(customerVO.credit));
				this.customerName.setText(customerVO.customerName);
				this.contactWay.setText(customerVO.telephone);
				MemberVO memberVO = MemberController.getInstance().getMemberInfo(customerID);
				
				MemberType me = memberVO.memberType;
				if(me.getType()== MemberBelongType.None){
					this.applyMessage.setVisible(false);
					this.memberType.setText("不是会员");
					this.memberType.setVisible(true);
					this.memberType_apply.getItems().clear();
					this.memberType_apply.getItems().add("普通会员");
					this.memberType_apply.getItems().add("企业会员");
					this.memberType.setText("");
					
				}else if(me.getType()==MemberBelongType.Ordinary){
					this.applyMessage.setVisible(false);
					this.applyMember.setVisible(false);
					this.memberType.setText("普通会员");
					this.memberMessage.setVisible(true);
					this.memberTypeInfo.setText("会员生日:");
					this.memberTypeInfo.setVisible(true);
					this.memberInfo.setText(me.getBirthday().toString());
					this.memberInfo.setVisible(true);
					this.level.setText(String.valueOf(me.getLevel()));
					this.level.setVisible(true);
					this.levelLable.setVisible(true);
				}else{
					this.applyMessage.setVisible(false);
					this.applyMember.setVisible(false);
					this.memberType.setText("企业会员");
					this.memberMessage.setVisible(true);
					this.memberTypeInfo.setText("企业名称:");
					this.memberTypeInfo.setVisible(true);
					this.memberInfo.setText(me.getCompanyName());
					this.memberInfo.setVisible(true);
					this.level.setText(String.valueOf(me.getLevel()));
					this.level.setVisible(true);
					this.levelLable.setVisible(true);
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void handleSave(){
		CustomerVO customerVO =  new CustomerVO
				(customerID, this.customerName.getText(), this.gender.getValue(),
						this.contactWay.getText(), null, 0);
		if(ResultMessage_Modify.Success.equals(CustomerDealController.getInstance().changeCustomerInfo(customerVO))){
			Dialogs.showMessage("嘿", "保存成功了哟……");
		}else {
			Dialogs.showMessage("阿欧", "保存失败了……");
		}
	}
	@FXML
	private void handleApplyMember(){
		memberMessage.setVisible(false);
		applyMessage.setVisible(true);
	}
	@FXML
	private void handleMemberType_apply(){
		if("普通会员".equals(memberType_apply.getValue())){
			memberTypeInfo_apply.setText("生日");
			birthday_apply.setVisible(true);
			companyName_apply.setVisible(false);
		}else if ("企业会员".equals(memberType_apply.getValue())) {
			memberTypeInfo_apply.setText("企业名称");
			birthday_apply.setVisible(false);
			companyName_apply.setVisible(true);
		}
	}
	@FXML
	private void handleApply(){
		if("普通会员".equals(this.memberType_apply.getValue())){
			LocalDate birthday = this.birthday_apply.getValue();
			if(birthday == null)  return;
			
			MemberService memberService  =MemberController.getInstance();
			MemberType memberType = new MemberType(customerID);
			memberType.setBirthday(birthday);
			memberType.setType(MemberBelongType.Ordinary);
			MemberVO memberVO = new MemberVO(customerID, memberType);
			ResultMessage_Member rs = memberService.modifyMemberInfo(memberVO);
			if(rs==ResultMessage_Member.Success){
				Dialogs.showMessage("会员申请成功");
				try {
					rootLayoutController.changeDetails("../customer/ClientInfo.fxml");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else{
				Dialogs.showMessage("会员申请失败，也许是你信用值不够呢");
			}
		}else  if("企业会员".equals(this.memberType_apply.getValue())){
			if(this.companyName_apply.getText()==null){
				return ;
			}
			String companyapplyname = this.companyName_apply.getText().trim();
			MemberService memberService  =MemberController.getInstance();
			MemberType memberType = new MemberType(customerID);
			memberType.setCompanyName(companyapplyname);
			memberType.setType(MemberBelongType.Enterprise);
			MemberVO memberVO = new MemberVO(customerID, memberType);
			ResultMessage_Member rs = memberService.modifyMemberInfo(memberVO);
			if(rs==ResultMessage_Member.Success){
				Dialogs.showMessage("会员申请成功");
				try {
					rootLayoutController.changeDetails("../customer/ClientInfo.fxml");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else{
				Dialogs.showMessage("会员申请失败   请注意自己的信用值");
			}
		}
		
	}
	
}
