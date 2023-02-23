package com.booking.room.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.booking.room.service.BanquetHotelService;

@Controller
@RequestMapping(HotelApiPaths.BASE_URI)
public class HotelController {
	
	@Autowired
	private BanquetHotelService hotelService;
	
	@GetMapping(HotelApiPaths.FLOORS)
	public ResponseEntity<Object> getTotalFloors(){
		Integer floorCount= hotelService.getTotalFloors();
		return ResponseEntity.ok(floorCount);
		
	}
	
	@GetMapping(HotelApiPaths.ROOMS_PER_FLOOR)
	public ResponseEntity<Object> getRoomsPerFloor(){
		Integer rooms = hotelService.getTotalRoomsPerFloor();
		return ResponseEntity.ok(rooms);
		
	}
	
}
