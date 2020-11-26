package com.capg.fms.as.exception;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidateException {
@ExceptionHandler(ValidateAirportException.class)
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public ResponseEntity<Object> handleException(ValidateAirportException ex)
{
List<String> errors=ex.getErrorList().stream().map(err->err.getDefaultMessage()).collect(Collectors.toList());
return new ResponseEntity<>(errors,HttpStatus.NOT_FOUND);
}

}
