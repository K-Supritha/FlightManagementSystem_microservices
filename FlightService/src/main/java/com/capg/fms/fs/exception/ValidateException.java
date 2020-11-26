package com.capg.fms.fs.exception;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

public class ValidateException {
@ExceptionHandler(ValidateFlightException.class)

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public ResponseEntity<Object> handleException(ValidateFlightException ex)
{
List<String> errors=ex.getErrorList().stream().map(err->err.getDefaultMessage()).collect(Collectors.toList());
return new ResponseEntity<>(errors,HttpStatus.NOT_FOUND);
}

}
