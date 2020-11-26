package com.capg.fms.fs.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.capg.fms.fs.dto.Flight;
import com.capg.fms.fs.exception.FlightNotFoundException;
import com.capg.fms.fs.exception.ValidateFlightException;
import com.capg.fms.fs.service.FlightService;

/**************************************************************************************
 * @author K.Supritha Description It is a Rest Controller class that provides
 *         the suitable Flight Management methods for the Flight Service for the
 *         given matching URL and returns response in different types of data
 *         objects.
 * @version 1.0 Created Date 19-NOV-2020
 ***************************************************************************************/
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class FlightController {
	Logger logger = LoggerFactory.getLogger(FlightController.class);
	@Autowired
	private FlightService flightService;

	public void setFlightService(FlightService flightService) {
		this.flightService = flightService;
	}

	// Adding flights
	@PostMapping(value = "/addFlight")
	public ResponseEntity<String> addFlight(@Valid @RequestBody() Flight flight, BindingResult br)
			throws ValidateFlightException {
		if (br.hasErrors()) {
			throw new ValidateFlightException(br.getFieldErrors());
		}
		String msg = "adding the flight :";
		logger.info(msg);
		flightService.addFlight(flight);
		return new ResponseEntity<String>("Flight added successfully!!", HttpStatus.OK);
	}

	// Searching the flight by id
	@GetMapping(value = "/getFlight/{flightNo}", produces = "application/json")
	public ResponseEntity<Optional<Flight>> getFlight(@PathVariable String flightNo) throws FlightNotFoundException {
		String msg = "View the flight:";
		logger.info(msg);
		Optional<Flight> flight = flightService.getFlight(flightNo);
		if (flight.isPresent())
			return new ResponseEntity<Optional<Flight>>(flight, HttpStatus.OK);
		return new ResponseEntity<Optional<Flight>>(flight, HttpStatus.NOT_FOUND);
	}

	// get all available flights
	@GetMapping(value = "/getFlights", produces = "application/json")
	public List<Flight> getFlights() {
		String msg = "View all flights :";
		logger.info(msg);
		return flightService.getFlights();
	}

	// Modifying the flight details
	@PutMapping(value = "/updateFlight", consumes = "application/json")
	public String updateFlight(@RequestBody() Flight flight) throws FlightNotFoundException {
		String msg = "update the flight :";
		logger.info(msg);
		flightService.updateFlight(flight);
		return "updated succesfully";
	}

	// Delete the flight by id
	@DeleteMapping("/deleteFlight/{flightNo}")
	public ResponseEntity<String> deleteFlight(@PathVariable String flightNo) throws FlightNotFoundException {
		String msg = "deleting  the flight :";
		logger.info(msg);

		flightService.deleteFlight(flightNo);
		return new ResponseEntity<String>("Flight Deleted Successfully!!", HttpStatus.OK);
	}

}
