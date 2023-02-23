package com.booking.room.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.room.cache.HotelRoomMap;
import com.booking.room.model.RoomStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Service
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class RoomBookingService implements BookingService {
	@Autowired
	private HotelRoomMap hotelRoomMap;

	@Override
	public String bookNextAvailableRoom() {

		Optional<String> room = hotelRoomMap.getRoomStatusMap().entrySet().stream()
				.filter(e -> e.getValue().equals(RoomStatus.Aavialable.toString())).findFirst().map(e -> e.getKey());

		if (room.isPresent()) {
			String roomNumber = room.get();
			hotelRoomMap.getRoomStatusMap().put(roomNumber, RoomStatus.Occupied.toString());
			return roomNumber;
		}
		return null;
	}

	@Override
	public Boolean checkOut(String roomNum) {

		if (hotelRoomMap.getRoomStatusMap().get(roomNum).equals(RoomStatus.Occupied.toString())) {
			hotelRoomMap.getRoomStatusMap().put(roomNum, RoomStatus.Vacant.toString());
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Boolean makeRoom(String roomNum) {
		if (hotelRoomMap.getRoomStatusMap().get(roomNum).equals(RoomStatus.Vacant.toString())) {
			hotelRoomMap.getRoomStatusMap().put(roomNum, RoomStatus.Aavialable.toString());
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Boolean makeForRepair(String roomNum) {
		if (hotelRoomMap.getRoomStatusMap().get(roomNum).equals(RoomStatus.Vacant.toString())) {
			hotelRoomMap.getRoomStatusMap().put(roomNum, RoomStatus.Repair.toString());
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Boolean repairRoom(String roomNum) {
		if (hotelRoomMap.getRoomStatusMap().get(roomNum).equals(RoomStatus.Repair.toString())) {
			hotelRoomMap.getRoomStatusMap().put(roomNum, RoomStatus.Vacant.toString());
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<String> getAllAvailableRooms() {

		return hotelRoomMap.getRoomStatusMap().entrySet().stream()
				.filter(e -> e.getValue().equals(RoomStatus.Aavialable.toString())).map(e -> e.getKey())
				.collect(Collectors.toList());
	}

	public RoomBookingService(HotelRoomMap hotelRoomMap) {
		this.hotelRoomMap = hotelRoomMap;
	}

}
