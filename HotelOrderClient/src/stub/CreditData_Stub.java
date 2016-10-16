package stub;

import java.util.ArrayList;
import java.util.List;

import dataservice.CreditDataService;
import po.CreditLogPO;
import po.OrderPO;
import tools.ActionType;
import tools.ResultMessage;

public class CreditData_Stub implements CreditDataService {

	@Override
	public ResultMessage add(CreditLogPO creditlog) {
		if(creditlog!=null)  return ResultMessage.Exist;
				return ResultMessage.NotExist;
	}

	@Override
	public List<CreditLogPO> getLogList(String customer_id) {
		// TODO Auto-generated method stub
		List<CreditLogPO> creditLogPOList = new ArrayList<>();
		CreditLogPO creditLogPO1 = new CreditLogPO(ActionType.Charge, null, 100);
		OrderPO orderPO = new OrderPO("2134");
		CreditLogPO creditLogPO2 = new CreditLogPO(ActionType.RightOrder, orderPO, 20);
		
		creditLogPOList.add(creditLogPO1);
		creditLogPOList.add(creditLogPO2);
				
		return creditLogPOList;
	}

}
