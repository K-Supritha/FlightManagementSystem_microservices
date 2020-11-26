package com.capg.fms.bs.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookingException extends Exception{
	
	@ExceptionHandler(value={BookingNotFoundException.class })
		public ResponseEntity<Object> exception(BookingNotFoundException exception)
		{
		      return new ResponseEntity<>("No such booking Id exists", HttpStatus.NOT_FOUND);
		}

}
