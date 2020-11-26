package com.capg.fss.dto;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="schedule")
public class FlightSchedule 
{
	@Id
	@Column(name="sched_id",length=25)
	private String scheduleId;
	@OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name="flight_no")
	private Flight flight;
	@OneToOne
	@JoinColumn(name="source" , referencedColumnName="airport_id")
	private Airport source;
	@OneToOne
	@JoinColumn(name="destination" , referencedColumnName="airport_id")
	private Airport destination;
	private double fare;
	private LocalDateTime departure;
	private LocalDateTime arrival;
	public FlightSchedule() {}
	public FlightSchedule(String scheduleId, Flight flight, Airport source, Airport destination, double fare,LocalDateTime departure, LocalDateTime arrival) 
	{
		this.scheduleId = scheduleId; 	this.flight = flight;	this.source = source;	this.destination = destination;
		this.fare = fare; 	this.departure = departure; 	this.arrival = arrival;
	}
	public String getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public Airport getSource() {
		return source;
	}
	public void setSource(Airport source) {
		this.source = source;
	}
	public Airport getDestination() {
		return destination;
	}
	public void setDestination(Airport destination) {
		this.destination = destination;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	public LocalDateTime getDeparture() {
		return departure;
	}
	public void setDeparture(LocalDateTime departure) {
		this.departure = departure;
	}
	public LocalDateTime getArrival() {
		return arrival;
	}
	public void setArrival(LocalDateTime arrival) {
		this.arrival = arrival;
	}
}
