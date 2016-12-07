package tools;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.OrderPO;
import po.SearchOrderInfo;
import tools.ResultMessage;
/**
 * 
 * @author zjy
 *
 */
public interface OrderDataService extends Remote{
	/**
	 * 持久化增加订单
	 * @param order 订单的信息
	 * @return 调用成功则返回Exist，失败返回NotExist
	 */
	public ResultMessage add(OrderPO order)throws RemoteException;
	/**
	 * 获取单个订单的信息
	 * @param order_id 订单的ID
	 * @return 目标订单的信息，如果没找到目标订单，返回null
	 */
	public OrderPO findOrder(String order_id)throws RemoteException;
	/**
	 * 修改订单的信息
	 * @param order 要修改的的信息
	 * @return 调用成功则返回Exist，失败返回NotExist
	 */
	public ResultMessage modify(OrderPO order)throws RemoteException;
	/**
	 * 搜索符合条件的订单
	 * @param searchOrderInfo 搜索的条件
	 * @return 符合条件的 列表
	 */
	public List<OrderPO> searchOrder(SearchOrderInfo searchOrderInfo)throws RemoteException;

}
