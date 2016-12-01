package testHibernate;

import DataFactory.DataHelperUtils;
import DataFactory.Hibernateutils;
import dataservice.datahelper.HotelDataHelper;

public class testHotel {
		public static void main(String[] args) {
			HotelDataHelper helper = DataHelperUtils.getHotelDataHelper();
			String id  = "HT001";

			Hibernateutils.shutdown();
		}
}
