package com.booking.room.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.booking.room.cache.HotelRoomMap;

public class RoomBookingServiceTest {

	private RoomBookingService roomBookingService;
	private HotelRoomMap hotelRoomMap;

	@BeforeEach
	public void setUp() {
		hotelRoomMap = new HotelRoomMap();
		roomBookingService = new RoomBookingService(hotelRoomMap);
	}

	@Test
	public void getAllAvailableRoomsTestPositive() {
		List<String> result = roomBookingService.getAllAvailableRooms();
		assertNotEquals(0, result.size());
		assertEquals(20, result.size());
	}

	@Test
	public void getAllAvailableRoomsTestNegative() {
		List<String> result = roomBookingService.getAllAvailableRooms();

		for (int i = 0; i < result.size(); i++) {
			roomBookingService.bookNextAvailableRoom();
		}

		result = roomBookingService.getAllAvailableRooms();
		assertTrue(result.isEmpty());
	}

	@Test
	public void bookNextAvailableRoomTestPositive() {
		String result = roomBookingService.bookNextAvailableRoom();
		assertNotNull(result);
	}

	@Test
	public void bookNextAvailableRoomTestNegative() {
		List<String> result = roomBookingService.getAllAvailableRooms();

		for (int i = 0; i < result.size(); i++) {
			roomBookingService.bookNextAvailableRoom();
		}
		String response = roomBookingService.bookNextAvailableRoom();
		assertNull(response);
	}

	@Test
	public void checkOutTestPositive() {
		String roomNum = roomBookingService.bookNextAvailableRoom();
		Boolean result = roomBookingService.checkOut(roomNum);
		assertTrue(result);
	}

	@Test
	public void checkOutTestNegative() {
		String roomNum = roomBookingService.getAllAvailableRooms().stream().findFirst().get();
		Boolean result = roomBookingService.checkOut(roomNum);
		assertFalse(result);
	}

	@Test
	public void makeRoomTestPositive() {
		String roomNum = roomBookingService.bookNextAvailableRoom();
		Boolean checkOutResult = roomBookingService.checkOut(roomNum);
		assertTrue(checkOutResult);
		Boolean result = roomBookingService.makeRoom(roomNum);
		assertTrue(result);
	}

	@Test
	public void makeRoomTestNegative() {
		String roomNum = roomBookingService.getAllAvailableRooms().stream().findFirst().get();
		Boolean checkOutResult = roomBookingService.checkOut(roomNum);
		assertFalse(checkOutResult);
		Boolean result = roomBookingService.makeRoom(roomNum);
		assertFalse(result);
	}

	@Test
	public void makeForRepairTestPositive() {
		String roomNum = roomBookingService.bookNextAvailableRoom();
		Boolean checkOutResult = roomBookingService.checkOut(roomNum);
		assertTrue(checkOutResult);
		Boolean result = roomBookingService.makeForRepair(roomNum);
		assertTrue(result);
	}

	@Test
	public void makeForRepairTestNegative() {
		String roomNum = roomBookingService.getAllAvailableRooms().stream().findFirst().get();
		Boolean checkOutResult = roomBookingService.checkOut(roomNum);
		assertFalse(checkOutResult);
		Boolean result = roomBookingService.makeForRepair(roomNum);
		assertFalse(result);
	}

	@Test
	public void repairRoomTestPositive() {
		String roomNum = roomBookingService.bookNextAvailableRoom();
		Boolean checkOutResult = roomBookingService.checkOut(roomNum);
		assertTrue(checkOutResult);
		Boolean markRepairResult = roomBookingService.makeForRepair(roomNum);
		assertTrue(markRepairResult);
		Boolean result = roomBookingService.repairRoom(roomNum);
		assertTrue(result);
	}

	@Test
	public void repairRoomTestNegative() {
		String roomNum = roomBookingService.getAllAvailableRooms().stream().findFirst().get();
		Boolean checkOutResult = roomBookingService.checkOut(roomNum);
		assertFalse(checkOutResult);
		Boolean markRepairResult = roomBookingService.makeForRepair(roomNum);
		assertFalse(markRepairResult);
		Boolean result = roomBookingService.repairRoom(roomNum);
		assertFalse(result);
	}
}
