package com.booking.room.model;

public class Hotel {
	 static Integer floors;
     static Integer roomsPerFloor;
     
     private Hotel() {}
	
	static {
		floors=4;
		roomsPerFloor=5;
	}	
	
	public static Integer getFloors() {
		return floors;
	}
	
	public static Integer getRoomsPerFloor() {
		return roomsPerFloor;
	}
}
