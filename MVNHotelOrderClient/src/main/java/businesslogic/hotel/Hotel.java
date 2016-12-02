package businesslogic.hotel;

import java.net.URI;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Exception.CustomerCreditNotEnoughException;
import businesslogic.account.HotelAccountController;
import dataservice.HotelDataService;
import po.HotelPO;
import rmi.RemoteHelper;
import stub.HotelDeal_Stub;
import tools.ResultMessage_Account;
import tools.ResultMessage_Hotel;
import tools.SortType;
import tools.StandardSearch;
import vo.CommentVO;
import vo.DiscountVO_hotel;
import vo.HotelDiscribtionsVO;
import vo.HotelInputVO;
import vo.HotelbriefVO;
import vo.SearchHotelVO;

public class Hotel {
	private HotelDataService hotelDataService;
	private PictureDeal pictureDeal;
	public Hotel(){
		hotelDataService = RemoteHelper.getInstance().getHotelDataService();
		pictureDeal = new PictureDeal();
	}
	
	/**
	 * 添加酒店
	 * @param hotelInputVO
	 * @return ResultMessage_Hotel成功
	 */
	public ResultMessage_Hotel addHotel(HotelInputVO hotelInputVO) {
		String username = hotelInputVO.username;
		String password = hotelInputVO.password;
		HotelAccountController hotelAccountController =  HotelAccountController.getInstance();
		ResultMessage_Account rs = hotelAccountController.addAccount(username, password);
		
		if(!rs.equals(ResultMessage_Account.Success)){
			//TODO  add more return detail
			return ResultMessage_Hotel.fail;
		}
		String hotelID = hotelAccountController.getAccountID(username);
		if("".equals(hotelID) || hotelID == null) return ResultMessage_Hotel.fail;
		
		HotelPO hotelPO = new HotelPO(hotelInputVO);
		hotelPO.setHotelID(hotelID);	
		ResultMessage_Hotel result;
		try {
			result = hotelDataService.addHotel(hotelPO);
		} catch (RemoteException e) {
			System.out.println(e.getMessage());
			return ResultMessage_Hotel.fail;
		}
		return result;
	} 
	

	/**
	 *保存酒店信息
	 * @param hotelInfo
	 * @return 成功
	 */
	public ResultMessage_Hotel saveHotelInfo(HotelInputVO hotelInputVO) {
		if(hotelInputVO.hotelID==null || "".equals(hotelInputVO.hotelID));
		ResultMessage_Hotel rs = ResultMessage_Hotel.success;
		if(hotelInputVO.hotePictureURI!=null){
			ResultMessage_Hotel r= pictureDeal.uploadFrontPicture(hotelInputVO.hotelID, hotelInputVO.hotePictureURI);
			if(r == ResultMessage_Hotel.fail)
				rs = ResultMessage_Hotel.fail;
		}
		if(hotelInputVO.hotelInfoVO!=null){
			ResultMessage_Hotel r=modifyHotelDiscribtions(hotelInputVO.hotelID, hotelInputVO.hotelInfoVO);
			if(r == ResultMessage_Hotel.fail)
				rs = ResultMessage_Hotel.fail;
		}	
		HotelPO hotelPO = new HotelPO(hotelInputVO);
		try {
			ResultMessage_Hotel r = hotelDataService.modifyHotel(hotelPO);
			if(r == ResultMessage_Hotel.fail)
				rs = ResultMessage_Hotel.fail;
		} catch (RemoteException e) {
			System.out.println(e.getMessage());
			return ResultMessage_Hotel.fail;
		}
		return rs;
	}

	/**
	 * 搜索酒店
	 * @param searchhotel
	 * @return 酒店信息列表
	 */
	public List<HotelbriefVO> SearchHotel(SearchHotelVO searchhotel) {
		if(searchhotel.city==null)  return null;
		List<HotelPO> hotelPOs  = null;
		try {
			hotelPOs = hotelDataService.searchHotelList(new StandardSearch(searchhotel));
		} catch (RemoteException e) {
			System.out.println(e.getMessage());
			return null;
		}	
		
		if(hotelPOs==null || hotelPOs.isEmpty())  return null;
		List<HotelbriefVO> hotelbriefVOs = new ArrayList<HotelbriefVO>();
		Iterator<HotelPO> it = hotelPOs.iterator();
		while(it.hasNext()){
			HotelPO hotelPO  =  it.next();
			HotelbriefVO hotelbriefVO = new HotelbriefVO(hotelPO);
			hotelbriefVO.imageuri = pictureDeal.downloadFrontPicture(hotelPO.getHotelID());
			hotelbriefVOs.add(hotelbriefVO);
		}
		
		return hotelbriefVOs;
		
	}

