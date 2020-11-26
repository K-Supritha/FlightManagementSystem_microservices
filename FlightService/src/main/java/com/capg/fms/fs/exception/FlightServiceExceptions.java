package com.capg.fms.fs.exception;

public class FlightServiceExceptions extends Exception 
{
	private static final long serialVersionUID = 1L;
	public FlightServiceExceptions(String message)
	{
		super(message);
	}
	public FlightServiceExceptions()
	{
		super();
	}
}