package stub;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dataservice.CreditDataService;
import po.CreditLogPO;
import po.OrderPO;
import tools.ActionType;
import tools.ResultMessage;
import vo.CreditlogVO;

public class CreditData_Stub implements CreditDataService {


	public ResultMessage add(CreditLogPO creditlog) {
		if(creditlog!=null)  return ResultMessage.Exist;
				return ResultMessage.NotExist;
	}

	
	public List<CreditLogPO> getLogList(String customer_id) {
		// TODO Auto-generated method stub
		List<CreditLogPO> creditLogPOList = new ArrayList<CreditLogPO>();
//		CreditLogPO creditLogPO1 = new CreditLogPO(ActionType.Charge, null, 100);
//		OrderPO orderPO = new OrderPO("2134");
//		CreditLogPO creditLogPO2 = new CreditLogPO(ActionType.RightOrder, orderPO, 20);
		
//		creditLogPOList.add(creditLogPO1);
//		creditLogPOList.add(creditLogPO2);
				
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date1 = null;
		try {
			date1 = df.parse("2004-01-02 11:30:24");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CreditLogPO creditlog = new CreditLogPO("008",ActionType.Charge,null,date1,10,1000);
		creditLogPOList.add(creditlog);
		return creditLogPOList;
	}


	public ResultMessage changeCredit(String customer_id, int resultCredit) {
		// TODO Auto-generated method stub
		return null;
	}


//	@Override
//	public ResultMessage setLevel(int level, String customer_id) {
		// TODO Auto-generated method stub
//		return null;
//	}


	
	

}
