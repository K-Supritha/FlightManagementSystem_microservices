package com.capg.fms.as.exception;


public class AirportNotFoundException extends RuntimeException
{
	private static final long serialVersionUID = 1L;
	public AirportNotFoundException()
	{
		super();
	}

	public AirportNotFoundException(String message) 
	{
		super(message);
	}
}
