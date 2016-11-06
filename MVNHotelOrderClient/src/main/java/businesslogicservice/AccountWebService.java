package businesslogicservice;

import java.util.List;

import tools.ResultMessage;
import vo.WebAccountVO;
import vo.WebDesignerSearchVO;

/**
 * 
 * @author wshwbluebird
 *
 */
public interface AccountWebService {

	/**
	 * 增加网站设计人员
	 * @param webAccountVO
	 * @return ResultMessage 
	 */
	public ResultMessage addWebAccount(WebAccountVO webAccountVO);
	
	/**
	 * 修改网站设计人员的账户信息
	 * @param webAccountVO
	 * @return ResultMessage
	 */
	public ResultMessage modifyWebAccount(WebAccountVO webAccountVO);

	/**
	 * 根据ID获取网站设计人员的账户信息
	 * @param webDesigner_id
	 * @return WebAccountVO
	 */
	public WebAccountVO getWebAccount(String webDesigner_id);
	
	/**
	 * 根据搜索信息获取网站设计人员的信息列表s
	 * @param webDesignerSearchVO
	 * @return List<WebAccountVO>
	 */
}
