package com.capg.fms.bs.dto;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
@Entity
@Table(name="bookingdetails")

public class Booking {
	@Id
    @Column(name="booking_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
    @SequenceGenerator(name = "book_seq", sequenceName = "bookingdetails_s1", allocationSize=1)
    private long bookingId;
    @OneToOne
    @JoinColumn(name="username")
    private Users users;
    @OneToOne
    @JoinColumn(name="sched_id")
    private FlightSchedule flightSchedule;
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="booking_id")
    List<Passengers> passengers;
    @NotNull(message="Booking date should not be null")
    @Column(name="booking_date")
    private LocalDate bookingDate;
    @NotNull(message="Travel Date should not be null")
   @Column(name="travel_date")
    private LocalDate travelDate;
    public Booking() { }
	public Booking(long bookingId, Users users, FlightSchedule flightSchedule, LocalDate bookingDate,	LocalDate travelDate,List<Passengers> passengers) 
	{
		this.bookingId = bookingId;		this.users = users;		this.flightSchedule = flightSchedule;
		this.bookingDate = bookingDate;		this.travelDate = travelDate; this.passengers=passengers;
	}
	public long getBookingId() {
		return bookingId;
	}
	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public FlightSchedule getFlightSchedule() {
		return flightSchedule;
	}
	public void setFlightSchedule(FlightSchedule flightSchedule) {
		this.flightSchedule = flightSchedule;
	}
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	public LocalDate getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}
	public List<Passengers> getPassengers() {
		return passengers;
	}
	public void setPassengers(List<Passengers> passengers) {
		this.passengers = passengers;
	}

}
