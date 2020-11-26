package com.capg.fms.as.controller;

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

import com.capg.fms.as.dao.AirportDAO;
import com.capg.fms.as.dto.Airport;
import com.capg.fms.as.exception.AirportNotFoundException;
import com.capg.fms.as.exception.ValidateAirportException;
import com.capg.fms.as.service.AirportService;


/**************************************************************************************
 * @author P.Manasa Devi Description It is a Rest Controller class that provides
 *         the suitable Flight Management methods for the given matching URL and
 *         returns response in different types of data objects.
 * @version 1.0 Created Date 19-NOV-2020
 ***************************************************************************************/

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class AirportController {
	@Autowired
	private AirportService airportService;

	@Autowired
	private AirportDAO airportDao;

	private static final Logger LOGGER = LoggerFactory.getLogger(AirportController.class);

	public void setFlightService(AirportService airportService) {
		this.airportService = airportService;
	}

//add airport
	@PostMapping(value = "/addAirport")
	public ResponseEntity<String> addAirport(@Valid @RequestBody() Airport airport, BindingResult br)
			throws ValidateAirportException {
		if (br.hasErrors()) {
			throw new ValidateAirportException(br.getFieldErrors());
		}
		airportService.addAirport(airport);
		LOGGER.info("Add airport method is accessed");
		return new ResponseEntity<String>("Airport details added", HttpStatus.OK);
	}

//view airport by ID
	@GetMapping("/getAirport/{id}")
	public ResponseEntity<Object> getAirport(@PathVariable("id") String airportId) throws AirportNotFoundException{
		Optional<Airport> airport = airportDao.findById(airportId);
		if (airport.isPresent()) {
			LOGGER.info("Get Airport method is accessed");
			return new ResponseEntity<>(airport.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Airport not found", HttpStatus.NOT_FOUND);
		}
	}

//view airport list
	@GetMapping("/getAirport")
	public ResponseEntity<Object> getAirports() {
		List<Airport> airportList = airportService.getAirports();
		LOGGER.info("View Airports method is accessed");
		return new ResponseEntity<>(airportList, HttpStatus.OK);
	}

//update Airport
	@PutMapping("/updateAirport/{id}")
	public String updateAirport(@PathVariable("id") String airportId, @RequestBody Airport airport)
			throws AirportNotFoundException {		
			airportService.updateAirport(airport);
			LOGGER.info("update airport method is accessed");
			return "Airport is updated successsfully";
		
	}
	/*@PutMapping(value = "/updateFlight", consumes = "application/json")
	public void updateFlight(@RequestBody() Flight flight) throws FlightNotFoundException {
		String msg = "update the flight :";
		logger.info(msg);
		flightService.updateFlight(flight);
	}*/

//Delete Airport By Id
	@DeleteMapping("/deleteAirport/{id}")
	public ResponseEntity<Object> deleteAirport(@PathVariable("id") String airportId) throws AirportNotFoundException {
		
			airportService.deleteAirport(airportId);
			LOGGER.info("delete Airport method is accessed");
			return new ResponseEntity<>("Airport is deleted successsfully", HttpStatus.OK);
		} 
	}
	
	/*@DeleteMapping("/deleteFlight/{flightNo}")
	public ResponseEntity<String> deleteFlight(@PathVariable String flightNo) throws FlightNotFoundException {
		String msg = "deleting  the flight :";
		logger.info(msg);

		flightService.deleteFlight(flightNo);
		return new ResponseEntity<String>("Flight Deleted Successfully!!", HttpStatus.OK);
	}*/

