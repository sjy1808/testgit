package com.dessert.exception;

public class ServiceException extends RuntimeException{
	private static final long serialVersionUID = 509893675571937113L;
	public ServiceException(){
		super();
	}
	public ServiceException(String message){
		super(message);
	}
	public ServiceException(Throwable cause){
		super(cause);
	}
}