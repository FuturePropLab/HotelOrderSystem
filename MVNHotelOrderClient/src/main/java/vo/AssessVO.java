package vo;

import tools.Mark;

/**
 * 订单的评价信息
 * @author zjy
 *
 */
public class AssessVO {
	public Mark mark;
	public String assessment;
	/**
	 * 
	 * @param mark 评分
	 * @param assessment 评价
	 */
	public AssessVO(Mark mark, String assessment) {
		super();
		this.mark = mark;
		this.assessment = assessment;
	}
}
