package businesslogicservice;

import java.util.List;

import tools.ResultMessage;
import vo.SearchConditionVO;
import vo.WebAccountVO;

public interface AccountWeb_blService {
	public ResultMessage addWebAccount(WebAccountVO vo);

	public ResultMessage modifyWebAccount(WebAccountVO vo);

	public WebAccountVO getWebAccount(String web_id);

	public List<WebAccountVO> searchWebAccount(SearchConditionVO vo);
}
