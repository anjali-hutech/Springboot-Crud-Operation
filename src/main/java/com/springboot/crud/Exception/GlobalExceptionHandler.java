package com.springboot.crud.Exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	//handle Specific Exception
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException (ResourceNotFoundException exception , WebRequest  request)
	{
		ErrorDetails errorDetails = new ErrorDetails
		  (new Date(), exception.getMessage(), request.getDescription(false));
		return new  ResponseEntity(errorDetails , HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(APIException.class)
	public ResponseEntity<?> handleAPIException (APIException exception , WebRequest  request)
	{
		ErrorDetails errorDetails = new ErrorDetails
		  (new Date(), exception.getMessage(), request.getDescription(false));
		return new  ResponseEntity(errorDetails , HttpStatus.NOT_FOUND);
	}

    
	
	//handle Global Exception
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleGlobalException (Exception exception , WebRequest  request)
	{
		ErrorDetails errorDetails = new ErrorDetails
		  (new Date(), exception.getMessage(), request.getDescription(false));
		return new  ResponseEntity(errorDetails , HttpStatus.INTERNAL_SERVER_ERROR);
	}


}
