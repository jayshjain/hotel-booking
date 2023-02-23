package com.booking.room.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.booking.room.cache.HotelRoomMap;
import com.booking.room.model.RoomStatus;


@Service
public class RoomBookingService implements BookingService {

	@Override
	public String bookNextAvailableRoom() {

		Optional<String> room = HotelRoomMap.roomStatusMap.entrySet().stream()
				.filter(e -> e.getValue().equals(RoomStatus.Aavialable.toString())).findFirst().map(e -> e.getKey());

		String roomNumber= room.get();
		HotelRoomMap.roomStatusMap.put(roomNumber, RoomStatus.Occupied.toString());
		return roomNumber;
	}

	@Override
	public Boolean checkOut(String roomNum) {

		HotelRoomMap.roomStatusMap.put(roomNum, RoomStatus.Vacant.toString());
		return true;
	}

	@Override
	public Boolean makeRoom(String roomNum) {
		HotelRoomMap.roomStatusMap.put(roomNum, RoomStatus.Aavialable.toString());
		return true;
	}

	@Override
	public Boolean makeForRepair(String roomNum) {
		HotelRoomMap.roomStatusMap.put(roomNum, RoomStatus.Repair.toString());
		return true;
	}

	@Override
	public Boolean repairRoom(String roomNum) {
		HotelRoomMap.roomStatusMap.put(roomNum, RoomStatus.Vacant.toString());
		return true;
	}

	@Override
	public List<String> getAllAvailableRooms() {

		return HotelRoomMap.roomStatusMap.entrySet().stream()
				.filter(e -> e.getValue().equals(RoomStatus.Aavialable.toString())).map(e -> e.getKey())
				.collect(Collectors.toList());
	}

}
