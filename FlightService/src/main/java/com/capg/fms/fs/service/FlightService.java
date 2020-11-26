package com.capg.fms.fs.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.capg.fms.fs.dao.FlightDAO;
import com.capg.fms.fs.dto.Flight;
import com.capg.fms.fs.exception.FlightNotFoundException;
@Service
public class FlightService
{
   @Autowired
   private FlightDAO flightdao;
   
   public void setFlightdao(FlightDAO flightdao) { this.flightdao=flightdao; }
   
   @Transactional(readOnly=true)
   public Optional<Flight> getFlight(String flightNo)
   {
	   if(!flightdao.existsById(flightNo))
	   {
		   throw new FlightNotFoundException();
	   }
	   else {
	   return flightdao.findById(flightNo);
   }
   }
   
   @Transactional(readOnly=true)
   public List<Flight> getFlights()
   {
	   return flightdao.findAll(Sort.by(Sort.Direction.ASC, "flightNo"));
   }
   
   @Transactional
   public Flight addFlight(Flight flight)
   {
	   return flightdao.save(flight);
   }
   
   @Transactional
   public String updateFlight(Flight flight)
   {
	   if(flightdao.existsById(flight.getFlightNo()))
	   {
		   flightdao.save(flight);
	   return "flights were updated successfully";
       }
	   else
	   {
		   throw new FlightNotFoundException();
	   }
     }
   
   @Transactional
   public void deleteFlight(String flightNo)
   {
	   if(!flightdao.existsById(flightNo))
	   {
		   throw new FlightNotFoundException();
	   }
	   else
	   {
		   flightdao.deleteById(flightNo);
	   }
   }
}