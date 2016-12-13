package ui.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import ui.main.RootLayoutController;

import org.junit.experimental.theories.Theories;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXDialog.DialogTransition;

/**
 * 弹窗消息
 * @author zjy
 *
 */
public class Dialogs {
	private static StackPane rootLayout;
	private static JFXDialog dialog;
	
	/**
	 * 给这个类设置rootLayout和dialog的引用
	 * 这个方法是因为设计不合理而产生的补救方法，只提供给RootLayoutController调用
	 * @param rootLayout 根界面
	 * @param dialog 根界面的JFXDialog区域
	 */
	public static void init(StackPane rootLayout,JFXDialog dialog) {
		Dialogs.rootLayout=rootLayout;
		Dialogs.dialog=dialog;
	}

	/**
	 * 显示消息对话框
	 * @param message 信息
	 */
	public static void showMessage(String message) {
		showMessage("哈喽", message);
	}
	
	/**
	 * 显示消息对话框
	 * @param title 对话框标题
	 * @param message 信息
	 */
	public static void showMessage(String title,String message) {
//    	Alert alert = new Alert(AlertType.INFORMATION);
//		alert.setTitle(title);
//		alert.setHeaderText(headerText);
//		alert.setContentText(message);
//		alert.show();
		showMessage(title, message, DialogTransition.TOP);
	}
	
	/**
	 * 显示消息对话框
	 * @param title 对话框标题
	 * @param message 信息
	 * @param transition 对话框出现方向，默认是DialogTransition.TOP
	 */
	public static void showMessage(String title,String message,DialogTransition transition) {
		JFXButton acceptButton=new JFXButton("我知道了");
		acceptButton.setOnAction(e -> dialog.close());
		
		Label headingLabel=new Label(title);
		headingLabel.setFont(new Font(30));
		headingLabel.setTextFill(Color.LIGHTCORAL);
		Label bodyLabel=new Label(message);
		bodyLabel.setFont(new Font(22));
		
		JFXDialogLayout jfxDialogLayout=new JFXDialogLayout();
		jfxDialogLayout.setHeading(headingLabel);
		jfxDialogLayout.getHeading().forEach(
				heading->heading.setStyle("-fx-font-weight: BOLD;-fx-alignment: center-left;"));
		jfxDialogLayout.setBody(bodyLabel);
		jfxDialogLayout.getBody().forEach(
				body->body.setStyle("-fx-wrap-text: true;"));
		jfxDialogLayout.setActions(acceptButton);
		
		dialog=new JFXDialog(rootLayout, jfxDialogLayout, DialogTransition.TOP);
		dialog.setTransitionType(transition);
		dialog.show(rootLayout);
	}
	
	/**
	 * 提示用户选择选项
	 * @deprecated 还没写
	 * @param message 显示给用户的信息
	 * @param choise1 选择1的名称
	 * @param choise2 选择2的名称
	 * @return 如果用户选择第一个选项，返回Choise.choise1
	 * 			如果用户选择第二个选项，返回Choise.choise2
	 * 			如果用户取消选择，返回null
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
