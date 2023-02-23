package com.booking.room.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.room.model.Hotel;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class BanquetHotelService implements HotelService {
	@Autowired
	private Hotel hotel;

	public BanquetHotelService(Hotel hotel) {
		this.hotel=hotel;
	}

	@Override
	public Integer getTotalFloors() {
		return hotel.getFloors();
	}

	@Override
	public Integer getTotalRoomsPerFloor() {
		return hotel.getRoomsPerFloor();
	}

}
