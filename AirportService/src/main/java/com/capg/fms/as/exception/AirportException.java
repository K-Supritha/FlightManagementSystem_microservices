package com.capg.fms.as.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class AirportException extends Exception
{
private static final long serialVersionUID = 1L;
@ExceptionHandler(value={AirportNotFoundException.class })
	public ResponseEntity<Object> exception(AirportNotFoundException exception)
	{
	      return new ResponseEntity<>("Enter Valid Airport ID", HttpStatus.NOT_FOUND);
	}
}

