package businesslogic.account;

import java.rmi.RemoteException;
import java.util.List;

import vo.CustomerSearchVO;
import vo.CustomerVO;
/**
 * 客户调用的接口
 * @author wshwbluebird
 *
 *
 *
 */
public interface CustomerInfo {
		/**
		 * 同层调用客户模块的搜索客户的方法
		 * @param customerSearchVO
		 * @return 符合条件的id列表
		 * @throws RemoteException 
		 */
		public List<String> searchCustomer(CustomerSearchVO customerSearchVO) throws RemoteException;
		
		/**
		 * 同层调用客户模块的获取客户基本信息的方法
		 * @param customer_id
		 * @return CustomerVO
		 * @throws RemoteException 
		 */
		public CustomerVO getCustomerDetail(String customer_id) throws RemoteException;
}
