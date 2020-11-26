package com.capg.fss.dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Flight 
{
    @Id
    @Column(name="flight_no",length=15)
    private String flightNo;
    @Column(name="carrier_name",length=15)
    private String carrierName;
    @Column(name="flight_model",length=15)
    private String flightModel;
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
