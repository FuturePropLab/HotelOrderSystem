package dataservice.datahelper.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import DataFactory.Hibernateutils;
import dataservice.datahelper.HotelDataHelper;
import po.HotelAddressPO;
import po.HotelBasePO;
import po.HotelFacilityPO;
import po.OrderAssessPO;
import po.OrderSearchStorePO;
import po.RoomPK;
import po.TypeRoomInfoPO;
import tools.HotelAddress;
import tools.HotelFacility;
import tools.HotelRoomInfo;
import tools.ResultMessage_Hotel;
import tools.RoomType;
import tools.Star;
import tools.TypeRoomInfo;

public class HotelDataHelperImpl implements HotelDataHelper {
	
	private static HotelDataHelperImpl hotelDataHelperImpl = null;
	
	private HotelDataHelperImpl(){
		
	}
	
	public static HotelDataHelperImpl getInstance(){
		if(hotelDataHelperImpl == null)
			hotelDataHelperImpl = new  HotelDataHelperImpl();
		return hotelDataHelperImpl;
	}
	/*@
	 * (non-Javadoc)
	 * @see dataservice.datahelper.HotelDataHelper#getHotelID(java.lang.String)
	 */
	public String getHotelID(String hotelName) {
		Session s = Hibernateutils.getSessionFactory().openSession();
		//check if the userid or username already exits
		try {	
			Query q = s.createSQLQuery("select hotelID from hotelbasepo where hotelname = '" + hotelName + "' limit 1");
			if (q.list().isEmpty()) {
				return "NOT_EXITS";
			}
			String hotelID = (String) q.list().get(0);
			return hotelID;
		}catch(Exception e){
			System.out.println(e.getMessage());
			return "FAIL";
		}finally {
			s.close();
		}

	}
	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.datahelper.HotelDataHelper#getHotelBasePO(java.lang.String)
	 */
	public HotelBasePO getHotelBasePO(String hotelID) {
		Session s = Hibernateutils.getSessionFactory().openSession();
		Criteria cr = s.createCriteria(HotelBasePO.class);
		cr.add(Restrictions.eq("hotelID", hotelID));
		List<HotelBasePO> HotelBasePOs = cr.list();
		
		//TODO  maybe wrong
		s.close();
		if(HotelBasePOs.isEmpty()) return null;
		HotelBasePO hotelBasePO = HotelBasePOs.get(0);	
		return hotelBasePO;
	}

