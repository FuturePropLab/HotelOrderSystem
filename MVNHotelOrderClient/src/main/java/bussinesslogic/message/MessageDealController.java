package bussinesslogic.message;

import java.rmi.RemoteException;

import businesslogicservice.MessageDealService;
import dataservice.MessgeDataService;
import po.MessagePO;
import rmi.RemoteHelper;
import vo.MessageVO;


/**
 * 
 * @author wshwbluebird
 *
 */
public class MessageDealController implements MessageDealService{
	
	private static MessageDealController messageDealController = null;
	
	private MessgeDataService messgeDataService ;
	
	private MessageDealController(){
		this.messgeDataService = RemoteHelper.getInstance().getMessgeDataService();
	}
	
	public static MessageDealController getInstance(){
		if(messageDealController == null)
			messageDealController = new MessageDealController();
		return messageDealController;
	}
	
	@Override
	public MessageVO getMessage(String custoemerID) {
		try {
			MessagePO messagePO =  messgeDataService.getMessage(custoemerID);
			return new MessageVO(messagePO);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

}
