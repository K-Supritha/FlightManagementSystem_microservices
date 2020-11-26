package com.capg.fss.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class FlightScheduleException extends Exception
{
private static final long serialVersionUID = 1L;
@ExceptionHandler(value={FlightScheduleNotFoundException.class })
	public ResponseEntity<Object> exception(FlightScheduleNotFoundException exception)
	{
	      return new ResponseEntity<>("Flight Schedule not found", HttpStatus.NOT_FOUND);
	}
}
