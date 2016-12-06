package testHibernate;

import java.util.ArrayList;
import java.util.List;

import dataservice.datahelper.OrderDataHelper;
import dataservice.datahelper.impl.OrderDateHelperImpl;

public class testOrder {
		public static void main(String[] args) {
			OrderDataHelper orderDataHelper = new OrderDateHelperImpl();
			List<String> list = new ArrayList<String>();
			list.add("303");
			list.add("302");
			
			orderDataHelper.addOrderRoomPO("HT001", list);
			
		}
}
