package businesslogicservice;

import java.rmi.RemoteException;
import java.util.List;

import tools.ResultMessage_Account;
import vo.AccountVO;
import vo.CustomerSearchVO;
import vo.CustomerVO;

public interface AccountCustomerService {
	/**
	 * 通过用户名 返回该账户的ID
	 * @param username
	 * @param password
	 * @return 该账户的ID 
	 */
	public String getAccountID(String username);
	
	/**
	 * 通过注册的用户名和密码 以及账户类型 新增一个新的账户  自动生成ID
	 * @param username
	 * @param password
	 * @param accountType
	 * @return 是否成功
	 */
	public ResultMessage_Account addAccount(String username ,String password);
	
	/**
	 * 通过输入账户名 重制账户的密码
	 * @param userid
	 * @param newPassword
	 * @return 重设是否成功
	 */
	public ResultMessage_Account resetPassword(String userid, String newPassword);
	
	
	/**
	 * 通过账户的id ，获取账户的名字
	 * @param userId
	 * @return 该账户的用户名
	 */
	public String getUsername(String userId);
	
	/**
	 * 根据id 删除账户信息
	 * @param userId
	 * @return 删除操作是否成功
	 */
	public ResultMessage_Account deleteAccount(String userId);
	
	/**
	 * 通过客户的id 返回客户的个人基本信息
	 * @param customer_id
	 * @return CustomerVO
	 * @throws RemoteException 
	 */
	public CustomerVO getCustomerDetail(String customer_id) throws RemoteException;
	
	
	/**
	 * 通过客户的搜索信息值 返回符合条件的AccountVO 列表
	 * @param customerSearchVO
	 * @return 符合条件的客户账户VO 列表
	 * @throws RemoteException 
	 */
	public List<AccountVO> searchCustomerAccount(CustomerSearchVO customerSearchVO) throws RemoteException;
	

}
