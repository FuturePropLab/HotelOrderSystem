package dataservice.datahelper.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import DataFactory.Hibernateutils;
import dataservice.datahelper.MessageDateHelper;
import po.MessagePO;
import tools.ResultMessage;

public class MessageDataHelperImpl implements MessageDateHelper {

	
	private static MessageDataHelperImpl messageDataHelperImpl  =null;
	
	
	private MessageDataHelperImpl(){
		
	}
	
	public static MessageDataHelperImpl getInstance(){
		if(messageDataHelperImpl == null)
			messageDataHelperImpl = new MessageDataHelperImpl();
		return messageDataHelperImpl;
	}
	
	public MessagePO getMessage(String custoemerID) {
		Session s = Hibernateutils.getSessionFactory().openSession();
		Criteria cr = s.createCriteria(MessagePO.class);
		cr.add(Restrictions.eq("customerID", custoemerID));
		List<MessagePO> messages = cr.list();
		s.close();
		if(messages.isEmpty())  return null;
		s = Hibernateutils.getSessionFactory().openSession();
		try {			
			Transaction t = s.beginTransaction();
			s.delete(messages.get(0));
			t.commit();
		} catch (Exception e) {
			return null;
		}finally{
			s.close();	
		}
			
		return messages.get(0);
	}

	public ResultMessage writeMessage(String customerID, String message, String orderID) {
		MessagePO messagePO = new MessagePO(customerID, message, orderID);
		Session s = Hibernateutils.getSessionFactory().openSession();
		//try {			
			Transaction t = s.beginTransaction();
			s.saveOrUpdate(messagePO);
			t.commit();
			return ResultMessage.Exist;
		//} catch (Exception e) {
		//	return ResultMessage.NotExist;
		//}finally{
		//	s.close();	
		//}
	}

}
