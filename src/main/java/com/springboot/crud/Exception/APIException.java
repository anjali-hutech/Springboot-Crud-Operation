package com.springboot.crud.Exception;

public class APIException  extends RuntimeException{
	
	public APIException (String message)
	{
		super(message);
	}

}
