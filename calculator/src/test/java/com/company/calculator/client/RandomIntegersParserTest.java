package com.company.calculator.client;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RandomIntegersParserTest {

	@Autowired
	RandomIntegersParser randomIntegersParser;
	
	@Test
	void parse() {
		String input = "1\n2\n3";
		
		List<Integer> expected = new ArrayList<>();
		expected.add(1);expected.add(2);expected.add(3);
		
		List<Integer> result = randomIntegersParser.parse(input);
		
		assertThat(result).isEqualTo(expected);
	}
}
