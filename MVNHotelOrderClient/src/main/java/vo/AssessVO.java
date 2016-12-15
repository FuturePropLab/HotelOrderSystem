package vo;

import tools.Mark;

/**
 * 订单的评价信息
 * @author zjy
 *
 */
public class AssessVO {
	public String orderID;
	public Mark mark;
	public String assessment;
	/**
	 * 
	 * @param orderID 订单ID
	 * @param mark 评分
	 * @param assessment 评价
	 */
	public AssessVO(String orderID,Mark mark, String assessment) {
		super();
		this.orderID=orderID;
		this.mark = mark;
		this.assessment = assessment;
	}
}