	/**
	 * 排序
	 * @param hotelInfo
	 * @param sortType
	 * @return 排序列表
	 */
	public List<HotelbriefVO> SortHotel(List<HotelbriefVO> hotelInfo, SortType sortType) {
		// TODO Auto-generated method stub
		HotelDeal_Stub test=new HotelDeal_Stub();
		return test.SortHotel(hotelInfo, sortType);
	}
	/**
	 * 获取酒店信息
	 * @param hotel_id
	 * @return 
	 */
	public HotelbriefVO getHotelInfo(String hotel_id) {
		// TODO Auto-generated method stub
		HotelDeal_Stub test=new HotelDeal_Stub();
		
		return test.getHotelInfo(hotel_id);
	}
	/**
	 * 
	 * @param hotel_id
	 * @return 酒店优惠列表
	 */
	public List<DiscountVO_hotel> getHotelDiscount(String hotel_id) {
		// TODO Auto-generated method stub
		MockHotelDiscount test=new MockHotelDiscount();
		return test.getHotelDiscount(hotel_id);
	}
	/**
	 * 
	 * @param hotel_id
	 * @return 酒店评价
	 */
	public List<CommentVO> getComment(String hotel_id) {
		// TODO Auto-generated method stub
		MockOrder test = null;
		try {
			test = new MockOrder(null, null, null, null);
		} catch (CustomerCreditNotEnoughException e) {
			System.out.println("客户信用值不足");
		}
		return test.getComment();
	}
	
	public  ResultMessage_Hotel modifyHotelDiscribtions (String hotelID , HotelDiscribtionsVO hotelDiscribtionsVO){
		ResultMessage_Hotel re = ResultMessage_Hotel.success;
		List<URI> pictureURI  = hotelDiscribtionsVO.pictureURI;
		if(pictureURI!=null){
			ResultMessage_Hotel r = pictureDeal.uploadHotelInfoPic(hotelID, pictureURI);
			if(r==ResultMessage_Hotel.fail) 
				re = ResultMessage_Hotel.fail;		
		}
		List<String> discribes  = hotelDiscribtionsVO.discribes;
		try {
			ResultMessage_Hotel r =  hotelDataService.modifyHotelInfoString(hotelID, discribes);
			if(r==ResultMessage_Hotel.fail) 
				re = ResultMessage_Hotel.fail;	
		} catch (RemoteException e) {
			System.out.println(e.getMessage());
			re = ResultMessage_Hotel.fail;
		}
		
		return re;		
	}
	
	  public HotelDiscribtionsVO  getHotelDiscribtionsVO(String hotelID){
		  HotelDiscribtionsVO hotelDiscribtionsVO = new HotelDiscribtionsVO();
		  hotelDiscribtionsVO.pictureURI= pictureDeal.downloadHotelInfoPic(hotelID);
		  try {
			hotelDiscribtionsVO.discribes = hotelDataService.getHotelInfoString(hotelID);
		} catch (RemoteException e) {
			System.out.println(e.getMessage());
			hotelDiscribtionsVO.discribes = null;
		}
		  return hotelDiscribtionsVO;
		  
	  }
	  /**
	   * 
	   * @return
	   */
	 public List<String> getAllCity() {
		List<String> list = new ArrayList<String>();
		list.add("北京");
		list.add("南京");
		list.add("上海");
		return list;
	 }
	 
	 /**
	  * 
	  * @param city
	  * @return
	  */
	 public List<String> getAllDistrictByCity(String city){ 
		try {
			return hotelDataService.getAllDistrictByCity(city);
		} catch (RemoteException e) {
			System.out.println(e.getMessage());
			return null;
		}
	 }
	 
	 /**
	  * 
	  * @param district
	  * @return
	  */
	 public List<String> getBusineeCircleByDistrict(String district) {
		try {
			return hotelDataService.getBusineeCircleByDistrict(district);
		} catch (RemoteException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	
}
