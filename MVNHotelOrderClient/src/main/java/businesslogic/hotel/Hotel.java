package businesslogic.hotel;

import java.net.URI;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import Exception.OutOfBoundsException;
import businesslogic.account.HotelAccountController;
import businesslogic.discount.getDiscountInfoImp;
import businesslogic.order.HotelCommentImpl;
import dataservice.HotelDataService;
import po.HotelPO;
import po.OrderAssessPO;
import rmi.RemoteHelper;
import tools.HotelFacility;
import tools.Mark;
import tools.ResultMessage_Account;
import tools.ResultMessage_Hotel;
import tools.SortType;
import tools.StandardSearch;
import vo.AssessVO;
import vo.CommentVO;
import vo.DiscountVO_hotel;
import vo.HotelAssessVO;
import vo.HotelDetailsVO;
import vo.HotelDiscribtionsVO;
import vo.HotelFacilityVO;
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
	 * chenyuyan 测试用构造
	 */
	public Hotel(HotelDataService hotelDataService){
		this.hotelDataService = hotelDataService;
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
			return ResultMessage_Hotel.fail;
		}
		String hotelID = hotelAccountController.getAccountID(username);
		if("".equals(hotelID) || hotelID == null) return ResultMessage_Hotel.fail;
		
		//一般应该是空的
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
		
		//更新酒店的图片
		if(hotelInputVO.hotePictureURI!=null){
			ResultMessage_Hotel r= pictureDeal.uploadFrontPicture(hotelInputVO.hotelID, hotelInputVO.hotePictureURI);
			if(r == ResultMessage_Hotel.fail)
				rs = ResultMessage_Hotel.fail;
		}
		//更新酒店详情界面
		if(hotelInputVO.hotelInfoVO!=null){
			ResultMessage_Hotel r=modifyHotelDiscribtions(hotelInputVO.hotelID, hotelInputVO.hotelInfoVO);
			if(r == ResultMessage_Hotel.fail)
				rs = ResultMessage_Hotel.fail;
		}	
		
		//更新酒店的设施图片
		if(hotelInputVO.hotelFacilityVO!=null  && hotelInputVO.hotelFacilityVO.facilityImage!=null){
			URI uri = hotelInputVO.hotelFacilityVO.facilityImage;
			ResultMessage_Hotel r = pictureDeal.uploadFacilttyPicture(hotelInputVO.hotelID, uri);
			if(r == ResultMessage_Hotel.fail)
				rs = ResultMessage_Hotel.fail;
		}
		//更新酒店的其他信息
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
		double mark=gethotelAssessVO(hotelPO.getHotelID()).averageMark;//test!!!
			try {
				hotelbriefVO.mark = new Mark(mark);
			} catch (OutOfBoundsException e) {
				try {
					hotelbriefVO.mark = new Mark(0);
				} catch (OutOfBoundsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
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
		if(hotelInfo == null)  return null;
		Comparator comparator;
		if(sortType.equals(SortType.Price))
				comparator  =new ComparatorHotelbyPrice();
		else if(sortType.equals(SortType.grade))
				comparator  =new ComparatorHotelbymark();
		else 
				comparator = new ComparatorHotelbyStar();
	   Collections.sort(hotelInfo, comparator);
		return hotelInfo;
	}
	
	
	
	
	/**
	 * 获取酒店信息
	 * @param hotel_id
	 * @return 
	 */
	public HotelbriefVO getHotelInfo(String hotel_id) {
		HotelPO hotelPO = null;
		try {
			hotelPO = hotelDataService.getHotel(hotel_id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HotelbriefVO hotelbriefVO = new HotelbriefVO(hotelPO);	
		hotelbriefVO.imageuri = pictureDeal.downloadFrontPicture(hotel_id);
		return hotelbriefVO;
	}
	/**
	 * 
	 * @param hotel_id
	 * @return 酒店优惠列表
	 */
	public List<DiscountVO_hotel> getHotelDiscount(String hotel_id) {
		// TODO Auto-generated method stub
//		MockHotelDiscount hotelDisController=new MockHotelDiscount();//test!!!
		getDiscountInfo hotelDisController =new getDiscountInfoImp();
		return hotelDisController.getHotelDiscount(hotel_id);
	}
	/**
	 * 
	 * @param hotel_id
	 * @return 酒店评价
	 */
	public List<CommentVO> getComment(String hotel_id) {
		// TODO Auto-generated method stub
		
		getComment getComment = new HotelCommentImpl();
		return getComment.getComment(hotel_id);
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
		  hotelDiscribtionsVO.pictureURI= pictureDeal.downloadHotelInfoPic(hotelID);//test!!!!
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
	 
	 public List<HotelbriefVO> searchHotelListFuzzy(String input){
		 List<HotelPO> hotelPOs  = null;
		 if(input != null &&!"".equals(input))
			try {
				hotelPOs = hotelDataService.searchHotelListFuzzy(input);
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
				double mark=gethotelAssessVO(hotelPO.getHotelID()).averageMark;
				System.out.println("mark:  "+mark);
				try {
					hotelbriefVO.mark = new Mark(mark);
				} catch (OutOfBoundsException e) {
					try {
						hotelbriefVO.mark = new Mark(0);
					} catch (OutOfBoundsException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				hotelbriefVO.imageuri = pictureDeal.downloadFrontPicture(hotelPO.getHotelID());
				hotelbriefVOs.add(hotelbriefVO);
			}			
			return hotelbriefVOs;
		 
	 }
	 
	 class ComparatorHotelbyPrice implements Comparator{
		 public int compare(Object arg0, Object arg1) {
		  HotelbriefVO hotel0=(HotelbriefVO)arg0;
		  HotelbriefVO hotel1=(HotelbriefVO)arg1;

		  if(hotel0.averagePrice<hotel1.averagePrice)
			  return -1;
		  if(hotel0.averagePrice>hotel1.averagePrice)
			  return 1;
		  else{
			  if(hotel0.priceRange.lowest<hotel1.priceRange.lowest)
				  return -1;
			  if(hotel0.priceRange.lowest>hotel1.priceRange.lowest)
				  return 1;
			  else
				  return 0;
		  }
		}
		 
	}
	 
	 class ComparatorHotelbymark implements Comparator{
		 public int compare(Object arg0, Object arg1) {
		  HotelbriefVO hotel0=(HotelbriefVO)arg0;
		  HotelbriefVO hotel1=(HotelbriefVO)arg1;

		  if(hotel0.mark.getValue()<hotel1.mark.getValue())
			  return 1;
		  if(hotel0.mark.getValue()>hotel1.mark.getValue())
			  return -1;
		  else return 0;			 
		 }
	 }
	 
	 class ComparatorHotelbyStar implements Comparator{
		 public int compare(Object arg0, Object arg1) {
		  HotelbriefVO hotel0=(HotelbriefVO)arg0;
		  HotelbriefVO hotel1=(HotelbriefVO)arg1;

		  return -hotel0.star.compareTo(hotel1.star);			 
		 }
	 }
	 
	 /**
	  * 
	  * @param hotelID
	  * @return
	  */
	 public HotelDetailsVO getHotelDetailsVO(String hotelID) {
		 HotelDetailsVO hotelDetailsVO = null	;
		 System.out.println("HotelDetailsVO:   "+hotelID);
		 try {
			 HotelPO hotelPO = hotelDataService.getHotel(hotelID);
			 System.out.println("HotelDetailsVO getHotelDetailsVO:  isnull?:   "+hotelPO == null);
			 hotelDetailsVO =  new HotelDetailsVO(hotelPO);
			 hotelDetailsVO.hotelImage = pictureDeal.downloadFrontPicture(hotelID);
			 hotelDetailsVO.hotelDiscribtionsVO = getHotelDiscribtionsVO(hotelID);			 
			 } catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return hotelDetailsVO;
		}
	 
	 

		public HotelFacilityVO gethotelFacilityVO(String hotelID) {
			try {
				System.out.println("dddd: "+hotelID);
				HotelPO hotelPO  = hotelDataService.getHotel(hotelID);
				HotelFacilityVO hotelFacilityVO = new HotelFacilityVO(hotelPO.getFacility());
				hotelFacilityVO.hotelID = hotelID;
				hotelFacilityVO.hotelName = hotelPO.getHotelName();
				System.out.println(hotelFacilityVO.hotelName);
				hotelFacilityVO.facilityImage = pictureDeal.downloadFacilttyPicture(hotelID);
				return hotelFacilityVO;
			} catch (RemoteException e) {
				return null;
			}
			
		
		}
		
		
		
		public ResultMessage_Hotel modifyHotelPicture(String hotelID, URI uri) {
			return pictureDeal.uploadFrontPicture(hotelID, uri);
		}
		
		/**
		 * woe
		 * @param hotelID
		 * @return
		 */
		public HotelAssessVO gethotelAssessVO(String hotelID) {
			List<OrderAssessPO> orderAssessPOs  = new ArrayList<>();
			try {
				orderAssessPOs= hotelDataService.gethotelAssessVO(hotelID);
				System.out.println("orderAssessPOs+    ::"+orderAssessPOs.size());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Iterator<OrderAssessPO> it = orderAssessPOs.iterator();
			List<AssessVO> assessVOs = new ArrayList<AssessVO>();
			double fullmark  = 0;
			int count = 0;
			while(it.hasNext()){
				OrderAssessPO hAssessPO = it.next();
				Mark mark = null;
				try {
					mark = new Mark(hAssessPO.getMarkValue());
					System.out.println("mark Value:   "+hAssessPO.getMarkValue());
				} catch (OutOfBoundsException e) {
					try {
						mark = new Mark(5);
					} catch (OutOfBoundsException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				AssessVO assessVO = new AssessVO(hAssessPO.getOrderID(),mark, hAssessPO.getAssessment());
				assessVOs.add(assessVO);
				fullmark+=hAssessPO.getMarkValue();
				count++;		
			}
			double avmark = 4;
			if(count!=0){
				avmark = fullmark/count;
			}
			HotelAssessVO hotelAssessVO = new HotelAssessVO(avmark,assessVOs);
			
			return hotelAssessVO;
		}
		
		/**
		 * 
		 * @param hotelID
		 * @param hotelFacilityVO
		 * @return
		 */
		ResultMessage_Hotel saveFacility(String hotelID ,HotelFacilityVO hotelFacilityVO){
			ResultMessage_Hotel rs = ResultMessage_Hotel.success;
			HotelFacility hotelFacility = new HotelFacility(hotelFacilityVO);
			try {
				rs = hotelDataService.saveFacility(hotelID, hotelFacility);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				rs = ResultMessage_Hotel.fail;
			}
			if(hotelFacilityVO.facilityImage!=null){
				ResultMessage_Hotel r= pictureDeal.uploadFacilttyPicture(hotelFacilityVO.hotelID, hotelFacilityVO.facilityImage);			
				if(r==ResultMessage_Hotel.fail)rs = ResultMessage_Hotel.fail;
			}
			
			return rs;
		}
		
		/**
		 * 
		 * @param customerID
		 * @param hotelID
		 * @return
		 */
		public boolean isbooked(String customerID, String hotelID) {
			try {
				return hotelDataService.isbooked(customerID, hotelID);
			} catch (RemoteException e) {
				return false;
			}
		}
		/**
		 * 酒店注册时 修改酒店的名字
		 * @param hotelID
		 * @param hotelName
		 * @return
		 */
		public ResultMessage_Hotel modifyHotelName(String hotelID, String hotelName) {
			try {
				return hotelDataService.modifyHotelName(hotelID, hotelName);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();;
				return ResultMessage_Hotel.fail;
			}
		}
	
}
