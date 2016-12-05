package dataservice.datahelper.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import DataFactory.Hibernateutils;
import dataservice.datahelper.DiscountDataHelper;
import po.DiscountPO_web;
import po.DiscountPO_web_district;
import po.DiscountPO_web_level;
import po.DiscountPO_web_period;
import tools.ResultMessage_Discount;
import tools.ResultMessage_strategy;
import tools.Strategy_webType;

public class DiscountDataHelperImpl implements DiscountDataHelper {


	private String generateDiscountID(){
			String generatedID = "DS";
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSS");
			LocalDateTime now = LocalDateTime.now();
			return generatedID = generatedID + dtf.format(now) + (int)(Math.random()*(10-1+1)) ;					
	}

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

	public List<DiscountPO_web_district> getDiscountPOWebDistrictList() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DiscountPO_web_level> getDiscountPOWebLevelList() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DiscountPO_web_period> getDiscountPOWebPeriodList() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DiscountPO_web> getALLDiscountPOList() {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage_strategy addgetDiscountPO(DiscountPO_web discountPO_web) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage_Discount modifyDiscountPO(DiscountPO_web discountPO_web) {
		// TODO Auto-generated method stub
		return null;
	}

}
