package com.capg.fms.bs.service;

import java.util.List;
import java.util.Optional;

import com.capg.fms.bs.dto.Passengers;
import com.capg.fms.bs.exceptions.PassengerNotFoundException;

public interface IPassengersService {
	public Optional<Passengers> getPassenger(String uid) throws PassengerNotFoundException;
	public List<Passengers> getAllPassengers();
	public Passengers addPassenger(Passengers passenger);
	public void updatePassenger(Passengers passenger) ;
	public void deletePassenger(String uid) throws PassengerNotFoundException;

}
