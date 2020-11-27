package com.capg.fms.fs.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FlightServiceExceptions {
	
	@ExceptionHandler(value={FlightNotFoundException.class })
	public ResponseEntity<Object> exception(FlightNotFoundException exception) {
	      return new ResponseEntity<>("Flight not found", HttpStatus.NOT_FOUND);
	   }
	
}