	/*@
	 * (non-Javadoc)
	 * @see dataservice.datahelper.HotelDataHelper#getHotelAddressPO(java.lang.String)
	 */
	public HotelAddressPO getHotelAddressPO(String hotelID) {
		Session s = Hibernateutils.getSessionFactory().openSession();
		Criteria cr = s.createCriteria(HotelAddressPO.class);
		cr.add(Restrictions.eq("hotelID", hotelID));
		List<HotelAddressPO> hotelAddressPOs = cr.list();
		//maybe wrong  TODO
		s.close();
		if(hotelAddressPOs.isEmpty()) return null;
		HotelAddressPO hotelAddressPO = hotelAddressPOs.get(0);
		return hotelAddressPO;
	}
	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.datahelper.HotelDataHelper#getTypeRoomInfoList(java.lang.String)
	 */
	public List<TypeRoomInfo> getTypeRoomInfoList(String hotelName) {
		Session s = Hibernateutils.getSessionFactory().openSession();
		Criteria cr = s.createCriteria(TypeRoomInfoPO.class);
		cr.add(Restrictions.eq("hotelName", hotelName));
		List<TypeRoomInfoPO> typeRoomInfoPOs = cr.list();
		System.out.println(hotelName+"  "+typeRoomInfoPOs.size());
		s.close();
		if(typeRoomInfoPOs.isEmpty()) return null;
		List<TypeRoomInfo> typeRoomInfos = new ArrayList<TypeRoomInfo>();
		Iterator<TypeRoomInfoPO> it = typeRoomInfoPOs.iterator();
		while(it.hasNext()){
			TypeRoomInfo typeRoomInfo = new TypeRoomInfo(it.next());
			typeRoomInfos.add(typeRoomInfo);
		}		
		return typeRoomInfos;
	}
	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.datahelper.HotelDataHelper#getHotelFacilityPO(java.lang.String)
	 */
	public HotelFacilityPO getHotelFacilityPO(String hotelID) {
		Session s = Hibernateutils.getSessionFactory().openSession();
		Criteria cr = s.createCriteria(HotelFacilityPO.class);
		cr.add(Restrictions.eq("hotelID", hotelID));
		List<HotelFacilityPO> hotelFacilityPOs = cr.list();
		
		s.close();
		if(hotelFacilityPOs.isEmpty()) return null;
		HotelFacilityPO hotelFacilityPO = hotelFacilityPOs.get(0);
		return hotelFacilityPO;
	}
	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.datahelper.HotelDataHelper#addHotelAddressPO(po.HotelAddressPO)
	 */
	public ResultMessage_Hotel addHotelAddressPO(HotelAddressPO hotelAddressPO) {
		Session s = Hibernateutils.getSessionFactory().openSession();
		try{
			Transaction t = s.beginTransaction();
			s.save(hotelAddressPO);
			t.commit();
			return ResultMessage_Hotel.success;
		}catch(Exception e){
			System.out.println(e.getMessage());
			return ResultMessage_Hotel.fail;
		}finally {
			s.close();
		}
	}
	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.datahelper.HotelDataHelper#modifyHotelAddressPO(po.HotelAddressPO)
	 */
	public ResultMessage_Hotel modifyHotelAddressPO(HotelAddressPO hotelAddressPO) {
		Session s = Hibernateutils.getSessionFactory().openSession();
		try{
			Transaction t = s.beginTransaction();
			s.update(hotelAddressPO);
			t.commit();
			return ResultMessage_Hotel.success;
		}catch(Exception e){
			System.out.println(e.getMessage());
			return ResultMessage_Hotel.fail;
		}finally {
			s.close();
		}
	}
	/*@
	 * (non-Javadoc)
	 * @see dataservice.datahelper.HotelDataHelper#addHotelBasePO(po.HotelBasePO)
	 */
	public ResultMessage_Hotel addHotelBasePO(HotelBasePO hotelBasePO) {
		Session s = Hibernateutils.getSessionFactory().openSession();
		try{
			Transaction t = s.beginTransaction();
			s.save(hotelBasePO);
			t.commit();
			return ResultMessage_Hotel.success;
		}catch(Exception e){
			System.out.println(e.getMessage());
			return ResultMessage_Hotel.fail;
		}finally {
			s.close();
		}
			
		
	}
	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.datahelper.HotelDataHelper#modifyHotelBasePO(po.HotelBasePO)
	 */
	public ResultMessage_Hotel modifyHotelBasePO(HotelBasePO hotelBasePO) {		
		Session s = Hibernateutils.getSessionFactory().openSession();
		try{
			Transaction t = s.beginTransaction();
			s.update(hotelBasePO);
			t.commit();
			s.close();
			s = Hibernateutils.getSessionFactory().openSession();
			t =  s.beginTransaction();
			RoomPK roomPK =new RoomPK(hotelBasePO.getHotelID(), RoomType.Double);
			TypeRoomInfoPO typeRoomInfoPO= (TypeRoomInfoPO) s.load(TypeRoomInfoPO.class, roomPK);
			typeRoomInfoPO.setHotelName(hotelBasePO.getHotelName());
			s.update(typeRoomInfoPO);
			
			roomPK =new RoomPK(hotelBasePO.getHotelID(), RoomType.EluxeSuite);
			typeRoomInfoPO= (TypeRoomInfoPO) s.load(TypeRoomInfoPO.class, roomPK);
			typeRoomInfoPO.setHotelName(hotelBasePO.getHotelName());
			s.update(typeRoomInfoPO);
			
			roomPK =new RoomPK(hotelBasePO.getHotelID(), RoomType.Single);
			typeRoomInfoPO= (TypeRoomInfoPO) s.load(TypeRoomInfoPO.class, roomPK);
			typeRoomInfoPO.setHotelName(hotelBasePO.getHotelName());
			s.update(typeRoomInfoPO);
			
			roomPK =new RoomPK(hotelBasePO.getHotelID(), RoomType.Standard);
			typeRoomInfoPO= (TypeRoomInfoPO) s.load(TypeRoomInfoPO.class, roomPK);
			typeRoomInfoPO.setHotelName(hotelBasePO.getHotelName());
			s.update(typeRoomInfoPO);
			
			roomPK =new RoomPK(hotelBasePO.getHotelID(), RoomType.Suites);
			typeRoomInfoPO= (TypeRoomInfoPO) s.load(TypeRoomInfoPO.class, roomPK);
			typeRoomInfoPO.setHotelName(hotelBasePO.getHotelName());
			s.update(typeRoomInfoPO);
			t.commit();
			return ResultMessage_Hotel.success;
		}catch(Exception e){
			System.out.println(e.getMessage());
			return ResultMessage_Hotel.fail;
		}finally {
			s.close();
		}
	}
	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.datahelper.HotelDataHelper#addHotelFacilityPO(po.HotelFacilityPO)
	 */
	public ResultMessage_Hotel addHotelFacilityPO(HotelFacilityPO hotelFacilityPO) {
		Session s = Hibernateutils.getSessionFactory().openSession();
		try{
			Transaction t = s.beginTransaction();
			s.save(hotelFacilityPO);
			t.commit();
			return ResultMessage_Hotel.success;
		}catch(Exception e){
			System.out.println(e.getMessage());
			return ResultMessage_Hotel.fail;
		}finally {
			s.close();
		}
	}
	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.datahelper.HotelDataHelper#modifyHotelFacilityPO(po.HotelFacilityPO)
	 */
	public ResultMessage_Hotel modifyHotelFacilityPO(HotelFacilityPO hotelFacilityPO) {
		Session s = Hibernateutils.getSessionFactory().openSession();
		try{
			Transaction t = s.beginTransaction();
			s.update(hotelFacilityPO);
			t.commit();
			return ResultMessage_Hotel.success;
		}catch(Exception e){
			System.out.println(e.getMessage());
			return ResultMessage_Hotel.fail;
		}finally {
			s.close();
		}
	}
	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.datahelper.HotelDataHelper#addTypeRoomInfo(po.TypeRoomInfo)
	 */
	public ResultMessage_Hotel addTypeRoomInfo(TypeRoomInfo typeRoomInfo) {
		Session s = Hibernateutils.getSessionFactory().openSession();
		TypeRoomInfoPO typeRoomInfoPO = new TypeRoomInfoPO(typeRoomInfo);
		try{
			Transaction t = s.beginTransaction();
			s.save(typeRoomInfoPO);
			t.commit();
			return ResultMessage_Hotel.success;
		}catch(Exception e){
			System.out.println(e.getMessage());
			return ResultMessage_Hotel.fail;
		}finally {
			s.close();
		}
	}
	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.datahelper.HotelDataHelper#modifyTypeRoomInfo(po.TypeRoomInfo)
	 */
	public ResultMessage_Hotel modifyTypeRoomInfo(TypeRoomInfo typeRoomInfo) {
		Session s = Hibernateutils.getSessionFactory().openSession();
		TypeRoomInfoPO typeRoomInfoPO = new TypeRoomInfoPO(typeRoomInfo);
		try{
			Transaction t = s.beginTransaction();
			s.update(typeRoomInfoPO);
			t.commit();
			return ResultMessage_Hotel.success;
		}catch(Exception e){
			System.out.println(e.getMessage());
			return ResultMessage_Hotel.fail;
		}finally {
			s.close();
		}
	}
	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.datahelper.HotelDataHelper#modifyHotelRoomInfo(tools.HotelRoomInfo)
	 */
	public ResultMessage_Hotel modifyHotelRoomInfo(HotelRoomInfo hotelRoomInfo) {
		List<TypeRoomInfo> typeRoomInfos = hotelRoomInfo.getTypeRoomInfo();
		if(typeRoomInfos == null) return ResultMessage_Hotel.success;
		String hotelName = getHotelName(hotelRoomInfo.getHotelID());
		
		if(hotelName==null || "".equals(hotelName))  return ResultMessage_Hotel.fail;
		Iterator<TypeRoomInfo> it = typeRoomInfos.iterator();
		while(it.hasNext()){
			TypeRoomInfo typeRoomInfo = it.next();
			if(hotelRoomInfo.getHotelID().equals(typeRoomInfo.getHotelID())){
				typeRoomInfo.setHotelName(hotelName);
				ResultMessage_Hotel rs = addTypeRoomInfo(typeRoomInfo);
				if(rs.equals(ResultMessage_Hotel.fail)){
					rs = modifyTypeRoomInfo(typeRoomInfo);
				}
				if(rs.equals(ResultMessage_Hotel.fail))
					return rs;
			}
		}		
		return ResultMessage_Hotel.success;
	}
	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.datahelper.HotelDataHelper#getHotelRoomInfo(java.lang.String)
	 */
	public HotelRoomInfo getHotelRoomInfo(String hotelID) {
		String hotelName = getHotelName(hotelID);
		if("FAIL".equals(hotelName) || "NOT_EXITS".equals(hotelName)) {
			System.out.println("HotelRoomInfo: "+hotelName);
			return null;
		}
		System.out.println("HotelRoomInfo: "+hotelName);
		List<TypeRoomInfo> typeRoomInfos = getTypeRoomInfoList(hotelName);
		HotelRoomInfo hotelRoomInfo = new HotelRoomInfo(hotelID, hotelName, typeRoomInfos);
	
		return hotelRoomInfo;
	}
	

