package com.capg.fss.exception;

public class FlightScheduleNotFoundException extends RuntimeException
{
	private static final long serialVersionUID = 1L;
	public FlightScheduleNotFoundException()
	{
		super();
	}

	public FlightScheduleNotFoundException(String message) 
	{
		super(message);
	}

}
