package po;

public class SearchHotelInfo {
	private SearchHotelType searchType;
	private HotelInfoPO hotelInfo;
	
	public void setSearchType(SearchHotelType type){
		this.searchType = type;
	}
	public SearchHotelType getSearchType(){
		return this.searchType;
	}
	
	public void setHotelInfoPO(HotelInfoPO hotelInfo){
		this.hotelInfo = hotelInfo;
	}
	public HotelInfoPO getHotelInfoPO(){
		return this.hotelInfo;
	}

}
