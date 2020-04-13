package com.company.calculator.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.company.calculator.client.RandomIntegersClient;
import com.company.calculator.client.RandomIntegersException;
import com.company.calculator.math.MathService;

@SpringBootTest
public class CalculatorServiceTest {
	
	@InjectMocks
	CalculatorService calculatorService;
	
	@Mock
	RandomIntegersClient randomIntegersClient;
	
	@Mock
	MathService mathService;

	@Test
	void sumList() throws ValidationException, RandomIntegersException {

		String expected = "sum of random numbers: 6 + 7 = 13";
		
		when(randomIntegersClient.getRandomInteger(1,10)).thenReturn(6);
		when(mathService.getRandomInteger(1,10)).thenReturn(7);
		
		String result = calculatorService.calculate(1,10);
		
		assertThat(result).isEqualTo(expected);
		
	}
}
