package ui.main;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXDrawer.DrawerDirection;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * 详情面板的控制器
 * @author zjy
 *
 */
public class DetailsController {
	protected RootLayoutController rootLayoutController;

	/**
	 * 设置根界面控制器
	 * @param rootLayoutController
	 */
	public void setRootLayoutController(RootLayoutController rootLayoutController) {
		this.rootLayoutController = rootLayoutController;
	}
	
	/**
	 * @deprecated 尝试转场动画，已放弃
	 * @param pane
	 */
	public void translate(AnchorPane pane) {
//		final Timeline timeline = new Timeline();
//		timeline.setCycleCount(Timeline.INDEFINITE);
//		timeline.setAutoReverse(true);
//		final KeyValue kv = new KeyValue(pane.layoutXProperty(), 600);
//		final KeyFrame kf = new KeyFrame(Duration.millis(500), kv);
//		timeline.getKeyFrames().add(kf);
//		timeline.play();
		
		JFXDrawer leftDrawer = new JFXDrawer();
		leftDrawer.setSidePane(pane);
		leftDrawer.setDefaultDrawerSize(1300);
		leftDrawer.setDirection(DrawerDirection.LEFT);	
		leftDrawer.setOverLayVisible(false);
		leftDrawer.setResizableOnDrag(true);
	}
	
}
