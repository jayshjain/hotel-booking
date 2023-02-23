package com.booking.room.model;

import org.springframework.stereotype.Component;

@Component
public class Hotel {
	private Integer floors;
	private Integer roomsPerFloor;

	public Hotel() {
		this.floors = 4;
		this.roomsPerFloor = 5;
	}

	public int getFloors() {
		return this.floors;
	}

	public int getRoomsPerFloor() {
		return this.roomsPerFloor;
	}

}
