package ui.utils;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.scene.control.TextField;

/**
 * 输入框的功能设置类，只提供静态方法
 * @author zjy
 *
 */
public class TextFieldUtil {

	public static void setValidator(JFXTextField textField) {

		textField.setLabelFloat(true);
		
		RequiredFieldValidator validator = new RequiredFieldValidator();
		validator.setErrorStyleClass("");
		validator.setMessage("Please type something!");
//		validator.setIcon(new Icon(AwesomeIcon.WARNING,"1em",";","error"));		
		textField.getValidators().add(validator);
		textField.focusedProperty().addListener((o,oldVal,newVal)->{
			if(!newVal) textField.validate();
		});
	}
}
