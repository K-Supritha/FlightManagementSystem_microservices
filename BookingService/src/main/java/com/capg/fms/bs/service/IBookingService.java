package com.capg.fms.bs.service;

import java.util.List;
import java.util.Optional;

import com.capg.fms.bs.dto.Booking;
import com.capg.fms.bs.exceptions.BookingNotFoundException;

public interface IBookingService {
	public Optional<Booking> getBookingDetails(long bookingId) throws BookingNotFoundException;
	public List<Booking> getAllBookingDetails();
	public Booking addBookingDetails(Booking booking);
	
	public void updateBookingDetails(Booking booking);
	public void deleteBookingDetails(long bookingId, Booking booking)throws BookingNotFoundException;

}
