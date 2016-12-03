package vo;

import java.util.Collection;

/**
 * 酒店评价信息
 * @author zjy
 *
 */
public class HotelAssessVO {
	
	public double averageMark;
	public Collection<AssessVO> assesses;
	
	/**
	 * 
	 * @param averageMark 平均评分
	 * @param assesses 各条评价信息
	 */
	public HotelAssessVO(double averageMark, Collection<AssessVO> assesses) {
		super();
		this.averageMark = averageMark;
		this.assesses = assesses;
	}
}
