package businesslogic.order;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import dataservice.OrderDataService;
import rmi.RemoteHelper;
import vo.CommentVO;

public class HotelCommentImpl implements businesslogic.hotel.getComment{

	@Override
	public List<CommentVO> getComment(String hotelID) {
		OrderDataService orderDataService = RemoteHelper.getInstance().getOrderDataService();
		try {
			List<String>  liststr = orderDataService.getAllComment(hotelID);
			List<CommentVO> commentLsit = new ArrayList<>();
			for (int i = 0; i < liststr.size(); i++) {
				  CommentVO commentVO = new CommentVO(liststr.get(i));
				  commentLsit.add(commentVO);
			}
			return commentLsit;
		} catch (RemoteException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
		
	}

}
