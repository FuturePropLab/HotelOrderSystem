package po;

public class SearchHotelInfo {
	private SearchHotelType searchType;
	private HotelInfoVO hotelInfo;
	
	public void setSearchType(SearchHotelType type){
		this.searchType = type;
	}
	public SearchHotelType getSearchType(){
		return this.searchType;
	}
	
	public void setHotelInfoPO(HotelInfoVO hotelInfo){
		this.hotelInfo = hotelInfo;
	}
	public HotelInfoVO getHotelInfoPO(){
		return this.hotelInfo;
	}

}
