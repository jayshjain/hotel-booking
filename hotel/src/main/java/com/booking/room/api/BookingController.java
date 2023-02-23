package com.booking.room.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.booking.room.service.RoomBookingService;

@Controller
@RequestMapping(BookingApiPaths.BASE_URI)
public class BookingController {
	@Autowired
	private RoomBookingService bookingService;

	@PostMapping(BookingApiPaths.BOOK_ROOM)
	public ResponseEntity<Object> bookNextAvailableRoom(){
		return ResponseEntity.ok(bookingService.bookNextAvailableRoom());
	}
	
	@PostMapping(BookingApiPaths.CHECKOUT_ROOM)
	public ResponseEntity<Object> checkOut(@PathVariable String roomNumber){
		return ResponseEntity.ok(bookingService.checkOut(roomNumber));
	}
	
	@PostMapping(BookingApiPaths.MAKE_ROOM)
	public ResponseEntity<Object> makeRoom(@PathVariable String roomNumber){
		return ResponseEntity.ok(bookingService.makeRoom(roomNumber));
	}
	
	@PostMapping(BookingApiPaths.MAKE_FOR_REPAIR)
	public ResponseEntity<Object> makeForRepair(@PathVariable String roomNumber){
		return ResponseEntity.ok(bookingService.makeForRepair(roomNumber));
	}
	
	@PostMapping(BookingApiPaths.REPAIR_ROOM)
	public ResponseEntity<Object> repairRoom(@PathVariable String roomNumber){
		return ResponseEntity.ok(bookingService.repairRoom(roomNumber));
	}
	
	@GetMapping(BookingApiPaths.GET_ROOMS)
	public ResponseEntity<Object> getAllAvailableRooms(){
		return ResponseEntity.ok(bookingService.getAllAvailableRooms());
	}
	
	
}
