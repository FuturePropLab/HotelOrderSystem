package businesslogicservice;

import java.rmi.RemoteException;

import vo.OrderInputCalVO;
import vo.StrategyVO;
/**
 * 
 * @author LWY
 *
 */
public interface StrategyService {
	public StrategyVO CalculateBestStrategy(OrderInputCalVO orderInputCalVO) throws RemoteException;
}
