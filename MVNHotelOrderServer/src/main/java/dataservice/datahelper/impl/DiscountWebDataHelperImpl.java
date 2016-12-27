package dataservice.datahelper.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import DataFactory.Hibernateutils;
import dataservice.datahelper.DiscountWebDataHelper;
import po.DiscountPO_web;
import po.DiscountPO_web_district;
import po.DiscountPO_web_level;
import po.DiscountPO_web_period;
import tools.DiscountState;
import tools.ResultMessage_Discount;
import tools.ResultMessage_DiscountDetail;
import tools.Strategy_webType;

public class DiscountWebDataHelperImpl implements DiscountWebDataHelper {
	
	
	private static DiscountWebDataHelperImpl discountDataHelperImpl = null;
	
	private DiscountWebDataHelperImpl(){
		
	}

	public static DiscountWebDataHelperImpl getInstance(){
		if(discountDataHelperImpl == null)
			 discountDataHelperImpl  = new DiscountWebDataHelperImpl();
		return discountDataHelperImpl;
	}
	private String generateDiscountID(){
			String generatedID = "DS";
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSS");
			LocalDateTime now = LocalDateTime.now();
			return generatedID = generatedID + dtf.format(now) + (int)(Math.random()*(10-1+1)) ;					
	}
	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.datahelper.DiscountDataHelper#getDiscountPO(java.lang.String)
	 */
	public DiscountPO_web getDiscountPO(String discountID) {
		Session s = Hibernateutils.getSessionFactory().openSession();
		Criteria cr = s.createCriteria(DiscountPO_web.class);
		cr.add(Restrictions.eq("discountID", discountID));
		List<DiscountPO_web> DiscountPO_webs = cr.list();
		if(DiscountPO_webs.isEmpty())  {
			s.close();
			return null;
		}
		Strategy_webType strategy_webType  =  DiscountPO_webs.get(0).getType();
		System.out.println("get  Type  : "  + strategy_webType);
		
		if(strategy_webType.equals(Strategy_webType.VIP_district)){
			Criteria crnew = s.createCriteria(DiscountPO_web_district.class);
			crnew.add(Restrictions.eq("discountID", discountID));
			List<DiscountPO_web_district> discountPO_web_districts = crnew.list();
		
			if(discountPO_web_districts==null || discountPO_web_districts.isEmpty())   {
				s.close();
				return null ;	
			}else{
				s.close();
				return discountPO_web_districts.get(0);
			}
		}else if(strategy_webType.equals(Strategy_webType.Level)){
			Criteria crnew = s.createCriteria(DiscountPO_web_level.class);
			crnew.add(Restrictions.eq("discountID", discountID));
			List<DiscountPO_web_level> discountPO_web_level = crnew.list();
		
			if(discountPO_web_level==null || discountPO_web_level.isEmpty())   {
				s.close();
				return null ;	
			}else{
				s.close();
				return discountPO_web_level.get(0);
			}
		}else if(strategy_webType.equals(Strategy_webType.Period)){
			Criteria crnew = s.createCriteria(DiscountPO_web_period.class);
			crnew.add(Restrictions.eq("discountID", discountID));
			List<DiscountPO_web_period> discountPO_web_period = crnew.list();
		
			if(discountPO_web_period==null || discountPO_web_period.isEmpty())   {
				s.close();
				return null ;	
			}else{
				s.close();
				return discountPO_web_period.get(0);
			}
		}
		s.close();
		return null;
	}
	
	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.datahelper.DiscountDataHelper#getDiscountPOWebDistrictList()
	 */
	public List<DiscountPO_web_district> getDiscountPOWebDistrictList() {
		Session s = Hibernateutils.getSessionFactory().openSession();
		Criteria cr = s.createCriteria(DiscountPO_web_district.class);
		List<DiscountPO_web_district>  list = cr.list();
		s.close();
		return list;
	}
	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.datahelper.DiscountDataHelper#getDiscountPOWebLevelList()
	 */
	public List<DiscountPO_web_level> getDiscountPOWebLevelList() {
		Session s = Hibernateutils.getSessionFactory().openSession();
		Criteria cr = s.createCriteria(DiscountPO_web_level.class);
		List<DiscountPO_web_level> list = cr.list();;
		s.close();
		return list;

	}

