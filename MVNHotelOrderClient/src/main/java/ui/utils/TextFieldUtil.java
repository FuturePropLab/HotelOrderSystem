package ui.utils;

import java.util.Date;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.NumberValidator;
import com.jfoenix.validation.RequiredFieldValidator;
import com.jfoenix.validation.base.ValidatorBase;

import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;

/**
 * 输入框的功能设置类，只提供静态方法
 * @author zjy
 *
 */
public class TextFieldUtil {

	/**
	 * 为textField增加输入不能为空的输入控制器
	 * @param textField
	 */
	public static void setValidator(JFXTextField textField) {
		textField.setLabelFloat(true);
		
		RequiredFieldValidator validator = new RequiredFieldValidator();
		validator.setErrorStyleClass("");
		validator.setMessage("这项内容不能为空!");
//		validator.setIcon(new Icon(AwesomeIcon.WARNING,"1em",";","error"));		
		textField.getValidators().add(validator);
		textField.focusedProperty().addListener((o,oldVal,newVal)->{
			if(!newVal) textField.validate();
		});
	}
	/**
	 * 为passwordField增加输入不能为空的输入控制器
	 * @param passwordField
	 */
	public static void setValidator(JFXPasswordField passwordField) {
		passwordField.setLabelFloat(true);
		
		RequiredFieldValidator validator = new RequiredFieldValidator();
		validator.setErrorStyleClass("");
		validator.setMessage("这项内容不能为空!");
//		validator.setIcon(new Icon(AwesomeIcon.WARNING,"1em",";","error"));		
		passwordField.getValidators().add(validator);
		passwordField.focusedProperty().addListener((o,oldVal,newVal)->{
			if(!newVal) passwordField.validate();
		});
	}
	/**
	 * 为passwordField增加输入不能为空的输入控制器，和监听方法以及信息
	 * @param passwordField 首次输入密码框
	 * @param repeatPassword 重复输入密码框
	 */
	public static void setRepeatValidator(JFXPasswordField passwordField,JFXPasswordField repeatPassword) {
		repeatPassword.setLabelFloat(true);
		
		RequiredFieldValidator validator = new RequiredFieldValidator();
		validator.setErrorStyleClass("");
		validator.setMessage("两次密码不一致!");
//		validator.setIcon(new Icon(AwesomeIcon.WARNING,"1em",";","error"));	
		repeatPassword.getValidators().add(validator);
		repeatPassword.focusedProperty().addListener((o,oldVal,newVal)->{
			if((!"".equals(passwordField.getText())) && (!"".equals(repeatPassword.getText())) &&
					(!passwordField.getText().equals(repeatPassword.getText()))) {
				repeatPassword.clear();
				repeatPassword.validate();
			}
		});
		
	}
	/**
	 * 为textArea增加输入不能为空的输入控制器
	 * @param textArea
	 */
	public static void setValidator(JFXTextArea textArea) {
		textArea.setLabelFloat(true);
		
		RequiredFieldValidator validator = new RequiredFieldValidator();
		validator.setErrorStyleClass("");
		validator.setMessage("这项内容不能为空!");
//		validator.setIcon(new Icon(AwesomeIcon.WARNING,"1em",";","error"));		
		textArea.getValidators().add(validator);
		textArea.focusedProperty().addListener((o,oldVal,newVal)->{
			if(!newVal) textArea.validate();
		});
	}
	/**
	 * 为textField增加输入只能是数字的输入控制器
	 * @param textField
	 */
	public static void setNumberValidator(JFXTextField textField) {
		textField.setLabelFloat(true);
		
		NumberValidator numberValidator=new NumberValidator();
		numberValidator.setErrorStyleClass("");
		numberValidator.setMessage("只能输入数字!");
//		validator.setIcon(new Icon(AwesomeIcon.WARNING,"1em",";","error"));		
		textField.getValidators().add(numberValidator);
		textField.focusedProperty().addListener((o,oldVal,newVal)->{
			if(!newVal) textField.validate();
		});
	}
}
