package com.booking.room.api;

public interface BookingApiPaths {
	String BASE_URI = "/bookings";
	String BOOK_ROOM = "/book";
	String CHECKOUT_ROOM = "/checkout/{roomNumber}";
	String MAKE_ROOM = "/makeRoom/{roomNumber}";
	String MAKE_FOR_REPAIR = "/makeForRepair/{roomNumber}";
	String REPAIR_ROOM = "/repairRoom/{roomNumber}";
	String GET_ROOMS = "/rooms";

}
