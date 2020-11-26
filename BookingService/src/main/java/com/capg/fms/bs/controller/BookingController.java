package com.capg.fms.bs.controller;

import java.util.List;
import com.capg.fms.bs.exceptions.ValidateBookingException;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.fms.bs.dto.Booking;
import com.capg.fms.bs.dto.Passengers;
import com.capg.fms.bs.service.BookingService;
import com.capg.fms.bs.service.PassengersService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class BookingController {
	@Autowired
	private BookingService bookingService;

	public void setBookingService(BookingService bookingService) {
		this.bookingService = bookingService;
	}

	@Autowired
	PassengersService passengersService;
	
	public void setPdao(PassengersService passengersService) {
		this.passengersService = passengersService;
	}

	@GetMapping(value = "/getBookingDetails/{bookingId}")
	public Optional<Booking> getBookingDetails(@PathVariable long bookingId) {
		return bookingService.getBookingDetails(bookingId);
	}

	@PostMapping(value = "/addBookingDetails")
	public String addBookingDetails(@Valid @RequestBody() Booking booking, BindingResult br)
			throws ValidateBookingException {
		if (br.hasErrors()) {
			throw new ValidateBookingException(br.getFieldErrors());
		}
		for (Passengers p : booking.getPassengers())
			passengersService.addPassenger(p);
		Booking b = bookingService.addBookingDetails(booking);
		return "{\"bookingId\":" + b.getBookingId() + "}";
	}
	

	@GetMapping(value = "/getAllBookingDetails")
	public List<Booking> getAllBookingDetails() {
		return bookingService.getAllBookingDetails();
	}

	@DeleteMapping("/deleteBookingDetails/{bookingId}")
	public String deleteBookingDetails(@PathVariable long bookingId, Booking booking) {

		bookingService.deleteBookingDetails(bookingId, booking);
		return "Booking is deleted";
	}

}
