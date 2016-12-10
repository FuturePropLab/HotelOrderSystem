package ui.customer;

import businesslogic.customer.CustomerDealController;
import businesslogic.member.MemberController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import tools.MemberBelongType;
import tools.MemberType;
import ui.main.DetailsController;
import vo.CustomerVO;
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
	}
	
	@FXML
	private void handleSave(){
		CustomerVO customerVO =  new CustomerVO
				(customerID, this.customerName.getText(), this.gender.getValue(),
						this.contactWay.getText(), null, 0);
		try {
			CustomerDealController.getInstance().changeCustomerInfo(customerVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		//TODO:调用blservice申请会员
	}
	
	/**
	 * 
	 * @param customerID 客户ID
	 */
	public void initValue(String customerID) {
		this.customerID = customerID;
		CustomerVO customerVO = null ;
		//TODO:调用blservice获取客户信息并将组件的值填好
		try {
		   customerVO  =CustomerDealController.getInstance().getCustomerInfo(customerID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(customerVO!=null){
			this.gender.setValue(customerVO.gender);
			this.credit.setText(String.valueOf(customerVO.credit));
			this.customerName.setText(customerVO.customerName);
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
	}
}
