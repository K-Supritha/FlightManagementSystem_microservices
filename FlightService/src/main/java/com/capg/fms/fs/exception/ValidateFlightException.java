package com.capg.fms.fs.exception;

import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.FieldError;
public class ValidateFlightException extends Exception{

private List<FieldError> errorList=new ArrayList<>();
public List<FieldError> getErrorList() {
return errorList;
}

public void setErrorList(List<FieldError> errorList) {
this.errorList = errorList;
}

public ValidateFlightException(List<FieldError> errorList) {
super();
this.errorList = errorList;
}

public ValidateFlightException() {
super();

}

public ValidateFlightException(String arg0) {
super(arg0);

}

}
