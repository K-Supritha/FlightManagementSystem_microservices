package com.capg.fms.us.exception;
@SuppressWarnings("serial")
public class UserAccountNotFoundException extends RuntimeException
{
	public UserAccountNotFoundException()
	{
		super();
	}

	public UserAccountNotFoundException(String message) 
	{
		super(message);
	}
}
