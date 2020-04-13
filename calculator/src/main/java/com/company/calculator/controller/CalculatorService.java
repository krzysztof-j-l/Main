package com.company.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.calculator.client.RandomIntegersClient;
import com.company.calculator.client.RandomIntegersException;
import com.company.calculator.math.MathService;

@Service
public class CalculatorService {
	
	@Autowired
	RandomIntegersClient randomIntegersClient;
	
	@Autowired
	MathService mathService;
			
	public String calculate(Integer min, Integer max) throws ValidationException, RandomIntegersException {
		CalculatorValidator.validate(min, max);
		
		Integer clientInt = randomIntegersClient.getRandomInteger(min, max);
		
		Integer mathInt = mathService.getRandomInteger(min, max);
			
		Integer sumInt = clientInt + mathInt;
		
		String sum = "sum of random numbers: " + clientInt + " + " + mathInt + " = " + sumInt;
		
		return sum;
	}
}
