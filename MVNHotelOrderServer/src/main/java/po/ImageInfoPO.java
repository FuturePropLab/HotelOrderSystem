package po;

import java.io.File;
import java.io.Serializable;


/**
 * 测试图片的rmi传输
 * @author wshwbluebird
 *
 */
public class ImageInfoPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7948436112561337798L;
	private String pictureName;
	private File picture;
	public String getPictureName() {
		return pictureName;
	}
	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}

	public File getPicture() {
		return picture;
	}
	public void setPicture(File picture) {
		this.picture = picture;
	}

	
	
}
