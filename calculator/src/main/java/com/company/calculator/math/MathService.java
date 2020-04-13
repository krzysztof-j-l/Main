package com.company.calculator.math;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.company.calculator.controller.CalculatorValidator;
import com.company.calculator.controller.ValidationException;

@Service
public class MathService {
	
	public Integer getRandomInteger(Integer min, Integer max) throws ValidationException{
		CalculatorValidator.validate(min, max);		
		Random random = new Random();
		return min + random.nextInt(max - min);
	}
}
