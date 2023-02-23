package com.booking.room.api;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.booking.room.service.BanquetHotelService;

@WebMvcTest(HotelController.class)
class HotelControllerTest {

	@Autowired
	private MockMvc mvc;
	@MockBean
	private BanquetHotelService hotelService;

	@Test
	void getTotalFloorsTest() throws Exception {
		when(hotelService.getTotalFloors()).thenReturn(4);
		mvc.perform(MockMvcRequestBuilders.get(HotelApiPaths.BASE_URI + HotelApiPaths.FLOORS)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	void getRoomsPerFloorTest() throws Exception {
		when(hotelService.getTotalRoomsPerFloor()).thenReturn(5);
		mvc.perform(MockMvcRequestBuilders.get(HotelApiPaths.BASE_URI + HotelApiPaths.ROOMS_PER_FLOOR)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
}
