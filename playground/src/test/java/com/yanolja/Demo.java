package com.yanolja;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.io.IOException;

public class Demo {

	private static final Logger logger = LogManager.getLogger(Demo.class);

	ObjectMapper mapper = new ObjectMapper();

	int circleOfNumbers(int n, int firstNumber) {
		return (firstNumber + n/2) % n;
	}

	@Test
	public void test1() throws IOException {
		int ret =circleOfNumbers(10, 2);
		logger.debug("ret : {}", mapper.writeValueAsString(ret));
	}
}
