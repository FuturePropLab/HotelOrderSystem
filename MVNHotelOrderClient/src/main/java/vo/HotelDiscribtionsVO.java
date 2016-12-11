package vo;

import java.net.URI;
import java.util.List;

/**
 * 酒店简介信息
 * @author zjy
 *
 */
public class HotelDiscribtionsVO {
	public List<String> discribes;
	public List<URI> pictureURI;
	
	/**
	 * 
	 * @param discribes 酒店描述
	 * @param pictureURI 酒店图片
	 */
	public HotelDiscribtionsVO(List<String> discribes, List<URI> pictureURI) {
		super();
		this.discribes = discribes;
		this.pictureURI = pictureURI;
	}
	
	
	public HotelDiscribtionsVO(){
		super();
	}
}
