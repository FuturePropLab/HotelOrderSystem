package dataservice.datahelper.impl;

import java.util.List;

import org.hibernate.Session;

import DataFactory.Hibernateutils;
import dataservice.datahelper.AddressDataHelper;

public class AddressDataHelperImpl implements AddressDataHelper {
	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.datahelper.AddressDataHelper#getDistributeList(java.lang.String)
	 */
	public List<String> getDistributeList(String city) {
		Session s = Hibernateutils.getSessionFactory().openSession();
		List<String> districtList;
//		try{
			districtList = s.createSQLQuery("select distribute from CityDistributePO"
					+ " where city = '"+city+"'").list();
			System.out.println("getDistributeList:   "+districtList.size());
			return districtList;
//		}catch(Exception e){
//			return null;
//		}finally {
//			s.close();
//		}
	}
	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.datahelper.AddressDataHelper#getBusinessCircleList(java.lang.String)
	 */
	public List<String> getBusinessCircleList(String district) {
		Session s = Hibernateutils.getSessionFactory().openSession();
		List<String> businessCirclelist;
		try{
			businessCirclelist = s.createSQLQuery("select businessCircle from DistributeCommercialPO"
					+ " where distribute = '"+district+"'").list();
			System.out.println("getBusinessCircleList:   "+businessCirclelist.size());
			return businessCirclelist;
		}catch(Exception e){
			return null;
		}finally {
			s.close();
		}
	}

}
