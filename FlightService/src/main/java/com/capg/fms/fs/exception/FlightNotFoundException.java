package com.capg.fms.fs.exception;

@SuppressWarnings("serial")
public class FlightNotFoundException extends RuntimeException
{
	public FlightNotFoundException()
	{
		super();
	}

	public FlightNotFoundException(String message) 
	{
		super(message);
	}
}
