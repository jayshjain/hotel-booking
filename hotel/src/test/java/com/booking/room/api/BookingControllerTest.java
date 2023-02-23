package com.booking.room.api;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.booking.room.service.RoomBookingService;

@WebMvcTest(BookingController.class)
class BookingControllerTest {

	@Autowired
	private MockMvc mvc;
	@MockBean
	private RoomBookingService roomBookingService;
	private String roomNum = "1A";

	@Test
	void getAllAvailableRoomsTest() throws Exception {
		List<String> rooms = Arrays.asList("1A", "1B");
		when(roomBookingService.getAllAvailableRooms()).thenReturn(rooms);

		mvc.perform(MockMvcRequestBuilders.get(BookingApiPaths.BASE_URI + BookingApiPaths.GET_ROOMS)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

	}

	@Test
	void bookNextAvailableRoomTest() throws Exception {
		when(roomBookingService.bookNextAvailableRoom()).thenReturn(roomNum);
		mvc.perform(MockMvcRequestBuilders.post(BookingApiPaths.BASE_URI + BookingApiPaths.BOOK_ROOM)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	void checkOutTest() throws Exception {
		when(roomBookingService.checkOut(roomNum)).thenReturn(true);
		mvc.perform(MockMvcRequestBuilders.post(BookingApiPaths.BASE_URI + BookingApiPaths.CHECKOUT_ROOM, roomNum)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	void makeRoomTest() throws Exception {
		when(roomBookingService.makeRoom(roomNum)).thenReturn(true);
		mvc.perform(MockMvcRequestBuilders.post(BookingApiPaths.BASE_URI + BookingApiPaths.MAKE_ROOM, roomNum)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

	}
	
	@Test
	void makeRoomForRepairTest() throws Exception {
		when(roomBookingService.makeForRepair(roomNum)).thenReturn(true);
		mvc.perform(MockMvcRequestBuilders.post(BookingApiPaths.BASE_URI + BookingApiPaths.MAKE_FOR_REPAIR, roomNum)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

	}
	
	@Test
	void repairRoomTest() throws Exception {
		when(roomBookingService.repairRoom(roomNum)).thenReturn(true);
		mvc.perform(MockMvcRequestBuilders.post(BookingApiPaths.BASE_URI + BookingApiPaths.REPAIR_ROOM, roomNum)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

	}

}