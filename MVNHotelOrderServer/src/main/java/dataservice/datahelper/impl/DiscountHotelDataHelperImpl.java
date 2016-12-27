package dataservice.datahelper.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import DataFactory.Hibernateutils;
import dataservice.datahelper.DiscountHotelDataHelper;
import po.DiscountHotelPO;
import po.DiscountPO_hotel;
import po.DiscountPO_web;
import tools.DiscountState;
import tools.ResultMessage_Discount;
import tools.ResultMessage_DiscountDetail;

public class DiscountHotelDataHelperImpl implements DiscountHotelDataHelper {
	
	private static DiscountHotelDataHelperImpl discountHotelDataHelperImpl = null;
	
	private DiscountHotelDataHelperImpl(){
		
	}

	public static DiscountHotelDataHelperImpl getInstance(){
		if(discountHotelDataHelperImpl == null)
			discountHotelDataHelperImpl  = new DiscountHotelDataHelperImpl();
		return discountHotelDataHelperImpl;
	}
	
	private String generateDiscountID(){
			String generatedID = "DSH";
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSS");
			LocalDateTime now = LocalDateTime.now();
			return generatedID = generatedID + dtf.format(now) + (int)(Math.random()*(10-1+1)) ;					
	}
	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.datahelper.DiscountHotelDataHelper#addHotelDiscount(java.lang.String, po.DiscountPO_hotel)
	 */
	public ResultMessage_DiscountDetail addHotelDiscount(String hotelID, DiscountPO_hotel discountPO_hotel) {
		DiscountHotelPO discountHotelPO = new DiscountHotelPO(hotelID, discountPO_hotel);
		discountHotelPO.setDiscountID(generateDiscountID());
		Session s = Hibernateutils.getSessionFactory().openSession();
		try {
			Transaction t = s.beginTransaction();
			s.save(discountHotelPO);
			t.commit();
			return ResultMessage_DiscountDetail.Success;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResultMessage_DiscountDetail.fail;
		}finally {
			 s.close();
		}
		
	}
	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.datahelper.DiscountHotelDataHelper#modifyHotelDiscount(java.lang.String, po.DiscountPO_hotel)
	 */
	public ResultMessage_Discount modifyHotelDiscount(String hotelID, DiscountPO_hotel discountPO_hotel) {
		DiscountHotelPO discountHotelPO = new DiscountHotelPO(hotelID, discountPO_hotel);
		if(discountHotelPO.getDiscountID()==null)  return ResultMessage_Discount.Fail;
		
		
		Session s = Hibernateutils.getSessionFactory().openSession();
		try {
			Transaction t = s.beginTransaction();
			s.update(discountHotelPO);
			t.commit();
			return ResultMessage_Discount.Success;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResultMessage_Discount.Fail;
		}finally {
			 s.close();
		}
		
	}
	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.datahelper.DiscountHotelDataHelper#getHotelDiscount(java.lang.String)
	 */
	public List<DiscountPO_hotel> getHotelDiscount(String hotelID) {
		Session s = Hibernateutils.getSessionFactory().openSession();
		Criteria cr = s.createCriteria(DiscountHotelPO.class);
		cr.add(Restrictions.eq("hotelID", hotelID));
		List<DiscountHotelPO>  list = cr.list();
		Iterator< DiscountHotelPO>  it = list.iterator();
		s.close();
		List<DiscountPO_hotel> returnlist = new ArrayList<DiscountPO_hotel>();
		while(it.hasNext()){
			DiscountPO_hotel discountPO_hotel = new DiscountPO_hotel(it.next());
			returnlist.add(discountPO_hotel);
		}
		return returnlist;
	}
	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.datahelper.DiscountHotelDataHelper#deleteHotelDiscount(java.lang.String, java.lang.String)
	 */
	public ResultMessage_Discount deleteHotelDiscount(String hotelID, String discountID) {
		Session s = Hibernateutils.getSessionFactory().openSession();
		try {
			DiscountHotelPO discountHotelPO = (DiscountHotelPO) s.load(DiscountHotelPO.class, discountID);
			Transaction t = s.beginTransaction();
			s.delete(discountHotelPO);
			t.commit();
			return ResultMessage_Discount.Success;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResultMessage_Discount.Fail;
		}finally {
			 s.close();
		}
	}
	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.datahelper.DiscountHotelDataHelper#invalidDiscount(java.lang.String)
	 */
	public ResultMessage_Discount invalidDiscount(String discountID) {
		Session s = Hibernateutils.getSessionFactory().openSession();
		try {
			DiscountHotelPO discountHotelPO = (DiscountHotelPO) s.load(DiscountHotelPO.class, discountID);
			discountHotelPO.setDiscountState(DiscountState.invalid);
			Transaction t = s.beginTransaction();
			s.update(discountHotelPO);
			t.commit();
			return ResultMessage_Discount.Success;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResultMessage_Discount.Fail;
		}finally {
			 s.close();
		}
	}

}
