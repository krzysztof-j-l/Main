package com.company.calculator.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.company.calculator.client.RandomIntegersException;

@RestController
public class CalculatorController {
	
	@Autowired
	private CalculatorService calculatorService;
	
	@GetMapping("/sum")
	public String hello(
			@RequestParam(value = "min", defaultValue = "1") Integer min,
			@RequestParam(value = "max", defaultValue = "10") Integer max, HttpServletResponse response) {
		try {
			return calculatorService.calculate(min, max);
		} catch (NumberFormatException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Wrong Response from Random Api", ex);
		} catch (ValidationException | RandomIntegersException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
		}		
	}
}
