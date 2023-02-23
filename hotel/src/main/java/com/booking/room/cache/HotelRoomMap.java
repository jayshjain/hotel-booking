package com.booking.room.cache;

import java.util.LinkedHashMap;

import com.booking.room.model.Hotel;
import com.booking.room.model.RoomStatus;

public class HotelRoomMap {
	
	public static LinkedHashMap<String, String> roomStatusMap = new LinkedHashMap<String,String>();

	static {
		for(int i=1;i<=Hotel.getFloors();i++) {
			for(int j=1;j<=Hotel.getRoomsPerFloor();j++) {
				String s = ((Integer)i).toString();
				String s1= ((Character)((char)(j+64))).toString();				
				roomStatusMap.put((s+s1), RoomStatus.Aavialable.toString());
			}
		}
	}
	
	
}
