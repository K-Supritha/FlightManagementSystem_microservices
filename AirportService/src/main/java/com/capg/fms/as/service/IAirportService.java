package com.capg.fms.as.service;

import java.util.List;
import java.util.Optional;

import com.capg.fms.as.dto.Airport;

public interface IAirportService {
	public Optional<Airport> getAirport(String airportId);
	public List<Airport> getAirports();
	public Airport addAirport(Airport airport);
	public void updateAirport(Airport airport);
	public void deleteAirport(String airportId);
}
