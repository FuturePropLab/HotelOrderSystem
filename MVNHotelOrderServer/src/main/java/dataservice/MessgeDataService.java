package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.MessagePO;
import tools.ResultMessage;

public interface MessgeDataService  extends Remote{
	/**
	 * 获取并且删除消息
	 * @param custoemerID
	 * @return
	 * @throws RemoteException 
	 */
	public MessagePO getMessage(String custoemerID) throws RemoteException;
		
	
	/**
	 * 写入或者更新一条消息
	 * @param custoemerID
	 * @param message
	 * @param orderID
	 * @return
	 */
	public ResultMessage writeMessage(String custoemerID,String message , String orderID) throws RemoteException;
}