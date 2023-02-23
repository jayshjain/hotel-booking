package com.booking.room.cache;

import java.util.LinkedHashMap;

import org.springframework.stereotype.Component;

import com.booking.room.model.RoomStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class HotelRoomMap {

	private LinkedHashMap<String, String> roomStatusMap;

	public HotelRoomMap() {
		roomStatusMap = new LinkedHashMap<String, String>();
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 5; j++) {
				String s = ((Integer) i).toString();
				String s1 = ((Character) ((char) (j + 64))).toString();
				roomStatusMap.put((s + s1), RoomStatus.Aavialable.toString());
			}
		}
	}

	public LinkedHashMap<String, String> getRoomStatusMap() {
		return this.roomStatusMap;
	}

}
