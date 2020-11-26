package com.capg.fms.bs.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PassengerException extends Exception {
	
	@ExceptionHandler(value={PassengerNotFoundException.class })
		public ResponseEntity<Object> exception(PassengerNotFoundException exception)
		{
		      return new ResponseEntity<>("No such passenger Id exists", HttpStatus.NOT_FOUND);
		}

}
