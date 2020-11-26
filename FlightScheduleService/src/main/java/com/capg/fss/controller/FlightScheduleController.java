package com.capg.fss.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.fss.dao.FlightScheduleDAO;
import com.capg.fss.dto.FlightSchedule;
import com.capg.fss.exception.FlightScheduleNotFoundException;
import com.capg.fss.service.FlightScheduleService;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class FlightScheduleController 
{
	@Autowired
	private FlightScheduleService flightScheduleService;
	
	@Autowired
	private FlightScheduleDAO flightScheduleDao;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FlightScheduleController.class);
	
	public void setFlightScheduleService(FlightScheduleService flightScheduleService)
	{
		this.flightScheduleService = flightScheduleService;
	}
	
	//view Flight Schedule By Id
	@GetMapping(value="/getFlightSchedule/{scheduleId}",produces="application/json")
	public ResponseEntity<Object> getFlightSchedule(@PathVariable String scheduleId)
	{
		Optional<FlightSchedule> flightSchedule= flightScheduleDao.findById(scheduleId);
	    if (flightSchedule.isPresent())
	    {
	      LOGGER.info("View Flight Schedule method is accessed");	
	      return new ResponseEntity<>(flightSchedule.get(), HttpStatus.OK);
	    }
	    else
	    {
	      return new ResponseEntity<>("Flight Schedule not found",HttpStatus.NOT_FOUND);
	    }
	}
	
	//view FlightSchedules
	@GetMapping(value="/getFlightSchedules",produces="application/json")
	public ResponseEntity<Object> getAllFlightSchedules()
	{
		List<FlightSchedule> flightScheduleList = flightScheduleService.getAllFlightSchedules();
		return new ResponseEntity<>(flightScheduleList, HttpStatus.OK);
	}
	
	
	//add FlightSchedule 
	@PostMapping(value="/addFlightSchedule",consumes="application/json")
	public ResponseEntity<String> addFlightSchedule(@Valid @RequestBody()FlightSchedule flightSchedule)
	{
		try {
			flightScheduleService.addFlightSchedule(flightSchedule);
			LOGGER.info("Add Flight Schedule method is accessed");
			return new ResponseEntity<>("Flight Schedule details added",HttpStatus.OK);
		} 
		catch (DataIntegrityViolationException ex) {
			return new ResponseEntity<>(ex.getMessage() + "Flight Schedule details already added", HttpStatus.BAD_REQUEST);
		}
	}
	
	//update Flight schedule
	@PutMapping("/updateFlightSchedule/{id}")
	public ResponseEntity<Object> updateFlightSchedule(@PathVariable("id") String scheduleId, @RequestBody FlightSchedule flightSchedule)throws FlightScheduleNotFoundException
	{
				if (flightScheduleDao.existsById(scheduleId))
				{
					flightScheduleService.updateFlightSchedule(flightSchedule);
					LOGGER.info("update Flight Schedule method is accessed");
					return new ResponseEntity<>("Flight Schedule is updated successsfully", HttpStatus.OK);
				} else 
				{
					throw new FlightScheduleNotFoundException();
				}
     }
	
	//Delete FlightSchedule By Id
	@DeleteMapping("/deleteFlightSchedule/{scheduleId}")
	public ResponseEntity<String> deleteFlightSchedule(@PathVariable String scheduleId)throws FlightScheduleNotFoundException
	{
		if (flightScheduleDao.existsById(scheduleId))
		{
			flightScheduleService.deleteFlightSchedule(scheduleId);
			LOGGER.info("Delete Flight Schedule method is accessed");
			return new ResponseEntity<>("Flight Schedule is deleted successsfully", HttpStatus.OK);
		}
		else
		{
			throw new FlightScheduleNotFoundException();
		}
	}
	
	
}
			
