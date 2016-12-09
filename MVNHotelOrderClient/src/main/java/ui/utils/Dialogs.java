package ui.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.StackPane;

import com.jfoenix.controls.JFXDialog;

/**
 * 弹窗消息
 * @author zjy
 *
 */
public class Dialogs {

	/**
	 * 显示消息对话框
	 * @param message 信息
	 */
	public static void showMessage(String message) {
		showMessage("", message);
	}
	
	/**
	 * 显示消息对话框
	 * @param headerText 消息头
	 * @param message 信息
	 */
	public static void showMessage(String headerText,String message) {
    	showMessage("消息", headerText, message);
	}
	
	/**
	 * 显示消息对话框
	 * @param title 对话框标题
	 * @param headerText 消息头
	 * @param message 信息
	 */
	public static void showMessage(String title,String headerText,String message) {
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.setContentText(message);
		alert.show();
	}
	
	/**
	 * 提示用户选择选项
	 * @deprecated 还没写
	 * @param message 显示给用户的信息
	 * @param choise1 选择1的名称
	 * @param choise2 选择2的名称
	 */
	public static Choise showChoise(String message,String choise1,String choise2) {
		//TODO
		return Choise.choise1;
	}
	
	/**
	 * 用户的选择
	 * @author zjy
	 *
	 */
	public enum Choise{
		choise1,
		choise2
	}
}
