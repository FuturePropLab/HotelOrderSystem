package ui.utils;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import ui.guid.ResetPasswordController;
import ui.main.RootLayoutController;

import java.util.ArrayList;
import java.util.List;

import org.junit.experimental.theories.Theories;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXDialog.DialogTransition;

/**
 * 弹窗消息，只提供静态方法
 * @author zjy
 *
 */
public class Dialogs {
	private static StackPane rootLayout;
	private static JFXDialog dialog;
	
	private static void showDialog(String title,String message,DialogTransition transition,JFXButton... buttons) {	
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
		jfxDialogLayout.setActions(buttons);
		
		dialog=new JFXDialog(rootLayout, jfxDialogLayout, DialogTransition.TOP);
		if(transition!=null){
			dialog.setTransitionType(transition);
		}
		dialog.show(rootLayout);
	}
	
	
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
		showDialog(title, message, transition, acceptButton);
	}
	
	/**
	 * 提示用户选择选项
	 * <p>
	 * 下面是一个例子
	 * <p>
	 * Dialogs.showChoise("message", new Choice("choice1",e->System.out.println("choice1")),
	 * new Choice("choice2",e->System.out.println("choice2")),
	 * new Choice("choice3",e->System.out.println("choice3")));
	 * @param message 显示给用户的信息
	 * @param choices 提供给用户的选择，包括选项名称和处理方法
	 */
	public static void showChoise(String message,Choice... choices) {
		List<JFXButton> buttons=new ArrayList<JFXButton>();
		for(Choice choice:choices){
			JFXButton choiseButton=new JFXButton(choice.choiceName);
			choiseButton.setOnAction(e -> {
				dialog.close();
				choice.value.handle(e);
			});
			buttons.add(choiseButton);
		}
		showDialog("aaa", message, DialogTransition.BOTTOM, buttons.toArray(new JFXButton[0]));
	}
	
	/**
	 * 显示修改密码的对话框
	 * @param jfxDialogLayout 对话框界面
	 */
	public static void showResetPassword(JFXDialogLayout jfxDialogLayout,ResetPasswordController controller) {
		controller.setOnClose(e->dialog.close());
		dialog=new JFXDialog(rootLayout, jfxDialogLayout, DialogTransition.LEFT);
		dialog.show(rootLayout);
	}
}
