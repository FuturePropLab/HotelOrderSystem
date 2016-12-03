package testHibernate;

import DataFactory.DataHelperUtils;
import DataFactory.Hibernateutils;
import dataservice.datahelper.RoomDateHelper;

public class testRoom {
		
		public static void main(String[] args) {
			RoomDateHelper  roomDateHelper = DataHelperUtils.getRoomDateHelper();
			System.out.println(roomDateHelper.deleteRoom("HT001", "315"));
//			System.out.println(roomDateHelper.addRoom("HT001", "305", RoomType.Double));
//			System.out.println(roomDateHelper.deleteRoom("HT001", "301"));
//			System.out.println(roomDateHelper.deleteRoom("HT001", "311"));
//			Date date1 = new Date(2016-1900, 12-1, 10);
//			Date date2 = new Date(2016-1900, 12-1, 11);
//			Date date3 = new Date(2016-1900, 12-1, 9);
//			Date date4 = new Date(2016-1900, 12-1, 10);
//			System.out.println(roomDateHelper.addRecord("HT001", "301", date1,date2));
//			System.out.println(roomDateHelper.addRecord("HT001", "301", date3,date4));
			
//			System.out.println(roomDateHelper.getRoomNobyType("HT001", RoomType.Double).size());
//			System.out.println(roomDateHelper.getRoomNobyType("HT001", RoomType.Single).size());
//			System.out.println(roomDateHelper.isAvailableRoom("HT001", "301", date2,date3));
			
			Hibernateutils.shutdown();
		}
}
