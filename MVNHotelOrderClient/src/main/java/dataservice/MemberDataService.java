package dataservice;

import java.util.List;

import po.ApplyPO;
import po.BackPO;
import po.MemberPO;
import tools.ResultMessage;
import tools.ResultMessage_Member;
/**
 * 
 * @author zjy
 *
 */
public interface MemberDataService {
//	/**
//	 * 增加会员，这是给网站管理人员的bl调用的
//	 * @param customer_id 客户ID
//	 * @return 调用成功则返回Exist，失败返回NotExist
//	 */
//	public ResultMessage_Member addMember(String customer_id);
//	目前就用这两个 方法!!!!!
	
	/**
	 * 修改会员信息
	 * @param member 修改的信息
	 * @return 调用成功则返回Exist，失败返回NotExist
	 */
	public ResultMessage_Member modifyMember(MemberPO member);
	/**
	 * 获取会员信息
	 * @param customer_id 请求查询的客户ID
	 * @return 会员信息
	 */
	public MemberPO getMember(String customer_id);

	
	
	
	//	/**
//	 * 申请会员，这是给客户的bl调用的
//	 * @param po 申请的信息
//	 * @return 调用成功则返回Exist，失败返回NotExist
//	 */
//	public ResultMessage_Member addApply(ApplyPO po);
//	/**
//	 * 返回申请会员的结果，这是给网站管理人员的bl调用的
//	 * @param po 申请结果的信息
//	 * @return 调用成功则返回Exist，失败返回NotExist
//	 */
//	public ResultMessage_Member addBack (BackPO po);
//	/**
//	 * 修改申请会员的信息，这是给客户的bl调用的
//	 * @param po 申请结果的信息
//	 * @return 调用成功则返回Exist，失败返回NotExist
//	 */
//	public ResultMessage_Member modifyApply(ApplyPO po);
//	/**
//	 * 返回修改会员的结果，这是给网站管理人员的bl调用的
//	 * @param po 修改申请的结果
//	 * @return 调用成功则返回Exist，失败返回NotExist
//	 */
//	public ResultMessage_Member modifyBack(BackPO po);
//	/**
//	 * 获取申请会员的列表
//	 * @return 申请列表
//	 */
//	public List<ApplyPO> getApplyList ();
//	/**
//	 * 获得单个申请的信息
//	 * @param apply_id 申请信息的ID
//	 * @return 申请的信息
//	 */
//	public ApplyPO getApply(String apply_id);
//	/**
//	 * 获得单个申请回复的信息
//	 * @param back_id 申请回复信息的ID
//	 * @return 申请回复的信息
//	 */
//	public BackPO getBack (String back_id);
//	/**
//	 * 持久化删除申请
//	 * @deprecated 我觉得应该用不到
//	 * @param apply_id 申请信息的ID
//	 * @return 调用成功则返回Exist，失败返回NotExist
//	 */
//	public ResultMessage_Member deleteApply(String apply_id);
//	/**
//	 * 持久化删除申请回复
//	 * @deprecated 我觉得应该用不到
//	 * @param back_id
//	 * @return 调用成功则返回Exist，失败返回NotExist
//	 */
//	public ResultMessage_Member deleteBack (String back_id);
}
