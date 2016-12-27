package ui.hotel;

import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import tools.Mark;
import tools.Star;

/**
 * 酒店列表项的控制器
 * @author zjy
 *
 */
public class HotelItemController {
	private static Image yellowStar=new Image("file:./target/resources/images/star__selected.png");
	private static Image greyStar=new Image("file:./target/resources/images/star_unselected.png");
	
	@FXML
	private ImageView imageView;
	@FXML
	private Label hotelName;
	@FXML
	private Label star;
	@FXML
	private ImageView star_1;
	@FXML
	private ImageView star_2;
	@FXML
	private ImageView star_3;
	@FXML
	private ImageView star_4;
	@FXML
	private ImageView star_5;
	@FXML
	private Label mark;
	@FXML
	private ImageView mark_1;
	@FXML
	private ImageView mark_2;
	@FXML
	private ImageView mark_3;
	@FXML
	private ImageView mark_4;
	@FXML
	private ImageView mark_5;
	@FXML
	private Label price_from;
	@FXML
	private Label price_to;
	@FXML
	private Hyperlink hotelDetail;
	@FXML
	private Hyperlink book;
	private String hotelID;
	private HotelSearchController hotelSearchController;
	
	@FXML
	private void handleHotelDetail(){
		hotelSearchController.toHotelDetailUI(hotelID);
	}
	@FXML
	private void handleBookHotel(){
		hotelSearchController.toBookHotelUI(hotelID);
	}
	
	/**
	 * 设置列表项的各项值
	 * @param image 图片
	 * @param hotelName 酒店名字
	 * @param star 星级
	 * @param mark 评分
	 * @param price_from 价格区间，最低价
	 * @param price_to 价格区间，最高价
	 * @param hotelID 酒店ID，用于记录这条列表项对应的酒店
	 * @param hotelSearchController 为了调用跳转界面的方法而传过来
	 */
	public void setValues(Image image,String hotelName,Star star,Mark mark,double price_from,double price_to,
			String hotelID,HotelSearchController hotelSearchController) {	
		this.imageView.setImage(image==null? new Image("file:./target/resources/images/room.png"):image);
		this.hotelName.setText(hotelName);
		this.star.setText(star.ordinal()+"星");
		this.mark.setText(mark.getValue()+"分");
		this.price_from.setText("￥"+price_from);
		this.price_to.setText("￥"+price_to);
		this.hotelID=hotelID;
		this.hotelSearchController=hotelSearchController;
		
		star_1.setImage(star.ordinal()>=1? yellowStar:greyStar);
		star_2.setImage(star.ordinal()>=2? yellowStar:greyStar);
		star_3.setImage(star.ordinal()>=3? yellowStar:greyStar);
		star_4.setImage(star.ordinal()>=4? yellowStar:greyStar);
		star_5.setImage(star.ordinal()>=5? yellowStar:greyStar);
		mark_1.setImage(mark.getValue()>=1? yellowStar:greyStar);
		mark_2.setImage(mark.getValue()>=2? yellowStar:greyStar);
		mark_3.setImage(mark.getValue()>=3? yellowStar:greyStar);
		mark_4.setImage(mark.getValue()>=4? yellowStar:greyStar);
		mark_5.setImage(mark.getValue()>=5? yellowStar:greyStar);
	}
	
}
