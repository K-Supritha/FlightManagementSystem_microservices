package com.capg.fms.us.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserServiceException {
	
	@ExceptionHandler(value={UserAccountNotFoundException.class })
	public ResponseEntity<Object> exception(UserAccountNotFoundException exception) {
	      return new ResponseEntity<>("user account not found", HttpStatus.NOT_FOUND);
	   }
	
}