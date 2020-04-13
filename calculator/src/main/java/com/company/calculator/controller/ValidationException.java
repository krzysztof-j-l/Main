package com.company.calculator.controller;

public class ValidationException extends Exception {
	
	private static final long serialVersionUID = 4568885970582130884L;
	
	public static String MIN_NULL = "Num should not be null";
	
	public static String MAX_NULL = "Max should not be null";
	
	public static String MIN_GREATER_EQUAL_THEN_MAX = "The maximum value must be greater than the minimum value";
	
	public ValidationException(String msg) {
		super(msg);
	}
}
