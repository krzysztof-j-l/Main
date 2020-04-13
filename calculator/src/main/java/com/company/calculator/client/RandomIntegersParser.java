package com.company.calculator.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class RandomIntegersParser {

	public List<Integer> parse(String input) {
		String[] integersArray = input.split("\\n");		
		List<Integer> intList = new ArrayList<>(); 
		
		for (String integerString: integersArray) {
			intList.add(Integer.parseInt(integerString));
		}

		return intList;
	}
}
