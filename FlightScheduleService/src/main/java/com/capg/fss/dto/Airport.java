package com.capg.fss.dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Airport 
{
    @Id
    @Column(name="airport_id",length=10)
    private String airportId;
    @Column(name="airport_name",length=25)
    private String airportName;
    @Column(name="airport_loc",length=25)
    private String area;
    public Airport() {}
	public Airport(String airportId, String airportName, String area) 
	{
		this.airportId = airportId;
		this.airportName = airportName;
		this.area = area;
	}
	public String getAirportId() {
		return airportId;
	}
	public void setAirportId(String airportId) {
		this.airportId = airportId;
	}
	public String getAirportName() {
		return airportName;
	}
	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	@Override
	public String toString() {
		return "Airport [airportId=" + airportId + ", airportName=" + airportName + ", area=" + area + "]";
	}
	
}
