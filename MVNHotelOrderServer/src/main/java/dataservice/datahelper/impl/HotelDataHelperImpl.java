package dataservice.datahelper.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
import po.TypeRoomInfoPO;
import tools.HotelRoomInfo;
import tools.ResultMessage_Hotel;
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
		System.out.println(typeRoomInfoPOs.size());
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
		String hotelID = hotelBasePO.getHotelID();
		HotelBasePO hotelBasePO2 = getHotelBasePO(hotelID);
		if(hotelBasePO2==null)  return ResultMessage_Hotel.fail;
		
		String hotelName = hotelBasePO.getHotelName();		
		if(hotelName!=null && "".equals(hotelName)){
			 hotelBasePO2.setHotelName(hotelName);
		}
		
		if(hotelBasePO.getGrade()!=0){
			hotelBasePO2.setGrade(hotelBasePO.getGrade());
		}
		
		Star star = hotelBasePO.getStar();
		if(star != null){
			hotelBasePO2.setStar(star);
		}
		
		
		Session s = Hibernateutils.getSessionFactory().openSession();
		try{
			Transaction t = s.beginTransaction();
			s.update(hotelBasePO2);
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
		if("FAIL".equals(hotelName) || "NOT_EXITS".equals(hotelName))  return null;
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

}
