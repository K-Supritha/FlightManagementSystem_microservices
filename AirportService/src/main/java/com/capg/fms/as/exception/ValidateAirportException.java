package com.capg.fms.as.exception;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.FieldError;
public class ValidateAirportException extends Exception{

List<FieldError> errorList=new ArrayList<>();
public List<FieldError> getErrorList() {
return errorList;
}

public void setErrorList(List<FieldError> errorList) {
this.errorList = errorList;
}

public ValidateAirportException(List<FieldError> errorList) {
super();
this.errorList = errorList;
}

public ValidateAirportException() {
super();

}

public ValidateAirportException(String arg0) {
super(arg0);

}

}
