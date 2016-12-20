package testHibernate;

import DataFactory.DataHelperUtils;
import dataservice.datahelper.MessageDateHelper;

public class testMessage {
	 public static void main(String[] args) {
		MessageDateHelper messageDateHelper = DataHelperUtils.getMessageDateHelper();
//		System.out.println(messageDateHelper.writeMessage("HT001", "good your change is not ok ", null));
//		System.out.println(messageDateHelper.getMessage("HT001").getMessage());
	}
}
