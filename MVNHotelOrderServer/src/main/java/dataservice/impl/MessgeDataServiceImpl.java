package dataservice.impl;

import java.rmi.RemoteException;

import DataFactory.DataHelperUtils;
import dataservice.MessgeDataService;
import dataservice.datahelper.MessageDateHelper;
import po.MessagePO;
import tools.ResultMessage;

public class MessgeDataServiceImpl implements MessgeDataService {
	
	private MessageDateHelper messageDateHelper;
	
	public MessgeDataServiceImpl(){
		this.messageDateHelper  = DataHelperUtils.getMessageDateHelper();
	}
	
	public MessagePO getMessage(String customerID) throws RemoteException {
		return messageDateHelper.getMessage(customerID);
	}

	public ResultMessage writeMessage(String custoemerID, String message, String orderID)throws RemoteException {
		return messageDateHelper.writeMessage(custoemerID, message, orderID);
	}

}
