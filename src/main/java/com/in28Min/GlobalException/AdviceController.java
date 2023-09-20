package com.in28Min.GlobalException;

import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AdviceController extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoDataFound(NoSuchElementException noSuchDatafound){
		return new ResponseEntity<String>("No data found",HttpStatus.NO_CONTENT);
	}
	
@Override
protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
		HttpHeaders headers, HttpStatus status, WebRequest request) {
	// TODO Auto-generated method stub
	return new ResponseEntity<Object>("change your thhp method",HttpStatus.NOT_FOUND);
}


}
