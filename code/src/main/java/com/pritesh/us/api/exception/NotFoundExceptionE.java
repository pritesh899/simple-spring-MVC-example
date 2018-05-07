package com.pritesh.us.api.exception;

public class NotFoundExceptionE extends Throwable{
	
		
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public NotFoundExceptionE(String message)
		{
			super(message);
		}
		
		public NotFoundExceptionE(String message, Throwable cause)
		{
			super(message, cause);
		}
	

}
