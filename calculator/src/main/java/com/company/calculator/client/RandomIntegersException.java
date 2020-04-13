package com.company.calculator.client;

public class RandomIntegersException extends Exception{

	private static final long serialVersionUID = -914810878980305738L;
	
	public static String FAILED_TO_GENERATE_INT = "Failed to generate number";
	
	public RandomIntegersException(String msg) {
		super(msg);
	}
}
