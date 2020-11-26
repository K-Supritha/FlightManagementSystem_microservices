package com.capg.fms.fs.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
public class Flight 
{
    @Id
    @Size(max = 10,message = "flight No must be between 3 and 10 characters")
    @Column(name="flight_no")
    private String flightNo;
    @NotNull
    @Column(name="carrier_name",length=20)
    private String carrierName;
    @NotNull
    @Column(name="flight_model",length=20)
    private String flightModel;
    @NotNull
	@Column(name="seat_capacity",length=10)
    private int seatCapacity;
    public Flight() { }
    
	public Flight(String flightNo, String carrierName, String flightModel, int seatCapacity) {
		super();
		this.flightNo = flightNo;
		this.carrierName = carrierName;
		this.flightModel = flightModel;
		this.seatCapacity = seatCapacity;
	}
	public String getFlightModel() {
		return flightModel;
	}
	public void setFlightModel(String flightModel) {
		this.flightModel = flightModel;
	}
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public String getCarrierName() {
		return carrierName;
	}
	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}
	public int getSeatCapacity() {
		return seatCapacity;
	}
	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}
	@Override
	public String toString() {
		return "Flight [flightNo=" + flightNo + ", carrierName=" + carrierName + ", flightModel=" + flightModel
				+ ", seatCapacity=" + seatCapacity + "]";
	}
	
}