	public String getHotelName(String hotelID){
		Session s = Hibernateutils.getSessionFactory().openSession();
		//check if the userid or username already exits
		try {	
			Query q = s.createSQLQuery("select hotelname from hotelbasepo where hotelID = '" + hotelID + "' limit 1");
			if (q.list().isEmpty()) {
				return "NOT_EXITS";
			}
			String hotelName = (String) q.list().get(0);
			return hotelName;
		}catch(Exception e){
			System.out.println(e.getMessage());
			return "FAIL";
		}finally {
			s.close();
		}

	}

	public List<String> getHotelIDListByAddress(HotelAddress hotelAddress) {
		String city = hotelAddress.getCity();
		System.out.println("bottom :   "+city);
		Session s = Hibernateutils.getSessionFactory().openSession();
		Criteria cr = s.createCriteria(HotelAddressPO.class);
		cr.add(Restrictions.eq("city", city));
		String district = hotelAddress.getDistrict();
		if(district!=null && !"".equals(district))
				cr.add(Restrictions.eq("district", district));
		String BusinessCircle = hotelAddress.getBusinessCircle();
		
		if(BusinessCircle!=null && !"".equals(BusinessCircle))
			cr.add(Restrictions.eq("businessCircle", BusinessCircle));
		
		List<HotelAddressPO> hotelAddresss = cr.list();
		System.out.println(hotelAddresss.size());
		List<String> hotelIDList = new ArrayList<String>();
		
		
		
		if(hotelAddress==null) {
			s.close();
			return hotelIDList;
		}
		
		Iterator<HotelAddressPO> it = hotelAddresss.iterator();
		while(it.hasNext()){
			hotelIDList.add(it.next().getHotelID());
		}
		s.close();
		return hotelIDList;
	}

