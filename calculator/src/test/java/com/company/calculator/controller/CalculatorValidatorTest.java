package com.company.calculator.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculatorValidatorTest {

	@Test
	void validateMinNull() {
		ValidationException ex = assertThrows(ValidationException.class, () -> CalculatorValidator.validate(null,3));
		assertThat(ex.getMessage()).isEqualTo(ValidationException.MIN_NULL);
	}
	
	@Test
	void validateMaxNull() {
		ValidationException ex = assertThrows(ValidationException.class, () -> CalculatorValidator.validate(3,null));
		assertThat(ex.getMessage()).isEqualTo(ValidationException.MAX_NULL);
	}
	
	@Test
	void validateMinGrearThanMax() {
		ValidationException ex = assertThrows(ValidationException.class, () -> CalculatorValidator.validate(4,1));
		assertThat(ex.getMessage()).isEqualTo(ValidationException.MIN_GREATER_EQUAL_THEN_MAX);
	}
	
}
