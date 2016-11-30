package po;

public class SearchHotelInfo {
	private SearchHotelType searchType;
	private HotelPO hotelInfo;
	
	public void setSearchType(SearchHotelType type){
		this.searchType = type;
	}
	public SearchHotelType getSearchType(){
		return this.searchType;
	}
	
	public void setHotelInfoPO(HotelPO hotelInfo){
		this.hotelInfo = hotelInfo;
	}
	public HotelPO getHotelInfoPO(){
		return this.hotelInfo;
	}

}
