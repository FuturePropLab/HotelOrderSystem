package ui.utils;

import java.net.URL;

/**
 * 图片信息的处理
 * @author zjy
 *
 */
public class ImageUtil {

	/**
	 * 获取resources/image目录下的图片路径
	 * @param name 图片名（不带路径）
	 * @return 图片的绝对路径URL
	 */
	public static String getURL(String name) {
		URL url=ImageUtil.class.getResource("/images/"+name);
		return url.toString();
	}
}
