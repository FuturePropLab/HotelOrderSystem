package tools;

import java.io.Serializable;

public class StandardSearch implements Serializable{
	

		private static final long serialVersionUID = 5267785254860192870L;
		HotelAddress hotelAddress;
		double low;
		double high;
		String hotelName;
		boolean booked;
		RoomType roomType;
		Star star;
		
		public HotelAddress getHotelAddress() {
			return hotelAddress;
		}
		public void setHotelAddress(HotelAddress hotelAddress) {
			this.hotelAddress = hotelAddress;
		}
		public double getLow() {
			return low;
		}
		public void setLow(double low) {
			this.low = low;
		}
		public double getHigh() { 
			return high;
		}
		public void setHigh(double high) {
			this.high = high;
		}
		public String getHotelName() {
			return hotelName;
		}
		public void setHotelName(String hotelName) {
			this.hotelName = hotelName;
		}
		public boolean isBooked() {
			return booked;
		}
		public void setBooked(boolean booked) {
			this.booked = booked;
		}
		public RoomType getRoomType() {
			return roomType;
		}
		public void setRoomType(RoomType roomType) {
			this.roomType = roomType;
		}
		public Star getStar() {
			return star;
		}
		public void setStar(Star star) {
			this.star = star;
		}
		
		
}
