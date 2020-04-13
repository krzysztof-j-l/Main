package com.company.calculator.controller;

public class CalculatorValidator {
	public static void validate(Integer min, Integer max) throws ValidationException{

		if (min == null) {
			throw new ValidationException(ValidationException.MIN_NULL);			
		}
		
		if (max == null) {
			throw new ValidationException(ValidationException.MAX_NULL);			
		}
		
		if (min != null && max != null && min >= max) {
			throw new ValidationException(ValidationException.MIN_GREATER_EQUAL_THEN_MAX);
		}
	}
}
