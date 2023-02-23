package com.booking.room.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.booking.room.model.Hotel;

public class BanquetHotelServiceTest {

	private BanquetHotelService banquetHotelService;

	private Hotel hotel;

	@BeforeEach
	public void setUp() {
		hotel = new Hotel();
		banquetHotelService = new BanquetHotelService(hotel);
	}

	@Test
	public void getTotalFloorsTest() {
		Integer result = banquetHotelService.getTotalFloors();
		assertEquals(4, result);
	}

	@Test
	public void getTotalRoomsPerFloorTest() {
		Integer result = banquetHotelService.getTotalRoomsPerFloor();
		assertEquals(5, result);
	}
}
