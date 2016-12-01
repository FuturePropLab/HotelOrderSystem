package dataservice.impl;

import java.rmi.RemoteException;
import java.util.List;

import DataFactory.DataHelperUtils;
import dataservice.HotelDataService;
import dataservice.datahelper.HotelDataHelper;
import po.HotelAddressPO;
import po.HotelBasePO;
import po.HotelFacilityPO;
import po.HotelPO;
import tools.HotelRoomInfo;
import tools.ResultMessage_Hotel;
import tools.SearchHotel;

public class HotelDataServiceImpl implements HotelDataService {
	
	private HotelDataHelper hotelDataHelper;
	
	public HotelDataServiceImpl(){
		this.hotelDataHelper = DataHelperUtils.getHotelDataHelper();
	}
	
	public ResultMessage_Hotel addHotel(HotelPO hotelPO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage_Hotel modifyHotel(HotelPO hotelPO) throws RemoteException  {
		// TODO Auto-generated method stub
		return null;
	}

	public HotelPO getHotel(String hotel_id) throws RemoteException  {
		HotelBasePO hotelBasePO = hotelDataHelper.getHotelBasePO(hotel_id);
		if(hotelBasePO == null )  return null;
		HotelAddressPO hotelAddressPO = hotelDataHelper.getHotelAddressPO(hotel_id);
		HotelFacilityPO hotelFacilityPO = hotelDataHelper.getHotelFacilityPO(hotel_id);
		HotelRoomInfo hotelRoomInfo = hotelDataHelper.getHotelRoomInfo(hotel_id);
		
		HotelPO hotelPO = new HotelPO(hotelBasePO, hotelAddressPO, 
				null, hotelRoomInfo, hotelFacilityPO);		
		return hotelPO;
	}

	public List<HotelPO> searchHotelList(SearchHotel searchhotel) throws RemoteException  {
		// TODO Auto-generated method stub
		return null;
	}

}