	public List<DiscountPO_web_period> getDiscountPOWebPeriodList() {
		Session s = Hibernateutils.getSessionFactory().openSession();
		Criteria cr = s.createCriteria(DiscountPO_web_period.class);
		List<DiscountPO_web_period> list = cr.list();
		s.close();
		return list;

	}
	
	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.datahelper.DiscountDataHelper#getALLDiscountPOList()
	 */
	public List<DiscountPO_web> getALLDiscountPOList() {
		List<DiscountPO_web> list = new ArrayList<DiscountPO_web>();
		list.addAll(getDiscountPOWebDistrictList());
		list.addAll(getDiscountPOWebLevelList());
		list.addAll(getDiscountPOWebPeriodList());
		return list;
	}
	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.datahelper.DiscountDataHelper#addgetDiscountPO(po.DiscountPO_web)
	 */
	public ResultMessage_DiscountDetail addDiscountPO(DiscountPO_web discountPO_web) {
		Session s = Hibernateutils.getSessionFactory().openSession();
		String discountID = generateDiscountID();
		discountPO_web.setDiscountID(discountID);
		
		Strategy_webType strategy_webType  = discountPO_web.getType();
		System.out.println("get  Type  : "  + strategy_webType);
		
		// when vip dostribute  not check 
		if(strategy_webType.equals(Strategy_webType.VIP_district)){
			//force change 
			DiscountPO_web_district discountPO_web_districts = (DiscountPO_web_district)discountPO_web;
			try{
				Transaction t = s.beginTransaction();
				s.save(discountPO_web_districts);
				t.commit();
				return ResultMessage_DiscountDetail.Success;
			}catch(Exception e){
				System.out.println(e.getMessage());
				return ResultMessage_DiscountDetail.fail;
			}finally {
				s.close();
			}
		}else if(strategy_webType.equals(Strategy_webType.Level)){
			//force change to level 
			DiscountPO_web_level discountPO_web_level = (DiscountPO_web_level)discountPO_web;
			
			//add more exeam
			Criteria cr = s.createCriteria(DiscountPO_web_level.class);
			cr.add(Restrictions.eq("discountState", DiscountState.valid));
			List<DiscountPO_web_level> discountPO_web_levels = cr.list();
			
			int levelNow = 0;
			for (DiscountPO_web_level discount : discountPO_web_levels) {
				if(discount.getLv() > levelNow ) levelNow = discount.getLv();
			}
			//if not right or it means 
			// if level 3 is to be saves  level 1 and level 2 must exsists
			if(discountPO_web_level.getLv()!=levelNow+1)  return ResultMessage_DiscountDetail.Conflict;
			
			try{
				Transaction t = s.beginTransaction();
				s.save(discountPO_web_level);
				t.commit();
				return ResultMessage_DiscountDetail.Success;
			}catch(Exception e){
				System.out.println(e.getMessage());
				return ResultMessage_DiscountDetail.fail;
			}finally {
				s.close();
			}			
		}else if(strategy_webType.equals(Strategy_webType.Period)){
			//force chagnge 
			DiscountPO_web_period discountPO_web_period = (DiscountPO_web_period)discountPO_web;
			try{
				Transaction t = s.beginTransaction();
				s.save(discountPO_web_period);
				t.commit();
				return ResultMessage_DiscountDetail.Success;
			}catch(Exception e){
				System.out.println(e.getMessage());
				return ResultMessage_DiscountDetail.fail;
			}finally {
				s.close();
			}
		}
		s.close();
		return ResultMessage_DiscountDetail.fail;
	}
	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.datahelper.DiscountDataHelper#modifyDiscountPO(po.DiscountPO_web)
	 */
	public ResultMessage_Discount modifyDiscountPO(DiscountPO_web discountPO_web) {
		Session s = Hibernateutils.getSessionFactory().openSession();
//		String discountID = generateDiscountID();
//		discountPO_web.setDiscountID(discountID);
		
		Strategy_webType strategy_webType  = discountPO_web.getType();
		System.out.println("get  Type  : "  + strategy_webType);
		
		// when vip dostribute  not check 
		if(strategy_webType.equals(Strategy_webType.VIP_district)){
			//force change 
			DiscountPO_web_district discountPO_web_district = (DiscountPO_web_district)discountPO_web;
			try{
				Transaction t = s.beginTransaction();
				System.out.println("?????? modify");
				System.out.println(discountPO_web_district.getDiscountID());
				s.update(discountPO_web_district);
				t.commit();
				return ResultMessage_Discount.Success;
			}catch(Exception e){
				System.out.println(e.getMessage());
				return ResultMessage_Discount.Fail;
			}finally {
				s.close();
			}
		}else if(strategy_webType.equals(Strategy_webType.Level)){
			//force change to level 
			DiscountPO_web_level discountPO_web_level = (DiscountPO_web_level)discountPO_web;
			
			//add more exeam
			Criteria cr = s.createCriteria(DiscountPO_web_level.class);
			cr.add(Restrictions.eq("discountID", discountPO_web_level.getDiscountID()));
			List<DiscountPO_web_level> discountPO_web_levels = cr.list();
			
			if(discountPO_web_levels.isEmpty()  ||
					!(discountPO_web_levels.get(0).getLv()==discountPO_web_level.getLv()))
					
			return ResultMessage_Discount.Fail;
			s.close();
			s = Hibernateutils.getSessionFactory().openSession();
				//be able to update 
		try{
				Transaction t = s.beginTransaction();
				s.update(discountPO_web_level);
				t.commit();
				return ResultMessage_Discount.Success;
			}catch(Exception e){
				System.out.println(e.getMessage());
				return ResultMessage_Discount.Fail;
			}finally {
				s.close();
			}			
		}else if(strategy_webType.equals(Strategy_webType.Period)){
			//force chagnge 
			DiscountPO_web_period discountPO_web_period = (DiscountPO_web_period)discountPO_web;
			try{
				Transaction t = s.beginTransaction();
				s.update(discountPO_web_period);
				t.commit();
				return ResultMessage_Discount.Success;
			}catch(Exception e){
				System.out.println(e.getMessage());
				return ResultMessage_Discount.Fail;
			}finally {
				s.close();
			}
		}
		s.close();
		return ResultMessage_Discount.Fail;
	}
	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.datahelper.DiscountDataHelper#invalidDisCount(java.lang.String)
	 */
	public ResultMessage_Discount invalidDisCount(String discountID) {
		//get factory
		Session s = Hibernateutils.getSessionFactory().openSession();
		//check whether it exits
		Criteria cr = s.createCriteria(DiscountPO_web.class);
		cr.add(Restrictions.eq("discountID", discountID));
		List<DiscountPO_web> DiscountPO_webs = cr.list();
		if(DiscountPO_webs.isEmpty())  {
			s.close();
			return ResultMessage_Discount.Fail;
		}
		Strategy_webType strategy_webType  =  DiscountPO_webs.get(0).getType();
		System.out.println("get  Type  : "  + strategy_webType);
		
		if(strategy_webType.equals(Strategy_webType.VIP_district)){
			//get the aim discount
			DiscountPO_web_district discountPO_web_district = 
					(DiscountPO_web_district) s.load(DiscountPO_web_district.class, discountID);
			
			try {
				//change it to null;
				Transaction t = s.beginTransaction();
				discountPO_web_district.setDiscountState(DiscountState.invalid);
				s.update(discountPO_web_district);
				t.commit();
				return ResultMessage_Discount.Success;
			} catch(Exception e){
				//print the wrong info
				System.out.println(e.getMessage());
				return ResultMessage_Discount.Fail;
			}finally {
				s.close();
			}			
		}else if(strategy_webType.equals(Strategy_webType.Level)){
			//get the aim discount
			DiscountPO_web_level discountPO_web_level = 
					(DiscountPO_web_level) s.load(DiscountPO_web_level.class, discountID);
			
			Criteria cl = s.createCriteria(DiscountPO_web_level.class);
			cl.add(Restrictions.gt("level", discountPO_web_level.getLv()));
			cl.add(Restrictions.eq("discountState",DiscountState.valid));
			
			if(!cl.list().isEmpty() && discountPO_web_level.getDiscountState().equals(DiscountState.valid))  
				return ResultMessage_Discount.Fail;
			try {
				//change it to null;
				Transaction t = s.beginTransaction();
				discountPO_web_level.setDiscountState(DiscountState.invalid);
				s.update(discountPO_web_level);
				t.commit();
				return ResultMessage_Discount.Success;
			} catch(Exception e){
				//print the wrong info
				System.out.println(e.getMessage());
				return ResultMessage_Discount.Fail;
			}finally {
				s.close();
			}			
		}else if(strategy_webType.equals(Strategy_webType.Period)){
			//get the aim discount
			DiscountPO_web_period discountPO_web_period = 
					(DiscountPO_web_period) s.load(DiscountPO_web_period.class, discountID);
			
			try {
				//change it to null;
				Transaction t = s.beginTransaction();
				discountPO_web_period.setDiscountState(DiscountState.invalid);
				s.update(discountPO_web_period);
				t.commit();
				return ResultMessage_Discount.Success;
			} catch(Exception e){
				//print the wrong info
				System.out.println(e.getMessage());
				return ResultMessage_Discount.Fail;
			}finally {
				s.close();
			}
			
		}
		s.close();
		return ResultMessage_Discount.Fail;
	}
	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.datahelper.DiscountDataHelper#deleteDiscount(java.lang.String)
	 */
	public ResultMessage_Discount deleteDiscount(String discountID) {
		//get factory
				Session s = Hibernateutils.getSessionFactory().openSession();
				//check whether it exits
				Criteria cr = s.createCriteria(DiscountPO_web.class);
				cr.add(Restrictions.eq("discountID", discountID));
				List<DiscountPO_web> DiscountPO_webs = cr.list();
				if(DiscountPO_webs.isEmpty())  {
					s.close();
					return ResultMessage_Discount.Fail;
				}
				Strategy_webType strategy_webType  =  DiscountPO_webs.get(0).getType();
				System.out.println("get  Type  : "  + strategy_webType);
				
				if(strategy_webType.equals(Strategy_webType.VIP_district)){
					//get the aim discount
					DiscountPO_web_district discountPO_web_district = 
							(DiscountPO_web_district) s.load(DiscountPO_web_district.class, discountID);
					
					try {
						//change it to null;
						Transaction t = s.beginTransaction();
						discountPO_web_district.setDiscountState(DiscountState.invalid);
						s.delete(discountPO_web_district);
						t.commit();
						return ResultMessage_Discount.Success;
					} catch(Exception e){
						//print the wrong info
						System.out.println(e.getMessage());
						return ResultMessage_Discount.Fail;
					}finally {
						s.close();
					}			
				}else if(strategy_webType.equals(Strategy_webType.Level)){
					//get the aim discount
					DiscountPO_web_level discountPO_web_level = 
							(DiscountPO_web_level) s.load(DiscountPO_web_level.class, discountID);
					
					Criteria cl = s.createCriteria(DiscountPO_web_level.class);
					cl.add(Restrictions.gt("level", discountPO_web_level.getLv()));
					cl.add(Restrictions.eq("discountState",DiscountState.valid));
					
					if(!cl.list().isEmpty())  return ResultMessage_Discount.Fail;
					try {
						//change it to null;
						Transaction t = s.beginTransaction();
						discountPO_web_level.setDiscountState(DiscountState.invalid);
						s.delete(discountPO_web_level);
						t.commit();
						return ResultMessage_Discount.Success;
					} catch(Exception e){
						//print the wrong info
						System.out.println(e.getMessage());
						return ResultMessage_Discount.Fail;
					}finally {
						s.close();
					}			
				}else if(strategy_webType.equals(Strategy_webType.Period)){
					//get the aim discount
					DiscountPO_web_period discountPO_web_period = 
							(DiscountPO_web_period) s.load(DiscountPO_web_period.class, discountID);
					
					try {
						//change it to null;
						Transaction t = s.beginTransaction();
						discountPO_web_period.setDiscountState(DiscountState.invalid);
						s.delete(discountPO_web_period);
						t.commit();
						return ResultMessage_Discount.Success;
					} catch(Exception e){
						//print the wrong info
						System.out.println(e.getMessage());
						return ResultMessage_Discount.Fail;
					}finally {
						s.close();
					}
					
				}
				s.close();
				return ResultMessage_Discount.Fail;
	}

}
