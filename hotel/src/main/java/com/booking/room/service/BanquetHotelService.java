package com.booking.room.service;

import org.springframework.stereotype.Service;

import com.booking.room.model.Hotel;

@Service
public class BanquetHotelService implements HotelService {

	@Override
	public Integer getTotalFloors() {
		return Hotel.getFloors();
	}

	@Override
	public Integer getTotalRoomsPerFloor() {
		return Hotel.getRoomsPerFloor();
	}

}
