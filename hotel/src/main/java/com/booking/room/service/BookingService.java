package com.booking.room.service;

import java.util.List;

public interface BookingService {
	
	public String bookNextAvailableRoom();
	
	public Boolean checkOut(String roomNum);
	
	public Boolean makeRoom(String roomNum);
	
	public Boolean makeForRepair(String roomNum);
	
	public Boolean repairRoom(String roomNum);
	
	public List<String> getAllAvailableRooms();

}
