package businesslogicservice;

import java.util.List;

import tools.ResultMessage;
import vo.ExecutionInfoVO;
import vo.OrderInputVO;
import vo.OrderVO;
import vo.SearchHotelVO;
import vo.SearchOrderInfoVO;
/**
 * 
 * @author zjy
 *
 */
public interface OrderService {
	/**
	 * 创建订单
	 * @param orderInput 下单信息
	 * @return 订单信息
	 */
	public OrderVO createOrders(OrderInputVO orderInput);
	/**
	 * 持久化保存订单
	 * @param preorder 订单信息
	 * @return 调用成功则返回Exist，失败返回NotExist
	 */
	public ResultMessage saveOrder(OrderVO preorder); 
	/**
	 * 搜索订单
	 * @param searchOrderInfo 搜索订单的搜索条件
	 * @return 符合条件的订单列表
	 */
	public List<OrderVO> CheckOrderList (SearchOrderInfoVO searchOrderInfo);
	/**
	 * 获取单个订单的信息
	 * @param order_id 订单的ID
	 * @return 订单的信息
	 */
	public OrderVO checkSingleOrder (String order_id );
	/**
	 * 撤销订单
	 * @param order 订单的信息
	 * @return 调用成功则返回Exist，失败返回NotExist
	 */
	public ResultMessage revokeCurrentOrder(OrderVO order);
	/**
	 * 计算撤销订单将要损失的信用值
	 * @param order 订单的信息
	 * @return 预计损失的信用值
	 */
	public int calculateCreditLose (OrderVO order);
	/**
	 * 客户到店办理入住时，酒店工作人员执行订单，即修改订单的入住信息
	 * @param executionInfo 修改的信息
	 * @return 调用成功则返回Exist，失败返回NotExist
	 */
	public ResultMessage executionModify (ExecutionInfoVO executionInfo);
	/**
	 * 时间超过最晚到店时间时，自动将订单置为异常订单
	 * @param Order 订单信息
	 * @return 调用成功则返回Exist，失败返回NotExist
	 */
	public ResultMessage AutoToBad(OrderVO Order);
	/**
	 * 撤销异常订单
	 * @param badOrder 订单信息
	 * @return 调用成功则返回Exist，失败返回NotExist
	 */
	public ResultMessage revokeBadOrderr(OrderVO badOrder);
}