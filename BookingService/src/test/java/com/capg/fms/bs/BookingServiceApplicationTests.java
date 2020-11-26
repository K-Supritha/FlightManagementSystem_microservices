package com.capg.fms.bs;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.fms.bs.dto.Booking;
import com.capg.fms.bs.exceptions.BookingNotFoundException;
import com.capg.fms.bs.service.BookingService;

@SpringBootTest
public class BookingServiceApplicationTests {
	@Autowired
	private BookingService service;

	@Test
	public void testGetBookingDetails() throws BookingNotFoundException
	{
		Optional<Booking> opt=service.getBookingDetails(12);
		Assertions.assertTrue(opt.isPresent());
		
	}
	@Test
	public void testByBookingNotFound() throws BookingNotFoundException
	{
		Assertions.assertThrows(BookingNotFoundException.class, ()->service.getBookingDetails(20));
	}
	

}
