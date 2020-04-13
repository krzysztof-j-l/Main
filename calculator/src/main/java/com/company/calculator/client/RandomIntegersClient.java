package com.company.calculator.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.company.calculator.controller.CalculatorValidator;
import com.company.calculator.controller.ValidationException;

@Service
public class RandomIntegersClient {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	RandomIntegersParser randomIntegersParser;
	
	static final String BASE_URL = "https://www.random.org/integers/?col=1&base=10&format=plain&rnd=new&num=1";
	
	public Integer getRandomInteger(Integer min, Integer max) throws ValidationException, RandomIntegersException {
		CalculatorValidator.validate(min, max);	
		
		StringBuffer randomIntUrl = new StringBuffer(BASE_URL);
				
		if (min != null ) {
			randomIntUrl.append("&min="+min.intValue());
		}
		
		if (max != null) {
			randomIntUrl.append("&max="+max.intValue());
		}
		
		String integersResponse = restTemplate.getForObject(
				randomIntUrl.toString(), String.class);
		
		List<Integer> intList = randomIntegersParser.parse(integersResponse);	
		
		if (intList == null || intList.isEmpty()) {
			throw new RandomIntegersException(RandomIntegersException.FAILED_TO_GENERATE_INT);
		}
		
		return intList.get(0);
	} 
}
