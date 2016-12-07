package businesslogicservice;

import java.util.List;

import tools.ResultMessage;
import tools.ResultMessage_Member;
import vo.ApplyVO;
import vo.BackVO;
import vo.MemberVO;
/**
 * 
 * @author zjy
 *
 */
public interface MemberService {
	/**
	 * 获取会员信息
	 * @param customer_id 请求查询的客户ID
	 * @return 会员信息
	 */
	public MemberVO getMemberInfo(String customer_id);
	/**
	 * 申请会员，这是给客户的ui调用的
	 * @param apply 申请的信息
	 * @return 调用成功则返回Exist，失败返回NotExist
	 */
//	public ResultMessage_Member addApply(ApplyVO apply);
	/**
	 * 返回申请会员的结果，这是给网站管理人员的ui调用的
	 * @param back 申请结果的信息
	 * @return 调用成功则返回Exist，失败返回NotExist
	 */
//	public ResultMessage_Member addBack(BackVO back);
	/**
	 * 获取申请会员的列表
	 * @return 申请列表
	 */
//	public List<ApplyVO> getApplyList();
	/**
	 * 获取申请会员的结果，这是给客户的ui调用的
	 * @param customer_id 客户ID
	 * @return 申请结果的信息
	 */
//	public BackVO getBack(String customer_id);
	/**
	 * 修改会员信息
	 * @param memberInfo 修改的信息
	 * @return 调用成功则返回Exist，失败返回NotExist
	 */
	public ResultMessage_Member modifyMemberInfo (MemberVO memberInfo);
}