	public boolean isvalidBase(String hotelID, Star star, String regex) {
		if(star == null && regex == null) return true;
		Session s = Hibernateutils.getSessionFactory().openSession();
		Criteria cr = s.createCriteria(HotelBasePO.class);
		cr.add(Restrictions.eq("hotelID", hotelID));
		HotelBasePO hotelBasePO = (HotelBasePO) cr.list().get(0);
		s.close();
		if(star!=null && star != hotelBasePO.getStar())  return false;
		if(!"".equals(regex) && regex!=null){
			Pattern pattern = Pattern.compile(regex);
	    	Matcher matcher = pattern.matcher(hotelBasePO.getHotelName());
	    	return matcher.matches();
		}			
		return true;
		
	}

	public boolean isvalidRoomType(String hotelID, RoomType roomType) {
		if(roomType==null)  return true;
		RoomPK roomPK = new RoomPK(hotelID, roomType);
		Session s = Hibernateutils.getSessionFactory().openSession();
		Criteria cr = s.createCriteria(TypeRoomInfoPO.class);
		cr.add(Restrictions.eq("roomPK", roomPK));
		cr.add(Restrictions.lt("availableCount", 0));
		List<TypeRoomInfoPO>  list = cr.list();	
		s.close();
		return list.size()!=0;

	}

