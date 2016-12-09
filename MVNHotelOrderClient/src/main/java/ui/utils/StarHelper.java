package ui.utils;

import javafx.scene.control.ComboBox;
import tools.Star;

/**
 * 处理星级或者评分的类，只提供静态方法
 * @author zjy
 *
 */
public class StarHelper {
	public static Star stars[]={Star.one,Star.two,Star.three,Star.four,Star.five};

	/**
	 * 获取星级
	 * @param comboBox 星级的选择器
	 * 如果有5个选项，默认是1-5星
	 * 如果有6个选项，默认第一个是“所有”，后面是1-5星
	 * 否则认为是错误参数
	 * @return 星级
	 */
	public static Star getStar(ComboBox<? extends Object> comboBox) {
		int index;
		if(comboBox.getItems().size()==5){
			index=comboBox.getSelectionModel().getSelectedIndex();
		}else if (comboBox.getItems().size()==6) {
			index=comboBox.getSelectionModel().getSelectedIndex()-1;
		}else {
			return null;
		}
		return index>=0? stars[index]:null;
	}
}
