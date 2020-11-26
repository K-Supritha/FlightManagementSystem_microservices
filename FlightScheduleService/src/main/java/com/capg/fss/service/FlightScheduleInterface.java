package com.capg.fss.service;

import java.util.List;
import java.util.Optional;

import com.capg.fss.dto.FlightSchedule;

public interface FlightScheduleInterface
{
	public Optional<FlightSchedule> getFlightSchedule(String scheduleId);
	public List<FlightSchedule> getAllFlightSchedules();
	public FlightSchedule addFlightSchedule(FlightSchedule flightSchedule);
	public void updateFlightSchedule(FlightSchedule flightschedule);
	public void deleteFlightSchedule(String scheduleId);
	
}