	public boolean isvalidRoomType(String hotelID, RoomType roomType, double low, double high) {
		if(low==0 && high == 0)  return true;
		System.out.println("high: "+high);
		Session s = Hibernateutils.getSessionFactory().openSession();
		Criteria cr = s.createCriteria(TypeRoomInfoPO.class);
		RoomPK roomPK = new RoomPK(hotelID, roomType);
		cr.add(Restrictions.eq("roomPK", roomPK));
		cr.add(Restrictions.le("price", high));
		cr.add(Restrictions.ge("price",low));
		
		List<TypeRoomInfoPO>  list = cr.list();	
		s.close();
		return list.size()!=0;
	}

	public List<String> getIDListByFuzzy(String regex) {
		Session s = Hibernateutils.getSessionFactory().openSession();
		Criteria cr = s.createCriteria(HotelAddressPO.class);
		List<HotelAddressPO> hotelAddressPOs = cr.list();
		
		s.close();
		if(hotelAddressPOs == null)  return null;
		Iterator<HotelAddressPO>  it = hotelAddressPOs.iterator();
		
		List<String> idList = new ArrayList<String>();
		while(it.hasNext()){
			HotelAddressPO hotelAddressPO = it.next();
			String id = hotelAddressPO.getHotelID();
			String allInfo = hotelAddressPO.toAllString() + getHotelName(id);
			Pattern pattern = Pattern.compile(regex);
	    	Matcher matcher = pattern.matcher(allInfo);
	    	if(matcher.matches())   idList.add(id);
		}
		return idList;
	}

	public List<OrderAssessPO> gethotelAssessVO(String hotelID) {
		Session s = Hibernateutils.getSessionFactory().openSession();
		Criteria cr = s.createCriteria(OrderAssessPO.class);
		cr.add(Restrictions.eq("hotelID", hotelID));
		
		List<OrderAssessPO> hAssessPOs =  cr.list();
		s.close();
		return hAssessPOs;
	}

	public boolean isbooked(String customerID, String hotelID) {
		Session s = Hibernateutils.getSessionFactory().openSession();
		Criteria cr = s.createCriteria(OrderSearchStorePO.class);
		cr.add(Restrictions.eq("hotelID", hotelID));
		cr.add(Restrictions.eq("customerID", customerID));
		boolean ans = cr.list().isEmpty();
		s.close();
		return !ans;
	}

	public ResultMessage_Hotel modifyHotelName(String hotelID, String hotelName) {
		Session s = Hibernateutils.getSessionFactory().openSession();
		HotelBasePO hotelBasePO  =(HotelBasePO) s.load(HotelBasePO.class, hotelID);
		try{
			hotelBasePO.setHotelName(hotelName);
			s.close();
			return modifyHotelBasePO(hotelBasePO);
		}catch(Exception e){
			s.close();
			return ResultMessage_Hotel.fail;
		}
	}
	




}
